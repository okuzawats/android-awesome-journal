package com.okuzawats.awesome.ui

import android.os.Bundle
import androidx.navigation.NavBackStackEntry

fun NavBackStackEntry.requireArgument(): Bundle = requireNotNull(arguments)
