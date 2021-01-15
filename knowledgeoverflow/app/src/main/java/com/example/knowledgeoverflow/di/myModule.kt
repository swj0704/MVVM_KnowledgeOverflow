package com.example.knowledgeoverflow.di

import android.content.Context
import com.example.knowledgeoverflow.network.api.*
import com.example.knowledgeoverflow.viewmodel.activity.LoginViewModel
import com.example.knowledgeoverflow.viewmodel.activity.MainViewModel
import com.example.knowledgeoverflow.viewmodel.activity.SignUpViewModel
import com.example.knowledgeoverflow.viewmodel.activity.SplashViewModel
import com.example.knowledgeoverflow.viewmodel.fragment.HomeViewModel
import com.example.knowledgeoverflow.viewmodel.fragment.SettingViewModel
import com.example.knowledgeoverflow.viewmodel.fragment.SlideshowViewModel
import org.koin.android.ext.koin.androidApplication
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val myModule = module{

    val service: Retrofit = Retrofit.Builder()
        .baseUrl("https://dca04efa0205.ngrok.io/")
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
    viewModel { MainViewModel(get()) }
    viewModel { SlideshowViewModel() }
    viewModel { LoginViewModel(get<GetAPI>(), get<Context>()) }
    viewModel { SettingViewModel() }
    viewModel { SignUpViewModel(get<GetAPI>(), get<AddAPI>(), get<CheckAPI>()) }
}