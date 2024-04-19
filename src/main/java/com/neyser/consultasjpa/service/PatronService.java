package com.neyser.consultasjpa.service;

import com.neyser.consultasjpa.entity.Patron;
import com.neyser.consultasjpa.repository.PatronRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PatronService {

    private final PatronRepository patronRepository;

    public void crearPatron(Patron patron){
        patronRepository.save(patron);
    }

    public List<Patron> listarPatrones(){
        return patronRepository.findAll();
    }

    public void actualizarPatron(Patron patron){
        patronRepository.save(patron);
    }

    public void eliminarPatron(Long idPatron){
        patronRepository.deleteById(idPatron);
    }

}
