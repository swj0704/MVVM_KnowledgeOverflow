package com.example.knowledgeoverflow.di

import com.example.knowledgeoverflow.viewmodel.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val myModule = module{
    viewModel { MainViewModel() }
}