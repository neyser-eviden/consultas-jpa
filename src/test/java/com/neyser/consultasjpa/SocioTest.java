package com.neyser.consultasjpa;

import com.neyser.consultasjpa.entity.Socio;
import com.neyser.consultasjpa.repository.SocioRepository;
import lombok.RequiredArgsConstructor;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
@SpringBootTest
@RequiredArgsConstructor
public class SocioTest {

    private final SocioRepository socioRepository;


    public void crerSocio(){




    }

}
