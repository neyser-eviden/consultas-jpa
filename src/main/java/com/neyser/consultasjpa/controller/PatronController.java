package com.neyser.consultasjpa.controller;

import com.neyser.consultasjpa.entity.Patron;
import com.neyser.consultasjpa.service.PatronService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/patrones")
public class PatronController {

    private final PatronService patronService;


    @GetMapping
    public List<Patron> listarPatrones(){
        return patronService.listarPatrones();
    }

    @PostMapping
    public void crearPatron(@RequestBody Patron patron){
        patronService.crearPatron(patron);
    }

    @PutMapping
    public void actualizarPatron(@RequestBody Patron patron){
        patronService.actualizarPatron(patron);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> eliminarPatron(@PathVariable("id") Long idPatron){
        patronService.eliminarPatron(idPatron);
        return ResponseEntity.ok("Todo deleted successfully!.");
    }

}
