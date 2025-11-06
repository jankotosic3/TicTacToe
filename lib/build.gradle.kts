plugins {
    id("java")
    kotlin("jvm")
}

dependencies {
    implementation(libs.bundles.kotlinxEcosystem)
    testImplementation(kotlin("test"))
}

java{
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(22))
    }
}