package com.okuzawats.awesome.ui

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.okuzawats.awesome.ui.component.AwesomeBottomAppBar
import com.okuzawats.awesome.ui.component.BulletCreateOrEdit
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
    navigator.toEdit
      .onEach { navController.navigate(route = "${MainNavigation.BulletEdit}/${it.id}") }
      .launchIn(this)
  }

  MaterialTheme {
    Scaffold(
      bottomBar = {
        AwesomeBottomAppBar(
          modifier = Modifier.fillMaxWidth(),
          onFabClicked = {
            // TODO MainScreen用のPresenterを作成する。
            navController.navigate("${MainNavigation.BulletEdit}/${null}")
          },
        )
      },
    ) { padding ->
      NavHost(
        navController = navController,
        startDestination = MainNavigation.BulletList.toString(),
        modifier = Modifier.padding(padding),
      ) {
        /* Bullet一覧画面 */
        composable(
          route = MainNavigation.BulletList.toString(),
        ) {
          BulletList()
        }
        /* Bullet新規作成・編集画面 */
        composable(
          route = "${MainNavigation.BulletEdit}/{bullet_id}",
          arguments = listOf(
            navArgument("bullet_id") {
              type = NavType.StringType
              nullable = true
            }
          ),
        ) {
          BulletCreateOrEdit(
            bulletId = it.requireArgument().getString("bullet_id", null),
          )
        }
      }
    }
  }
}
