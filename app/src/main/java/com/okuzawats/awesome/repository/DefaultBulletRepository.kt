package com.okuzawats.awesome.repository

import com.okuzawats.awesome.domain.bullet.Bullet
import com.okuzawats.awesome.domain.bullet.BulletRepository
import java.util.UUID

class DefaultBulletRepository : BulletRepository {
    companion object {
        private const val charset = "ABCDEFGHIJKLMNOPQRSTUVWXTZabcdefghiklmnopqrstuvwxyz0123456789"
    }
    override suspend fun getBullets(): List<Bullet> {
        return (0 ..< 100).map {
            val text = (0 ..< 30).map { charset.random() }.joinToString("")
            Bullet(
                id = UUID.randomUUID(),
                text = text,
                done = false,
            )
        }
    }
}
