package com.okuzawats.awesome

import com.okuzawats.awesome.domain.bullet.BulletRepository
import com.okuzawats.awesome.presenter.bulletedit.BulletEditPresenter
import com.okuzawats.awesome.presenter.bulletedit.navigator.BulletEditNavigator
import com.okuzawats.awesome.presenter.bulletlist.BulletListPresenter
import com.okuzawats.awesome.presenter.bulletlist.navigator.BulletListNavigator
import com.okuzawats.awesome.presenter.bulletlist.reducer.BulletListReducer
import com.okuzawats.awesome.repository.DefaultBulletRepository
import com.okuzawats.awesome.ui.navigator.MainNavigator
import org.koin.dsl.bind
import org.koin.dsl.binds
import org.koin.dsl.module

val awesomeModule = module {
  factory { BulletEditPresenter(get()) }
  factory { BulletListPresenter(get(), get(), get()) }
  factory { BulletListReducer() }
  single { MainNavigator() } binds arrayOf(BulletEditNavigator::class, BulletListNavigator::class)
  single { DefaultBulletRepository() } bind BulletRepository::class
}
