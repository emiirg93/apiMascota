package com.api.mascotas.controller;

import com.api.mascotas.model.Mascota;
import com.api.mascotas.repository.MascotaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class MascotaController {
    @Autowired
    MascotaRepository mascotaRepository;

    @RequestMapping("/mascotas")
    public Map<String, Object> GetMascotas() {
        Map<String, Object> dto = new LinkedHashMap<String, Object>();

        dto.put("mascotas", mascotaRepository.findAll());

        return dto;
    }

    @RequestMapping("/mascota/{id}")
    public Map<String, Object> GetMascota(@PathVariable Long id) {
        Map<String, Object> dto = new LinkedHashMap<String, Object>();

        dto.put("mascota", mascotaRepository.findById(id).get());

        return dto;
    }

    @RequestMapping(path = "/mascota/edit", method = RequestMethod.PUT)
    public ResponseEntity<Map<String, Object>> editMascota(@RequestBody Mascota mascota) {

        Mascota m = mascotaRepository.findById(mascota.getId()).get();

        mascotaRepository.save(mascota);
        return new ResponseEntity<>(makeMap("OK", "modificacion exitosa", "mascota", mascota), HttpStatus.OK);
    }

    @RequestMapping(path = "/mascota/add", method = RequestMethod.POST)
    public ResponseEntity<Map<String, Object>> addMascota(@RequestBody Mascota mascota) {

        mascotaRepository.save(mascota);
        return new ResponseEntity<>(makeMap("OK", "creacion exitosa", "mascota", mascota), HttpStatus.CREATED);

    }

    @RequestMapping(path = "/mascota/delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Map<String, Object>> deleteMascota(@PathVariable Long id) {

        Mascota m = mascotaRepository.findById(id).get();
        mascotaRepository.deleteById(id);
        return new ResponseEntity<>(makeMap("OK", "eliminacion exitosa", "mascota", m), HttpStatus.OK);

    }

    private Map<String, Object> makeMap(String key, Object value) {
        Map<String, Object> map = new HashMap<>();
        map.put(key, value);
        return map;
    }

    private Map<String, Object> makeMap(String key, Object value, String key2, Object o) {
        Map<String, Object> map = new HashMap<>();
        map.put(key, value);
        map.put(key2, o);
        return map;
    }
}
