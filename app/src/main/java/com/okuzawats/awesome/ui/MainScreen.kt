package com.okuzawats.awesome.ui

import android.os.Bundle
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.okuzawats.awesome.ui.component.AwesomeBottomAppBar
import com.okuzawats.awesome.ui.component.BulletCreate
import com.okuzawats.awesome.ui.navigator.MainNavigator
import com.okuzawats.awesome.ui.screen.BulletList
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import org.koin.compose.koinInject

@Composable
fun MainScreen(
  navigator: MainNavigator = koinInject(),
) {
  val navController = rememberNavController()

  LaunchedEffect(Unit) {
    navigator.toEdit.onEach {
      navController.navigate("${MainNavigation.BulletEdit}/${it.id}")
    }.launchIn(this)
  }

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
          BulletList()
        }
        composable(
          route = "${MainNavigation.BulletEdit}/{bullet_id}",
          arguments = listOf(
            navArgument("bullet_id") {
              type = NavType.StringType
              nullable = false
            }
          ),
        ) {
          BulletCreate(
            bulletId = it.requireStringArgument("bullet_id"),
          )
        }
      }
    }
  }
}

fun NavBackStackEntry.requireArgument(): Bundle = requireNotNull(arguments)

fun NavBackStackEntry.requireStringArgument(key: String) = requireArgument().requireString(key)

fun Bundle.requireString(key: String): String = requireNotNull(getString(key))
