package com.example.myprofile.screens

import android.content.Context
import android.os.Bundle
import android.view.View
import android.view.Window
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.example.myprofile.R
import com.example.myprofile.adapter.MarvelModel
import com.example.myprofile.databinding.DetailLtBinding
import com.example.myprofile.databinding.ListpageLayoutBinding
import com.google.android.material.transition.platform.MaterialContainerTransform
import com.google.android.material.transition.platform.MaterialContainerTransformSharedElementCallback
import com.google.gson.Gson
import de.hdodenhof.circleimageview.CircleImageView

class DetailPage : AppCompatActivity() {

    lateinit var back_btn: ImageView
    lateinit var profile_img: CircleImageView
    lateinit var binding: DetailLtBinding



    override fun onCreate(savedInstanceState: Bundle?) {
        applyTransition()
        super.onCreate(savedInstanceState)
        val view = binding.getRoot();
        setContentView(view)
        //setContentView(R.layout.detail_lt)

        InitializeFields()

    }



    private fun InitializeFields(){

        back_btn  = findViewById<ImageView>(R.id.back_btn)
        profile_img = findViewById<CircleImageView>(R.id.profile_img)


        back_btn.setOnClickListener {
               super.onBackPressed();
        }


        display_Detail()

    }

    //display detail
    fun display_Detail(){
        var intent = getIntent()
        var model  = intent.getSerializableExtra("my_data") as MarvelModel


        Glide.with(this@DetailPage)
            .load(model.imageurl)
            .diskCacheStrategy(DiskCacheStrategy.ALL)
            .into(profile_img)

        binding.name.text = model.name;
        binding.realname.text = model.realname;
        binding.publisher.text = model.publisher;
        binding.cntTxt.text = model.bio;
        binding.createdby.text = model.createdby;
    }



    //Launch Page with motion
    public  fun applyTransition(){
        binding = DetailLtBinding.inflate(layoutInflater)

        window.requestFeature(Window.FEATURE_ACTIVITY_TRANSITIONS)

        findViewById<View>(android.R.id.content).transitionName = "shared_element_container"
        setEnterSharedElementCallback(MaterialContainerTransformSharedElementCallback())

        window.sharedElementEnterTransition = MaterialContainerTransform().apply {
            addTarget(android.R.id.content)
            duration = 300L
        }
        window.sharedElementReturnTransition = MaterialContainerTransform().apply {
            addTarget(android.R.id.content)
            duration = 250L
        }
    }


}


