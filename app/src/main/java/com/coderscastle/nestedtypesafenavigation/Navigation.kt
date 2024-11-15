package com.coderscastle.nestedtypesafenavigation

import android.os.Build
import android.os.Bundle
import android.os.Parcelable
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navigation
import androidx.navigation.toRoute
import com.coderscastle.nestedtypesafenavigation.SubGraph.Auth
import kotlinx.parcelize.Parcelize
import kotlinx.serialization.Serializable
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import kotlin.reflect.typeOf


@Parcelize
@Serializable
data class MyDataClass (
    val name: String,
    val age: Int

) : Parcelable

val MyDataClassType  = object: NavType<MyDataClass>(false){
    override fun get(
        bundle: Bundle,
        key: String
    ): MyDataClass? {

        return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU){

            bundle.getParcelable(key,MyDataClass::class.java)

        } else {
            bundle.getParcelable(key)
        }
    }

    override fun parseValue(value: String): MyDataClass {
        return Json.decodeFromString(value)
    }

    override fun put(
        bundle: Bundle,
        key: String,
        value: MyDataClass
    ) {
      bundle.putParcelable(key,value)
    }

    override fun serializeAsValue(value: MyDataClass): String {
        return Json.encodeToString(value)
    }

}



@Composable
fun MainNavigation (){

    val navController = rememberNavController()

    NavHost(navController =navController, startDestination = Auth) {

        navigation<Auth>(startDestination = Dest.AuthFirstScreen){
            composable<Dest.AuthFirstScreen> {
                AuthFirst {

                    navController.navigate(Dest.AuthSecondScreen)

                }
            }

            composable<Dest.AuthSecondScreen> {
                AuthSecond {

                    navController.navigate(Dest.DashboardSecondScreen(MyDataClass("John",23)))
                }
            }

        }

        navigation<SubGraph.Dashboard>(startDestination = Dest.DashboardFirstScreen){
            composable<Dest.DashboardFirstScreen> {
               DashboardFirst {

               }
            }

            composable<Dest.DashboardSecondScreen> (
                typeMap = mapOf(typeOf<MyDataClass>() to MyDataClassType)

            ) {

                val dash = it.toRoute<Dest.DashboardSecondScreen>()
               DashboardSecond (dash) {

               }
            }

        }
    }

}

