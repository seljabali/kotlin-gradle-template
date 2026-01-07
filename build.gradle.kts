plugins {
    alias(libs.plugins.kotlin)
}
val jvmVersion = 25

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
    jvmToolchain(jvmVersion)
}
