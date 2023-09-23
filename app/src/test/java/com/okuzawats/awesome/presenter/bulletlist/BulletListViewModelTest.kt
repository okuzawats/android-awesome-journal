package com.okuzawats.awesome.presenter.bulletlist

import com.okuzawats.awesome.domain.bullet.Bullet
import com.okuzawats.awesome.domain.bullet.BulletRepository
import com.okuzawats.awesome.domain.bullet.BulletType
import com.okuzawats.awesome.domain.bulletdate.BulletDate
import com.okuzawats.awesome.presenter.bulletlist.navigator.BulletListNavigator
import com.okuzawats.awesome.presenter.bulletlist.reducer.BulletListReducer
import com.okuzawats.awesome.presenter.bulletlist.state.BulletList
import com.okuzawats.awesome.presenter.bulletlist.state.BulletListState
import com.okuzawats.awesome.rule.MainDispatcherRule
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.every
import io.mockk.mockk
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Ignore
import org.junit.Rule
import org.junit.Test
import java.text.SimpleDateFormat

class BulletListViewModelTest {

  @get:Rule
  var mainDispatcherRule = MainDispatcherRule()

  private lateinit var sut: BulletListViewModel

  private lateinit var bulletRepository: BulletRepository
  private lateinit var reducer: BulletListReducer
  private lateinit var navigator: BulletListNavigator
  private lateinit var dateProvider: DateProvider

  companion object {
    private val dateFormat = SimpleDateFormat("yyyy-MM-dd")
  }

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
  @Ignore("Stateのテストが書けるようになるまで無効化")
  fun present() = runTest {
    val today = dateFormat.parse("2023-09-23")!!
    every { dateProvider.today() } returns today
    coEvery { bulletRepository.getBulletsAt(BulletDate(any(), today)) }
    every { reducer.state } returns MutableStateFlow<BulletListState>(
      BulletList(date = today, bullets = emptyList()))
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
