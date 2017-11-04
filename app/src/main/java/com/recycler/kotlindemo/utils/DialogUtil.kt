package com.recycler.kotlindemo.utils

import android.app.Activity
import android.app.Dialog
import android.content.Context
import android.util.DisplayMetrics
import android.util.Log
import android.view.Gravity
import android.view.Window
import android.widget.Button
import android.widget.LinearLayout
import android.widget.ListView
import android.widget.TextView
import com.recycler.kotlindemo.R
import com.recycler.kotlindemo.adapters.DialogListAdapter


/**
 * Created by Manu on 11/3/2017.
 */

class DialogUtil {

    fun okFunc(context: Context, message: String, title: String, mOnDialogSelectedListener: OnDialogSelectedListener, dialogIndex: Int) {
        val dialog = Dialog(context)
        dialog.setContentView(R.layout.ok_dialog_layout)
        dialog.window!!.attributes.windowAnimations = R.style.DialogTheme
        /* My Cancel Button , and its listener */
        val mTitleView = dialog.findViewById(R.id.ok_dialog_title) as TextView
        mTitleView.text = title
        val mMessageView = dialog.findViewById(R.id.ok_dialog_message) as TextView
        mMessageView.text = message


        val okButton = dialog.findViewById(R.id.okButton) as Button
        okButton.setOnClickListener {
            Log.e("Constants == ?", dialogIndex.toString())
            mOnDialogSelectedListener.onDialogClick(DialogConstants.DIALOG_BUTTON_OK, null, dialogIndex)
            dialog.dismiss()
        }
        dialog.show()
    }


    fun doubleFunc(context: Context, message: String, title: String, mOnDialogSelectedListener: OnDialogSelectedListener, dialogIndex: Int) {
        val dialog = Dialog(context)
        dialog.setContentView(R.layout.double_dialog_layout)
        dialog.window!!.attributes.windowAnimations = R.style.DialogTheme
        /* My Cancel Button , and its listener */
        val mTitleView = dialog.findViewById(R.id.ok_dialog_title) as TextView
        mTitleView.text = title
        val mMessageView = dialog.findViewById(R.id.ok_dialog_message) as TextView
        mMessageView.text = message
        val yesButton = dialog.findViewById(R.id.YesButton) as Button
        yesButton.setOnClickListener{
                mOnDialogSelectedListener.onDialogClick(DialogConstants.DIALOG_BUTTON_OK, null, dialogIndex)
                dialog.dismiss()
        }
        val NoButton = dialog.findViewById(R.id.NoButton) as Button
        NoButton.setOnClickListener {
                dialog.dismiss()
        }
        dialog.show()
    }


    fun listFunc(context: Activity, title: String, mStringArrays: Array<String>, mOnDialogSelectedListener: OnDialogSelectedListener, dialogIndex: Int) {
        val metrics = DisplayMetrics()
        context.windowManager.defaultDisplay.getMetrics(metrics)

        val height = (metrics.heightPixels * 0.6).toInt()
        val dialog = Dialog(context, R.style.DialogSheet)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setContentView(R.layout.dialog_list_layout)
        dialog.setCancelable(true)
        dialog.window!!.setLayout(LinearLayout.LayoutParams.MATCH_PARENT, height)
        dialog.window!!.setGravity(Gravity.BOTTOM)
        /* My Cancel Button , and its listener */
        val mTitleView = dialog.findViewById(R.id.DialogTitle) as TextView
        mTitleView.text = title


        val mListView = dialog.findViewById(R.id.listView_dialog) as ListView
        val adapter = DialogListAdapter(context, mStringArrays)
        mListView.setAdapter(adapter)
        mListView.setOnItemClickListener { parent, view, position, id ->
            dialog.dismiss()
            mOnDialogSelectedListener.onDialogClick(DialogConstants.DIALOG_BUTTON_LIST, mStringArrays[position], dialogIndex)
        }

        dialog.show()
    }


    interface OnDialogSelectedListener {
        fun onDialogClick(selectedIndex: Int, mObj: Any?, dialogIndex: Int)
    }
}
