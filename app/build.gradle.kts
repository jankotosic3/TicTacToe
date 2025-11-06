plugins {
    id("java")
    kotlin("jvm")
    application
}
dependencies {
    implementation(project(":lib"))
}

application {
    mainClass.set( "org.jetbrains.kotlinx.tictactoe.Main")
}

java{
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(22))
    }
}
