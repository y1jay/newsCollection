plugins {
	java
	id("org.springframework.boot") version "3.5.4"
	id("io.spring.dependency-management") version "1.1.7"
}

group = "com.news"
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
//	implementation("org.springframework.boot:spring-boot-starter-security")
	implementation("org.mybatis.spring.boot:mybatis-spring-boot-starter:3.0.5")
	implementation ("com.querydsl:querydsl-apt:5.0.0:jakarta")
	implementation ("org.mybatis.spring.boot:mybatis-spring-boot-starter:3.0.3")
	compileOnly("org.projectlombok:lombok")
	runtimeOnly("com.mysql:mysql-connector-j")
	annotationProcessor("org.projectlombok:lombok")
//	annotationProcessor ("com.querydsl:querydsl-apt:${dependencyManagement.importedProperties['querydsl.version']}:jakarta")
	//Jakarta 설정 어노테이션에 사용된다.
	annotationProcessor ("jakarta.annotation:jakarta.annotation-api")
	annotationProcessor ("jakarta.persistence:jakarta.persistence-api")
	implementation ("org.springframework.boot:spring-boot-starter-web")
	testImplementation("org.springframework.boot:spring-boot-starter-test")
	testImplementation("org.mybatis.spring.boot:mybatis-spring-boot-starter-test:3.0.5")
	testImplementation("org.springframework.security:spring-security-test")
	testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

tasks.withType<Test> {
	useJUnitPlatform()
}
