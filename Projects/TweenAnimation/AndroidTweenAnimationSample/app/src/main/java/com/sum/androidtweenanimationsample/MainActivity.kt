package com.sum.androidtweenanimationsample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils

import com.sum.androidtweenanimationsample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener  {
    private lateinit var binding: ActivityMainBinding
    private var hyperspaceJump :Animation ?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.translateClick.setOnClickListener(this)
        binding.alfaClick.setOnClickListener(this)
        binding.rotateClick.setOnClickListener(this)
        binding.scaleClick.setOnClickListener(this)


    }

    override fun onClick(view: View?) {
        when(view){
            binding.translateClick -> { hyperspaceJump= AnimationUtils.loadAnimation(this, R.anim.translate)
                                        binding.imageView.startAnimation(hyperspaceJump)}

            binding.alfaClick -> {  hyperspaceJump= AnimationUtils.loadAnimation(this, R.anim.alfa)
                                    binding.imageView.startAnimation(hyperspaceJump)}

            binding.rotateClick ->{  hyperspaceJump= AnimationUtils.loadAnimation(this, R.anim.rotate)
                                     binding.imageView.startAnimation(hyperspaceJump)}
            binding.scaleClick->{    hyperspaceJump= AnimationUtils.loadAnimation(this, R.anim.scale)
                                     binding.imageView.startAnimation(hyperspaceJump)}
        }


    }


}