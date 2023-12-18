# The simplest Dropwizard service
The simplest Dropwizard service you can have. 

It does absolutely nothing except start when using `config.yml`,
which defines a minimal logging configuration.

However, if you try to start with either `config-empty.yml` or
`config-only-yaml-marker.yml` the service _will not start_.
The reason is that they do not define _any_ configuration at
all.

### Using `config.yml`

```shell
$ mvn -q package
$ java -jar target/simplest-dropwizard-service-0.1.0-SNAPSHOT.jar server config.yml
...
...lots of initialization, elided here for brevity...
...
INFO  [2023-12-17 20:54:16,630] org.eclipse.jetty.server.AbstractConnector: Started application@30d25c03{HTTP/1.1, (http/1.1)}{0.0.0.0:8080}
INFO  [2023-12-17 20:54:16,631] org.eclipse.jetty.server.AbstractConnector: Started admin@7a1f8def{HTTP/1.1, (http/1.1)}{0.0.0.0:8081}
INFO  [2023-12-17 20:54:16,631] org.eclipse.jetty.server.Server: Started Server@756b58a7{STARTING}[11.0.18,sto=30000] @642ms
```

### Using `config-empty.yml`

```shell
$ mvn -q package
$ java -jar target/simplest-dropwizard-service-0.1.0-SNAPSHOT.jar server config-empty.yml
io.dropwizard.configuration.ConfigurationParsingException: config-empty.yml has an error:
  * Configuration at config-empty.yml must not be empty

	at io.dropwizard.configuration.ConfigurationParsingException$Builder.build(ConfigurationParsingException.java:278)
	at io.dropwizard.configuration.BaseConfigurationFactory.build(BaseConfigurationFactory.java:91)
	at io.dropwizard.core.cli.ConfiguredCommand.parseConfiguration(ConfiguredCommand.java:139)
	at io.dropwizard.core.cli.ConfiguredCommand.run(ConfiguredCommand.java:85)
	at io.dropwizard.core.cli.Cli.run(Cli.java:78)
	at io.dropwizard.core.Application.run(Application.java:94)
	at com.acme.simple.App.main(App.java:14)
```

### Using `config-only-yaml-marker.yml`

```shell
$ mvn -q package
$ java -jar target/simplest-dropwizard-service-0.1.0-SNAPSHOT.jar server config-only-yaml-marker.yml
java.lang.IllegalArgumentException: HV000116: The object to be validated must not be null.
	at org.hibernate.validator.internal.util.Contracts.assertNotNull(Contracts.java:44)
	at org.hibernate.validator.internal.engine.ValidatorImpl.validate(ValidatorImpl.java:151)
	at io.dropwizard.configuration.BaseConfigurationFactory.validate(BaseConfigurationFactory.java:270)
	at io.dropwizard.configuration.BaseConfigurationFactory.build(BaseConfigurationFactory.java:149)
	at io.dropwizard.configuration.BaseConfigurationFactory.build(BaseConfigurationFactory.java:94)
	at io.dropwizard.core.cli.ConfiguredCommand.parseConfiguration(ConfiguredCommand.java:139)
	at io.dropwizard.core.cli.ConfiguredCommand.run(ConfiguredCommand.java:85)
	at io.dropwizard.core.cli.Cli.run(Cli.java:78)
	at io.dropwizard.core.Application.run(Application.java:94)
	at com.acme.simple.App.main(App.java:14)
```

### Making it work

You can make it work using either `config-empty.yml` or `config-only-yaml-marker.yml`
by uncommenting the `greeting` in those files.

Then, the service will start up and log a greeting that starts with the value from
the configuration file.
