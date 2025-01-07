plugins {
    alias(libs.plugins.kotlin.jvm)
    `java-library`
}

repositories {
    mavenCentral()
}

dependencies {
    testImplementation("org.jetbrains.kotlin:kotlin-test-junit5")

    testImplementation(libs.junit.jupiter.engine)

    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

version = "1.0.0"

java {
    withSourcesJar()
}

tasks.named<Test>("test") {
    useJUnitPlatform()
}
