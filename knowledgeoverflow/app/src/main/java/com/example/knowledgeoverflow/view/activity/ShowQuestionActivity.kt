package com.example.knowledgeoverflow.view.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.knowledgeoverflow.R
import com.example.knowledgeoverflow.base.BaseActivity
import com.example.knowledgeoverflow.databinding.ActivityShowQuestionBinding
import com.example.knowledgeoverflow.viewmodel.activity.ShowQuestionViewModel
import org.koin.androidx.viewmodel.ext.android.getViewModel

class ShowQuestionActivity : BaseActivity<ShowQuestionViewModel, ActivityShowQuestionBinding>() {
    override val resource: Int
        get() = R.layout.activity_show_question
    override val viewModel: ShowQuestionViewModel
        get() = getViewModel(ShowQuestionViewModel::class)

    override fun init() {}

    override fun observerViewModel() {

    }
}