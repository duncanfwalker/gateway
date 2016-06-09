package uk.co.bbc.micro.rabbit;

/**
 * Created by walked51 on 09/06/2016.
 */
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RabbitSender {

    private static final String EXCHANGE_NAME = "logs";
    ConnectionFactory factory;

    Channel channel;

    public RabbitSender( ) throws Exception {
        factory = new ConnectionFactory();
        factory.setHost("localhost");

    }

    public void send(String message ) throws Exception
    {
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();

        channel.exchangeDeclare(EXCHANGE_NAME, "fanout");

        channel.basicPublish(EXCHANGE_NAME, "", null, message.getBytes());
        System.out.println(" [x] Sent '" + message + "'");

        channel.close();
        connection.close();
    }
}
