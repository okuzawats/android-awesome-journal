package com.okuzawats.awesome.presenter.bulletedit

import com.okuzawats.awesome.domain.bullet.BulletRepository
import com.okuzawats.awesome.presenter.bulletedit.navigator.BulletEditNavigator
import com.okuzawats.awesome.rule.MainDispatcherRule
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class BulletEditViewModelTest {

  @get:Rule
  var mainDispatcherRule = MainDispatcherRule()

  private lateinit var sut: BulletEditViewModel

  private lateinit var bulletEditNavigator: BulletEditNavigator
  private lateinit var bulletRepository: BulletRepository

  @Before
  fun setUp() {
    bulletEditNavigator = mockk(relaxUnitFun = true)
    bulletRepository = mockk(relaxUnitFun = true)

    sut = BulletEditViewModel(
      navigator = bulletEditNavigator,
      bulletRepository = bulletRepository,
    )
  }

  @Test
  fun whenBackClickedThenPopBack() = runTest {
    sut.onBackClicked()

    coVerify(exactly = 1) {
      bulletEditNavigator.popEdit()
    }
  }

  @Test
  fun whenSaveClickedThenSaveBullet() = runTest {
    sut.onSaveClicked()

    coVerify(exactly = 1) {
      bulletRepository.create(any())
    }
  }
}
