package com.vijac.kafkatester.service;

import com.vijac.kafkatester.model.KafkaMessage;
import com.vijac.kafkatester.repository.KafkaMessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import java.util.UUID;
import java.util.logging.Logger;

@Component
public class AppStartUp implements ApplicationListener<ContextRefreshedEvent> {

    private static final Logger LOG = Logger.getLogger(AppStartUp.class.getSimpleName());

    private static int counter = 10;
    private static boolean enableMessageSender = true;

    @Autowired
    KafkaTemplate<String, KafkaMessage> kTemplate;

    @Autowired
    KafkaMessageRepository kRepository;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {

        LOG.warning("Running on start code");

        if (enableMessageSender) {

            for (int i = 0; i < counter; i++) {

                LOG.warning("iteration : " + i);

                KafkaMessage msg = new KafkaMessage();
                msg.setMessage(UUID.randomUUID().toString());

                kRepository.save(msg);
                LOG.warning("Sending KafkaMessage : " + msg);
                LOG.warning("Sending to Partition : " + msg.getPartitionSetBySender());

                kTemplate.send("kafka-tester", msg.getPartitionSetBySender(), UUID.randomUUID().toString(), msg);

            }
        }
    }
}