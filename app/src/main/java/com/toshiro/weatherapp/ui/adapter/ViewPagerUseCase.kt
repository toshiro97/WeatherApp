package com.toshiro.weatherapp.ui.adapter

import android.util.SparseArray
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import androidx.viewpager.widget.ViewPager
import java.lang.ref.WeakReference

class ViewPagerUseCase constructor(
    viewPagerInterface: ViewPagerUseCase.ViewPagerInterface,
    fragmentManager: FragmentManager
) {

    interface ViewPagerInterface {
        fun getCountViewPager(): Int
        fun getFragmentItemViewPager(position: Int): Fragment
        fun getPagerTitleViewPager(position: Int): CharSequence
        fun getViewPager(): ViewPager
    }

    init {
        val adapter = MyPagerAdapter(viewPagerInterface, fragmentManager)
        viewPagerInterface.getViewPager().adapter = adapter
    }

    private class MyPagerAdapter(
        viewPagerInterface: ViewPagerInterface,
        fragmentManager: FragmentManager
    ) :
        FragmentStatePagerAdapter(fragmentManager) {

        private val fragment: WeakReference<ViewPagerInterface> = WeakReference(viewPagerInterface)
        private val registerFragment: SparseArray<Fragment> = SparseArray()

        override fun instantiateItem(container: ViewGroup, position: Int): Any {
            val fragment = super.instantiateItem(container, position)
            if (fragment is Fragment) {
                registerFragment.put(position, fragment)
            }
            return fragment
        }

        override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
            registerFragment.remove(position)
            super.destroyItem(container, position, `object`)
        }

        override fun getItem(position: Int): Fragment {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            return fragment.get()?.getFragmentItemViewPager(position)!!
        }

        override fun getCount(): Int {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            val viewPagerInterface = fragment.get()
            if (viewPagerInterface != null) {
                return viewPagerInterface.getCountViewPager()
            } else {
                return 0
            }
        }

        fun getRegisterFragment(position: Int): Fragment {
            return registerFragment.get(position)
        }
    }
}