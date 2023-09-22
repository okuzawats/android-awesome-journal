package com.okuzawats.awesome.presenter.architecture

import app.cash.turbine.test
import com.google.common.truth.Truth.assertThat
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test

class AwesomeReducerTest {
  private sealed class TestUiState: UiState
  private data object InitialUiState: TestUiState()
  private data object SecondUiState: TestUiState()
  private data object SomeUiState: TestUiState()

  private sealed class TestUiEvent: UiEvent
  private data object SomeUiEvent: TestUiEvent()

  private lateinit var sut: AwesomeReducer<TestUiState, TestUiEvent>

  @Before
  fun setUp() {
    sut = object : AwesomeReducer<TestUiState, TestUiEvent>(InitialUiState) {
      override fun reduce(oldState: TestUiState, event: TestUiEvent) {
        setState(SecondUiState)
      }
    }
  }

  @Test
  fun initialStateIsInitialUiState() = runTest {
    sut.state.test {
      val initialItem = awaitItem()
      assertThat(initialItem).isInstanceOf(InitialUiState::class.java)
    }
  }

  @Test
  fun setStateCouldUpdateState() = runTest {
    sut.state.test {
      awaitItem() // 初期状態を読み捨てる

      sut.setState(SomeUiState)

      val secondItem = awaitItem()
      assertThat(secondItem).isInstanceOf(SomeUiState::class.java)
    }
  }

  @Test
  fun sendEventCouldUpdateState() = runTest {
    sut.state.test {
      awaitItem() // 初期状態を読み捨てる

      sut.sendEvent(SomeUiEvent)

      val secondItem = awaitItem()
      assertThat(secondItem).isInstanceOf(SecondUiState::class.java)
    }
  }
}
