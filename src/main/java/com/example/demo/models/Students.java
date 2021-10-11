package com.example.demo.models;

import java.io.Serializable;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Students implements Serializable{

	private static final long serialVersionUID = 8298575577308571019L;
	private int id;
	private String name;
	private String surname;
	@JsonFormat(pattern="dd/MM/yyyy")
	private LocalDateTime birthDay;
	
	@JsonIgnore
	private String password;
	

}
