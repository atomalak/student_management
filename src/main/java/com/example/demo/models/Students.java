package com.example.demo.models;

import java.io.Serializable;
import java.time.LocalDate;

import javax.validation.constraints.Future;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

import org.mockito.NotExtensible;

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
	
	@NotNull(message="Öğrencinin Ismi Dolu Olmalı")
	@NotBlank(message="Öğrencinin Ismi Dolu Olmalı")
	private String name;


	@NotNull(message="Öğrencinin Soyadı Dolu Olmalı")
	@NotBlank(message="Öğrencinin Soyadı Dolu Olmalı")
	private String surname;
	
	@Past
	@JsonFormat(pattern="dd/MM/yyyy")
	private LocalDate birthDay;
	
	@NotNull(message="Şifre Dolu Olmalı")
	@NotBlank(message="Şifre Dolu Olmalı")
	@JsonIgnore
	private String password;
	

}
