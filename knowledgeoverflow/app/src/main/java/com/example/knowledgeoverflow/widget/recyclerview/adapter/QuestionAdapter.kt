package com.example.knowledgeoverflow.widget.recyclerview.adapter

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.knowledgeoverflow.databinding.ItemQuestionBinding

class QuestionAdapter : RecyclerView.Adapter<QuestionAdapter.ViewHolder>() {

    class ViewHolder(val binding : ItemQuestionBinding) : RecyclerView.ViewHolder(binding.root) {
        private val adapter = QuestionAdapter()

        fun bind(){

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }
}