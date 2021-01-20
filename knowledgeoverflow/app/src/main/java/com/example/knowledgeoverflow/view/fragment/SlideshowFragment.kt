package com.example.knowledgeoverflow.view.fragment

import android.widget.ArrayAdapter
import com.example.knowledgeoverflow.R
import com.example.knowledgeoverflow.base.BaseFragment
import com.example.knowledgeoverflow.databinding.FragmentSlideshowBinding
import com.example.knowledgeoverflow.view.activity.MainActivity
import com.example.knowledgeoverflow.viewmodel.fragment.SlideshowViewModel
import org.koin.androidx.viewmodel.ext.android.getViewModel

class SlideshowFragment : BaseFragment<FragmentSlideshowBinding, SlideshowViewModel>() {
    override val resource: Int
        get() = R.layout.fragment_slideshow

    override val viewModel: SlideshowViewModel
        get() = getViewModel(SlideshowViewModel::class)

    override fun init() {
        val spinnerArray: MutableList<String> = ArrayList()
        spinnerArray.add("상식")
        spinnerArray.add("코딩")
        spinnerArray.add("일상")
        val adapter = ArrayAdapter<String>(viewModel.mContext, android.R.layout.simple_spinner_item, spinnerArray)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        binding.themeSpinner.adapter = adapter
    }

    override fun observerViewModel() {
        with(viewModel){
            goWriteQuestionEvent.observe(this@SlideshowFragment, {
                // 질문 적는 곳으로 이동!
            })
        }
    }


}