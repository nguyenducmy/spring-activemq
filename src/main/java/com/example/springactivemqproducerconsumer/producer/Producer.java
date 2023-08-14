package com.example.springactivemqproducerconsumer.producer;

import com.example.springactivemqproducerconsumer.dto.Student;
import com.fasterxml.jackson.databind.ObjectMapper;


import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/produce")
public class Producer {

	@Autowired
	private JmsTemplate jmsTemplate;

	@Autowired
	private ActiveMQQueue queue;

	@PostMapping("/message")
	public Student sendMessage(@RequestBody Student student) {

		try {
			ObjectMapper mapper = new ObjectMapper();
			String studentAsJson = mapper.writeValueAsString(student);

			jmsTemplate.convertAndSend(queue, studentAsJson);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return student;
	}
}
