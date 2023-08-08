package com.okuzawats.awesome.presenter.bulletlist

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import com.okuzawats.awesome.domain.bullet.Bullet
import com.okuzawats.awesome.domain.bullet.BulletRepository
import com.okuzawats.awesome.presenter.bulletlist.state.BulletList
import com.okuzawats.awesome.presenter.bulletlist.state.BulletListState
import com.slack.circuit.runtime.presenter.Presenter
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

/**
 * Bullet一覧画面のPresenter
 */
class BulletListPresenter(
    private val bulletRepository: BulletRepository,
) : Presenter<BulletListState>, CoroutineScope {

    override val coroutineContext: CoroutineContext
        get() = job + Dispatchers.IO

    private val job = Job()

    @Composable
    override fun present(): BulletListState {
        var bullets: List<Bullet> by remember { mutableStateOf(emptyList()) }

        LaunchedEffect(Unit) {
            bullets = bulletRepository.getBullets()
        }

        return BulletList(bullets) {
            launch {
                bullets = bulletRepository.getBullets()
            }
        }
    }

    fun conceal() {
        job.cancel()
    }
}
