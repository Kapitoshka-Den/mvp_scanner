package com.example.mvp_scanner.core.model

import android.annotation.SuppressLint
import androidx.navigation.NavHostController

object StaticToken {
    var token:String = ""
}
object equipId{
    var id:String = ""
}
object StaticNavContolller{
    @SuppressLint("StaticFieldLeak")
    var navHostController:NavHostController? = null
}