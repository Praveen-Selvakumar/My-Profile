package com.example.myprofile.objects

import android.app.ActivityOptions
import android.content.ClipDescription
import android.content.Context
import android.content.Context.MODE_PRIVATE
import android.content.Intent
import android.content.SharedPreferences
import android.renderscript.ScriptGroup.Binding
import android.view.View
import android.view.Window
import android.widget.ImageView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.ConstraintSet.Constraint
import androidx.core.app.ActivityCompat.setExitSharedElementCallback
import androidx.core.content.ContextCompat.startActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.example.myprofile.adapter.MarvelModel
import com.example.myprofile.databinding.ListpageLayoutBinding
import com.example.myprofile.databinding.ProfileLtBinding
import com.example.myprofile.screens.ListActivity_Page
import com.example.myprofile.screens.Profile_Page
import com.google.android.material.transition.platform.MaterialContainerTransform
import com.google.android.material.transition.platform.MaterialContainerTransformSharedElementCallback

object Constants {

    public fun Shared_Instance(context: Context) = context.getSharedPreferences("MySharedPref",MODE_PRIVATE);



    public fun _update(sp: SharedPreferences, name: String, des: String){
        val myEdit = sp.edit()
        myEdit.run {
            putString("name",name)
            putString("des",des)
            commit()
        }
    }

    var _getName  = { sp: SharedPreferences -> sp.getString("name","") }
    val _getDes  = { sp: SharedPreferences -> sp.getString("des","") }


    //ListActivity_Page




    //DashBaord Icons
    fun  iconsVisibility_Screen1(binding: ListpageLayoutBinding){
       binding.apply {
          tb.tbTitle.text = "Dashboard"
          tb.startIconTb.visibility = View.GONE
          tb.profileIconLt.visibility = View.VISIBLE
       }
    }

    //DashBoard To Profile
    fun SceneTransition_Screen1(binding: ListpageLayoutBinding, _this: ListActivity_Page){
        binding.tb.profileIconBg.setOnClickListener(View.OnClickListener {
            val intent = Intent(_this, Profile_Page::class.java)

            val options = ActivityOptions.makeSceneTransitionAnimation(
                _this,
                binding.tb.profileIcon,
                "shared_element_container"
            )

            _this.startActivity(intent, options.toBundle())
        })
    }


    //Pass Data Locally
    fun pass_data_locally(it: ArrayList<MarvelModel>): ArrayList<MarvelModel>{
       return it.apply {
              add(MarvelModel(name = "Iron Man", realname =  "Tony Stark", createdby = "Stan Lee" ,publisher = "Marvel Comics", bio = content4()  ,imageurl = "https://www.simplifiedcoding.net/demos/marvel/ironman.jpg" ))
              add(MarvelModel(name = "Wolverine", realname =  "James Howlett", createdby = "Len Wein" ,publisher = "Marvel Comics", bio = content3()  ,imageurl = "https://www.simplifiedcoding.net/demos/marvel/logan.jpg" ))
              add(MarvelModel(name = "SpiderMan", realname =  "Peter Parker", createdby = "Stan Lee" ,publisher = "Marvel Comics", bio = content2()  ,imageurl = "https://www.simplifiedcoding.net/demos/marvel/spiderman.jpg" ))
              add(MarvelModel(name = "Thor", realname =  "Thor Odinson", createdby = "Stan Lee" ,publisher = "Marvel Comics", bio = content1()  ,imageurl = "https://www.simplifiedcoding.net/demos/marvel/thor.jpg" ))
        }
    }

    //Profile Page
      fun makeToolbar(binding: ProfileLtBinding){
        binding.apply {
            tb.tbTitle.text = "Profile"
            tb.profileIconLt.visibility = View.GONE
        }

    }


    //JUnit
    fun passEmptyList(): ArrayList<MarvelModel>{
        var list = ArrayList<MarvelModel>()
        return list.apply {
            add(MarvelModel(name = "Praveen"))
            add(MarvelModel(name = "Selvakumar"))
        }
    }

    private fun content1() :String{
        return  "Thor's father Odin decides his son needed to be taught humility and consequently places Thor (without memories of godhood) into the body and memories of an existing, partially disabled human medical student, Donald Blake.[52] After becoming a doctor and on vacation in Norway, Blake witnesses the arrival of an alien scouting party. Blake flees from the aliens into a cave. After discovering Thor's hammer Mjolnir (disguised as a walking stick) and striking it against a rock, he transforms into the thunder god."
    }

  private fun content2() :String{
      return  "In Forest Hills, Queens, New York,[43] Midtown High School student Peter Parker is a science-whiz orphan living with his Uncle Ben and Aunt May. As depicted in Amazing Fantasy #15 (Aug. 1962), he is bitten by a radioactive spider (erroneously classified as an insect in the panel) at a science exhibit and \\\"acquires the agility and proportionate strength of an arachnid\\\".[44] Along with super strength, Parker gains the ability to adhere to walls and ceilings. Through his native knack for science, he develops a gadget that lets him fire adhesive webbing of his own design through small, wrist-mounted barrels. Initially seeking to capitalize on his new abilities, Parker dons a costume and, as \\\"Spider-Man\\\", becomes a novelty television star. However, \\\"He blithely ignores the chance to stop a fleeing thief, [and] his indifference ironically catches up with him when the same criminal later robs and kills his Uncle Ben.\\\" Spider-Man tracks and subdues the killer and learns, in the story's next-to-last caption, \\\"With great power there must also come-great responsibility!"
     }

   private fun content3() :String{
     return  "\\r\\n\\t\\tWolverine was born James Howlett in northern Alberta, Canada, during the late 1880s, purportedly to rich farm owners John and Elizabeth Howlett,[27] though he is actually the illegitimate son of the Howletts' groundskeeper, Thomas Logan.[28] After Thomas is thrown off the Howletts' property for an attempted rape perpetrated by his other son, named simply Dog, he returns to the Howlett manor and kills John Howlett. In retaliation, young James kills Thomas with bone claws that emerge from the back of his hands, as his mutation manifests.[29] He flees with his childhood companion, Rose, and grows into manhood on a mining colony in the Yukon, adopting the name \\\"Logan\\\".[30] When Logan accidentally kills Rose with his claws, he flees the colony and lives in the wilderness among wolves,[31] until he is captured and placed in a circus.[32] Saul Creed, brother of Victor Creed, frees Logan, but after he betrays Logan and Clara Creed to Nathaniel Essex, Logan drowns Creed in Essex's potion.[33] Logan returns to civilization, residing with the Blackfoot people. Following the death of his Blackfoot lover, Silver Fox, at the hands of Victor Creed, now known as Sabretooth,[34] he is ushered into the Canadian military during World War I. Logan spends time in Madripoor before settling in Japan, where he marries Itsu and has a son, Daken. Logan is unaware of his son for many years.\\r\\n\\t\\t"
   }

   private fun content4() :String{
       return "\\r\\n\\t\\tAnthony Edward Stark, the son of wealthy industrialist and head of Stark Industries, Howard Stark, and Maria Stark. A boy genius, he enters MIT at the age of 15 to study electrical engineering and later receives master's degrees in electrical engineering and physics. After his parents are killed in a car accident, he inherits his father's company.\\r\\n\\t\\t"
   }

}

