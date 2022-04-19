package com.sum.myproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import com.sum.myproject.databinding.ActivityStartBinding

class StartActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding: ActivityStartBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_start)
        //setContentView(R.layout.activity_start)
    }

    override fun onClick(view: View?) {
        when(view?.id){
            binding.btnSignIn.id ->{
                val intent = Intent(this@StartActivity, PremiumActivity::class.java)
                startActivity(intent)}

        }
    }
}