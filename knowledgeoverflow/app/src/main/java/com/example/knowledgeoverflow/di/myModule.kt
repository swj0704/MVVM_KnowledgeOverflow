package com.example.knowledgeoverflow.di

import android.content.Context
import com.example.knowledgeoverflow.network.*
import com.example.knowledgeoverflow.viewmodel.*
import org.koin.android.ext.koin.androidApplication
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val myModule = module{

    val service: Retrofit = Retrofit.Builder()
        .baseUrl("https://def3c747ac93.ngrok.io/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()


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
    viewModel { LoginViewModel(get<GetAPI>(), get<Context>()) }
    viewModel { SettingViewModel() }
    viewModel { SignUpViewModel(get<GetAPI>(), get<AddAPI>()) }
}