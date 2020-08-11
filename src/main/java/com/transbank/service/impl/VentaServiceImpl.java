package com.transbank.service.impl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.transbank.dto.VentasDTO;
import com.transbank.model.Venta;
import com.transbank.repo.IVentaRepo;
import com.transbank.service.IVentaService;

@Service
public class VentaServiceImpl implements IVentaService{

	@Autowired
	private IVentaRepo repo;

	@Override
	public Venta registrar(Venta venta)  {

		Venta ven = repo.save(venta);
		
		return venta;

	}
	
	@Override
	public List<Venta> buscarFecha(VentasDTO filtro) {
//		LocalDateTime fechaVenta = filtro.getFechaConsulta();
		//return repo.buscarFecha(filtro.getFechaConsulta(), fechaSgte);
		
		List<Venta> listaVentas = new ArrayList<>();
		return listaVentas;
	}

}
