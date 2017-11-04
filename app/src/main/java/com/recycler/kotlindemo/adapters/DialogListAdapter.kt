package com.recycler.kotlindemo.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView

import com.recycler.kotlindemo.R

/**
 * Created by Manu on 11/4/2017.
 */

class DialogListAdapter(var context: Context, internal var itemList: Array<String>) : BaseAdapter() {
    var inflater: LayoutInflater

    init {
        this.inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
    }

    override fun getCount(): Int {
        // TODO Auto-generated method stub
        return itemList.size
    }

    override fun getItem(position: Int): Any {
        // TODO Auto-generated method stub
        return itemList[position]
    }

    override fun getItemId(position: Int): Long {
        // TODO Auto-generated method stub
        return 0
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var convertView = convertView
        // TODO Auto-generated method stub

        val holder: ViewHolder
        if (convertView == null) {
            holder = ViewHolder()
            convertView = inflater.inflate(R.layout.dialog_list_item, null)
            holder.txtViewTitle = convertView!!.findViewById(R.id.dialog_textview) as TextView
            convertView.tag = holder
        } else
            holder = convertView.tag as ViewHolder
        holder.txtViewTitle!!.text = itemList[position]
        return convertView
    }

    class ViewHolder {
        internal var txtViewTitle: TextView? = null

    }

}