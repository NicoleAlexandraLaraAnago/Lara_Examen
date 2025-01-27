package com.microservicioMuseo.Repository;

import com.microservicioMuseo.Model.Museo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MuseoRepository extends JpaRepository<Museo, Long> {
}