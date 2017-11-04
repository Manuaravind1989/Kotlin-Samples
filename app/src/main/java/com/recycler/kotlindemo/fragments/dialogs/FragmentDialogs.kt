package com.recycler.kotlindemo.fragments.dialogs

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.recycler.kotlindemo.OnFragmentInteractionListener
import com.recycler.kotlindemo.R
import com.recycler.kotlindemo.utils.DialogConstants
import com.recycler.kotlindemo.utils.DialogUtil

/**
 * Created by Manu on 11/3/2017.
 */
class FragmentDialogs : Fragment(), View.OnClickListener, DialogUtil.OnDialogSelectedListener {

    private var mListener: OnFragmentInteractionListener? = null
    private var singleAlertButton: Button? = null
    private var doubleAlertButton: Button? = null
    private var listAlertButton: Button? = null
    private var editAlertButton: Button? = null
    var arrayofData = arrayOf("One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten");

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        var rootview = inflater.inflate(R.layout.fragment_dialogs, container, false)
        singleAlertButton = rootview.findViewById(R.id.singleAlertButton) as Button?
        singleAlertButton!!.setOnClickListener(this)
        doubleAlertButton = rootview.findViewById(R.id.doubleAlertButton) as Button
        doubleAlertButton!!.setOnClickListener(this)
        listAlertButton = rootview.findViewById(R.id.listAlertButton) as Button
        listAlertButton!!.setOnClickListener(this)
        editAlertButton = rootview.findViewById(R.id.editAlertButton) as Button
        editAlertButton!!.setOnClickListener(this)

        return rootview
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.singleAlertButton -> {
                if (mListener != null) {
                    var dialogUtil = DialogUtil();
                    dialogUtil.okFunc(activity, "Mesages...", "Title", this, DialogConstants.DIALOG_BUTTON_OK)
                }
            }
            R.id.doubleAlertButton -> {
                if (mListener != null) {
                    var dialogUtil = DialogUtil();
                    dialogUtil.doubleFunc(activity, "Are you sure?...", "Title", this, DialogConstants.DIALOG_BUTTON_YES)
                }
            }
            R.id.listAlertButton -> {
                if (mListener != null) {
                    var dialogUtil = DialogUtil();
                    dialogUtil.listFunc(activity, "Dialog ListView", arrayofData, this, DialogConstants.DIALOG_BUTTON_YES)
                }
            }
            R.id.editAlertButton -> {
                if (mListener != null) {
                    // mListener!!.onFragmentInteraction(ActivityConstants.view_search_fragments)
                }
            }
            else -> {/* do your code */
            }
        }
    }

    override fun onDialogClick(selectedIndex: Int, mObj: Any?, dialogIndex: Int) {
     //Callback function based on dialog button click event
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
