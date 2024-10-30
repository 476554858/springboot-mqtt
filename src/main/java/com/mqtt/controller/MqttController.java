package com.mqtt.controller;

import com.mqtt.message.MqttMessageProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/mqtt")
public class MqttController {

    @Autowired
    private MqttMessageProducer mqttMessageProducer;


    @GetMapping("/send/msg")
    public Object sendMsg(String topic, String msg) {
        mqttMessageProducer.sendToMqtt(msg, topic);
        return "ok";
    }

}
