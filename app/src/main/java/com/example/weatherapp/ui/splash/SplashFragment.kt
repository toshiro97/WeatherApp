package com.example.weatherapp.ui.splash


import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.Navigation

import com.example.weatherapp.R
import com.example.weatherapp.data.prefs.PreferencesManager
import com.example.weatherapp.ui.base.BaseFragment

class SplashFragment : BaseFragment() {




    private lateinit var navController: NavController
    private lateinit var preferencesManager: PreferencesManager
    private val mHandlerLeak = Handler()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_splash, container, false)
    }


    override fun setUpView(view: View) {
        navController = Navigation.findNavController(view)
        preferencesManager = PreferencesManager(context!!)

        mHandlerLeak.postDelayed({
            authenticationFragment(preferencesManager.isFirstTime())
        }, 1000)
    }

    override fun onDestroy() {
        super.onDestroy()
        mHandlerLeak.removeCallbacksAndMessages(null)
    }


    private fun authenticationFragment(isFirstTime: Boolean) {
        when (isFirstTime) {
            true -> navController.navigate(R.id.action_splashFragment_to_introFragment)
            false -> navController.navigate(R.id.action_splashFragment_to_homeFragment)
        }
    }

}
