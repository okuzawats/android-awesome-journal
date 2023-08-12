package com.okuzawats.awesome.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.okuzawats.awesome.ui.component.AwesomeBottomAppBar
import com.okuzawats.awesome.ui.screen.BulletList

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                Scaffold(
                    bottomBar = {
                        AwesomeBottomAppBar(
                            modifier = Modifier
                                .fillMaxWidth(),
                            onFabClicked = {
                                // TODO
                            },
                        )
                    },
                ) { padding ->
                    BulletList(
                        modifier = Modifier
                            .padding(padding)
                    )
                }
            }
        }
    }
}
