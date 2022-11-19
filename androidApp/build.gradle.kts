plugins {
    id("com.android.application")
    kotlin("android")
    id("kotlin-kapt")
    id("com.google.devtools.ksp").version("1.7.0-1.0.6").apply(true)
    id("com.google.dagger.hilt.android").version("2.44").apply(false)
}

android {
    namespace = "me.naingaungluu.kmmdevfest2022.android"
    compileSdk = 32
    defaultConfig {
        applicationId = "me.naingaungluu.kmmdevfest2022.android"
        minSdk = 24
        targetSdk = 32
        versionCode = 1
        versionName = "1.0"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.3.0"
    }
    packagingOptions {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }
    applicationVariants.all {
        kotlin.sourceSets {
            getByName(name) {
                kotlin.srcDir("build/generated/ksp/$name/kotlin")
            }
        }
    }
}

dependencies {
    implementation(project(":shared"))
    implementation("androidx.compose.ui:ui:1.2.1")
    implementation("androidx.compose.ui:ui-tooling:1.2.1")
    implementation("androidx.compose.ui:ui-tooling-preview:1.2.1")
    implementation("androidx.compose.foundation:foundation:1.2.1")
    implementation("androidx.compose.material:material:1.2.1")
    implementation("androidx.activity:activity-compose:1.5.1")

    // coil Image
    implementation("io.coil-kt:coil-compose:2.2.2")

    // Compose Destinations
    implementation("io.github.raamcosta.compose-destinations:core:1.6.27-beta")
    ksp("io.github.raamcosta.compose-destinations:ksp:1.6.27-beta")
}
