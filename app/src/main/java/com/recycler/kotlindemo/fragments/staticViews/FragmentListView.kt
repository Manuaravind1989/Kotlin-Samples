package com.recycler.kotlindemo.fragments.staticViews

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListView
import com.recycler.kotlindemo.R
import com.recycler.kotlindemo.adapters.ListViewAdapter

/**
 * Created by Manu on 10/29/2017.
 */
class FragmentListView : Fragment() {

    var arrayofData = arrayOf("One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten");

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var view = inflater?.inflate(R.layout.fragment_listview, container, false)
        var listView = view!!.findViewById(R.id.listview) as ListView
        var listAdapter = ListViewAdapter(activity, arrayofData)
        listView.adapter = listAdapter
        return view;

    }


}