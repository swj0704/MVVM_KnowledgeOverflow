package com.example.knowledgeoverflow.view.fragment

import android.view.Menu
import android.view.MenuInflater
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.SearchView
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

    var item : String = ""

    override fun init() {
        setHasOptionsMenu(true)

        val spinnerArray: MutableList<String> = ArrayList()
        spinnerArray.add("상식")
        spinnerArray.add("코딩")
        spinnerArray.add("일상")
        val adapter = ArrayAdapter<String>(viewModel.mContext, android.R.layout.simple_spinner_item, spinnerArray)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        binding.themeSpinner.adapter = adapter
        binding.themeSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                item = spinnerArray[position]
                viewModel.getList(spinnerArray[position])
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                item = spinnerArray[0]
                viewModel.getList("상식")
            }
        }
    }

    override fun observerViewModel() {
        with(viewModel){
            goWriteQuestionEvent.observe(this@SlideshowFragment, {
                // 질문 적는 곳으로 이동!
            })
            onChangeListEvent.observe(this@SlideshowFragment, {
                // 리스트 변경
            })
        }
    }
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)

        val search = menu.findItem(R.id.action_search)
        val searchView : SearchView = search.actionView as SearchView
        searchView.queryHint = "제목 검색"
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(s: String?): Boolean {
                if (s != null) {
                    if(s.isNotEmpty()) {
                        viewModel.getList(item, s)
                    }
                }
                return false
            }

            override fun onQueryTextChange(p0: String?): Boolean {
                return false
            }

        })
    }



}