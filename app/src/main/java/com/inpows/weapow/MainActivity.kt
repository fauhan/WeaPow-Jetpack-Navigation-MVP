package com.inpows.weapow

import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.inpows.weapow.base.BaseActivity
import com.inpows.weapow.databinding.ActivityMainBinding


/**
 * @author Fauhan Handay Pugar (fauhan.pugar@dana.id)
 * @version MainActivity, v 0.1 27/04/22 20.44 by Fauhan Handay Pugar
 */
class MainActivity: BaseActivity(){

    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding!!

    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val navHostFragment = supportFragmentManager
            .findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        navController = navHostFragment.navController
    }

    override fun init() {
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}