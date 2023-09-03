package com.okuzawats.awesome.domain.done

import androidx.test.ext.junit.runners.AndroidJUnit4
import app.cash.turbine.test
import com.google.common.truth.Truth.assertThat
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import dagger.hilt.android.testing.HiltTestApplication
import kotlinx.coroutines.test.runTest
import org.junit.After
import org.junit.Before
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
class DefaultDoneToDoUseCaseTest {
  companion object {
    const val ID_DONE_TODO_SUCCESS = 1L
    const val ID_DONE_TODO_FAILURE = 2L
  }

  @get:Rule
  var hiltRule = HiltAndroidRule(this)

  @Inject
  lateinit var sut: DoneToDoUseCase

  @Before
  fun setUp() {
    hiltRule.inject()
  }

  @After
  fun tearDown() {
  }

  @Test
  fun emits_done_only_if_saved_successfully() = runTest {
    sut.invoke(ID_DONE_TODO_SUCCESS).test {
      val first = awaitItem()
      assertThat(first).isEqualTo(DoneState.Done)

      awaitComplete()
    }
  }

  @Test
  fun emits_todo_after_emitting_done_if_save_failed() = runTest {
    sut.invoke(ID_DONE_TODO_FAILURE).test {
      val first = awaitItem()
      assertThat(first).isEqualTo(DoneState.Done)

      val second = awaitItem()
      assertThat(second).isEqualTo(DoneState.ToDo)

      awaitComplete()
    }
  }
}
