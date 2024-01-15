package com.rebolledonaharro.dinoapi;

import com.rebolledonaharro.dinoapi.clasification.model.ClasificationType;
import com.rebolledonaharro.dinoapi.clasification.model.Classification;
import com.rebolledonaharro.dinoapi.clasification.repository.ClasificationRepository;
import com.rebolledonaharro.dinoapi.clasification.service.ClasificationService;
import com.rebolledonaharro.dinoapi.dino.model.Dinosaur;
import com.rebolledonaharro.dinoapi.dino.repository.DinosaurRepository;
import com.rebolledonaharro.dinoapi.dino.service.DinosaurService;
import com.rebolledonaharro.dinoapi.period.model.Period;
import com.rebolledonaharro.dinoapi.period.repository.PeriodRepository;
import com.rebolledonaharro.dinoapi.period.service.PeriodService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.UUID;


@SpringBootTest
public class DinosaurTest {


    @InjectMocks
    DinosaurService service;

    @Test
    void registerNewDino() {
        Dinosaur dinosaur = Dinosaur.builder()
                .scientificName("Manolo Saurio")
                .name("Manolo Saurio")
                .height(3)
                .weight(3)
                .length(3)
                .liveSince(3)
                .liveUntil(3)
                .numTheeth(3)
                .periods(List.of(Period.builder()
                        .name("Late Cretaceous")
                        .started(100.5)
                        .finished(65)
                        .description("The Late Cretaceous (100.5–66 Ma) is the younger of two epochs into which the Cretaceous Period is divided in the geologic time scale. Rock strata from this epoch form the Upper Cretaceous Series. The Cretaceous is named after creta, the Latin word for the white limestone known as chalk. The chalk of northern France and the white cliffs of south-eastern England date from the Cretaceous Period.")
                        .build()))
                .classification(Classification.builder()
                        .id(UUID.fromString("d1638980-6a3e-47ba-8c68-ec059ca560f1"))
                        .type(ClasificationType.GENUS)
                        .schemaOrder(0)
                        .name("Tyrannosaurus")
                        .description("Genius of T-rex")
                        .build())
                .build();



        Mockito.when(service.addDino2(dinosaur)).thenReturn(dinosaur);


        Assertions.assertEquals(service.addDino2(dinosaur), dinosaur);




    }

    @Test
    void getDinosaurs(){

    }

}
