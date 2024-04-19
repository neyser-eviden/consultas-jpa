package com.neyser.consultasjpa.service;

import com.neyser.consultasjpa.entity.Barco;
import com.neyser.consultasjpa.repository.BarcoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BarcoService {

    private final BarcoRepository barcoRepository;

    public void crearBarco(Barco barco){
        barcoRepository.save(barco);
    }

    public void eliminarBarco(Long idBarco) {
        barcoRepository.deleteById(idBarco);
    }

    public List<Barco> listarBarcos() {
        return barcoRepository.findAll();
    }

    public void actualizarBarco(Barco barco) {
        barcoRepository.save(barco);
    }
}
