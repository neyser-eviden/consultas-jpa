package com.neyser.consultasjpa.controller;

import com.neyser.consultasjpa.entity.Socio;
import com.neyser.consultasjpa.service.SocioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/socios")
@RequiredArgsConstructor
public class SocioController {

    private final SocioService socioService;

    @GetMapping
    public List<Socio> listarSocios(){
        return socioService.listarSocios();
    }

    @GetMapping("{id}")
    public Socio obtenerSocio(@PathVariable("id") Long idSocio){
        return socioService.obtenerSocio(idSocio);
    }

    @PostMapping
    public Socio crearSocio(@RequestBody Socio socio){
        return socioService.crearSocio(socio);
    }

    @PutMapping("{/id}")
    public Socio actualizarsocio(@PathVariable Long idSocio, @RequestBody Socio socio){
        return socioService.actualizarSocio(socio);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> eliminarSocio(@PathVariable("id") Long idSocio){
        socioService.eliminarSocio(idSocio);
        return ResponseEntity.ok("Socio con Id: "+idSocio+" eliminado correctamente");
    }

    @PatchMapping
    public void actualizarParcialSocio(@RequestBody Socio socio){
        socioService.actualizarSocio(socio);
    }

}
