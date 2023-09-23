package com.okuzawats.awesome

import com.okuzawats.awesome.presenter.bulletlist.DateProvider
import java.util.Date
import javax.inject.Inject

class DefaultDateProvider @Inject constructor() : DateProvider {
  override fun today(): Date {
    return Date()
  }
}
