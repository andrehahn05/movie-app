@file:Suppress("DEPRECATION")

import com.android.build.api.dsl.Lint
import java.io.FileInputStream
import java.util.Properties

plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("kotlin-kapt")
    id("com.google.dagger.hilt.android")
    id("com.google.devtools.ksp")

}

val apiKeyPropertiesFile: File = rootProject.file("apiKey.properties")
val apiKeyProperties = Properties()
apiKeyProperties.load(FileInputStream(apiKeyPropertiesFile))

android {
    namespace = "com.example.movieapp"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.movieapp"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"

        buildFeatures {
            buildConfig = true
        }

        buildConfigField("String", "API_KEY", apiKeyProperties["API_KEY"].toString())
        buildConfigField("String", "BASE_URL", apiKeyProperties["BASE_URL"].toString())
        buildConfigField("String", "BASE_URL_IMAGE", apiKeyProperties["BASE_URL_IMAGE"].toString())

        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = true
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
        lint {
            warningsAsErrors = true
        }
    }


    kotlinOptions {
        jvmTarget = "17"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.4.3"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {

    implementation("androidx.core:core-ktx:1.12.0")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.7.0")
    implementation("androidx.activity:activity-compose:1.8.2")
    implementation(platform("androidx.compose:compose-bom:2024.01.00"))
    implementation("androidx.compose.ui:ui")
    implementation("androidx.compose.ui:ui-graphics")
    implementation("androidx.compose.ui:ui-tooling-preview")
    implementation("androidx.compose.material3:material3")
    implementation("androidx.media3:media3-effect:1.3.0")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
    androidTestImplementation(platform("androidx.compose:compose-bom:2024.01.00"))
    androidTestImplementation("androidx.compose.ui:ui-test-junit4")
    debugImplementation("androidx.compose.ui:ui-tooling")
    debugImplementation("androidx.compose.ui:ui-test-manifest")


    // Coil
    implementation("io.coil-kt:coil-compose:2.5.0")
    //Timber
    implementation("com.jakewharton.timber:timber:5.0.1")
    //DataStore
    implementation("androidx.datastore:datastore-preferences:1.0.0")
    // Splashscreen
    implementation("androidx.core:core-splashscreen:1.0.1")
    // Paging3
    implementation("androidx.paging:paging-runtime-ktx:3.2.1")
    implementation("androidx.paging:paging-compose:3.3.0-alpha02")
    // Others - Compose dependencies
    implementation("androidx.compose.material:material-icons-extended")
    implementation("androidx.lifecycle:lifecycle-viewmodel-compose:2.7.0")
    implementation("com.google.accompanist:accompanist-flowlayout:0.34.0")
    implementation("androidx.navigation:navigation-compose:2.7.6")
    //Gson
    implementation("com.google.code.gson:gson:2.10.1")
    // Coroutines
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.7.3")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.7.3")
    // Coroutine Lifecycle Scopes
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.7.0")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.7.0")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.7.3")
    // Retrofit
    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    implementation("com.squareup.retrofit2:converter-gson:2.9.0")
    implementation("com.squareup.okhttp3:okhttp:5.0.0-alpha.12")
    implementation("com.squareup.okhttp3:logging-interceptor:5.0.0-alpha.12")
    //DI - Hilt
    implementation("com.google.dagger:hilt-android:2.50")
    implementation("androidx.hilt:hilt-navigation-compose:1.1.0")
    kapt("com.google.dagger:hilt-compiler:2.50")
    kapt("androidx.hilt:hilt-compiler:1.1.0")
    // Room
    implementation("androidx.room:room-ktx:2.6.1")
    implementation("androidx.room:room-runtime:2.6.1")
    ksp("androidx.room:room-compiler:2.5.0")

}

kapt {
    useBuildCache = false
    correctErrorTypes = true
}



