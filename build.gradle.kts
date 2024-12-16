import com.diffplug.gradle.spotless.SpotlessExtension

plugins {
    java
    id("org.springframework.boot") version "3.4.0"
    id("io.spring.dependency-management") version "1.1.6"
    id("com.diffplug.spotless") version "7.0.0.BETA4"
}

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(22)
    }
}

var gsonVersion by extra { "2.11.0" }

allprojects {
    group = "me.jiniworld"
    version = "0.0.1"

    repositories {
        mavenCentral()
    }
}

subprojects {
    apply(plugin = "java")
    apply(plugin = "org.springframework.boot")
    apply(plugin = "io.spring.dependency-management")
    plugins.apply("com.diffplug.spotless")

    dependencies {
        implementation("com.google.code.gson:gson:$gsonVersion")
        implementation("org.projectlombok:lombok")
        implementation("org.springframework.boot:spring-boot-starter-test")
        implementation("com.diffplug.spotless:spotless-plugin-gradle:7.0.0.BETA4")
        annotationProcessor("org.projectlombok:lombok")
        annotationProcessor("org.springframework.boot:spring-boot-configuration-processor")
        testAnnotationProcessor("org.projectlombok:lombok")
        testImplementation("org.projectlombok:lombok")
        testImplementation("org.springframework.boot:spring-boot-starter-test")
        testRuntimeOnly("org.junit.platform:junit-platform-launcher")
        developmentOnly("org.springframework.boot:spring-boot-devtools")
    }

    dependencyManagement {
        imports {
            mavenBom(org.springframework.boot.gradle.plugin.SpringBootPlugin.BOM_COORDINATES)
        }
    }

    configure<SpotlessExtension> {
        java {
            target("**/*.java")
            targetExclude("**/Ttt*.java")
            indentWithTabs()
            indentWithSpaces(4)
            trimTrailingWhitespace()
            endWithNewline()
            removeUnusedImports()
        }
    }

    tasks.withType<Test> {
        useJUnitPlatform()
    }
}
