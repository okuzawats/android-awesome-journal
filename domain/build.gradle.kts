plugins {
  id("com.android.library")
  id("org.jetbrains.kotlin.android")
  id("org.jetbrains.kotlin.kapt")
  id("com.google.dagger.hilt.android")
}

android {
  namespace = "com.okuzawats.awesome.domain"
  compileSdk = 33

  defaultConfig {
    minSdk = 26

    testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    consumerProguardFiles("consumer-rules.pro")
  }

  buildTypes {
    release {
      isMinifyEnabled = false
      proguardFiles(
        getDefaultProguardFile("proguard-android-optimize.txt"),
        "proguard-rules.pro"
      )
    }
  }
  compileOptions {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
  }
  kotlinOptions {
    jvmTarget = JavaVersion.VERSION_17.toString()
  }
  packaging {
    // kotlinx-coroutines-coreのデバッグ機能を除外
    // https://github.com/Kotlin/kotlinx.coroutines#avoiding-including-the-debug-infrastructure-in-the-resulting-apk
    resources.excludes += "DebugProbesKt.bin"
  }
}

dependencies {
  implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.7.3")
  implementation("com.google.dagger:hilt-android:2.48")
  kapt("com.google.dagger:hilt-compiler:2.48")
  testImplementation("com.google.dagger:hilt-android-testing:2.48")
  kaptTest("com.google.dagger:hilt-android-compiler:2.48")
}

kapt {
  correctErrorTypes = true // hilt
}

// FIXME コンパイルタスクのJVMのバージョンを固定するHack
//  see https://qiita.com/Nabe1216/items/322caa7acf11dbe032ca
tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile>()
  .configureEach {
    kotlinOptions {
      // targetCompatibilityと揃える
      jvmTarget = JavaVersion.VERSION_17.toString()
    }
  }
