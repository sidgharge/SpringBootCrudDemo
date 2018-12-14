# Actuator API Details

For detailed information, please read [Actuator docs](https://docs.spring.io/spring-boot/docs/current/actuator-api/html/).


## Getting started

To use actuator in the project add the following dependency:

```
	<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-actuator</artifactId>
	</dependency>
```

To expose the actuator apis add the following property with comma separated values(endpoints) in the application.properties file:

```
	management.endpoints.web.exposure.include=health,info
```

To expose all of the enabled apis use *

```
	management.endpoints.web.exposure.include=*
```

By default all of the endpoints are enabled, except shutdown.
To enable shutdown api use the following property:

```
	management.endpoint.shutdown.enabled=true
```
