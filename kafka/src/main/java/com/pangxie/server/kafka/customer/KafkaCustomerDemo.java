package com.pangxie.server.kafka.customer;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

import java.util.Arrays;
import java.util.Properties;

/**
 * Create By fightingcrap On 2019/04/25
 * |  .--,       .--,
 * |( (  \.---./  ) )
 * | '.__/o   o\__.'
 * |    {=  ^  =}
 * |     >  -  <
 * |    /       \
 * |   //       \\
 * |  //|   .   |\\
 * |  "'\       /'"_.-~^`'-.
 * |     \  _  /--'         `
 * |   ___)( )(___
 * |  (((__) (__)))    程序镇压神兽，排查一切bug。
 * |
 * |
 * | KafkaCustomerDemo
 * |
 * | @author fightingcrap
 **/
public class KafkaCustomerDemo {

    public static void main(String[] args) {
        Properties properties = new Properties();
        properties.put("bootstrap.servers", "");
        properties.put("group.id", "test");
        properties.put("enable.auto.commit", "true");
        properties.put("enable.commit.interval.ms","1000");
        properties.put("session.timeout.ms", "30000");
        properties.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        properties.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        properties.put("max.poll.records", "1");
        KafkaConsumer<String, String> kafkaConsumer = new KafkaConsumer<String, String>(properties);
        //订阅topic
        kafkaConsumer.subscribe(Arrays.asList("test"));
        while (true) {
           ConsumerRecords<String, String> consumerRecord= kafkaConsumer.poll(1000);
           for(ConsumerRecord<String,String> consumerRecord1:consumerRecord){
               System.out.println(consumerRecord1.value());
           }
        }
    }
}
