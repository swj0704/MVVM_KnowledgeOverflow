package com.example.knowledgeoverflow.widget.recyclerview.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.knowledgeoverflow.R
import com.example.knowledgeoverflow.databinding.ItemQuestionBinding
import com.example.knowledgeoverflow.network.DTO.QuestionResponse
import com.example.knowledgeoverflow.widget.recyclerview.viewmodel.QuestionItemViewModel

class QuestionAdapter(private val questionItem : ArrayList<QuestionResponse>) : RecyclerView.Adapter<QuestionAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.item_question, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(questionItem[position])
    }

    override fun getItemCount(): Int {
        return questionItem.size
    }

    class ViewHolder(val binding : ItemQuestionBinding) : RecyclerView.ViewHolder(binding.root) {
        private val viewModel = QuestionItemViewModel()

        fun bind(item : QuestionResponse){
            viewModel.bind(item)
            binding.viewModel = viewModel
        }

    }
}