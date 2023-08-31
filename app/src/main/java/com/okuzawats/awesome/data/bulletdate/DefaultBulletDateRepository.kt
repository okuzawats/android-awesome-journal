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
      // TODO mapの実装
      bulletDataDao
        .getAll()
        .map {
          BulletDate(
            UUID.randomUUID(),
            Date(),
          )
        }
    }
  }

  override suspend fun getCurrentDate(): BulletDate {
    return withContext(Dispatchers.IO) {
      BulletDate(
        UUID.randomUUID(),
        Date(),
      )
    }
  }

  override suspend fun createCurrentDate() {
    // TODO 日付の取得処理の実装
    withContext(Dispatchers.IO) {
      bulletDataDao.save(
        BulletDateEntity("id", "date")
      )
    }
  }
}
