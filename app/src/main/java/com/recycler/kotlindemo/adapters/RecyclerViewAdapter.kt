package com.recycler.kotlindemo.adapters

import android.content.Context
import android.support.v7.widget.CardView
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.recycler.kotlindemo.R

/**
 * Created by Manu on 10/30/2017.
 */
class RecyclerViewAdapter : RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {

        var view = LayoutInflater.from(act).inflate(R.layout.recycler_row, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {

        holder?.text_list?.text = nama?.get(position)
        holder?.image_list?.setImageResource(gambar?.get(position)!!)
        holder?.card_list?.setOnClickListener {
//            var intent = Intent(act?.applicationContext, DetailRecycler::class.java)
//            intent.putExtra("nama", nama?.get(position))
//                    .putExtra("gambar", gambar?.get(position))
//            act?.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {

        return nama?.size!!
    }

    var act: Context? = null
    var nama: Array<String>? = null
    var gambar: Array<Int>? = null

    constructor(recyclerViewActivity: Context, namaArray: Array<String>, gambarArray: Array<Int>) {
        act = recyclerViewActivity
        nama = namaArray
        gambar = gambarArray
    }

    class ViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView) {

        var text_list: TextView? = itemView?.findViewById(R.id.text_wadah) as TextView?
        var image_list: ImageView? = itemView?.findViewById(R.id.image_wadah) as ImageView?
        var card_list : CardView? = itemView?.findViewById(R.id.card_view_wadah) as CardView?
    }

}