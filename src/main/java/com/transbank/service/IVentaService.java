package com.transbank.service;

import java.util.List;

import com.transbank.dto.VentasDTO;
import com.transbank.model.Venta;

public interface IVentaService{

	Venta registrar(Venta venta);
	
	List<Venta> buscarFecha(VentasDTO filtro);
}
