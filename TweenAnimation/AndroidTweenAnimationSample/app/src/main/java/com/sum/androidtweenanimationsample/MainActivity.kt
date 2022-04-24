package com.sum.androidtweenanimationsample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.ImageView

import com.sum.androidtweenanimationsample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var arrayImageArray: ArrayList<ImageView>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //arrayList
        arrayImageArray = ArrayList()
        arrayImageArray.add(binding.imageView)
        arrayImageArray.add(binding.imageView2)
        arrayImageArray.add(binding.imageView3)
        arrayImageArray.add(binding.imageView4)
        arrayImageArray.add(binding.imageView6)
        arrayImageArray.add(binding.imageView7)
        arrayImageArray.add(binding.imageView8)
        



        binding.btnClick.setOnClickListener {
            val hyperspaceJump: Animation = AnimationUtils.loadAnimation(this, R.anim.anim)


            for( i in arrayImageArray){
                i.startAnimation(hyperspaceJump)

            }



        }





    }


}