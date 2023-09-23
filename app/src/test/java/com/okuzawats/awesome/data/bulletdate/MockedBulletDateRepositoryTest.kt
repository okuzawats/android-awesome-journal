package com.okuzawats.awesome.data.bulletdate

import com.google.common.truth.Truth.assertThat
import com.okuzawats.awesome.domain.bulletdate.BulletDateRepository
import com.okuzawats.awesome.rule.MainDispatcherRule
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Ignore
import org.junit.Rule
import org.junit.Test

class MockedBulletDateRepositoryTest {

  @get:Rule
  var mainDispatcherRule = MainDispatcherRule()

  private lateinit var sut: BulletDateRepository

  private lateinit var dao: BulletDateDao

  @Before
  fun setUp() {
    dao = mockk(relaxUnitFun = true)
    sut = DefaultBulletDateRepository(dao)
  }

  @Test
  fun returnsEmptyIfNotSavedYet() = runTest {
    coEvery { dao.getAll() } returns emptyList()

    val all = sut.getAll()

    assertThat(all).isEmpty()
  }

  @Test
  fun returnsOneItemIfSavedOne() = runTest {
    coEvery { dao.getAll() } returns listOf(
      BulletDateEntity(id = "id", date = "2023-09-23")
    )

    val all = sut.getAll()

    assertThat(all).hasSize(1)
  }

  @Test
  @Ignore("not yet implemented")
  fun getCurrentDate() {
  }

  @Test
  @Ignore("not yet implemented")
  fun createCurrentDate() {
  }
}
