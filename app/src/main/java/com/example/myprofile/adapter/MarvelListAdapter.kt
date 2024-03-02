package com.example.myprofile.adapter

import android.app.ActivityOptions
import android.app.ActivityOptions.makeSceneTransitionAnimation
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.example.myprofile.R
import com.example.myprofile.screens.DetailPage
import com.example.myprofile.screens.ListActivity_Page
import com.google.gson.Gson
import de.hdodenhof.circleimageview.CircleImageView

class MarvelListAdapter(var context: ListActivity_Page, var arrayList: ArrayList<MarvelModel>) : RecyclerView.Adapter<MarvelListAdapter.ViewHolder>(){
    class ViewHolder(v: View): RecyclerView.ViewHolder(v) {
         val name = v.findViewById<TextView>(R.id.name)
         val aname_txt = v.findViewById<TextView>(R.id.aname_txt)
         val nav_btn = v.findViewById<CircleImageView>(R.id.nav_btn)
         val img = v.findViewById<CircleImageView>(R.id.img)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view  = inflater.inflate(R.layout.card_lt, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return arrayList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        var app  = arrayList.get(position)

        holder.name.text = app.name
        holder.aname_txt.text = app.createdby

        //onClick
        holder.nav_btn.setOnClickListener(View.OnClickListener {
            val intent = Intent(context.applicationContext, DetailPage::class.java)
           // addExtra(intent, app)
            intent.apply {
                putExtra("my_data",app)
            }

            //Transition Animation
            val options = ActivityOptions.makeSceneTransitionAnimation(
                this.context,
                holder.nav_btn,
                "shared_element_container"
            )

            context.startActivity(intent, options.toBundle())
        })

        //Card Slide through in (Animation)
        val animation = AnimationUtils.loadAnimation(context.applicationContext,R.anim.slide_in_row);
        animation.startOffset = (100*position).toLong() //Provide delay here
        holder.itemView.startAnimation(animation);


        Glide.with(context.applicationContext)
            .load(app.imageurl)
            .diskCacheStrategy(DiskCacheStrategy.ALL)
            .into(holder.img)
    }


    private fun  addExtra(intent: Intent, app: MarvelModel){
         intent.putExtra("name", app.name);
         intent.putExtra("realname", app.realname);
         intent.putExtra("createdby", app.createdby);
         intent.putExtra("publisher", app.publisher);
         intent.putExtra("imageUrl", app.imageurl);
         intent.putExtra("bio", app.bio);
         intent.putExtra("img", app.imageurl);
    }
}