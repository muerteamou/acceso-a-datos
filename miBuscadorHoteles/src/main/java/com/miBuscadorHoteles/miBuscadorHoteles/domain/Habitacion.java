package com.miBuscadorHoteles.miBuscadorHoteles.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Habitacion {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column
	private int numero;
	@Column
	private String tamanyo;
	@Column
	private int personas;
	@Column
	private float precio;
	@Column
	private Boolean desayuno;
	@Column
	private Boolean ocupada;

}
