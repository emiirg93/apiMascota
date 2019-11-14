package com.api.mascotas.repository;

import com.api.mascotas.model.Mascota;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface MascotaRepository extends JpaRepository<Mascota,Long> {
}
