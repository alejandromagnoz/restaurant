package com.transbank.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;

import com.google.gson.Gson;
import com.transbank.dto.VentasDTO;
import com.transbank.model.Venta;
import com.transbank.service.IVentaService;

import io.swagger.annotations.ApiParam;
import io.swagger.annotations.Authorization;





@RestController
@RequestMapping("/ventas")
public class VentaController {
	
	@Autowired
	private IVentaService service;
	
	@Autowired
	JmsTemplate jmsTemplate;
	
	@PostMapping
	public ResponseEntity<Venta> registrar(
			@ApiParam(value = "Header de autorizacion", required = true) @RequestHeader (value = "authorizationHeader", required = true) String authorizationHeader,  
			@ApiParam(value = "Request Body de Venta", required = true) @Valid @RequestBody(required = true) Venta venta,
			@RequestHeader HttpHeaders headers) {
		Venta obj = service.registrar(venta);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getIdVenta()).toUri();
		return ResponseEntity.created(location).build();
	}
	

	@PostMapping("/listar-ventas")
	public ResponseEntity<VentasDTO> listar(
			@ApiParam(value = "Header de autorizacion", required = true) @RequestHeader (value = "authorizationHeader", required = true) String authorizationHeader){  
		
		String resultado = jmsTemplate.receiveAndConvert("listadoventas").toString();
		Gson gson = new Gson(); 
		List<Venta> listadoVentas = gson.fromJson(resultado,  List.class); 
		VentasDTO ventaDto = new VentasDTO();
		ventaDto.setListadoVentas(listadoVentas);
		return new ResponseEntity<VentasDTO>(ventaDto, HttpStatus.OK);
	}
	
	
	
}
