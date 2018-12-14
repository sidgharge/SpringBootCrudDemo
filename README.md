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

To Show detailed health information, use:

```
management.endpoint.health.show-details=always
```
Valid values are: always, never and when-authorized.
always: Details are shown to all users.
never: Details are never shown.
when-authorized: Details are only shown to authorized users. Authorized roles can be configured using  ``management.endpoint.health.roles``.

## APIS details

### Beans
The beans endpoint provides information about the application’s beans.

To retrieve the beans, make a GET request to /actuator/beans

```
$ curl 'http://localhost:8080/actuator/beans' -i -X GET
```

### Caches
The caches endpoint provides access to the application’s caches.

To retrieve the application’s caches, make a GET request to /actuator/caches

```
$ curl 'http://localhost:8080/actuator/caches' -i -X GET
```

### Conditions Evaluation Report
The conditions endpoint provides information about the evaluation of conditions on configuration and auto-configuration classes.

To retrieve the report, make a GET request to /actuator/conditions

```
$ curl 'http://localhost:8080/actuator/conditions' -i -X GET
```

### Configuration Properties
The configprops endpoint provides information about the application’s @ConfigurationProperties beans.

To retrieve the @ConfigurationProperties beans, make a GET request to /actuator/configprops

```
$ curl 'http://localhost:8080/actuator/configprops' -i -X GET
```

### Environment
The env endpoint provides information about the application’s Environment.

To retrieve the entire environment, make a GET request to /actuator/env

```
$ curl 'http://localhost:8080/actuator/env' -i -X GET
```

To retrieve a single property, make a GET request to /actuator/env/{property.name}
For example, to retrieve datasource url, use:

```
$ curl 'http://localhost:8080/actuator/env/actuator/env/spring.datasource.url' -i -X GET
```

### Health
The health endpoint provides detailed information about the health of the application.

To retrieve the health of the application, make a GET request to /actuator/health

```
$ curl 'http://localhost:8080/actuator/health' -i -X GET
```

To retrieve the health of a particular component of the application, make a GET request to /actuator/health/{component}
For example, to retrieve health of the database use:

```
$ curl 'http://localhost:8080/actuator/health/db' -i -X GET
```

### HTTP Trace
The httptrace endpoint provides information about last 100 HTTP request-response exchanges.

To retrieve the traces, make a GET request to /actuator/httptrace

```
$ curl 'http://localhost:8080/actuator/httptrace' -i -X GET
```

### Log File
The logfile endpoint provides access to the contents of the application’s log file.

To retrieve the log file, make a GET request to /actuator/logfile

```
$ curl 'http://localhost:8080/actuator/logfile' -i -X GET
```

To retrieve part of the log file, make a GET request to /actuator/logfile by using the Range header

```
$ curl 'http://localhost:8080/actuator/logfile' -i -X GET -H 'Range: bytes=0-1023'
```

### Loggers
The loggers endpoint provides access to the application’s loggers and the configuration of their levels.

To retrieve the application’s loggers, make a GET request to /actuator/loggers

```
$ curl 'http://localhost:8080/actuator/loggers' -i -X GET
```

To retrieve a single logger, make a GET request to /actuator/loggers/{logger.name}
For example, to get logging level of `com.example` package use:

```
$ curl 'http://localhost:8080/actuator/loggers/com.example' -i -X GET
```

To set the level of a logger, make a POST request to /actuator/loggers/{logger.name} with a JSON body that specifies the configured level for the logger

```
$ curl 'http://localhost:8080/actuator/loggers/com.example' -i -X POST -H 'Content-Type: application/json' -d '{"configuredLevel":"debug"}'
```

This sets logging level of `com.example` package to debug.

To clear the level of a logger, make a POST request to /actuator/loggers/{logger.name} with a JSON body containing an empty object

```
$ curl 'http://localhost:8080/actuator/loggers/com.example' -i -X POST -H 'Content-Type: application/json' -d '{}'
```
This clears the logging level of `com.example` package.


### Mappings
The mappings endpoint provides information about the application’s request mappings.

To retrieve the mappings, make a GET request to /actuator/mappings

```
$ curl 'http://localhost:33632/actuator/mappings' -i -X GET
```

### Metrics
The metrics endpoint provides access to application metrics.

To retrieve the names of the available metrics, make a GET request to /actuator/metrics

```
$ curl 'http://localhost:8080/actuator/metrics' -i -X GET
```

To retrieve a metric, make a GET request to /actuator/metrics/{metric.name}
For example, to retrieve total number of requests to tomcat, use:

```
http://localhost:8080/actuator/metrics/tomcat.global.request
```

### Scheduled Tasks
The scheduledtasks endpoint provides information about the application’s scheduled tasks.

To retrieve the scheduled tasks, make a GET request to /actuator/scheduledtasks

```
$ curl 'http://localhost:8080/actuator/scheduledtasks' -i -X GET
```

### Shutdown
The shutdown endpoint is used to shut down the application.

To shut down the application, make a POST request to /actuator/shutdown

```
$ curl 'http://localhost:8080/actuator/shutdown' -i -X POST
```

### Thread Dump
The threaddump endpoint provides a thread dump from the application’s JVM.

To retrieve the thread dump, make a GET request to /actuator/threaddump

```
$ curl 'http://localhost:8080/actuator/threaddump' -i -X GET
```
