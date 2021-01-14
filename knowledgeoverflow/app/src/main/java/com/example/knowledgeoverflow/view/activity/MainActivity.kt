package com.example.knowledgeoverflow.view.activity

import android.view.Menu
import androidx.appcompat.widget.Toolbar
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.knowledgeoverflow.BR
import com.example.knowledgeoverflow.R
import com.example.knowledgeoverflow.base.BaseActivity
import com.example.knowledgeoverflow.databinding.ActivityMainBinding
import com.example.knowledgeoverflow.databinding.MainIncludeDrawerBinding
import com.example.knowledgeoverflow.viewmodel.activity.MainViewModel
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.nav_header_main.view.*

class MainActivity : BaseActivity<MainViewModel, ActivityMainBinding>() {

    private lateinit var appBarConfiguration: AppBarConfiguration

    override val resource: Int
        get() = R.layout.activity_main

    lateinit var back: MainIncludeDrawerBinding

    override val viewModel: MainViewModel
        get() = MainViewModel(this@MainActivity)

    override fun init() {

        back = DataBindingUtil.setContentView(this, R.layout.main_include_drawer)
        back.setVariable(BR.viewModel, viewModel)
        back.lifecycleOwner = this
        back.executePendingBindings()

        setSupportActionBar(binding.toolbar)

        val navController = findNavController(R.id.nav_host_fragment)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.

        setupActionBarWithNavController(navController, appBarConfiguration)
        back.navigationView.setupWithNavController(navController)
    }

    override fun observerViewModel() {
        
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }

}