package com.okuzawats.awesome.data.bulletdate

import com.okuzawats.awesome.domain.bulletdate.BulletDate
import com.okuzawats.awesome.domain.bulletdate.BulletDateRepository
import javax.inject.Inject

class DefaultBulletDateRepository @Inject constructor(
  private val bulletDataDao: BulletDateDao,
) : BulletDateRepository {
  override suspend fun getAll(): List<BulletDate> {
    TODO("Not yet implemented")
  }

  override suspend fun getCurrentDate(): BulletDate {
    TODO("Not yet implemented")
  }

  override suspend fun createCurrentDate() {
    TODO("Not yet implemented")
  }
}
