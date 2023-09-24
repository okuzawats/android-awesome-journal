package com.okuzawats.awesome.ui

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.okuzawats.awesome.ui.component.AwesomeBottomAppBar
import com.okuzawats.awesome.ui.screen.BulletEditScreen
import com.okuzawats.awesome.ui.screen.BulletListScreen
import com.okuzawats.awesome.ui.screen.DayListScreen
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch

@Composable
fun MainScreen(
  viewModel: MainViewModel = hiltViewModel(),
) {
  val navController = rememberNavController()

  // TODO BottomAppBarの管理方法を考える
  var isBottomAppBarVisible: Boolean by remember { mutableStateOf(true) }

  LaunchedEffect(Unit) {
    viewModel.navigator.toEdit
      .onEach {
        isBottomAppBarVisible = false
        navController.navigate(route = "${MainNavigation.BulletEdit}/${it.id}")
      }
      .launchIn(this)

    viewModel.navigator.pop
      .onEach {
        navController.popBackStack()
      }
      .launchIn(this)
  }

  MaterialTheme {
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Open)
    val drawerScope = rememberCoroutineScope()

    ModalNavigationDrawer(
      drawerState = drawerState,
      drawerContent = {
        DayListScreen(isOpened = drawerState.isOpen) {
          drawerScope.launch {
            drawerState.close()
          }
        }
      }
    ) {
      Scaffold(
        bottomBar = {
          if (isBottomAppBarVisible) {
            AwesomeBottomAppBar(
              modifier = Modifier.fillMaxWidth(),
              onCalendarClicked = {
                drawerScope.launch {
                  drawerState.open()
                }
              },
              onFabClicked = {
                // TODO MainScreen用のPresenterを作成する。
                isBottomAppBarVisible = false
                navController.navigate("${MainNavigation.BulletEdit}/${null}")
              },
            )
          }
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
            BulletListScreen()
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
            BulletEditScreen(
              bulletId = it.requireArgument().getString("bullet_id", null),
              onDisposed = {
                isBottomAppBarVisible = true
              },
            )
          }
        }
      }
    }
  }
}
