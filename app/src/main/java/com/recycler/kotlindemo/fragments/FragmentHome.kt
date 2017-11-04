package com.recycler.kotlindemo.fragments

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.CardView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.recycler.kotlindemo.ActivityConstants
import com.recycler.kotlindemo.OnFragmentInteractionListener
import com.recycler.kotlindemo.R

/**
 * Created by Manu on 10/29/2017.
 */
class FragmentHome : Fragment(), View.OnClickListener {

    private var cardViewList: CardView? = null
    private var cardViewUtils: CardView? = null
    private var cardViewStorage: CardView? = null
    private var cardViewOthers: CardView? = null

    private var mListener: OnFragmentInteractionListener? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        var rootview = inflater.inflate(R.layout.fragment_home, container, false)
        cardViewList = rootview.findViewById(R.id.card_viewList) as CardView?
        cardViewList!!.setOnClickListener(this)
        cardViewUtils = rootview.findViewById(R.id.card_viewUtils) as CardView
        cardViewUtils!!.setOnClickListener(this)
        cardViewStorage = rootview.findViewById(R.id.card_viewStorages) as CardView
        cardViewStorage!!.setOnClickListener(this)
        cardViewOthers = rootview.findViewById(R.id.card_viewOthers) as CardView
        cardViewOthers!!.setOnClickListener(this)

        return rootview
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.card_viewList -> {
                if (mListener != null) {
                    mListener!!.onFragmentInteraction(ActivityConstants.view_home)
                }
            }
            R.id.card_viewUtils -> {
                if (mListener != null) {
                   mListener!!.onFragmentInteraction(ActivityConstants.view_utils)
                }
            }
            R.id.card_viewStorages -> {
                if (mListener != null) {
                  //  mListener!!.onFragmentInteraction(ActivityConstants.view_popular_fragments)
                }
            }
            R.id.card_viewOthers -> {
                if (mListener != null) {
                  //  mListener!!.onFragmentInteraction(ActivityConstants.view_search_fragments)
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