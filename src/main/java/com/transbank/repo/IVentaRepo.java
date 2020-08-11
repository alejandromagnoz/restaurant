package com.transbank.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.transbank.model.Venta;

@Repository
public interface IVentaRepo extends JpaRepository<Venta, Long> {

}
