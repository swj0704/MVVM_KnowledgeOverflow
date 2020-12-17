package com.example.knowledgeoverflow.di

import com.example.knowledgeoverflow.viewmodel.SplashViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

val myModule = module{

    single {
        Retrofit.Builder()
                .baseUrl("")
                .client(get())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
    }

    viewModel { SplashViewModel() }
}