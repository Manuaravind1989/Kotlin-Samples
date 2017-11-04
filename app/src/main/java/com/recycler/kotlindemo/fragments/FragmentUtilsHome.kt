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
class FragmentUtilsHome : Fragment(), View.OnClickListener {

    private var mListener: OnFragmentInteractionListener? = null
    private var dialogButton: Button? = null


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        var rootview = inflater.inflate(R.layout.fragment_utils_home, container, false)
        dialogButton = rootview.findViewById(R.id.dialogButton) as Button?
        dialogButton!!.setOnClickListener(this)


        return rootview
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.dialogButton -> {
                if (mListener != null) {
                    mListener!!.onFragmentInteraction(ActivityConstants.view_dialog)
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