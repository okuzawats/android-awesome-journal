package com.okuzawats.awesome.data.bullet

import com.okuzawats.awesome.domain.bullet.Bullet
import com.okuzawats.awesome.domain.bullet.BulletRepository
import com.okuzawats.awesome.domain.bulletdate.BulletDate
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class DefaultBulletRepository @Inject constructor(
  private val bulletDao: BulletDao,
) : BulletRepository {
  override suspend fun getBullets(): List<Bullet> {
    // TODO
    return withContext(Dispatchers.IO) {
      bulletDao
        .getAllBulletAt("id")
        .map { Bullet("id", "text", true) }
    }
  }

  override suspend fun getBulletsAt(date: BulletDate): List<Bullet> {
    // TODO
    return withContext(Dispatchers.IO) {
      bulletDao
        .getAllBulletAt("date_id")
        .map { Bullet("id", "text", true) }
    }
  }

  override suspend fun create(bullet: Bullet) {
    withContext(Dispatchers.IO) {
      bulletDao.save(
        BulletEntity(
          id = "id",
          dateId = "date_id",
          type = "type",
          text = "text",
        )
      )
    }
  }

  override suspend fun update(bullet: Bullet) {
    withContext(Dispatchers.IO) {
      bulletDao.update(
        BulletEntity(
          id = "id",
          dateId = "date_id",
          type = "type",
          text = "new_text",
        )
      )
    }
  }
}
