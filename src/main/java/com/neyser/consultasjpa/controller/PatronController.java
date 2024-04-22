package com.neyser.consultasjpa.controller;

import com.neyser.consultasjpa.entity.Patron;
import com.neyser.consultasjpa.service.PatronService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/patrones")
public class PatronController {

    private final PatronService patronService;

    @GetMapping
    public List<Patron> listarPatrones(){
        return patronService.listarPatrones();
    }

    @GetMapping("{id}")
    public Patron obtenerPatron(@PathVariable("id") Long idPatron){
        return patronService.obtenerPatron(idPatron);
    }

    @PostMapping
    public Patron crearPatron(@RequestBody Patron patron){
        return patronService.crearPatron(patron);
    }

    @PutMapping
    public Patron actualizarPatronPut(@RequestBody Patron patron){
        return patronService.actualizarPatronPut(patron);
    }

    @PatchMapping("{id}")
    public Patron actualizarPatronPatch(@PathVariable("id") Long idPatron,@RequestBody Map<String, Object> fields){
        return patronService.actualizarPatronPatch(idPatron, fields);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> eliminarPatron(@PathVariable("id") Long idPatron){
        patronService.eliminarPatron(idPatron);
        return ResponseEntity.ok("Patron con Id: "+idPatron+" eliminado correctamente");
    }



}
