rootProject.name = "spring-playground"
include(
    "spring-boot",
    "spring-data:common"
)

pluginManagement {
    val springBootVersion: String by settings
    val springDependencyManagementVersion: String by settings
    val spotlessVersion: String by settings
    plugins {
        java
        id("org.springframework.boot") version springBootVersion
        id("io.spring.dependency-management") version springDependencyManagementVersion
        id("com.diffplug.spotless") version spotlessVersion
    }
}
