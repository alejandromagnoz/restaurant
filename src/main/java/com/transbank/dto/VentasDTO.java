package com.transbank.dto;

import java.util.List;

import com.transbank.model.Venta;

public class VentasDTO {

	private List<Venta> listadoVentas;

	public List<Venta> getListadoVentas() {
		return listadoVentas;
	}

	public void setListadoVentas(List<Venta> listadoVentas) {
		this.listadoVentas = listadoVentas;
	}

}
