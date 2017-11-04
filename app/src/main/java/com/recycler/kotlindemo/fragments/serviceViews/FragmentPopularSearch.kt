package com.recycler.kotlindemo.fragments.serviceViews

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
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
 * Created by Manu on 11/3/2017.
 */
class FragmentPopularSearch : Fragment() {
    lateinit var searchBox: EditText
    private var mListener: OnFragmentInteractionListener? = null
    lateinit var recyclerView: RecyclerView

    var popularAdapter: PopularSearchAdapter?=null
    var movieList: List<MovieModel.ResultsEntity>? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        var rootview = inflater.inflate(R.layout.fragment_popular_search, container, false)
        recyclerView = rootview.findViewById(R.id.recycler_view) as RecyclerView
        recyclerView!!.layoutManager = LinearLayoutManager(activity,  LinearLayoutManager.VERTICAL, false)
        searchBox = rootview.findViewById(R.id.searchbox) as EditText

        addArtist();
        searchImplementation()
        return rootview
    }

    fun searchImplementation(){
        searchBox?.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {

            }

            override fun onTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {

            }

            override fun afterTextChanged(editable: Editable) {
                //after the change calling the method and passing the search input
                filter(editable.toString())
            }
        })
    }

    private fun filter(text: String) {
        val filterdNames = ArrayList<MovieModel.ResultsEntity>()

        for (s in movieList!!) {
            if (s.title?.toLowerCase()?.contains(text.toLowerCase())!!) {
                filterdNames.add(s)
            }
        }
        popularAdapter?.filterList(filterdNames)
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
                        movieList = movieModel.results!!
                        popularAdapter = PopularSearchAdapter(activity, movieList!!)
                        recyclerView!!.adapter = popularAdapter
                    } catch (e: JSONException) {
                        e.printStackTrace()
                    }
                }, Response.ErrorListener {

        })
        //adding request to queue
        VolleySingleton.instance?.addToRequestQueue(stringRequest)
    }
}