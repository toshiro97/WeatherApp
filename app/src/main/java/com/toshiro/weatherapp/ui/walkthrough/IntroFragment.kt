package com.toshiro.weatherapp.ui.walkthrough

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.Navigation

import com.toshiro.weatherapp.R
import com.toshiro.weatherapp.ui.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_intro.*


class IntroFragment : BaseFragment(), View.OnClickListener {


    private lateinit var navController: NavController

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_intro, container, false)
    }

    override fun setUpView(view: View) {
        navController = Navigation.findNavController(view)

        btnNextToUser.setOnClickListener(this)
    }

    override fun onClick(p0: View?) {
        navController.navigate(R.id.action_introFragment_to_setNameFragment)
    }


}
