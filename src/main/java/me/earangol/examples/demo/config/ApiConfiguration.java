package me.earangol.examples.demo.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * This file is subject to the terms and conditions defined in
 * file 'LICENSE.txt', which is part of this source code package.
 *
 * Created with IntelliJ IDEA.
 */
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {"me.earangol.examples.demo.controllers", "me.earangol.examples.demo.services"})
public class ApiConfiguration {

}
