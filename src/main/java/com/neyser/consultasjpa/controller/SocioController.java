package com.neyser.consultasjpa.controller;

import com.neyser.consultasjpa.entity.Socio;
import com.neyser.consultasjpa.service.SocioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

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

    @PutMapping
    public Socio actualizarsocioPut(@RequestBody Socio socio){
        return socioService.actualizarSocioPut(socio);
    }

    @PatchMapping("{id}")
    public Socio actualizarsocioPatch(@PathVariable("id") Long idSocio,@RequestBody Map<String, Object> fields){
        return socioService.actualizarSocioPatch(idSocio, fields);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> eliminarSocio(@PathVariable("id") Long idSocio){
        socioService.eliminarSocio(idSocio);
        return ResponseEntity.ok("Socio con Id: "+idSocio+" eliminado correctamente");
    }

}
