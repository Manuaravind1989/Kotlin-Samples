package com.recycler.kotlindemo.fragments.staticViews

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.recycler.kotlindemo.R
import com.recycler.kotlindemo.adapters.RecyclerViewAdapter

/**
 * Created by Manu on 10/30/2017.
 */
class FragmentRecyclerView : Fragment() {

    var arrayofData = arrayOf("One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten");
    var gambarArray = arrayOf(R.drawable.menuprofile, R.drawable.menuprofile,
            R.drawable.menuprofile, R.drawable.menuprofile, R.drawable.menuprofile,
            R.drawable.menuprofile, R.drawable.menuprofile,
            R.drawable.menuprofile, R.drawable.menuprofile, R.drawable.menuprofile)

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var rootView = inflater?.inflate(R.layout.fragment_recyclerview, container, false)
        var recycler_view = rootView!!.findViewById(R.id.recycler_view) as RecyclerView
        var recyclerAdapter = RecyclerViewAdapter(activity, arrayofData, gambarArray)
        var linear = LinearLayoutManager(activity)
        recycler_view.layoutManager = linear

        //recView.layoutManager = LinearLayoutManager(baseContext,LinearLayoutManager.VERTICAL,false)
        //recView.addItemDecoration(DividerItemDecoration(this,DividerItemDecoration.VERTICAL))
        //recView.itemAnimator= DefaultItemAnimator()
        recycler_view.adapter = recyclerAdapter
        return rootView;

    }


}