package com.monsanto.ankur_mishra.repositry

import io.reactivex.Single
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.http.GET

interface BlogService {

    @GET(".")
    fun getBlogPage(): Single<String>

    companion object {
        fun createBlogService(): BlogService {
            return createRetrofit()
                    .create(BlogService::class.java)
        }

        private fun createRetrofit(): Retrofit {
            return Retrofit.Builder()
                    .baseUrl("https://blog.truecaller.com/2018/01/22/life-as-an-android-engineer/")
                    .addConverterFactory(ScalarsConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .build()
        }
    }
}