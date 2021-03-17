package com.cpiaoju;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.wf.jwtp.configuration.EnableJwtPermission;

@EnableJwtPermission
@SpringBootApplication
public class SystemWebApplication {
    public static void main(String[] args) {
        SpringApplication.run(SystemWebApplication.class, args);
    }
}
