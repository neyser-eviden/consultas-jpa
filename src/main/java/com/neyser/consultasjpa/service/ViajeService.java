package com.neyser.consultasjpa.service;


import com.neyser.consultasjpa.entity.Viaje;
import com.neyser.consultasjpa.repository.ViajeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ViajeService {

    private final ViajeRepository viajeRepository;

    public void crearSocio(Viaje viaje){
        viajeRepository.save(viaje);
    }

    public List<Viaje> listarViajes(){
        return viajeRepository.findAll();
    }

    public void actualizarViaje(Viaje viaje){
        viajeRepository.save(viaje);
    }

    public void eliminarViaje(Long idViaje){
        viajeRepository.deleteById(idViaje);
    }

}
