dependencies {
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    runtimeOnly("com.mysql:mysql-connector-j:9.1.0")
}

tasks.bootJar {
    archiveFileName.set("spring-data-common.jar")
}