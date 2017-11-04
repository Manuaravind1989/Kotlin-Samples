package com.recycler.kotlindemo


import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.v4.view.GravityCompat
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.MenuItem
import com.recycler.kotlindemo.fragments.*
import com.recycler.kotlindemo.fragments.dialogs.FragmentDialogs
import com.recycler.kotlindemo.fragments.serviceViews.FragmentGrid
import com.recycler.kotlindemo.fragments.serviceViews.FragmentPopular
import com.recycler.kotlindemo.fragments.serviceViews.FragmentPopularSearch
import com.recycler.kotlindemo.fragments.staticViews.FragmentListView
import com.recycler.kotlindemo.fragments.staticViews.FragmentRecyclerView
import kotlinx.android.synthetic.main.activity_home.*
import kotlinx.android.synthetic.main.toolbar_main.*

/**
 * Created by Manu on 10/28/2017.
 */
class HomeActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener, OnFragmentInteractionListener {

    val TAG = "MainActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        setSupportActionBar(toolbar_main)
        val toggle = ActionBarDrawerToggle(this, drawer_layout, toolbar_main, R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        drawer_layout.addDrawerListener(toggle)
        toggle.syncState()
        nav_view.setNavigationItemSelectedListener(this)
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        val homeFragment = FragmentHome()
        fragmentTransaction.replace(R.id.frame_layout_main, homeFragment)
        fragmentTransaction.commit()
    }

    override fun onBackPressed() {
        if (drawer_layout.isDrawerOpen(GravityCompat.START)) {
            drawer_layout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        // Handle navigation view item clicks here.
        when (item.itemId) {
            R.id.nav_home -> {
                supportFragmentManager.beginTransaction().replace(R.id.frame_layout_main, FragmentHome()).commit()
            }
            R.id.nav_profile -> {
                supportFragmentManager.beginTransaction().replace(R.id.frame_layout_main, FragmentProfile()).commit()
            }
            R.id.nav_aboutus -> {
                supportFragmentManager.beginTransaction().replace(R.id.frame_layout_main, FragmentAboutus()).commit()
            }
            R.id.nav_contactus -> {
                supportFragmentManager.beginTransaction().replace(R.id.frame_layout_main, FragmentContactus()).commit()
            }
            R.id.nav_settings -> {
                supportFragmentManager.beginTransaction().replace(R.id.frame_layout_main, FragmentSettings()).commit()
            }
        }
        drawer_layout.closeDrawer(GravityCompat.START)
        return true
    }

    override fun onFragmentInteraction(position: Int) {
        when (position) {
            ActivityConstants.view_home ->
                supportFragmentManager.beginTransaction().replace(R.id.frame_layout_main, FragmentListViewHome()).commit()

            ActivityConstants.list_fragment ->
                supportFragmentManager.beginTransaction().replace(R.id.frame_layout_main, FragmentListView()).commit()
            ActivityConstants.recycler_fragment ->
                supportFragmentManager.beginTransaction().replace(R.id.frame_layout_main, FragmentRecyclerView()).commit()

            ActivityConstants.grid_fragments ->
                supportFragmentManager.beginTransaction().replace(R.id.frame_layout_main, FragmentGrid()).commit()
            ActivityConstants.view_pager_fragments -> Log.i(this.TAG, "onFragmentInteraction with FooBarFragment")

            ActivityConstants.view_popular_fragments ->
                supportFragmentManager.beginTransaction().replace(R.id.frame_layout_main, FragmentPopular()).commit()
            ActivityConstants.view_search_fragments ->
                supportFragmentManager.beginTransaction().replace(R.id.frame_layout_main, FragmentPopularSearch()).commit()
            ActivityConstants.view_utils ->
                supportFragmentManager.beginTransaction().replace(R.id.frame_layout_main, FragmentUtilsHome()).commit()

            ActivityConstants.view_dialog ->
                supportFragmentManager.beginTransaction().replace(R.id.frame_layout_main, FragmentDialogs()).commit()
        }
    }

}