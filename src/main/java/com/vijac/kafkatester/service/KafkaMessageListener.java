package com.vijac.kafkatester.service;

import com.vijac.kafkatester.model.KafkaMessage;
import com.vijac.kafkatester.repository.KafkaMessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Component
public class KafkaMessageListener {

    private static final Logger LOG = Logger.getLogger(KafkaMessageListener.class.getSimpleName());

    @Autowired
    KafkaMessageRepository kRepository;


    @KafkaListener(topicPartitions = {@TopicPartition(topic = "kafka-tester", partitions = {"0"})})
    public void onMessagePartitionMessage0(@Payload KafkaMessage message) {

        LOG.warning("Received in partition 0 method :" + message);

        message.setPartitionSetByReceiver(0);
        message.setDelivered(true);
        kRepository.save(message);

    }


    @KafkaListener(topicPartitions = {@TopicPartition(topic = "kafka-tester", partitions = {"1"})})
    public void onMessagePartitionMessage1(@Payload KafkaMessage message) {

        LOG.warning("Received in partition 1 method :" + message);

        message.setPartitionSetByReceiver(1);
        message.setDelivered(true);
        kRepository.save(message);

    }

    @KafkaListener(topicPartitions = {@TopicPartition(topic = "kafka-tester", partitions = {"2"})})
    public void onMessagePartitionMessage2(@Payload KafkaMessage message) {

        LOG.warning("Received in partition 2 method :" + message);

        message.setPartitionSetByReceiver(2);
        message.setDelivered(true);
        kRepository.save(message);
    }

}
