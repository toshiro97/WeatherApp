package com.example.weatherapp.ui.walkthrough

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.Navigation

import com.example.weatherapp.R
import com.example.weatherapp.ui.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_intro.*


class IntroFragment : BaseFragment() {
    override fun setUpView(view: View) {
        navController = Navigation.findNavController(view)

        btnNextToUser.setOnClickListener {
            navController.navigate(R.id.action_introFragment_to_setNameFragment)
        }
    }

    private lateinit var navController: NavController

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_intro, container, false)
    }


}
