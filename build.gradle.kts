plugins {
	java
	id("org.springframework.boot") version "3.4.2"
	id("io.spring.dependency-management") version "1.1.7"
	id("org.flywaydb.flyway") version "11.3.2"
}

group = "com.example"
version = "0.0.1-SNAPSHOT"

java {
	toolchain {
		languageVersion = JavaLanguageVersion.of(17)
	}
}

configurations {
	compileOnly {
		extendsFrom(configurations.annotationProcessor.get())
	}
}

repositories {
	mavenCentral()
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-data-jpa")
	implementation("org.springframework.boot:spring-boot-starter-web")
	compileOnly("org.projectlombok:lombok")
	developmentOnly("org.springframework.boot:spring-boot-devtools")
	annotationProcessor("org.projectlombok:lombok")
	testImplementation("org.springframework.boot:spring-boot-starter-test")
	testRuntimeOnly("org.junit.platform:junit-platform-launcher")
	implementation("org.hibernate.orm:hibernate-core:6.4.2.Final")
	implementation("com.oracle.database.jdbc:ojdbc8:19.8.0.0")

	// Flyway untuk Oracle
	implementation("org.flywaydb:flyway-core:11.3.2")
	runtimeOnly("org.flywaydb:flyway-database-oracle:11.3.2")

	runtimeOnly("com.oracle.database.jdbc:ojdbc11")

	// Flyway untuk PostgreSQL
	// implementation("org.flywaydb:flyway-core:11.3.2")
	// runtimeOnly("org.flywaydb:flyway-database-postgresql:11.3.3")

	// runtimeOnly("org.postgresql:postgresql")
}

tasks.withType<Test> {
	useJUnitPlatform()
}