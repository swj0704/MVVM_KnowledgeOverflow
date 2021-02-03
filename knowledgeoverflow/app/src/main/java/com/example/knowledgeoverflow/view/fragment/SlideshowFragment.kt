package com.example.knowledgeoverflow.view.fragment

import android.view.Menu
import android.view.MenuInflater
import android.widget.SearchView
import com.example.knowledgeoverflow.R
import com.example.knowledgeoverflow.base.BaseFragment
import com.example.knowledgeoverflow.databinding.FragmentSlideshowBinding
import com.example.knowledgeoverflow.view.activity.WriteQuestionActivity
import com.example.knowledgeoverflow.viewmodel.fragment.SlideshowViewModel
import com.example.knowledgeoverflow.widget.extention.startActivity
import org.koin.android.ext.android.get
import org.koin.androidx.viewmodel.ext.android.getViewModel

class SlideshowFragment : BaseFragment<FragmentSlideshowBinding, SlideshowViewModel>() {
    override val resource: Int
        get() = R.layout.fragment_slideshow

    override val viewModel: SlideshowViewModel
        get() = getViewModel(SlideshowViewModel::class)

    override fun init() {
        setHasOptionsMenu(true)
        viewModel.getList("상식")
    }

    override fun observerViewModel() {
        with(viewModel){
            goWriteQuestionEvent.observe(this@SlideshowFragment, {
                context?.let { it1 -> startActivity(it1, WriteQuestionActivity::class.java) }
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
                        viewModel.getList(viewModel.item, s)
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