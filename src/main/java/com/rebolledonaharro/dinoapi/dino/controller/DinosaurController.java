package com.rebolledonaharro.dinoapi.dino.controller;


import com.rebolledonaharro.dinoapi.dino.dto.DinoBasicGET;
import com.rebolledonaharro.dinoapi.dino.dto.DinoPOST;
import com.rebolledonaharro.dinoapi.dino.dto.SimpleDinoGET;
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
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user/dino")
public class DinosaurController {

    private final DinosaurService service;

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "find dinosaurs with or without criteria", content = {
                    @Content(mediaType = "application/json",
                    array = @ArraySchema(schema = @Schema(implementation = DinoBasicGET.class)),
                    examples = {
                            @ExampleObject(
                                    value = """
                                            [
                                                {
                                                    "name": "tiranosaurus",
                                                    "scientificName": "tiranosaurus-rex",
                                                    "family": "Tyrannosaurus",
                                                    "height": "5.0",
                                                    "weight": "6000.0",
                                                    "lenght": "12.0",
                                                    "live": "to 68.0 mill ago, form 66.0 mill ago",
                                                    "numTheeth": "100",
                                                    "periods": "Late Cretaceous"
                                                }
                                            ]
                                            """
                            )
                    })
            }),
            @ApiResponse(responseCode = "404", description = "Dinosaur was not found", content = @Content)
    })
    @GetMapping("/alldinos")
    public ResponseEntity<List<DinoBasicGET>> findAll(@RequestParam(value = "q", required = false) String search) {

        if (search==null) {
            return ResponseEntity.ok(service.findAll());

        } else {
            return ResponseEntity.ok(service.findAllSpec(search));
        }

    }


    @ApiResponses(
           value = {
                   @ApiResponse(responseCode = "201", description = "Dinosaur was created", content = {
                           @Content(mediaType = "application/json",
                           array = @ArraySchema (schema = @Schema(implementation = DinoBasicGET.class)),
                           examples = {
                                   @ExampleObject(
                                           value = """
                                                   {
                                                       "name": "Anquilosaurus",
                                                       "scientificName": "Anquilosaurio",
                                                       "family": "Tyrannosaurus",
                                                       "height": "2.0",
                                                       "weight": "12.0",
                                                       "lenght": "6.0",
                                                       "live": "to 68.0 mill ago, form 66.0 mill ago",
                                                       "numTheeth": "50",
                                                       "periods": "Late Cretaceous"
                                                   }
                                                   """
                                   )
                           }
                           )
                   })
           }
    )
    @PostMapping("/add")
    public ResponseEntity<DinoBasicGET> add(@RequestBody DinoPOST post){

        return ResponseEntity.status(HttpStatus.CREATED).body(service.addDino(post));

    }

}
