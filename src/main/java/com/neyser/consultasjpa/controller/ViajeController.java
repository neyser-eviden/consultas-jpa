package com.neyser.consultasjpa.controller;

import com.neyser.consultasjpa.entity.Viaje;
import com.neyser.consultasjpa.service.ViajeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("viajes")
@RequiredArgsConstructor
public class ViajeController {

    private final ViajeService viajeService;

    @GetMapping
    public List<Viaje> listarViajes(){
        return viajeService.listarViajes();
    }

    @GetMapping("{id}")
    public Viaje obtenerViaje(@PathVariable("id") Long idViaje){
        return viajeService.obtenerViaje(idViaje);
    }

    @PostMapping
    public Viaje crearViaje(@RequestBody Viaje viaje){
        return viajeService.crearViaje(viaje);
    }

    @PutMapping
    public Viaje actualizarViajePut(@RequestBody Viaje viaje){
        return viajeService.actualizarViajePut(viaje);
    }

    @PatchMapping("{id}")
    public Viaje actualizarViajePatch(@PathVariable("id") Long idViaje,@RequestBody Map<String, Object> fields){
        return viajeService.actualizarViajePatch(idViaje, fields);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> eliminarViaje(@PathVariable("id") Long idViaje){
        viajeService.eliminarViaje(idViaje);
        return ResponseEntity.ok("Viaje con Id: "+idViaje+" eliminado correctamente");
    }

}
