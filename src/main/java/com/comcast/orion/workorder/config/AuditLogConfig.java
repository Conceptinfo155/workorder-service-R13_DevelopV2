package com.comcast.orion.workorder.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

 /*This class is to enable the orion audit logs*/
  /*Configuration class to scan the logging package*/

@Configuration
@ComponentScan({ "com.comcast.orion.logging" })
public class AuditLogConfig {
 
}
