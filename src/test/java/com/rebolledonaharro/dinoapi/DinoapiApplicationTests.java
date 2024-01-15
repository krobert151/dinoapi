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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

class DinoapiApplicationTests {


}
