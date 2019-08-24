package com.toshiro.weatherapp.ui.base

import android.app.ProgressDialog
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.toshiro.weatherapp.utils.showProgressDialog

abstract class BaseFragment : Fragment(), BaseContract.View {

    private var mProgressDialog: ProgressDialog? = null

    abstract fun setUpView(view: View)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpView(view)
    }

    override fun showLoading() {
        hideLoading()
        mProgressDialog = showProgressDialog(context!!)
    }

    override fun hideLoading() {
        if (mProgressDialog != null && mProgressDialog!!.isShowing) {
            mProgressDialog!!.cancel()
        }
    }

    override fun loadError(e: Throwable) {
        showHttpError(e)
    }

    override fun loadError(msg: String) {
        Toast.makeText(context, msg, Toast.LENGTH_SHORT).show()
    }

    private fun showHttpError(e: Throwable) {
        loadError(e.localizedMessage)
    }

    override fun onDestroy() {
        super.onDestroy()
        System.gc()
        System.runFinalization()
        hideLoading()
        mProgressDialog = null
    }


}
