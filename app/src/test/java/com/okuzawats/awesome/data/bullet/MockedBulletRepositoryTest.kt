package com.okuzawats.awesome.data.bullet

import com.google.common.truth.Truth.assertThat
import com.okuzawats.awesome.domain.bullet.Bullet
import com.okuzawats.awesome.domain.bullet.BulletRepository
import com.okuzawats.awesome.domain.bullet.BulletType
import com.okuzawats.awesome.domain.bulletdate.BulletDate
import com.okuzawats.awesome.rule.MainDispatcherRule
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import java.util.Date
import java.util.UUID

class MockedBulletRepositoryTest {

  @get:Rule
  var mainDispatcherRule = MainDispatcherRule()

  private lateinit var sut: BulletRepository

  private lateinit var dao: BulletDao

  @Before
  fun setUp() {
    dao = mockk(relaxUnitFun = true)
    sut = DefaultBulletRepository(dao)
  }

  @Test
  fun returnsEmptyIfNotSavedYet() = runTest {
    coEvery { dao.getAllBulletAt(any()) } returns emptyList()

    val all = sut.getBulletsAt(BulletDate(UUID.randomUUID(), Date()))

    assertThat(all).isEmpty()
  }

  @Test
  fun returnsOneItemIfSavedOne() = runTest {
    coEvery { dao.getAllBulletAt(any()) } returns listOf(
      BulletEntity(id = "id", dateId = "date_id", type = "type", text = "text")
    )

    val all = sut.getBulletsAt(BulletDate(UUID.randomUUID(), Date()))

    assertThat(all).hasSize(1)
  }

  @Test
  fun createSavesToDao() = runTest {
    sut.create(Bullet("id", "text", BulletType.Task, true))

    coVerify(exactly = 1) { dao.save(any()) }
  }

  @Test
  fun updateSavesToDao() = runTest {
    sut.update(Bullet("id", "text", BulletType.Task, true))

    coVerify(exactly = 1) { dao.update(any()) }
  }
}
