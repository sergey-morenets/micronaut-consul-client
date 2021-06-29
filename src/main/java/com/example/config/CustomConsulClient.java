package com.example.config;

import io.micronaut.context.annotation.BootstrapContextCompatible;
import io.micronaut.context.annotation.Replaces;
import io.micronaut.context.annotation.Requires;
import io.micronaut.discovery.consul.ConsulConfiguration;
import io.micronaut.discovery.consul.client.v1.AbstractConsulClient;
import io.micronaut.discovery.consul.client.v1.ConsulClient;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.retry.annotation.Retryable;

@Client(id = ConsulClient.SERVICE_ID, path = "/v1", configuration = ConsulConfiguration.class)
@Requires(beans = ConsulConfiguration.class)
@BootstrapContextCompatible
@Replaces(AbstractConsulClient.class)
@Retryable(attempts = "5", delay = "2s", multiplier = "2")
abstract class CustomConsulClient extends AbstractConsulClient {

}