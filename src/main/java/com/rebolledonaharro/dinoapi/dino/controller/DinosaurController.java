package com.rebolledonaharro.dinoapi.dino.controller;


import com.rebolledonaharro.dinoapi.dino.model.Dinosaur;
import com.rebolledonaharro.dinoapi.dino.service.DinosaurService;
import com.rebolledonaharro.dinoapi.person.dto.PersonResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class DinosaurController {

    private final DinosaurService service;

    @GetMapping("/auth/alldinos")
    public ResponseEntity<List<Dinosaur>> findAll(@RequestParam(value = "q", required = false) String search) {

        if (search==null) {
            return ResponseEntity.ok(service.findAll());

        } else {
            return ResponseEntity.ok(service.findAllSpec(search));
        }

    }

}
