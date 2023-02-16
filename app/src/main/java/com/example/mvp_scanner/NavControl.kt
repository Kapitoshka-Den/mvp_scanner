package com.example.mvp_scanner

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.mvp_scanner.screens.EquipmentScreen
import com.example.mvp_scanner.screens.MainScreen


sealed class NavControl (val route:String){
    object AudienceScreen: NavControl(route = "AudienceList")
    object EquipmentScreen:NavControl(route = "EquipmentInfo")
    object MainScreen:NavControl(route = "Main")
}

@Composable
fun ScreeHost(){
    val navControl = rememberNavController()

    NavHost(navController = navControl , startDestination = NavControl.MainScreen.route ){
        composable(NavControl.AudienceScreen.route){}
        composable(NavControl.MainScreen.route){ MainScreen(navControl) }
        composable(NavControl.EquipmentScreen.route){ EquipmentScreen()}
    }
}