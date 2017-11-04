package com.recycler.kotlindemo.fragments

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.recycler.kotlindemo.ActivityConstants
import com.recycler.kotlindemo.OnFragmentInteractionListener
import com.recycler.kotlindemo.R

/**
 * Created by Manu on 11/3/2017.
 */
class FragmentListViewHome : Fragment(),View.OnClickListener {

    private var mListener: OnFragmentInteractionListener? = null
    private var listview_button: Button? = null
    private var recyclerview_button: Button? = null
    private var recyclerview_remote_button: Button? = null
    private var recyclerview_search_button: Button? = null
    private var recyclerview_grid_button: Button? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        var rootview = inflater.inflate(R.layout.fragment_listview_home, container, false)
        listview_button = rootview.findViewById(R.id.listview_button) as Button?
        listview_button!!.setOnClickListener(this)
        recyclerview_button = rootview.findViewById(R.id.recyclerview_button) as Button
        recyclerview_button!!.setOnClickListener(this)
        recyclerview_remote_button = rootview.findViewById(R.id.recyclerview_remote_button) as Button
        recyclerview_remote_button!!.setOnClickListener(this)
        recyclerview_search_button = rootview.findViewById(R.id.recyclerview_search_button) as Button
        recyclerview_search_button!!.setOnClickListener(this)
        recyclerview_grid_button = rootview.findViewById(R.id.recyclerview_grid_button) as Button
        recyclerview_grid_button!!.setOnClickListener(this)
        return rootview
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.listview_button -> {
                if (mListener != null) {
                    mListener!!.onFragmentInteraction(ActivityConstants.list_fragment)
                }
            }
            R.id.recyclerview_button -> {
                if (mListener != null) {
                    mListener!!.onFragmentInteraction(ActivityConstants.recycler_fragment)
                }
            }
            R.id.recyclerview_remote_button -> {
                if (mListener != null) {
                    mListener!!.onFragmentInteraction(ActivityConstants.view_popular_fragments)
                }
            }
            R.id.recyclerview_search_button -> {
                if (mListener != null) {
                    mListener!!.onFragmentInteraction(ActivityConstants.view_search_fragments)
                }
            }
            R.id.recyclerview_grid_button -> {
                if (mListener != null) {
                    mListener!!.onFragmentInteraction(ActivityConstants.grid_fragments)
                }
            }
            else -> {/* do your code */
            }
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is OnFragmentInteractionListener) {
            mListener = context
        } else {
            throw RuntimeException(context.toString() + " must implement OnFragmentInteractionListener")
        }
    }

    override fun onDetach() {
        super.onDetach()
        mListener = null
    }

}
