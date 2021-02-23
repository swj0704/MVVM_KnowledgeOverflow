package com.example.knowledgeoverflow.di

import com.example.knowledgeoverflow.network.api.*
import com.example.knowledgeoverflow.viewmodel.activity.*
import com.example.knowledgeoverflow.viewmodel.fragment.HomeViewModel
import com.example.knowledgeoverflow.viewmodel.fragment.SettingViewModel
import com.example.knowledgeoverflow.viewmodel.fragment.SlideshowViewModel
import com.example.knowledgeoverflow.widget.recyclerview.viewmodel.QuestionItemViewModel
import org.koin.android.ext.koin.androidApplication
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val myModule = module{

    val service: Retrofit = Retrofit.Builder()
        .baseUrl("https://66ab83d5ef45.ngrok.io/")
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
    viewModel { HomeViewModel(androidApplication()) }
    viewModel { MainViewModel(get()) }
    viewModel { SlideshowViewModel(get<GetAPI>(), androidApplication()) }
    viewModel { LoginViewModel(get<GetAPI>(), androidApplication()) }
    viewModel { SettingViewModel(androidApplication()) }
    viewModel { SignUpViewModel(get<GetAPI>(), get<AddAPI>(), get<CheckAPI>()) }
    viewModel { WriteQuestionViewModel(get<GetAPI>(), get<AddAPI>(), get<CheckAPI>()) }
    viewModel { QuestionItemViewModel() }
    viewModel { ShowQuestionViewModel() }
}