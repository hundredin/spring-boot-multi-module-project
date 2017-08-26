# Spring Boot Boilerplate

## Freameworks
- Spring Framework
- Spring Boot
- Spring Data JPA(Hibernate)
- QueryDSL(cf. JPQL, Criteria API)

## Test
- [dbunit](https://springtestdbunit.github.io/spring-test-dbunit/)
- [assertj](http://joel-costigliola.github.io/assertj/)

## Modules
 - rest-api (dependent on `common-core`)
 - admin (dependent on `common-core`)
 - common-core
 

## Other Settings 
- Application 구동시 aspectj loadtime weaving을 위해 javaagent 지정 필요
- e.g) -javaagent:"${settings.localRepository}/lib/spring-instrument-${spring.version}.jar" -javaagent:"${settings.localRepository}/lib/aspectjweaver-${aspectjweaver.version}.jar"
- IntelliJ의 source path에 target/generated-sources/java 추가
  
