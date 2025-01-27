package com.microservicioMuseo.Repository;

import com.microservicioMuseo.Model.Curador;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CuradorRepository extends JpaRepository<Curador, Long> {
}