package com.okuzawats.awesome.module

import com.okuzawats.awesome.domain.bullet.BulletRepository
import com.okuzawats.awesome.presenter.bulletlist.BulletListPresenter
import com.okuzawats.awesome.presenter.bulletlist.navigator.BulletListNavigator
import com.okuzawats.awesome.presenter.bulletlist.reducer.BulletListReducer
import com.okuzawats.awesome.repository.DefaultBulletRepository
import com.okuzawats.awesome.ui.navigator.MainNavigator
import org.koin.dsl.bind
import org.koin.dsl.module

val bulletListModule = module {
  factory { BulletListPresenter(get(), get(), get()) }
  factory { BulletListReducer() }
  single { MainNavigator() } bind BulletListNavigator::class
  single { DefaultBulletRepository() } bind BulletRepository::class
}
