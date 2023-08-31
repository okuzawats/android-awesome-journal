package com.okuzawats.awesome.repository

import com.okuzawats.awesome.domain.bullet.Bullet
import com.okuzawats.awesome.domain.bullet.BulletRepository
import com.okuzawats.awesome.domain.bulletdate.BulletDate
import java.util.UUID
import javax.inject.Inject

class DefaultBulletRepository @Inject constructor() : BulletRepository {
  companion object {
    private const val charset = "ABCDEFGHIJKLMNOPQRSTUVWXTZabcdefghiklmnopqrstuvwxyz0123456789"
  }

  override suspend fun getBullets(): List<Bullet> {
    return (0 until  100).map {
      val text = (0 until  30).map { charset.random() }.joinToString("")
      Bullet(
        id = "${UUID.randomUUID()}",
        text = text,
        done = false,
      )
    }
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
