package com.acme.simple;

import com.acme.simple.config.AppConfiguration;
import io.dropwizard.core.Application;
import io.dropwizard.core.setup.Environment;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class App extends Application<AppConfiguration> {

    private static final Logger LOG = LoggerFactory.getLogger(App.class);

    public static void main(String[] args) throws Exception {
        new App().run(args);
    }

    @Override
    public void run(AppConfiguration configuration, Environment environment) {
        LOG.info("Hi, I don't do anything!");
    }
}
