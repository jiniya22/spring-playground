import com.diffplug.gradle.spotless.SpotlessExtension

plugins {
    java
    id("org.springframework.boot")
    id("io.spring.dependency-management")
    id("com.diffplug.spotless")
}

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(22)
    }
}

allprojects {
    val projectGroup: String by project
    val projectVersion: String by project

    group = projectGroup
    version = projectVersion

    repositories {
        mavenCentral()
    }
}

subprojects {
    val gsonVersion: String by project
    val spotlessVersion: String by project

    plugins.apply {
        apply("java")
        apply("org.springframework.boot")
        apply("io.spring.dependency-management")
        apply("com.diffplug.spotless")
    }

    dependencies {
        implementation("com.google.code.gson:gson:$gsonVersion")
        implementation("org.projectlombok:lombok")
        implementation("org.springframework.boot:spring-boot-starter-test")
        implementation("com.diffplug.spotless:spotless-plugin-gradle:$spotlessVersion")
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

    tasks.withType<ProcessResources> {
        filesMatching("application.yml") {
            expand(project.properties)
        }
    }
}
