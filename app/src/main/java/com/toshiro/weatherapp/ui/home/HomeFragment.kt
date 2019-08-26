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
import com.toshiro.weatherapp.ui.adapter.HomePagerAdapter
import com.toshiro.weatherapp.ui.base.BaseFragment
import android.widget.Toast
import androidx.viewpager.widget.ViewPager.OnPageChangeListener
import com.toshiro.weatherapp.data.database.AppDatabase
import com.toshiro.weatherapp.data.local.WeatherData
import com.toshiro.weatherapp.utils.ZoomOutPageTransformer


class HomeFragment : BaseFragment(), View.OnClickListener, HomeContract.View {


    private lateinit var mToolbar: Toolbar
    private lateinit var mDrawerLayout: DrawerLayout
    private lateinit var mNavView: NavigationView
    private lateinit var mBtnOpenDrawer: ImageView
    private lateinit var mBtnCloseDrawer: ImageView
    private lateinit var mBtnShareImage: ImageView
    private lateinit var mBtnAddLocation: ImageView
    private lateinit var mBtnSetting: ImageView
    private lateinit var mViewPager: ViewPager
    private lateinit var mAdapter: HomePagerAdapter

    private var appDatabase: AppDatabase? = null
    private var mListDataWeather: List<WeatherData>? = null

    private var mHomePresent: HomePresent ?= null


    override fun setUpView(view: View) {
        getHomePresenter().getDataFromDatabase()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_home, container, false)
        appDatabase = AppDatabase.getAppDataBase(context!!)

        initView(view)

        val activity = activity as AppCompatActivity?
        activity!!.setSupportActionBar(mToolbar)

        getHomePresenter()

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

        //setup viewpager


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


    private fun eventViewpager() {
        mViewPager.addOnPageChangeListener(object : OnPageChangeListener {

            // This method will be invoked when a new page becomes selected.
            override fun onPageSelected(position: Int) {
                Toast.makeText(
                    context,
                    "Selected page position: $position", Toast.LENGTH_SHORT
                ).show()
            }

            // This method will be invoked when the current page is scrolled
            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {
                // Code goes here
            }

            // Called when the scroll state changes:
            // SCROLL_STATE_IDLE, SCROLL_STATE_DRAGGING, SCROLL_STATE_SETTLING
            override fun onPageScrollStateChanged(state: Int) {
                // Code goes here
            }
        })
    }

    private fun getHomePresenter(): HomePresent {
        mHomePresent = HomePresent(this)
        return mHomePresent!!
    }

    override fun showFragment(listWeatherData: List<WeatherData>) {
        mListDataWeather = listWeatherData

        mAdapter = HomePagerAdapter(
            fragmentManager!!, mListDataWeather!!
        )
        mViewPager.setPageTransformer(true, ZoomOutPageTransformer())
        mViewPager.adapter = mAdapter
        eventViewpager()
    }

    override fun onStop() {
        super.onStop()
        mHomePresent?.let {
            mHomePresent!!.unbindView()
            mHomePresent = null
        }
    }


}
