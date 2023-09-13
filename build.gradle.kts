import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("org.springframework.boot") version "3.1.2"
    id("io.spring.dependency-management") version "1.1.2"
    id("org.jetbrains.kotlin.jvm") version "1.8.22"
    id("org.jetbrains.kotlin.plugin.spring") version "1.8.22"
    kotlin("kapt") version "1.8.21"
}

group = "com.rocket-solutions"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_17

repositories {
    mavenCentral()
    mavenLocal()
}

dependencies {
    // implementation 'de.tschuehly:spring-view-component-jte:0.6.0'
    /*implementation 'io.projectreactor:reactor-core:3.5.8'
    implementation 'org.jsoup:jsoup:1.16.1'
    implementation 'org.aspectj:aspectjrt:1.9.19'
    implementation fileTree('/Users/felixeckhardt/dev/kotlin/spring-view-component/jars')

    implementation 'org.springframework.boot:spring-boot-starter'
    implementation 'org.springframework.boot:spring-boot-starter-web'
    implementation 'org.springframework.boot:spring-boot-devtools'

    implementation 'com.fasterxml.jackson.module:jackson-module-kotlin'

    implementation 'org.webjars:bootstrap:5.3.1'
    implementation 'org.webjars.npm:htmx.org:1.9.4'
    implementation 'org.webjars:webjars-locator-core:0.53'

    implementation 'gg.jte:jte-kotlin:3.0.1'
    implementation 'gg.jte:jte-spring-boot-starter-3:3.1.0'

    implementation 'org.jetbrains.kotlin:kotlin-reflect'
    developmentOnly 'org.springframework.boot:spring-boot-devtools'
    testImplementation 'org.springframework.boot:spring-boot-starter-test'*/

    implementation("de.tschuehly:spring-view-component-jte:0.7.0-SNAPSHOT")
    kapt("de.tschuehly:spring-view-component-core:0.7.0-SNAPSHOT")

    implementation("org.webjars:bootstrap:5.3.1")
    implementation("org.webjars.npm:htmx.org:1.9.4")
    implementation("org.webjars:webjars-locator:0.47")

    implementation("org.springframework.boot:spring-boot-starter")
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-starter-actuator")
    implementation("org.springframework.boot:spring-boot-devtools")

    implementation("org.jetbrains.kotlin:kotlin-reflect")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs = listOf("-Xjsr305=strict")
        jvmTarget = "17"
    }
}

sourceSets.main.get().java.srcDir("build/generated-sources/jte")
