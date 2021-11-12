plugins {
    id("java-library")
    id("kotlin")
}

java {
    sourceCompatibility = JavaVersion.VERSION_1_7
    targetCompatibility = JavaVersion.VERSION_1_7
}

dependencies {
    implementation(project(":domain"))

    val coroutines = findProperty("version.kotlinx.coroutines")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:$coroutines")
}