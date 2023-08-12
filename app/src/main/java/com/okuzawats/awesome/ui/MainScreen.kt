package com.okuzawats.awesome.ui

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.okuzawats.awesome.ui.component.AwesomeBottomAppBar
import com.okuzawats.awesome.ui.component.BulletCreate
import com.okuzawats.awesome.ui.screen.BulletList

@Composable
fun MainScreen() {
    val navController = rememberNavController()

    MaterialTheme {
        Scaffold(
            bottomBar = {
                AwesomeBottomAppBar(
                    modifier = Modifier.fillMaxWidth(),
                    onFabClicked = {
                        // TODO
                    },
                )
            },
        ) { padding ->
            NavHost(
                navController = navController,
                startDestination = MainNavigation.BulletList.toString(),
                modifier = Modifier.padding(padding),
            ) {
                composable(
                    route = MainNavigation.BulletList.toString(),
                ) {
                    BulletList(
                        onBulletClick = { bullet ->
                            navController.navigate("${MainNavigation.BulletEdit}/${bullet.text}")
                        }
                    )
                }
                composable(
                    route = "${MainNavigation.BulletEdit}/{bullet}",
                    arguments = listOf(
                        navArgument("bullet") {
                            type = NavType.StringType
                            nullable = false
                        }
                    ),
                ) {
                    val message = it.arguments?.getString("bullet")
                        ?: throw IllegalArgumentException()
                    BulletCreate(
                        message = message,
                    )
                }
            }
        }
    }
}
