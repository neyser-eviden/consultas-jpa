package com.neyser.consultasjpa.controller;

import com.neyser.consultasjpa.entity.Barco;
import com.neyser.consultasjpa.service.BarcoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/barcos")
@RequiredArgsConstructor
public class BarcoController{

    private final BarcoService barcoService;

    @GetMapping
    public List<Barco> listarBarcos(){
        return barcoService.listarBarcos();
    }

    @PostMapping
    public void crearBarco(@RequestBody Barco barco){
        barcoService.crearBarco(barco);
    }

    @PutMapping
    public void actualizarBarco(@RequestBody Barco barco){
        barcoService.actualizarBarco(barco);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> eliminarBarco(@PathVariable("id") Long idBarco){
        barcoService.eliminarBarco(idBarco);
        return ResponseEntity.ok("Todo deleted successfully!.");
    }
}
