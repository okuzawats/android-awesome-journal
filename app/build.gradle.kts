plugins {
  id("com.android.application")
  id("org.jetbrains.kotlin.android")
  id("com.google.devtools.ksp")
  id("com.google.dagger.hilt.android")
}

apply(from = "../jacoco/modules.gradle")

android {
  namespace = "com.okuzawats.awesome"
  compileSdk = 34

  defaultConfig {
    applicationId = "com.okuzawats.awesome"
    minSdk = 26
    targetSdk = 34
    versionCode = 1
    versionName = "1.0"

    testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    vectorDrawables {
      useSupportLibrary = true
    }
  }

  buildTypes {
    release {
      isMinifyEnabled = false
      proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
    }
  }
  compileOptions {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
  }
  kotlinOptions {
    jvmTarget = JavaVersion.VERSION_17.toString()
  }
  buildFeatures {
    compose = true
  }
  composeOptions {
    kotlinCompilerExtensionVersion = "1.5.3"
  }
  packagingOptions {
    resources.excludes += "/META-INF/{AL2.0,LGPL2.1}"
  }
}

dependencies {
  implementation(platform("org.jetbrains.kotlin:kotlin-bom:1.9.10"))
  testImplementation("org.jetbrains.kotlinx:kotlinx-coroutines-test")

  implementation("androidx.core:core-ktx:1.12.0")
  implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.6.2")
  implementation("androidx.activity:activity-compose:1.7.2")
  implementation("androidx.navigation:navigation-compose:2.7.5")
  implementation("androidx.hilt:hilt-navigation-compose:1.0.0")

  implementation(platform("androidx.compose:compose-bom:2023.09.02"))
  implementation("androidx.compose.ui:ui")
  implementation("androidx.compose.ui:ui-graphics")
  implementation("androidx.compose.ui:ui-tooling-preview")
  implementation("androidx.compose.material3:material3")
  debugImplementation("androidx.compose.ui:ui-tooling")
  debugImplementation("androidx.compose.ui:ui-test-manifest")

  implementation("com.google.dagger:hilt-android:2.48")
  ksp("com.google.dagger:hilt-compiler:2.48")
  testImplementation("com.google.dagger:hilt-android-testing:2.48")
  ksp("com.google.dagger:hilt-android-compiler:2.48")

  implementation("androidx.room:room-runtime:2.5.2")
  ksp("androidx.room:room-compiler:2.5.2")

  testImplementation("junit:junit:4.13.2")
  testImplementation("androidx.test.ext:junit-ktx:1.1.5")
  testImplementation("org.robolectric:robolectric:4.10.3")
  testImplementation("com.google.truth:truth:1.1.5")
  testImplementation("io.mockk:mockk:1.13.8")
  testImplementation("app.cash.turbine:turbine:1.0.0")
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
