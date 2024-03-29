// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    id("com.android.application") version "8.1.1" apply false
    id("org.jetbrains.kotlin.android") version "1.9.10" apply false
    // STEP 1: Apply the Kotlin JVM (or Kotlin Android plugin)
    id ("org.jetbrains.kotlin.jvm") version "1.9.0"
    // STEP 2: Apply the KSP plugin
    id ("com.google.devtools.ksp") version "1.9.0-1.0.12"
}