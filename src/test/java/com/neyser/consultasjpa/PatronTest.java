package com.neyser.consultasjpa;

import com.neyser.consultasjpa.entity.Patron;
import com.neyser.consultasjpa.repository.PatronRepository;
import com.neyser.consultasjpa.service.PatronService;
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
class PatronTest {
    @MockBean
    private PatronRepository patronRepository;

    @Autowired
    private PatronService patronService;


    @Test
    public void crearPatron() {
        Patron patron = new Patron();
        patron.setNombre("Neyser");
        patron.setApellido("Huaman");
        patron.setEmail("ney.huaman@mail.com");
        patron.setTelefono("49943989");

        when(patronRepository.save(patron)).thenReturn(patron);
        assertEquals(patron, patronService.crearPatron(patron));
    }

    @Test
    public void listarPatrones() {
        Patron patron1 = new Patron();
        patron1.setNombre("Neyser");
        patron1.setApellido("Huaman");
        patron1.setEmail("neyser@mial.com");
        patron1.setTelefono("49943989");

        Patron patron2 = new Patron();
        patron2.setNombre("Neyser");
        patron2.setApellido("Huaman");
        patron2.setEmail("neyser@mial.com");
        patron2.setTelefono("49943989");

        when(patronRepository.findAll()).thenReturn(Stream
                .of(patron1, patron2).collect(Collectors.toList()));
        assertEquals(2, patronService.listarPatrones().size());
    }

    @Test
    public void eliminarPatron() {
        Long idPatron = 1L;

        // Simular el comportamiento de eliminar un patron
        doNothing().when(patronRepository).deleteById(idPatron);

        patronService.eliminarPatron(idPatron);

        // Verificamos que el método deleteById haya sido llamado con el id correcto
        verify(patronRepository, times(1)).deleteById(idPatron);
    }
}
