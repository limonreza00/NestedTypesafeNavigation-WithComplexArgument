package com.coderscastle.nestedtypesafenavigation

import android.content.Intent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp

@Composable
fun AuthFirst (modifier: Modifier= Modifier, onClick:()->Unit){
    Box (
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center) {
        Text(text = "Auth First Screen", modifier = Modifier.clickable { onClick() }, fontSize = 30.sp)
    }
}

@Composable
fun AuthSecond (modifier: Modifier= Modifier,onClick:()->Unit){
    Box (
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center) {
        Text(text = "Auth Second Screen", modifier = Modifier.clickable { onClick() }, fontSize = 30.sp)
    }
}

@Composable
fun DashboardFirst (modifier: Modifier= Modifier,onClick:()->Unit){
    Box (
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center) {
        Text(text = "Dash First Screen", modifier = Modifier.clickable { onClick() }, fontSize = 30.sp)
    }
}


@Composable
fun DashboardSecond (dash : Dest.DashboardSecondScreen, onClick:()->Unit){
    Box (
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center) {
        Text(text = "Hi my name is ${dash.myDataClass.name} \n I am ${dash.myDataClass.age} years old", modifier = Modifier.clickable { onClick() }, fontSize = 30.sp)
    }
}



