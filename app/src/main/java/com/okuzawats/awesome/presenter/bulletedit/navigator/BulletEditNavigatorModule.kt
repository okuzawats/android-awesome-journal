package com.okuzawats.awesome.presenter.bulletedit.navigator

import com.okuzawats.awesome.ui.navigator.MainNavigator
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class BulletEditNavigatorModule {
  @Binds
  abstract fun bindBulletEditNavigator(mainNavigator: MainNavigator): BulletEditNavigator
}
