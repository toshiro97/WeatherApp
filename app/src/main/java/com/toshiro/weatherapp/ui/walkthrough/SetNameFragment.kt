package com.toshiro.weatherapp.ui.walkthrough


import android.os.Bundle
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.toshiro.weatherapp.R
import com.toshiro.weatherapp.data.prefs.PreferencesManager
import com.toshiro.weatherapp.ui.base.BaseFragment
import com.toshiro.weatherapp.utils.showSnackbar
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.fragment_set_name.*

class SetNameFragment : BaseFragment(), View.OnClickListener {


    private lateinit var navController: NavController
    private lateinit var preferencesManager: PreferencesManager


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_set_name, container, false)
    }

    override fun setUpView(view: View) {
        navController = Navigation.findNavController(view)
        preferencesManager = PreferencesManager(context!!)

        btnNextToHome.setOnClickListener(this)
    }

    override fun onClick(p0: View?) {
        if (!TextUtils.isEmpty(edName.text.toString())) {
            preferencesManager.setUser(edName.text.toString())
            preferencesManager.setFirstTime(false)
            navController.navigate(R.id.action_setNameFragment_to_homeFragment)
        } else {
            contentSetName.showSnackbar(getString(R.string.set_name_error), Snackbar.LENGTH_SHORT)
        }
    }

}
