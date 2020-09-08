package springbootlearn.springbootredis.listener;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class FanoutReceiver {

    @RabbitHandler
    @RabbitListener(queues = "fanout.A")
    public void processA(Map testMessage){
        System.out.println("FanoutReceiverA消费者收到消息  : " +testMessage.toString());

    }

    @RabbitHandler
    @RabbitListener(queues = "fanout.B")
    public void processB(Map testMessage){
        System.out.println("FanoutReceiverB消费者收到消息  : " +testMessage.toString());

    }

    @RabbitHandler
    @RabbitListener(queues = "fanout.C")
    public void processC(Map testMessage){
        System.out.println("FanoutReceiverC消费者收到消息  : " +testMessage.toString());

    }
}
