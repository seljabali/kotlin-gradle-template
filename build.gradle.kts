import org.jetbrains.kotlin.gradle.dsl.JvmDefaultMode.NO_COMPATIBILITY

plugins {
    alias(libs.plugins.kotlin)
}
val javaVersion: Int = libs.versions.java.get().toInt()

group = "org.eljabali.sami"
version = "0.0.1"

repositories {
    mavenCentral()
    maven { url = uri("https://repo1.maven.org/maven2") }
}

dependencies {
    implementation(libs.kotlin.stdlib)
    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(javaVersion)
    compilerOptions {
        allWarningsAsErrors.set(false)

        jvmDefault = NO_COMPATIBILITY

        progressiveMode.set(true)

        freeCompilerArgs.addAll(
            "-Xjsr305=strict",
            "-Xannotation-default-target=param-property",
            "-Xcontext-sensitive-resolution",
            "-Xtype-enhancement-improvements-strict-mode",
            "-Xjvm-default=all",
        )
        optIn.addAll(
            "kotlin.ExperimentalStdlibApi",
            "kotlin.io.encoding.ExperimentalEncodingApi",
            "kotlin.RequiresOptIn",
            "kotlin.time.ExperimentalTime",
            "kotlinx.coroutines.ExperimentalCoroutinesApi",
            "kotlinx.coroutines.FlowPreview",
            "kotlinx.serialization.ExperimentalSerializationApi"
        )
    }
}
