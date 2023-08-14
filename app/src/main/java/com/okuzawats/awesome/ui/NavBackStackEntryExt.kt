package com.okuzawats.awesome.ui

import android.os.Bundle
import androidx.navigation.NavBackStackEntry

/**
 * NavBackStackEntryからBundleを取り出す。
 *
 * @throws IllegalArgumentException Bundleがnullだった場合にthrowされる。
 */
fun NavBackStackEntry.requireArgument(): Bundle = requireNotNull(arguments)
