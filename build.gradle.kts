plugins {
    java
    id("org.springframework.boot") version "3.3.3"
    id("io.spring.dependency-management") version "1.1.6"
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

    dependencies {
        implementation("com.google.code.gson:gson:$gsonVersion")
        implementation("org.projectlombok:lombok")
        implementation("org.springframework.boot:spring-boot-starter-test")
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

    tasks.withType<Test> {
        useJUnitPlatform()
    }
}
