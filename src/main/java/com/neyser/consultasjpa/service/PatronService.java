package com.neyser.consultasjpa.service;

import com.neyser.consultasjpa.entity.Patron;
import com.neyser.consultasjpa.repository.PatronRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PatronService {

    private final PatronRepository patronRepository;

    public Patron crearPatron(Patron patron){
        return patronRepository.save(patron);
    }

    public Patron obtenerPatron(Long idPatron){
        return patronRepository.buscarPatronPorId(idPatron);
    }

    public List<Patron> listarPatrones(){
        return patronRepository.findAll();
    }

    public Patron actualizarPatronPut(Patron patron){
        return patronRepository.save(patron);
    }

    public Patron actualizarPatronPatch(Long idPatron, Map<String, Object> fields){
        Optional<Patron> patron = patronRepository.findById(idPatron);
        if(patron.isPresent()){
            fields.forEach((key, value) ->{
                Field field = ReflectionUtils.findField(Patron.class, key);
                field.setAccessible(true);
                ReflectionUtils.setField(field, patron.get(), value);
            });

            return patronRepository.save(patron.get());
        }
        return null;
    }

    public void eliminarPatron(Long idPatron){
        patronRepository.deleteById(idPatron);
    }

}
