plugins {
    kotlin("jvm") version "2.2.20"
    id("com.github.johnrengelman.shadow") version "8.1.1"
}

group = "lgbt.faith"
version = "1.0.1"

repositories {
    mavenCentral()
}
dependencies {
    testImplementation(kotlin("test"))
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.9.0")
}
tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(17)
}
tasks.withType<com.github.jengelman.gradle.plugins.shadow.tasks.ShadowJar> {
    archiveBaseName.set("HighCryingFinder")
    archiveVersion.set("")
    manifest {
        attributes(
            "Main-Class" to "lgbt.faith.MainKt"
        )
    }
}
tasks.build {
    dependsOn(tasks.shadowJar)
}