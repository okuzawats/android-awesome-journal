package com.okuzawats.awesome.di

import com.okuzawats.awesome.presenter.bulletlist.navigator.BulletListNavigator
import com.okuzawats.awesome.ui.navigator.MainNavigator
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class BulletListNavigatorModule {
  @Provides
  fun provideBulletListNavigator(mainNavigator: MainNavigator): BulletListNavigator = mainNavigator
}
