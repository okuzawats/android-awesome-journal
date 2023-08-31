package com.okuzawats.awesome.data.bulletdate

import com.okuzawats.awesome.domain.bulletdate.BulletDate
import com.okuzawats.awesome.domain.bulletdate.BulletDateRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.util.Date
import java.util.UUID
import javax.inject.Inject

class DefaultBulletDateRepository @Inject constructor(
  private val bulletDataDao: BulletDateDao,
) : BulletDateRepository {
  override suspend fun getAll(): List<BulletDate> {
    return withContext(Dispatchers.IO) {
      // テスト用のデータ
      bulletDataDao
        .save(
          BulletDateEntity("", "")
        )
      bulletDataDao
        .getAll()
        .map {
          // TODO
          BulletDate(
            UUID.randomUUID(),
            Date(),
          )
        }
    }
  }

  override suspend fun getCurrentDate(): BulletDate {
    TODO("Not yet implemented")
  }

  override suspend fun createCurrentDate() {
    TODO("Not yet implemented")
  }
}
