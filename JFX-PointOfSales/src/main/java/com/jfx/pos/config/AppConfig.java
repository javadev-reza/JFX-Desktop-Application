package com.jfx.pos.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @author Reza
 */
@Configuration
@ComponentScan(basePackages={"com.jfx.pos.controller", "com.jfx.business.serviceimpl"})
public class AppConfig {}

