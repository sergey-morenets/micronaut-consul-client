package com.example.config;

import io.micronaut.context.annotation.BootstrapContextCompatible;
import io.micronaut.context.annotation.Replaces;
import io.micronaut.context.annotation.Requires;
import io.micronaut.context.env.Environment;
import io.micronaut.discovery.consul.ConsulConfiguration;
import io.micronaut.discovery.consul.client.v1.AbstractConsulClient;
import io.micronaut.discovery.consul.client.v1.ConsulClient;
import io.micronaut.discovery.consul.config.ConsulConfigurationClient;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.retry.annotation.Retryable;

import javax.inject.Singleton;

@Singleton
@Requires(beans = ConsulClient.class)
@BootstrapContextCompatible
@Replaces(ConsulConfigurationClient.class)
@Retryable(attempts = "5", delay = "2s", multiplier = "2")
class CustomConsulConfigurationClient extends ConsulConfigurationClient {

    public CustomConsulConfigurationClient(ConsulClient consulClient, ConsulConfiguration consulConfiguration, Environment environment) {
        super(consulClient, consulConfiguration, environment);
    }
}