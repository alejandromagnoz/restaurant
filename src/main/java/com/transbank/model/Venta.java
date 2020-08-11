package com.transbank.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "venta")
public class Venta {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long idVenta;

	@Column(name = "codigo", nullable = false)
	private Integer codigo;
	
	@Column(name = "nombre", length = 40, nullable = false)
	private String nombre;

	@Column(name = "precio", nullable = false)
	private Integer precio;

	@Column(name = "cantidad", nullable = false)
	private Integer cantidad;
	
	@Column(name = "total", nullable = false)
	private Integer total;
	
	@Column(name = "fecventa", nullable = false)
	@Temporal(TemporalType.DATE)
	//@JsonFormat(pattern="dd-MM-yyyy HH:mm:ss")
	private Date fechaVenta;

	public Long getIdVenta() {
		return idVenta;
	}

	public void setIdVenta(Long idVenta) {
		this.idVenta = idVenta;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getPrecio() {
		return precio;
	}

	public void setPrecio(Integer precio) {
		this.precio = precio;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	public Integer getTotal() {
		return total;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}

	public Date getFechaVenta() {
		return fechaVenta;
	}

	public void setFechaVenta(Date fechaVenta) {
		this.fechaVenta = fechaVenta;
	}

}
