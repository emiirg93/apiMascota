package com.api.mascotas.controller;

import com.api.mascotas.repository.MascotaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedHashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class MascotaController {
    @Autowired
    MascotaRepository mascotaRepository;

    @RequestMapping("/mascotas")
    public Map<String, Object> GetMascotas() {
        Map<String, Object> dto = new LinkedHashMap<String, Object>();

        dto.put("mascotas",mascotaRepository.findAll());

        return dto;
    }

    @RequestMapping("/mascota/{id}")
    public Map<String, Object> GetMascota(@PathVariable Long id) {
        Map<String, Object> dto = new LinkedHashMap<String, Object>();

        dto.put("mascota",mascotaRepository.findById(id).get());

        return dto;
    }

    @RequestMapping("/mascota/edit/{id}")
    public Map<String, Object> editMascota(@PathVariable Long id) {
        


    }
}
