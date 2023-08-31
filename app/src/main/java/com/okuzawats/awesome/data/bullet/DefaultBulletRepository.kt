package com.okuzawats.awesome.data.bullet

import com.okuzawats.awesome.domain.bullet.Bullet
import com.okuzawats.awesome.domain.bullet.BulletRepository
import com.okuzawats.awesome.domain.bulletdate.BulletDate
import javax.inject.Inject

class DefaultBulletRepository @Inject constructor(
  private val bulletDao: BulletDao,
) : BulletRepository {
  override suspend fun getBullets(): List<Bullet> {
    TODO("Not yet implemented")
  }

  override suspend fun getBulletsAt(date: BulletDate): List<Bullet> {
    TODO("Not yet implemented")
  }

  override suspend fun create(bullet: Bullet) {
    TODO("Not yet implemented")
  }

  override suspend fun update(bullet: Bullet) {
    TODO("Not yet implemented")
  }
}
