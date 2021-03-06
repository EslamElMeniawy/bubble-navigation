package com.gauravk.bubblebarsample

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.view.ViewPager
import com.gauravk.bubblebarsample.adapters.ScreenSlidePagerAdapter
import com.gauravk.bubblebarsample.fragment.ScreenSlidePageFragment
import kotlinx.android.synthetic.main.activity_bottom_bar.*

class BottomBarActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bottom_bar)

        val fragList = ArrayList<ScreenSlidePageFragment>()
        fragList.add(ScreenSlidePageFragment.newInstance(getString(R.string.home), R.color.red_inactive))
        fragList.add(ScreenSlidePageFragment.newInstance(getString(R.string.search), R.color.blue_inactive))
        fragList.add(ScreenSlidePageFragment.newInstance(getString(R.string.likes), R.color.blue_grey_inactive))
        fragList.add(ScreenSlidePageFragment.newInstance(getString(R.string.notification), R.color.green_inactive))
        fragList.add(ScreenSlidePageFragment.newInstance(getString(R.string.profile), R.color.purple_inactive))
        val pagerAdapter = ScreenSlidePagerAdapter(fragList, supportFragmentManager)
        view_pager.adapter = pagerAdapter
        view_pager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrollStateChanged(p0: Int) {

            }

            override fun onPageScrolled(p0: Int, p1: Float, p2: Int) {

            }

            override fun onPageSelected(p0: Int) {
                bottom_navigation_view_linear.setCurrentActiveItem(p0)
            }

        })

        bottom_navigation_view_linear.setNavigationChangeListener { _, position ->
            view_pager.setCurrentItem(position, true)
        }
    }


}
