package com.microservicioCurador.Repository;

import com.microservicioCurador.Model.Museo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MuseoRepository extends JpaRepository<Museo, Long> {
}
