package com.sum.viewmodelfactory

import android.util.Log
import androidx.lifecycle.ViewModel

class MainViewModel(name:String): ViewModel() {

    var myName:String = name



    init{
        Log.d("ViewModel","My Youtube channel name is ")
    }
}