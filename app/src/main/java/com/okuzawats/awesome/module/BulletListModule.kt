package com.okuzawats.awesome.module

import com.okuzawats.awesome.presenter.bulletlist.BulletListPresenter
import org.koin.dsl.module

val bulletListModule = module {
    factory { BulletListPresenter() }
}
