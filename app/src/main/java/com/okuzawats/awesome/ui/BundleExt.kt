package com.okuzawats.awesome.ui

import android.os.Bundle

fun Bundle.requireString(key: String): String = requireNotNull(getString(key))
