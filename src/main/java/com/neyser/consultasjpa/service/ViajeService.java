package com.neyser.consultasjpa.service;


import com.neyser.consultasjpa.entity.Viaje;
import com.neyser.consultasjpa.repository.ViajeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ViajeService {

    private final ViajeRepository viajeRepository;

    public Viaje crearViaje(Viaje viaje){
        return viajeRepository.save(viaje);
    }

    public Viaje obtenerViaje(Long idViaje){
        return viajeRepository.buscarViajePorId(idViaje);
    }

    public List<Viaje> listarViajes(){
        return viajeRepository.findAll();
    }

    public Viaje actualizarViajePut(Viaje viaje){
        return viajeRepository.save(viaje);
    }

    public Viaje actualizarViajePatch(Long idViaje, Map<String, Object> fields){
        Optional<Viaje> viaje = viajeRepository.findById(idViaje);
        if(viaje.isPresent()){
            fields.forEach((key, value) ->{
                Field field = ReflectionUtils.findField(Viaje.class, key);
                field.setAccessible(true);
                ReflectionUtils.setField(field, viaje.get(), value);
            });

            return viajeRepository.save(viaje.get());
        }
        return null;
    }

    public void eliminarViaje(Long idViaje){
        viajeRepository.deleteById(idViaje);
    }

}
