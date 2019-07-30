package com.vijac.kafkatester.repository;

import com.vijac.kafkatester.model.KafkaMessage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface KafkaMessageRepository extends JpaRepository<KafkaMessage, Long> {

}
