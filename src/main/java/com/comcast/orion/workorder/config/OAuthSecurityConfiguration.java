package com.comcast.orion.workorder.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * OAuthSecurityConfiguration
 *
 */
/**
 * This class provides Security Configuration
 *
 */
@Configuration
@ComponentScan({"com.comcast.xsp.security.config","com.comcast.xsp.security","com.comcast.xsp.service.core"})
public class OAuthSecurityConfiguration {
}
