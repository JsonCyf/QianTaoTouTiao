package com.study.qiantaotoutiao.http

import android.annotation.SuppressLint
import com.orhanobut.logger.Logger
import com.study.qiantaotoutiao.base.Constants
import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.security.cert.CertificateException
import java.security.cert.X509Certificate

import java.util.concurrent.TimeUnit
import javax.net.ssl.*
import javax.net.ssl.TrustManager


/**
 * @class describe
 * @anthor Administrator
 * @time 2021/9/7 0007
 */
object HttpUtils {

    private var mOkhttp: OkHttpClient? = null

    private fun isTest(isTest: Boolean): String =
        if (isTest) Constants.BASE_URL else Constants.BASE_URL_TEST

    fun <T> createApi(clazz: Class<T>): T = Retrofit.Builder()
        .baseUrl(isTest(true))

        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .addConverterFactory(GsonConverterFactory.create())
        .client(getClient())
        .build()
        .create(clazz)

    private fun getClient(): OkHttpClient? {
        if (mOkhttp == null) {
            mOkhttp = OkHttpClient.Builder()
                .addInterceptor(getInterceptor())
                .retryOnConnectionFailure(true)
                .readTimeout(30, TimeUnit.SECONDS)
                .connectTimeout(30, TimeUnit.SECONDS)
//                .sslSocketFactory(getSSLFactory())
//                .hostnameVerifier(object :HostnameVerifier{
//                    override fun verify(hostname: String?, session: SSLSession?): Boolean {
//                        return true
//                    }
//                })
                .build()
        }
        return mOkhttp
    }

    private fun getSSLFactory(): SSLSocketFactory {
       val trustManager= arrayOf<TrustManager>(object :X509TrustManager{

            override fun getAcceptedIssuers(): Array<X509Certificate> {
                return arrayOf()
            }

            @Throws(CertificateException::class)
            override fun checkClientTrusted(chain: Array<out X509Certificate>?, authType: String?) {

            }
            @Throws(CertificateException::class)
            override fun checkServerTrusted(chain: Array<out X509Certificate>?, authType: String?) {

            }


        })
        val sslContext=SSLContext.getInstance("SSL")
        sslContext.init(null,trustManager,java.security.SecureRandom())
        return sslContext.socketFactory

    }

    private fun getInterceptor(): Interceptor {
        HttpLoggingInterceptor.Logger {
            Logger.json(it)
        }
        return HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
    }


    fun <T> sendHttp(ob: Observable<T>, listenter:ResponseListernter<T>) {
        ob.subscribeOn(Schedulers.io())
            .subscribeOn(AndroidSchedulers.mainThread())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe (object :Observer<T>{
                override fun onSubscribe(d: Disposable) {

                }

                override fun onNext(t: T) {
                    listenter.onSuccess(t)
                }

                override fun onError(e: Throwable) {
                    listenter.onFail(e.message.toString())
                }

                override fun onComplete() {
                }


            })
    }
}