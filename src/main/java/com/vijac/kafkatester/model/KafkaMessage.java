package com.vijac.kafkatester.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Random;

@Entity
public class KafkaMessage {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank
    @Size(max = 40)
    private String message;

    @NotNull
    private boolean delivered = false;

    private int partitionSetBySender = new Random().nextInt(3);

    private int partitionSetByReceiver;

    public KafkaMessage() {
    }

    public KafkaMessage(Long id, @NotBlank @Size(max = 40) String message, @NotBlank boolean delivered) {
        this.id = id;
        this.message = message;
        this.delivered = delivered;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isDelivered() {
        return delivered;
    }

    public void setDelivered(boolean delivered) {
        this.delivered = delivered;
    }

    public int getPartitionSetBySender() {
        return partitionSetBySender;
    }

    public void setPartitionSetBySender(int partitionSetBySender) {
        this.partitionSetBySender = partitionSetBySender;
    }

    public int getPartitionSetByReceiver() {
        return partitionSetByReceiver;
    }

    public void setPartitionSetByReceiver(int partitionSetByReceiver) {
        this.partitionSetByReceiver = partitionSetByReceiver;
    }

    @Override
    public String toString() {
        return "KafkaMessage{" +
                "id=" + id +
                ", message='" + message + '\'' +
                ", delivered=" + delivered +
                ", partitionSetBySender=" + partitionSetBySender +
                ", partitionSetByReceiver=" + partitionSetByReceiver +
                '}';
    }
}
