package com.viapp.b.performer.app.base

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import com.viapp.b.performer.app.ui.theme.PerformerTheme

abstract class BaseActivity : ComponentActivity() {

    @Composable
    abstract fun ShowContent()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            PerformerTheme {
                ShowContent()
            }
        }
    }
}
