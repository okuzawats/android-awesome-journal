package com.okuzawats.awesome.repository

import com.okuzawats.awesome.domain.bullet.Bullet
import com.okuzawats.awesome.domain.bullet.BulletRepository
import java.util.UUID

class DefaultBulletRepository : BulletRepository {
    override suspend fun getBullets(): List<Bullet> {
        return (0 ..< 100).map {
            Bullet(
                id = UUID.randomUUID(),
                text = "ABCDEFGHIJKLMNOPQRSTUVWXYZ",
                done = false,
            )
        }
    }
}
