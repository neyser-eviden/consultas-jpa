package com.neyser.consultasjpa.service;

import com.neyser.consultasjpa.entity.Socio;
import com.neyser.consultasjpa.repository.SocioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public void eliminarSocio(Long idsocio){
        socioRepository.deleteById(idsocio);
    }

}
