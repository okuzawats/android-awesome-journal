package com.okuzawats.awesome.module

import com.okuzawats.awesome.domain.bullet.BulletRepository
import com.okuzawats.awesome.presenter.bulletlist.BulletListPresenter
import com.okuzawats.awesome.repository.DefaultBulletRepository
import org.koin.dsl.bind
import org.koin.dsl.module

val bulletListModule = module {
    factory { BulletListPresenter(get()) }
    single { DefaultBulletRepository() } bind BulletRepository::class
}
