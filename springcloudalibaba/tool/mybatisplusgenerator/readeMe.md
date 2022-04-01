

启动报错

```sell
org.springframework.context.ApplicationContextException: Failed to start bean 'documentationPluginsBootstrapper'; nested exception is java.lang.NullPointerException
```



在网上看到解决方案：

​		因为Springfox使用的路径匹配是基于AntPathMatcher的，而Spring Boot 2.6.X使用的是PathPatternMatcher。

​		解决办法，修改application.yaml

```text
spring:
  mvc:
    pathmatch:
      matching-strategy: ant_path_matcher
```

 于是修改

```properties
spring.mvc.pathmatch.matching-strategy= ant_path_matcher
```



![image-20220330145830952](https://raw.githubusercontent.com/waper97/Pic-Go/main/img/image-20220330145830952.png)

就ok了