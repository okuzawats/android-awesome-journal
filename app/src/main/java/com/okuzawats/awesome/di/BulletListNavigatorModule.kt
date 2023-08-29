package com.okuzawats.awesome.di

import com.okuzawats.awesome.presenter.bulletlist.navigator.BulletListNavigator
import com.okuzawats.awesome.ui.navigator.MainNavigator
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class BulletListNavigatorModule {
  @Binds
  abstract fun provideBulletListNavigator(mainNavigator: MainNavigator): BulletListNavigator
}
