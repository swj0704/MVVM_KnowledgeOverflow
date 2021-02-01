package com.example.knowledgeoverflow.widget.recyclerview.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.LifecycleOwner
import androidx.recyclerview.widget.RecyclerView
import com.example.knowledgeoverflow.R
import com.example.knowledgeoverflow.databinding.ItemQuestionBinding
import com.example.knowledgeoverflow.network.DTO.QuestionResponse
import com.example.knowledgeoverflow.widget.recyclerview.viewmodel.QuestionItemViewModel

class QuestionAdapter(private val context: Context) : RecyclerView.Adapter<QuestionAdapter.ViewHolder>() {

    var questionItem = ArrayList<QuestionResponse>()

    fun setList(questionList : ArrayList<QuestionResponse>){
        this.questionItem = questionList
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.item_question, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(questionItem[position])
    }

    override fun getItemCount(): Int {
        return questionItem.size
    }

    inner class ViewHolder(val binding : ItemQuestionBinding) : RecyclerView.ViewHolder(binding.root) {
        private val viewModel = QuestionItemViewModel()

        fun bind(item : QuestionResponse){
            viewModel.bind(item)

            binding.lifecycleOwner?.let {
                viewModel.onDetailEvent.observe(it, {
                    // 세부사항으로 이동 context.startActivity(Intent(context))
                })
            }

            binding.viewModel = viewModel
        }

    }
}