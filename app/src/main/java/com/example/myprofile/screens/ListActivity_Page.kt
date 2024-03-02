package com.example.myprofile.screens

import android.app.ActivityOptions
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.Window
import android.widget.ProgressBar
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myprofile.R
import com.example.myprofile.Repo.MainViewModel
import com.example.myprofile.Repo.Retrofit_Builder
import com.example.myprofile.adapter.MarvelListAdapter
import com.example.myprofile.adapter.MarvelModel
import com.example.myprofile.databinding.ListpageLayoutBinding
import com.example.myprofile.objects.Constants
import com.example.myprofile.objects.Constants.SceneTransition_Screen1
import com.example.myprofile.objects.Constants.Shared_Instance
import com.example.myprofile.objects.Constants._update
import com.example.myprofile.objects.Constants.iconsVisibility_Screen1
import com.example.myprofile.objects.Constants.pass_data_locally
import com.google.android.material.transition.platform.MaterialContainerTransformSharedElementCallback
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Response
import javax.security.auth.callback.Callback

class ListActivity_Page : AppCompatActivity() {


    lateinit var binding : ListpageLayoutBinding ;

    override fun onCreate(savedInstanceState: Bundle?) {
        applyTransition()
        super.onCreate(savedInstanceState)
        val view = binding.getRoot();
        setContentView(view)


        InitializeFields()

    }



    private  fun InitializeFields(){
        //setToolBar

        //Make Icon Visible
        iconsVisibility_Screen1(binding)

        //Navigate to Profile Page
        SceneTransition_Screen1(binding, this@ListActivity_Page)

        //Layout Manager
        binding.rv.layoutManager = LinearLayoutManager(this@ListActivity_Page, RecyclerView.VERTICAL, false)

        //Import data
        load_list()


        //Set and Update Data Locally
        _update(Shared_Instance(this@ListActivity_Page), "Praveen Selvakumar", "Android Developer with 3+ years Experience")
    }



    //Launch Page with motion
    private  fun applyTransition(){
        binding = ListpageLayoutBinding.inflate(layoutInflater)
        window.requestFeature(Window.FEATURE_ACTIVITY_TRANSITIONS)
        //call back
        setExitSharedElementCallback(MaterialContainerTransformSharedElementCallback())

        // Keep system bars (status bar, navigation bar) persistent throughout the transition.
        window.sharedElementsUseOverlay = false
    }


    private  fun load_list(){

        var viewmodel  = ViewModelProvider(this@ListActivity_Page).get(MainViewModel::class.java)
        viewmodel.getMutableLiveData().observe(this@ListActivity_Page, Observer {
            binding.apply {
                rv.adapter = MarvelListAdapter(this@ListActivity_Page,it )
                progressBar.visibility = View.GONE
            }
         })
    }






}
