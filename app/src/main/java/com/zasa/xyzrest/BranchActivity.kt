package com.zasa.xyzrest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import kotlinx.android.synthetic.main.activity_branch.*

class BranchActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_branch)

//        val actionBar = supportActionBar

        val bundle: Bundle? = intent.extras

        val city = bundle!!.getString("city")
        val image = bundle.getString("image")
        val description = bundle.getString("description")

//        actionBar!!.title = city

        tvBranchName.text = city
        Glide.with(this).load(image).transform(CenterCrop(), RoundedCorners(10)).into(ivItemBranch)
        tvDescription.text = description
    }
}