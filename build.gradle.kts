import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import org.jlleitschuh.gradle.ktlint.reporter.ReporterType

plugins {
    kotlin("jvm") version "1.4.10"
    id("org.jetbrains.dokka") version "1.4.10"
    id("org.jlleitschuh.gradle.ktlint") version "9.3.0"
    application
}
group = "me.myuser"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    jcenter()
}
dependencies {
    implementation("org.junit.jupiter:junit-jupiter:5.4.2")
    implementation("org.mariadb.jdbc:mariadb-java-client:2.1.2")
    testImplementation(kotlin("test-junit5"))
}
tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}
application {
    mainClassName = "MainKt"
}

tasks.test {
    useJUnitPlatform()
}
ktlint {
    verbose.set(true)
    outputToConsole.set(true)
    coloredOutput.set(true)
    // add for Arturo
    debug.set(false)
    android.set(false)
    outputColorName.set("RED")
    ignoreFailures.set(false)
    enableExperimentalRules.set(false)
    // End Add
    reporters {
        // reporter(ReporterType.CHECKSTYLE)
        // reporter(ReporterType.JSON)
        reporter(ReporterType.HTML)
    }
    // kotlinScriptAdditionalPaths {
    // include(fileTree("src"))
    // }
    filter {
        exclude("**/style-violations.kt")
        exclude("**/generated/**")
        include("**/kotlin/**")
    }
}
