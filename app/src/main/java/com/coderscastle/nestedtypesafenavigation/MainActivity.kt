package com.coderscastle.nestedtypesafenavigation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge

import com.coderscastle.nestedtypesafenavigation.ui.theme.NestedTypesafeNavigationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            NestedTypesafeNavigationTheme {
                MainNavigation()
            }
        }
    }
}

