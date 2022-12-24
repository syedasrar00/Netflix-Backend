package com.netflix.backend.configurations;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
import software.amazon.awssdk.auth.credentials.AwsCredentialsProvider;
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;

@Configuration
public class AwsConfiguration {
    @Value("${gpt.accesskey}")
    private String accessKey;
    @Value("${gpt.secretkey}")
    private String secretKey;

    @Bean
    public AwsCredentialsProvider getAwsCredentialProvider(){
        return StaticCredentialsProvider.create(AwsBasicCredentials.create(accessKey,secretKey));
    }
}
