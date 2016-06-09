package uk.co.bbc.micro;

import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.services.sqs.AmazonSQS;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import uk.co.bbc.ibrd.starter.aws.wormhole.WormholeCredentialsProvider;

/**
 * Created by walked51 on 09/06/2016.
 */
@Configuration
@EnableAutoConfiguration
public class Config {
    @Autowired
    AmazonSQS sqsClient;

    @Bean
    public AmazonSQS amazonSqs() {
        return sqsClient;
    }
}
