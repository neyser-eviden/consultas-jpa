package com.neyser.consultasjpa.controller;

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
class SocioControllerTest {

    @MockBean
    private SocioRepository socioRepository;

    @Autowired
    private SocioService socioService;


    @Test
    public void crearSocio() {
        Socio socio = new Socio();
        socio.setNombre("Neyser");
        socio.setApellido("Huaman");
        socio.setEmail("neyser@mail.com");
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
        Socio socio1 = new Socio();
        socio1.setNombre("Neyser");
        socio1.setApellido("Huaman");
        socio1.setEmail("neyser@mial.com");
        socio1.setTelefono("49943989");

        socioService.eliminarSocio(socio1.getId());
        verify(socioRepository, times(1)).delete(socio1);
    }


}