package com.recycler.kotlindemo.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.recycler.kotlindemo.R

/**
 * Created by Manu on 10/30/2017.
 */
class ListViewAdapter(context: Context, arrayOfData: Array<String>)  : BaseAdapter() {

    var arrayOfData : Array<String>;
    private val mInflator: LayoutInflater

    init {
        this.arrayOfData = arrayOfData
        this.mInflator = LayoutInflater.from(context)
    }

    override fun getItem(position: Int): Any {
        return arrayOfData[position];
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getCount(): Int {
        return arrayOfData.size
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View? {

        val view: View?
        val vh: ListRowHolder
        if (convertView == null) {
            view = this.mInflator.inflate(R.layout.list_row, parent, false)
            vh = ListRowHolder(view)
            view.tag = vh
        } else {
            view = convertView
            vh = view.tag as ListRowHolder
        }
        vh.label.text = arrayOfData[position]
        return view
    }




    private class ListRowHolder(row: View?) {
        public val label: TextView

        init {
            this.label = row?.findViewById(R.id.title) as TextView
        }
    }
}