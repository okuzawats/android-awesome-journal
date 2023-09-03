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
  // Kotlin Coroutines（特にFlow）
  implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.7.3")
  // 依存性注入
  implementation("com.google.dagger:hilt-android:2.47")
  kapt("com.google.dagger:hilt-compiler:2.47")
  // 単体テスト用のフレームワーク
  testImplementation("junit:junit:4.13.2")
  // JUnit 4とHiltを組み合わせてテストランナーを動かすために使用
  testImplementation("androidx.test.ext:junit-ktx:1.1.5")
  // テストコードでCoroutinesを動かすために使用
  testImplementation("org.jetbrains.kotlinx:kotlinx-coroutines-test:1.7.3")
  // テストコードでFluent Assertionを書くために使用
  testImplementation("com.google.truth:truth:1.1.4")
  // テストダブルの作成に使用
  testImplementation("io.mockk:mockk:1.13.1")
  // Flowのテストのために使用
  testImplementation("app.cash.turbine:turbine:1.0.0")
  // テストコードでAndroid特有のコードを動かすために使用
  testImplementation("org.robolectric:robolectric:4.10.3")
  // テストコードでHiltを用いた依存性注入を行うために使用
  testImplementation("com.google.dagger:hilt-android-testing:2.47")
  kaptTest("com.google.dagger:hilt-android-compiler:2.47")
}

kapt {
  correctErrorTypes = true // hilt
}
