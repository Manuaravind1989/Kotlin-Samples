package com.recycler.kotlindemo

import android.app.Dialog
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.widget.Button
import com.recycler.kotlindemo.utils.DialogUtil
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), DialogUtil.OnDialogSelectedListener {
    override fun onDialogClick(selectedIndex: Int, mObj: Any?, dialogIndex: Int) {

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        facebook_button.setOnClickListener {
            var facebookIntent = Intent(this, HomeActivity::class.java)
            startActivity(facebookIntent)
        }
        gmail_button.setOnClickListener {
          showNewNameDialog()
        }
    }

    fun showNewNameDialog() {
        val dialogBuilder = Dialog(this)
        val inflater = this.layoutInflater
        val dialogView = inflater.inflate(R.layout.custom_dialog, null)
        dialogBuilder.setContentView(dialogView)
        val buttonOk = dialogView.findViewById(R.id.okButton) as Button
        buttonOk.setOnClickListener {
            Log.e("Click","third")
            dialogBuilder.dismiss()
        }

        dialogBuilder.setTitle("Custom dialog")

        dialogBuilder.show()
    }
}
