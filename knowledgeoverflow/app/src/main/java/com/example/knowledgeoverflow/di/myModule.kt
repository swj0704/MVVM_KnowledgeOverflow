package com.example.knowledgeoverflow.di

import com.example.knowledgeoverflow.network.*
import com.example.knowledgeoverflow.viewmodel.*
import org.koin.android.ext.koin.androidApplication
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

val service: Retrofit = Retrofit.Builder()
    .baseUrl("")
    .addConverterFactory(GsonConverterFactory.create())
    .build()

val myModule = module{

    single {
        service.create(CheckAPI::class.java)
    }
    single {
        service.create(AddAPI::class.java)
    }
    single {
        service.create(GetAPI::class.java)
    }
    single {
        service.create(DeleteAPI::class.java)
    }
    single {
        service.create(ModifyAPI::class.java)
    }

    viewModel { SplashViewModel(androidApplication()) }
    viewModel { HomeViewModel() }
    viewModel { MainViewModel() }
    viewModel { SlideshowViewModel() }
    viewModel { LoginViewModel(get()) }
    viewModel { SettingViewModel() }
}