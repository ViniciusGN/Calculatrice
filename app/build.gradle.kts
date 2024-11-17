plugins {
    alias(libs.plugins.android.application)
}

android {
    namespace = "com.example.da_calculator"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.da_calculator"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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
    buildFeatures{
        viewBinding = true
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}

dependencies {

    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.activity)
    implementation(libs.constraintlayout)
    implementation(libs.navigation.fragment)
    implementation(libs.navigation.ui)
    testImplementation(libs.junit)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)

    implementation(libs.exp4j)

    // RxJava
    implementation("io.reactivex.rxjava2:rxandroid:2.1.1")
    implementation("io.reactivex.rxjava2:rxjava:2.2.21")

    //Retrofit
    implementation("com.squareup.retrofit2:adapter-rxjava:2.9.0")
    implementation("com.squareup.retrofit2:converter-simplexml:2.3.0")

    //Picasso
    implementation("com.squareup.picasso:picasso:2.71828")

    //Shimer effect
    implementation("com.facebook.shimmer:shimmer:0.5.0")
    implementation("com.github.omtodkar:ShimmerRecyclerView:v0.4.1")
}