package com.sum.myproject

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.sum.myproject.databinding.ActivityMainBinding
import java.sql.DatabaseMetaData

class MainActivity : AppCompatActivity() {

    //private lateinit var imageView: ImageView //neyden türetildiğine baktık
    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)

        binding.btnStartNow.setOnClickListener {
            val intent = Intent(this@MainActivity, StartActivity::class.java)
            startActivity(intent)

        }


    }
}