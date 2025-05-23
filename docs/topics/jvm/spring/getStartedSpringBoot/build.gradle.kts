plugins {
	kotlin("jvm") version "1.9.25"	// kotlin version / use | project
	kotlin("plugin.spring") version "1.9.25" // Kotlin Spring compiler
	// -- ad `open` | Kotlin classes -- Reason: make them -- compatible with -- Spring Framework features--

	id("org.springframework.boot") version "3.3.3"
	id("io.spring.dependency-management") version "1.1.6"
}

group = "com.example"
version = "0.0.1-SNAPSHOT"

java {
	toolchain {
		languageVersion = JavaLanguageVersion.of(17)
	}
}

repositories {
	mavenCentral()
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-data-jdbc")
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("com.fasterxml.jackson.module:jackson-module-kotlin") // serialize & deserialize Kotlin classes & data classes
	implementation("org.jetbrains.kotlin:kotlin-reflect")
	runtimeOnly("com.h2database:h2")
	testImplementation("org.springframework.boot:spring-boot-starter-test")
	testImplementation("org.jetbrains.kotlin:kotlin-test-junit5")
	testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

kotlin {
	compilerOptions {
		freeCompilerArgs.addAll("-Xjsr305=strict")
		// add extra arguments -- to the -- compiler
	}
}

tasks.withType<Test> {
	useJUnitPlatform()
}
