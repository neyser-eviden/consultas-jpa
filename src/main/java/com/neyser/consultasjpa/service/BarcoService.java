package com.neyser.consultasjpa.service;

import com.neyser.consultasjpa.entity.Barco;
import com.neyser.consultasjpa.repository.BarcoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BarcoService {

    private final BarcoRepository barcoRepository;

    public Barco crearBarco(Barco barco){
        return barcoRepository.save(barco);
    }

    public Barco obtenerBarco(Long idBarco){
        return barcoRepository.buscarBarcoPorId(idBarco);
    }

    public List<Barco> listarBarcos() {
        return barcoRepository.findAll();
    }

    public void actualizarBarco(Barco barco) {
        barcoRepository.save(barco);
    }

    public Barco actualizarBarcoPatch(Long idBarco, Map<String, Object> fields){
        Optional<Barco> barco = barcoRepository.findById(idBarco);
        if(barco.isPresent()){
            fields.forEach((key, value) ->{
                Field field = ReflectionUtils.findField(Barco.class, key);
                field.setAccessible(true);
                ReflectionUtils.setField(field, barco.get(), value);
            });

            return barcoRepository.save(barco.get());
        }
        return null;
    }

    public void eliminarBarco(Long idBarco) {
        barcoRepository.deleteById(idBarco);
    }




}
