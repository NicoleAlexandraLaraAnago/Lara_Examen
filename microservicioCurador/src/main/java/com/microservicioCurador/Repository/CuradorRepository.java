package com.microservicioCurador.Repository;

import com.microservicioCurador.Model.Curador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CuradorRepository extends JpaRepository<Curador, Long> {
}