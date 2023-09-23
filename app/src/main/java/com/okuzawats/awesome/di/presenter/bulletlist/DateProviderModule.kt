package com.okuzawats.awesome.di.presenter.bulletlist

import com.okuzawats.awesome.DefaultDateProvider
import com.okuzawats.awesome.presenter.bulletlist.DateProvider
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class DateProviderModule {
  @Binds
  abstract fun bindDateProvider(impl: DefaultDateProvider): DateProvider
}
