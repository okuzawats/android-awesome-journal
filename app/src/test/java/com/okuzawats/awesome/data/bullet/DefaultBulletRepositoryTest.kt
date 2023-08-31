package com.okuzawats.awesome.data.bullet

import androidx.test.ext.junit.runners.AndroidJUnit4
import com.google.common.truth.Truth.assertThat
import com.okuzawats.awesome.domain.bullet.Bullet
import com.okuzawats.awesome.domain.bullet.BulletRepository
import com.okuzawats.awesome.domain.bulletdate.BulletDate
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
import java.util.Date
import java.util.UUID
import javax.inject.Inject

@HiltAndroidTest
@Config(
  application = HiltTestApplication::class,
  manifest = Config.NONE,
)
@RunWith(AndroidJUnit4::class)
class DefaultBulletRepositoryTest {

  @get:Rule
  var hiltRule = HiltAndroidRule(this)

  @Inject
  lateinit var sut: BulletRepository

  @Before
    fun setUp() {
      hiltRule.inject()
    }

    @After
    fun tearDown() {
    }

    @Test
    fun hasEmptyItemByDefault() = runTest {
      val all = sut.getBulletsAt(BulletDate(UUID.randomUUID(), Date()))

      assertThat(all).isEmpty()
    }

    @Test
    fun hasOneItemAfterCreate() = runTest {
      sut.create(Bullet("id", "text", true))

      val all = sut.getBulletsAt(BulletDate(UUID.randomUUID(), Date()))

      assertThat(all).hasSize(1)
    }

  @Ignore("TODO")
    @Test
    fun updateAlterColumn() = runTest {
      sut.create(Bullet("id", "text", true))
      sut.update(Bullet("id", "new_text", true))

      val all = sut.getBulletsAt(BulletDate(UUID.randomUUID(), Date()))

      assertThat(all[0].text).isEqualTo("new_text")
    }
}