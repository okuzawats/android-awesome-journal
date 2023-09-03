package com.okuzawats.awesome.data.bulletdate

import androidx.test.ext.junit.runners.AndroidJUnit4
import com.google.common.truth.Truth.assertThat
import com.okuzawats.awesome.domain.bulletdate.BulletDateRepository
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import dagger.hilt.android.testing.HiltTestApplication
import kotlinx.coroutines.test.runTest
import org.junit.After
import org.junit.Before
import org.junit.Ignore
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.annotation.Config
import javax.inject.Inject

@HiltAndroidTest
@Config(
  application = HiltTestApplication::class,
  manifest = Config.NONE,
)
@RunWith(AndroidJUnit4::class)
class DefaultBulletDateRepositoryTest {

  @get:Rule
  var hiltRule = HiltAndroidRule(this)

  @Inject
  lateinit var sut: BulletDateRepository

  @Before
  fun setUp() {
    hiltRule.inject()
  }

  @After
  fun tearDown() {
  }

  @Test
  fun hasEmptyItemByDefault() = runTest {
    val all = sut.getAll()

    assertThat(all).isEmpty()
  }

  @Test
  fun hasOneItemAfterCreatingCurrentDate() = runTest {
    sut.createCurrentDate()

    val all = sut.getAll()

    assertThat(all).hasSize(1)
  }

  @Test
  fun doNotInsertCurrentDateTwice() = runTest {
    sut.createCurrentDate()
    sut.createCurrentDate()

    val all = sut.getAll()

    assertThat(all).hasSize(1)
  }

  @Ignore("TODO")
  @Test
  fun currentDateHasDateOfToday() = runTest {
    val today = sut.getCurrentDate()

    assertThat(today.date).isEqualTo("") // TODO
  }
}
