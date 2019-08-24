package com.toshiro.weatherapp.ui.home

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.*
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.drawerlayout.widget.DrawerLayout
import androidx.viewpager.widget.ViewPager
import com.google.android.material.navigation.NavigationView
import com.toshiro.weatherapp.R
import com.toshiro.weatherapp.data.local.WeatherData
import com.toshiro.weatherapp.data.network.currentWeather.DataCurrent
import com.toshiro.weatherapp.ui.base.BaseFragment
import com.toshiro.weatherapp.utils.Constant


class HomeFragment : BaseFragment(), View.OnClickListener, HomeContract.View {
    override fun showAllData(weatherData: WeatherData) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


    private lateinit var mToolbar: Toolbar
    private lateinit var mDrawerLayout: DrawerLayout
    private lateinit var mNavView: NavigationView
    private lateinit var mBtnOpenDrawer: ImageView
    private lateinit var mBtnCloseDrawer: ImageView
    private lateinit var mBtnShareImage: ImageView
    private lateinit var mBtnAddLocation: ImageView
    private lateinit var mBtnSetting: ImageView
    private lateinit var mViewPager: ViewPager

    private var homePresent: HomePresent? = null

    override fun setUpView(view: View) {
        getPresenter().let {
            it!!.getAndConverterData("", 105.7934252, 21.0376641)
        }

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_home, container, false)

        initView(view)

        val activity = activity as AppCompatActivity?
        activity!!.setSupportActionBar(mToolbar)

        activity.application
        return view

    }

    private fun initView(view: View) {
        mToolbar = view.findViewById(R.id.toolBarHome)
        mDrawerLayout = view.findViewById(R.id.drawer_layout)
        mNavView = view.findViewById(R.id.nav_view)
        mViewPager = view.findViewById(R.id.view_pager)

        mBtnOpenDrawer = view.findViewById(R.id.imgTBRightToggle)
        mBtnCloseDrawer = view.findViewById(R.id.imgTBClose)
        mBtnShareImage = view.findViewById(R.id.imgTBShare)
        mBtnAddLocation = view.findViewById(R.id.imgTBAdd)
        mBtnSetting = view.findViewById(R.id.imgTBSetting)

        //set onclick
        mBtnOpenDrawer.setOnClickListener(this)
        mBtnCloseDrawer.setOnClickListener(this)
        mBtnShareImage.setOnClickListener(this)
        mBtnAddLocation.setOnClickListener(this)
        mBtnSetting.setOnClickListener(this)

    }

    @SuppressLint("RtlHardcoded")
    override fun onClick(view: View?) {
        when (view!!.id) {
            R.id.imgTBRightToggle -> {
                mDrawerLayout.openDrawer(Gravity.RIGHT)
            }
            R.id.imgTBClose -> {
                mDrawerLayout.closeDrawer(Gravity.RIGHT)
            }
            R.id.imgTBShare -> {
                // do share image
            }
            R.id.imgTBAdd -> {
                // do add location
            }
            R.id.imgTBSetting -> {
                // do open setting
            }
        }
    }

    fun getPresenter(): HomePresent? {
        homePresent = HomePresent(this, activity!!.application)
        return homePresent
    }


}
