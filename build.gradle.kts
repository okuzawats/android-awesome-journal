buildscript {
  dependencies {
    classpath("org.jacoco:org.jacoco.core:0.8.10")
  }
}

plugins {
  id("com.android.application") version "8.1.0" apply false
  id("com.android.library") version "8.1.0" apply false
  id("org.jetbrains.kotlin.android") version "1.9.10" apply false
  id("com.google.devtools.ksp") version "1.9.10-1.0.13" apply false
  id("com.google.dagger.hilt.android") version "2.48" apply false
  id("org.jetbrains.kotlinx.kover") version "0.7.3" apply false
}
