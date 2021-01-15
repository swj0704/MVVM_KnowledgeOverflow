package com.example.knowledgeoverflow.view.activity

import android.view.Menu
import androidx.appcompat.widget.Toolbar
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.knowledgeoverflow.R
import com.example.knowledgeoverflow.base.BaseActivity
import com.example.knowledgeoverflow.databinding.ActivityMainBinding
import com.example.knowledgeoverflow.viewmodel.activity.MainViewModel
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.nav_header_main.view.*
import org.koin.androidx.viewmodel.ext.android.getViewModel

class MainActivity : BaseActivity<MainViewModel, ActivityMainBinding>() {

    private lateinit var appBarConfiguration: AppBarConfiguration

    override val resource: Int
        get() = R.layout.main_include_drawer


    override val viewModel: MainViewModel
        get() = getViewModel(MainViewModel::class)

    override fun init() {

        val navigationView : NavigationView = findViewById(R.id.navigation_view)

        val toolbar : Toolbar = findViewById(R.id.toolbar)
        val drawerLayout: DrawerLayout = findViewById(R.id.main_drawer_layout)
        setSupportActionBar(toolbar)

        val navController = findNavController(R.id.nav_host_fragment)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.

        appBarConfiguration = AppBarConfiguration(
                setOf(
                        R.id.navigation_home, R.id.navigation_slideshow, R.id.navigation_setting
                ), drawerLayout
        )

        setText()

        setupActionBarWithNavController(navController, appBarConfiguration)
        navigationView.setupWithNavController(navController)
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
    private fun setText(){
        val navView: NavigationView = findViewById(R.id.navigation_view)
        val header = navView.getHeaderView(0)

        header.sideEmailText.text = viewModel.email
        header.sideNickNameText.text = viewModel.nickName
    }
}