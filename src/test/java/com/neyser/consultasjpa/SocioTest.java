package com.neyser.consultasjpa;

import com.neyser.consultasjpa.entity.Socio;
import com.neyser.consultasjpa.repository.SocioRepository;
import com.neyser.consultasjpa.service.SocioService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
@SpringBootTest
class SocioTest {

    @MockBean
    private SocioRepository socioRepository;

    @Autowired
    private SocioService socioService;


    @Test
    public void crearSocio() {
        Socio socio = new Socio();
        socio.setNombre("Neyser");
        socio.setApellido("Huaman");
        socio.setEmail("ney.huaman@mail.com");
        socio.setTelefono("49943989");

        when(socioRepository.save(socio)).thenReturn(socio);
        assertEquals(socio, socioService.crearSocio(socio));
    }

    @Test
    public void listarSocios() {
        Socio socio1 = new Socio();
        socio1.setNombre("Neyser");
        socio1.setApellido("Huaman");
        socio1.setEmail("neyser@mial.com");
        socio1.setTelefono("49943989");

        Socio socio2 = new Socio();
        socio2.setNombre("Neyser");
        socio2.setApellido("Huaman");
        socio2.setEmail("neyser@mial.com");
        socio2.setTelefono("49943989");

        when(socioRepository.findAll()).thenReturn(Stream
                .of(socio1, socio2).collect(Collectors.toList()));
        assertEquals(2, socioService.listarSocios().size());
    }

    @Test
    public void eliminarSocio() {
        Long idSocio = 1L;

        // Simular el comportamiento de eliminar un socio
        doNothing().when(socioRepository).deleteById(idSocio);

        socioService.eliminarSocio(idSocio);

        // Verificamos que el método deleteById haya sido llamado con el id correcto
        verify(socioRepository, times(1)).deleteById(idSocio);
    }

}