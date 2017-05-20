# Sever Push with Servlet 4.0 on Glassfish 5.0-b06

**Servlet 4.0** has a feature for HTTP/2. One of HTTP/2 features is **Server Push** which can send response proacyively from sever-side between one request and response with same TCP connection.

## Description
Servlet 4.0 implements **Server Push** as API. This java project shows how to use Server Push with Servlet 4.0.
Sevelt 4.0 Specification is shown is [JSR 369](https://www.jcp.org/en/jsr/detail?id=369).

## Demo

## Features

- push web resources from server to client
  - server applications are able to send contents at the beginning of the initial requests, instead of waiting for clients' request

## Requirement
- servlet 4.0
  - javax.servlet-api: 4.0.0-b05
- Glassfish 5.0 - b05
  - [glassfish-5.0-b06.zip](http://download.oracle.com/glassfish/5.0/promoted/glassfish-5.0-b06.zip)

## Usage
```java
PushBuilder pushBuilder = request.newPushBuilder();
pushBuilder
        .path("bootstrap/css/bootstrap.min.css")
        .push();
```

1. ***newPushBuilder***: Generate **PushBuilder** from HTTPServletRequest
2. ***path(String)***: Add target resource for server push to PushBuilder
3. ***push()***: push to client

## Installation
```xml
<dependency>
    <groupId>javax.servlet</groupId>
    <artifactId>javax.servlet-api</artifactId>
    <version>4.0.0-b05</version>
    <scope>provided</scope>
</dependency>
```

## Licence
Released under the [MIT license](https://gist.githubusercontent.com/shinyay/56e54ee4c0e22db8211e05e70a63247e/raw/44f0f4de510b4f2b918fad3c91e0845104092bff/LICENSE)

## Author

[shinyay](https://github.com/shinyay)
