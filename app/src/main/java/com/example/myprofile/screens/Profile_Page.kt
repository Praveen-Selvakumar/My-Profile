package com.example.myprofile.screens

import android.annotation.SuppressLint
import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.View
import android.view.Window
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.myprofile.R
import com.example.myprofile.databinding.DetailLtBinding
import com.example.myprofile.databinding.ProfileLtBinding
import com.example.myprofile.objects.Constants.makeToolbar
import com.example.myprofile.objects.Constants
import com.example.myprofile.objects.Constants._getDes
import com.example.myprofile.objects.Constants._getName
import com.example.myprofile.objects.Constants._update
import com.example.myprofile.objects.JUnitUtil.valid_profileName
import com.example.myprofile.objects.JUnitUtil.validate_profileInfo
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import com.google.android.material.transition.platform.MaterialContainerTransform
import com.google.android.material.transition.platform.MaterialContainerTransformSharedElementCallback



class Profile_Page : AppCompatActivity() {

    lateinit var binding: ProfileLtBinding;
    lateinit var  sp: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        applyTransition()
        super.onCreate(savedInstanceState)
        val view = binding.root
        setContentView(view)

        //setContentView(R.layout.profile_lt)
        InitializeFields()



    }

    private fun InitializeFields() {
        //set Toolbar
       makeToolbar(binding)

        sp = Constants.Shared_Instance(this@Profile_Page)
        updateInfo()

        binding.tb.startIconTb.setOnClickListener {
            super.onBackPressed()
        }
        binding.updateBtn.setOnClickListener(View.OnClickListener {
            showAlertDialogButtonClicked()
        })

    }




    private fun updateInfo(){
        sp?.let {
            binding.apply {
                nameTxt.text = _getName(it)
                desTxt.text = _getDes(it)
            }
        }
    }


    //Display Alert Dialog
    @SuppressLint("MissingInflatedId")
    fun  showAlertDialogButtonClicked() {
        // set the custom layout
        val builder =   AlertDialog.Builder(this@Profile_Page);

        val view = layoutInflater.inflate(R.layout.update_alertr, null)
        builder.setView(view);

        val dialog = builder.create();

        val update_btn   = view.findViewById<MaterialButton>(R.id.update_btn_al) as MaterialButton
        val name_ed   = view.findViewById<TextInputEditText>(R.id.name_ed) as TextInputEditText
        val des_ed   = view.findViewById<TextInputEditText>(R.id.des_ed) as TextInputEditText
        val name_lt   = view.findViewById<TextInputLayout>(R.id.name_lt) as TextInputLayout
        val close_btn   = view.findViewById<ImageView>(R.id.close_btn) as ImageView

        //For alert Edit
        sp?.let {
            name_ed.setText(_getName(it))
            des_ed.setText(_getDes(it))
        }

        //OnClick Listeners
        close_btn.setOnClickListener {
            dialog.dismiss()
        }

        update_btn.setOnClickListener {
            var isValid = validate_profileInfo(name_ed.text.toString(), des_ed.text.toString())

             if(isValid){
                name_lt.isErrorEnabled = false
                _update(sp,name_ed.text.toString() , des_ed.text.toString() )
                updateInfo()
                Toast.makeText(this@Profile_Page, "Successfully Updated", Toast.LENGTH_SHORT).show()
                dialog.dismiss()
            }else if(valid_profileName(name_ed.text.toString())) {
                name_lt.isErrorEnabled = true
                name_lt.error = "Enter valid name "
            }
        }


        dialog.show();


    }


    //Launch Page with motion
    private  fun applyTransition(){
        binding = ProfileLtBinding.inflate(layoutInflater)

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
