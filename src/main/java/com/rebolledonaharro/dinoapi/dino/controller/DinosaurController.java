package com.rebolledonaharro.dinoapi.dino.controller;


import com.rebolledonaharro.dinoapi.dino.model.Dinosaur;
import com.rebolledonaharro.dinoapi.dino.service.DinosaurService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class DinosaurController {

    private final DinosaurService service;

    @GetMapping("/auth/alldinos")
    public ResponseEntity<List<Dinosaur>> findAll(){

        return ResponseEntity.ok(service.findAll());

    }


}
