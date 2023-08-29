package com.okuzawats.awesome.module

import com.okuzawats.awesome.presenter.bulletedit.BulletEditPresenter
import org.koin.dsl.module

val bulletEditModule = module {
  factory { BulletEditPresenter() }
}
