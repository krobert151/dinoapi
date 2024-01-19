package com.rebolledonaharro.dinoapi;

import com.rebolledonaharro.dinoapi.clasification.model.ClasificationType;
import com.rebolledonaharro.dinoapi.clasification.model.Classification;
import com.rebolledonaharro.dinoapi.clasification.repository.ClasificationRepository;
import com.rebolledonaharro.dinoapi.dino.model.Dinosaur;
import com.rebolledonaharro.dinoapi.dino.repository.DinosaurRepository;
import com.rebolledonaharro.dinoapi.period.model.Period;
import com.rebolledonaharro.dinoapi.period.repository.PeriodRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.testcontainers.junit.jupiter.Testcontainers;

import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.skyscreamer.jsonassert.JSONAssert.assertEquals;
@DataJpaTest
@Testcontainers
@ActiveProfiles({"test"})
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Sql(value = "classpath:import-test.sql",executionPhase = Sql.ExecutionPhase.AFTER_TEST_CLASS)
public class DinosaurRepoTest {

    @Autowired
    private DinosaurRepository dinosaurRepository;

    @Autowired
    private ClasificationRepository clasificationRepository;

    @Autowired
    private PeriodRepository periodRepository;

    @Autowired
    private TestEntityManager entityManager;

    @Test
    void dinosaurResporitoryTest(){

        Period p = Period.builder()
                .name("Late Cretaceous")
                .started(100.5)
                .finished(65)
                .description("The Late Cretaceous (100.5–66 Ma) is the younger of two epochs into which the Cretaceous Period is divided in the geologic time scale. Rock strata from this epoch form the Upper Cretaceous Series. The Cretaceous is named after creta, the Latin word for the white limestone known as chalk. The chalk of northern France and the white cliffs of south-eastern England date from the Cretaceous Period.")
                .build();

        entityManager.persist(p);

        Classification c = Classification.builder()
                .type(ClasificationType.GENUS)
                .schemaOrder(0)
                .name("Tyrannosaurus")
                .description("Genius of T-rex")
                .build();

        entityManager.persist(c);

        Dinosaur dinosaur = Dinosaur.builder()
                .scientificName("Manolo Saurio")
                .name("Tyranosaurus")
                .height(3)
                .weight(3)
                .length(3)
                .liveSince(3)
                .liveUntil(3)
                .numTheeth(3)
                .periods(List.of(p))
                .classification(c)
                .build();

        entityManager.persist(dinosaur);

        List<Dinosaur> listResp;
        listResp = dinosaurRepository.findByPeriodName("Late Cretaceous");


        Assertions.assertEquals(2,listResp.size());
        Assertions.assertFalse(listResp.get(0).getPeriods()
                .stream()
                .filter(
                        x -> x.getName()
                                .equalsIgnoreCase("Late Cretaceous")
                ).collect(Collectors.toSet()).isEmpty());

    }



}
