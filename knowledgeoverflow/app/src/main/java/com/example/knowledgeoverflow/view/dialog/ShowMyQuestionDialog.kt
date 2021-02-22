package com.example.knowledgeoverflow.view.dialog

import com.example.knowledgeoverflow.R
import com.example.knowledgeoverflow.base.BaseDialog
import com.example.knowledgeoverflow.databinding.DialogShowMyQuestionBinding
import com.example.knowledgeoverflow.viewmodel.dialog.ShowMyQuestionViewModel
import org.koin.androidx.viewmodel.ext.android.getViewModel

class ShowMyQuestionDialog : BaseDialog<DialogShowMyQuestionBinding, ShowMyQuestionViewModel>() {
    override val viewModel: ShowMyQuestionViewModel
        get() = getViewModel(ShowMyQuestionViewModel::class)
    override val resource: Int
        get() = R.layout.dialog_show_my_question

    override fun init() {

    }

    override fun observerViewModel() {

    }


}