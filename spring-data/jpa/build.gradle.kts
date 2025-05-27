val mysqlConnectorVersion: String by project
val mapStructVersion = "1.6.3"

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("org.mapstruct:mapstruct:$mapStructVersion")
    annotationProcessor("org.mapstruct:mapstruct-processor:$mapStructVersion")
    runtimeOnly("com.mysql:mysql-connector-j:$mysqlConnectorVersion")
}

tasks.bootJar {
    archiveFileName.set("spring-data-common.jar")
    manifest {
        attributes["Implementation-Title"] =  "spring data commons by jini"
        attributes["Implementation-Version"] = version
    }
}