package com.example.knowledgeoverflow.view.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.knowledgeoverflow.R
import com.example.knowledgeoverflow.base.BaseActivity
import com.example.knowledgeoverflow.databinding.ActivityWriteQuestionBinding
import com.example.knowledgeoverflow.viewmodel.activity.WriteQuestionViewModel
import org.koin.androidx.viewmodel.ext.android.getViewModel

class WriteQuestionActivity : BaseActivity<WriteQuestionViewModel, ActivityWriteQuestionBinding>() {
    override val resource: Int
        get() = R.layout.activity_write_question
    override val viewModel: WriteQuestionViewModel
        get() = getViewModel(WriteQuestionViewModel::class)

    override fun init() {
        TODO("Not yet implemented")
    }

    override fun observerViewModel() {
        TODO("Not yet implemented")
    }


}