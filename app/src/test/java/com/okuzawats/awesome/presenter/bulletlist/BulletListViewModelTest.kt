package com.okuzawats.awesome.presenter.bulletlist

import com.okuzawats.awesome.domain.bullet.Bullet
import com.okuzawats.awesome.domain.bullet.BulletRepository
import com.okuzawats.awesome.domain.bullet.BulletType
import com.okuzawats.awesome.presenter.bulletlist.navigator.BulletListNavigator
import com.okuzawats.awesome.presenter.bulletlist.reducer.BulletListReducer
import com.okuzawats.awesome.rule.MainDispatcherRule
import io.mockk.coVerify
import io.mockk.mockk
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class BulletListViewModelTest {

  @get:Rule
  var mainDispatcherRule = MainDispatcherRule()

  private lateinit var sut: BulletListViewModel

  private lateinit var bulletRepository: BulletRepository
  private lateinit var reducer: BulletListReducer
  private lateinit var navigator: BulletListNavigator
  private lateinit var dateProvider: DateProvider

  @Before
  fun setUp() {
    bulletRepository = mockk()
    reducer = mockk()
    navigator = mockk(relaxUnitFun = true)
    dateProvider = mockk()

    sut = BulletListViewModel(
      bulletRepository = bulletRepository,
      reducer = reducer,
      navigator = navigator,
      dateProvider = dateProvider,
    )
  }

  @Test
  fun present() {
  }

  @Test
  fun whenBulletClickedThenNavigateToEdit() {
    val bullet = Bullet(id = "id", text = "text", type = BulletType.Task, done = false)

    sut.onBulletClicked(bullet)

    coVerify {
      navigator.toEdit(bullet)
    }
  }
}
