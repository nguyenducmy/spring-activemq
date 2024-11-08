package com.example.springactivemqproducerconsumer.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data @AllArgsConstructor @NoArgsConstructor
public class Student implements Serializable {
	private static final long serialVersionUID = 1L;
	private String studentId;
	private String name;
	private String rollNumber;
}
