package com.neyser.consultasjpa;

import com.neyser.consultasjpa.entity.Barco;
import com.neyser.consultasjpa.repository.BarcoRepository;
import com.neyser.consultasjpa.service.BarcoService;
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
import static org.mockito.Mockito.times;

@RunWith(SpringRunner.class)
@SpringBootTest
class BarcoTest {

    @MockBean
    private BarcoRepository barcoRepository;

    @Autowired
    private BarcoService barcoService;


    @Test
    public void crearBarco() {
        Barco barco = new Barco();
        barco.setMatricula("AAA123");
        barco.setNombre("Barco1");
        barco.setAmarre("Amarre001");
        barco.setCuota("1500");

        when(barcoRepository.save(barco)).thenReturn(barco);
        assertEquals(barco, barcoService.crearBarco(barco));
    }

    @Test
    public void listarBarcos() {
        Barco barco1 = new Barco();
        barco1.setMatricula("AAA123");
        barco1.setNombre("Barco1");
        barco1.setAmarre("Amarre001");
        barco1.setCuota("1500");

        Barco barco2 = new Barco();
        barco2.setMatricula("ZZZ123");
        barco2.setNombre("Barco2");
        barco2.setAmarre("Amarre002");
        barco2.setCuota("2500");

        when(barcoRepository.findAll()).thenReturn(Stream
                .of(barco1, barco2).collect(Collectors.toList()));
        assertEquals(2, barcoService.listarBarcos().size());
    }

    @Test
    public void eliminarBarco() {
        Long idBarco = 1L;

        doNothing().when(barcoRepository).deleteById(idBarco);

        barcoService.eliminarBarco(idBarco);

        verify(barcoRepository, times(1)).deleteById(idBarco);
    }
}
