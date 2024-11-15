package com.coderscastle.nestedtypesafenavigation

import kotlinx.serialization.Serializable

sealed class SubGraph{

    @Serializable
    data object Auth: SubGraph()

    @Serializable
    data object Dashboard: SubGraph()
}

sealed class Dest {

    @Serializable
    data object AuthFirstScreen: Dest()

    @Serializable
    data object AuthSecondScreen: Dest()

    @Serializable
    data object DashboardFirstScreen: Dest()

    @Serializable
    data class DashboardSecondScreen(
        val myDataClass: MyDataClass
    ): Dest()

}