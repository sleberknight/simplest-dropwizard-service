package com.acme.simple.config;

import io.dropwizard.core.Configuration;

public class AppConfiguration extends Configuration {

    private String greeting = "Hello";

    public String getGreeting() {
        return greeting;
    }

    public void setGreeting(String greeting) {
        this.greeting = greeting;
    }
}
