package com.neyser.consultasjpa.service;

import com.neyser.consultasjpa.entity.Socio;
import com.neyser.consultasjpa.repository.SocioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SocioService {

    private final SocioRepository socioRepository;

    public Socio crearSocio(Socio socio){
        return socioRepository.save(socio);
    }

    public Socio obtenerSocio(Long idSocio){
        return socioRepository.buscarSocioPorId(idSocio);
    }

    public List<Socio> listarSocios(){
        return socioRepository.findAll();
    }

    public Socio actualizarSocio(Socio socio){
        return socioRepository.save(socio);
    }

    public Socio actualizarSocio1(Long idsocio, Socio socio){
        Socio socio1 = socioRepository.findById(idsocio).get();
        socio1 = socio;
        return socioRepository.save(socio1);
    }

    public Socio actualizarSocio2(Long idSocio, Map<String, Object> fields){
        Optional<Socio> socio = socioRepository.findById(idSocio);

        if(socio.isPresent()){
            fields.forEach((key, value) ->{
                Field field = ReflectionUtils.findField(Socio.class, key);
                field.setAccessible(true);
                ReflectionUtils.setField(field, socio.get(), value);
            });

            return socioRepository.save(socio.get());
        }
        return null;
    }

    public void eliminarSocio(Long idsocio){
        socioRepository.deleteById(idsocio);
    }

}
