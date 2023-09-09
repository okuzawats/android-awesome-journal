//package com.okuzawats.awesome.data.todo
//
//import androidx.test.ext.junit.runners.AndroidJUnit4
//import com.google.common.truth.Truth.assertThat
//import dagger.hilt.android.testing.HiltAndroidRule
//import dagger.hilt.android.testing.HiltAndroidTest
//import dagger.hilt.android.testing.HiltTestApplication
//import kotlinx.coroutines.test.runTest
//import org.junit.Before
//import org.junit.Rule
//import org.junit.Test
//import org.junit.runner.RunWith
//import org.robolectric.annotation.Config
//import javax.inject.Inject
//
//@HiltAndroidTest
//@Config(
//  application = HiltTestApplication::class,
//  manifest = Config.NONE,
//)
//@RunWith(AndroidJUnit4::class)
//class DefaultToDoRepositoryTest {
//  companion object {
//    const val ID_IN_SUCCESS_TODO = "id_in_success_todo"
//    const val ID_IN_SUCCESS_DONE = "id_in_success_done"
//    const val ID_IN_FAILURE = "id_in_failure"
//  }
//
//  @get:Rule
//  var hiltRule = HiltAndroidRule(this)
//
//  @Inject
//  lateinit var sut: DefaultToDoRepository
//
//  @Before
//  fun setUp() {
//    hiltRule.inject()
//  }
//
//  @Test
//  fun canUpdateIsDoneToTrue() = runTest {
//    sut.createToDo(id = ID_IN_SUCCESS_TODO, whatToDo = "whatToDo", isDone = false)
//
//    sut.doneToDo(ID_IN_SUCCESS_TODO)
//
//    val toDo = sut.getToDoById(ID_IN_SUCCESS_TODO)
//    assertThat(toDo.isDone).isTrue()
//  }
//}
