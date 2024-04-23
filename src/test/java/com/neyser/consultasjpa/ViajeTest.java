package com.neyser.consultasjpa;

import com.neyser.consultasjpa.entity.Viaje;
import com.neyser.consultasjpa.repository.ViajeRepository;
import com.neyser.consultasjpa.service.ViajeService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.Timestamp;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;

@RunWith(SpringRunner.class)
@SpringBootTest
class ViajeTest {
    @MockBean
    private ViajeRepository viajeRepository;

    @Autowired
    private ViajeService viajeService;


    @Test
    public void crearViaje() {
        Viaje viaje = new Viaje();
        viaje.setDestino("Sevilla");
        viaje.setFecha_salida(Timestamp.valueOf("2024-08-28 13:52:05"));

        when(viajeRepository.save(viaje)).thenReturn(viaje);
        assertEquals(viaje, viajeService.crearViaje(viaje));
    }

    @Test
    public void listarViajes() {
        Viaje viaje1 = new Viaje();
        viaje1.setDestino("Barcelona");
        viaje1.setFecha_salida(Timestamp.valueOf("2024-08-28 13:52:05"));

        Viaje viaje2 = new Viaje();
        viaje2.setDestino("Madrid");
        viaje2.setFecha_salida(Timestamp.valueOf("2024-08-28 13:52:05"));

        when(viajeRepository.findAll()).thenReturn(Stream
                .of(viaje1, viaje2).collect(Collectors.toList()));
        assertEquals(2, viajeService.listarViajes().size());
    }

    @Test
    public void eliminarViaje() {
        Long idViaje = 1L;

        // Simular el comportamiento de eliminar un viaje
        doNothing().when(viajeRepository).deleteById(idViaje);

        viajeService.eliminarViaje(idViaje);

        // Verificamos que el método deleteById haya sido llamado con el id correcto
        verify(viajeRepository, times(1)).deleteById(idViaje);
    }
}
