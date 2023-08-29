package com.okuzawats.awesome.di

import com.okuzawats.awesome.presenter.bulletedit.navigator.BulletEditNavigator
import com.okuzawats.awesome.ui.navigator.MainNavigator
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class BulletEditNavigatorModule {
  @Provides
  fun provideBulletEditNavigator(mainNavigator: MainNavigator): BulletEditNavigator = mainNavigator
}
