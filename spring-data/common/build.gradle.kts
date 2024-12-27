val mysqlConnectorVersion: String by project

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    runtimeOnly("com.mysql:mysql-connector-j:$mysqlConnectorVersion")
}

tasks.bootJar {
    archiveFileName.set("spring-data-common.jar")
    manifest {
        attributes["Implementation-Title"] =  "spring data commons by jini"
        attributes["Implementation-Version"] = version
    }
}