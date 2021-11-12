package com.viapp.b.performer.app

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.viapp.b.performer.app.theme.PerformerTheme
import com.viapp.b.performer.base.BaseActivity

class MainActivity : BaseActivity() {

    @Composable
    override fun ShowContent() {
        Surface(color = MaterialTheme.colors.background) {
            Greeting("Android")
        }
    }


}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    PerformerTheme {
        Greeting("Android")
    }
}