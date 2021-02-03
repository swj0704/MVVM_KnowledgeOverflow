package com.example.knowledgeoverflow.widget.recyclerview.adapter

import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.LifecycleOwner
import androidx.recyclerview.widget.RecyclerView
import com.example.knowledgeoverflow.R
import com.example.knowledgeoverflow.databinding.ItemQuestionBinding
import com.example.knowledgeoverflow.network.DTO.QuestionResponse
import com.example.knowledgeoverflow.view.activity.ShowQuestionActivity
import com.example.knowledgeoverflow.widget.recyclerview.viewmodel.QuestionItemViewModel

class QuestionAdapter(private val context: Context) : RecyclerView.Adapter<QuestionAdapter.ViewHolder>() {

    var questionItem = ArrayList<QuestionResponse>()

    fun setList(questionList : ArrayList<QuestionResponse>){
        this.questionItem = questionList
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = ViewHolder(DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.item_question, parent, false))
        Log.d("Show View", "TEST3")
        return view
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        Log.d("Show View", "TEST2")
        holder.bind(questionItem[position])
    }

    override fun getItemCount(): Int {
        Log.d("Show View", "TEST1")
        Log.d("Show View", questionItem.size.toString())
        return questionItem.size
    }

    inner class ViewHolder(val binding : ItemQuestionBinding) : RecyclerView.ViewHolder(binding.root) {
        private val viewModel = QuestionItemViewModel()

        fun bind(item : QuestionResponse){
            viewModel.bind(item)
            binding.lifecycleOwner?.let {
                Log.d("Show View", "TEST")
                viewModel.onDetailEvent.observe(it, {
                    Log.d("Show View", "TEST")
                    context.startActivity(Intent(context, ShowQuestionActivity::class.java))
                })
            }

            binding.viewModel = viewModel
        }

    }
}