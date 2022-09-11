package com.zasa.xyzrest

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_home.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


private const val TAG = "HomeFragment"

class HomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val branches = mutableListOf<BranchResult>()
        val branchAdapter = BranchAdapter(requireContext().applicationContext, branches)

        val retrofit =
            Retrofit.Builder().baseUrl(Utils.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()

        val retrofitService = retrofit.create(RestaurantApi::class.java)

        retrofitService.getBranches().enqueue(object : Callback<List<BranchResult>> {
            override fun onResponse(
                call: Call<List<BranchResult>>,
                response: Response<List<BranchResult>>
            ) {
                val body = response.body()
                Log.i(TAG, "responce : $body")
                rvBraches.apply {
                    layoutManager = LinearLayoutManager(requireContext().applicationContext)
                    adapter = branchAdapter
                    branches.addAll(body!!)
                    branchAdapter.notifyDataSetChanged()
                }

                branchAdapter.setOnItemClickListener(object : BranchAdapter.onItemClickListner {
                    override fun onItemClick(position: Int) {
                        val branchIntent = Intent(requireContext().applicationContext, BranchActivity::class.java)
                        branchIntent.putExtra("image", branches[position].image_url)
                        branchIntent.putExtra("city", branches[position].name)
                        branchIntent.putExtra("description", branches[position].description)
                        startActivity(branchIntent)
                    }

                })
            }

            override fun onFailure(call: Call<List<BranchResult>>, t: Throwable) {
                Log.i(TAG, "failure : $t")
            }

        })
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)


    }

}