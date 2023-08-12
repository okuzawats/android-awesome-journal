package com.okuzawats.awesome.ui

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.okuzawats.awesome.ui.component.AwesomeBottomAppBar
import com.okuzawats.awesome.ui.screen.BulletList

@Composable
fun MainScreen() {
    val navController = rememberNavController()

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
