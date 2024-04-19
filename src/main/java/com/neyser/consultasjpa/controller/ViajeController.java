package com.neyser.consultasjpa.controller;


import com.neyser.consultasjpa.entity.Viaje;
import com.neyser.consultasjpa.service.ViajeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("viajes")
@RequiredArgsConstructor
public class ViajeController {

    private final ViajeService viajeService;

    @GetMapping
    public List<Viaje> listarSocios(){
        return viajeService.listarViajes();
    }

    @PostMapping
    public void crearViaje(@RequestBody Viaje viaje){
        viajeService.crearSocio(viaje);
    }

    @PutMapping
    public void actualizarViaje(@RequestBody Viaje viaje){
        viajeService.actualizarViaje(viaje);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> eliminarViaje(@PathVariable("id") Long idViaje){
        viajeService.eliminarViaje(idViaje);
        return ResponseEntity.ok("Todo deleted successfully!.");
    }

}
