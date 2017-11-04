package com.recycler.kotlindemo.fragments.serviceViews

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.google.gson.Gson
import com.recycler.kotlindemo.OnFragmentInteractionListener
import com.recycler.kotlindemo.R
import com.recycler.kotlindemo.network.HttpConstants
import com.recycler.kotlindemo.network.VolleySingleton
import org.json.JSONException

/**
 * Created by Manu on 10/30/2017.
 */
class FragmentPopular : Fragment() {

    private var mListener: OnFragmentInteractionListener? = null
    lateinit var recyclerView: RecyclerView

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        var rootview = inflater.inflate(R.layout.fragment_popular, container, false)
        recyclerView = rootview.findViewById(R.id.recycler_view) as RecyclerView
        recyclerView!!.layoutManager = LinearLayoutManager(activity,  LinearLayoutManager.VERTICAL, false)

        addArtist();
        return rootview
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

    private fun addArtist() {
        val stringRequest = StringRequest(Request.Method.GET, HttpConstants.BaseURL, // 2
                Response.Listener<String> { response ->
                    try {
                          // Toast.makeText(activity, response.toString(), Toast.LENGTH_SHORT).show()
                            println("Response =======> ") // 3
                        var movieModel = Gson().fromJson(response, MovieModel::class.java)
                        var movieList: List<MovieModel.ResultsEntity> = movieModel.results!!
                        var recyclerAdapter = PopularAdapter(activity, movieList)
                        recyclerView!!.adapter = recyclerAdapter
                    } catch (e: JSONException) {
                        e.printStackTrace()
                    }
                }, Response.ErrorListener {

        })
        //adding request to queue
        VolleySingleton.instance?.addToRequestQueue(stringRequest)
    }
}