package com.rebolledonaharro.dinoapi.person.controller;

import com.rebolledonaharro.dinoapi.security.blacklist.BlackListService;
import com.rebolledonaharro.dinoapi.security.jwt.access.JwtProvider;
import com.rebolledonaharro.dinoapi.person.dto.*;
import com.rebolledonaharro.dinoapi.person.model.Admin;
import com.rebolledonaharro.dinoapi.person.model.Person;
import com.rebolledonaharro.dinoapi.person.model.User;
import com.rebolledonaharro.dinoapi.person.service.AdminService;
import com.rebolledonaharro.dinoapi.person.service.PersonService;
import com.rebolledonaharro.dinoapi.person.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.nio.file.attribute.UserPrincipalNotFoundException;

@RestController
@RequiredArgsConstructor
public class UsuarioController {

    private final JwtProvider jwtProvider;
    private final AuthenticationManager authManager;
    private final PersonService personService;
    private final UserService userService;
    private final AdminService adminService;
    private final BlackListService blackListService;


    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Register as user", content = {
                    @Content(mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = PersonResponse.class)),
                            examples = {@ExampleObject(
                                    value = """
                                            {
                                                 "id": "c0a83801-8c5f-132e-818c-5f94162a0000",
                                                 "username": "manolo34",
                                                 "fullName": "Manolo Manolez",
                                                 "roles": [
                                                     "USER"
                                                 ],
                                                 "createdAt": "12/12/2023 20:49:49"
                                             }
                                            """
                            )}
                    )}),
            @ApiResponse(responseCode = "400", description = "Introduced data not valid", content = @Content)
    })
    @Operation(summary = "createPersonWithUserRole", description = "Register as user")
    @PostMapping("/auth/register")
    public ResponseEntity<PersonResponse> createPersonWithUserRole(@Valid @RequestBody CreatePersonRequest createPersonRequest){
        User user = userService.createPersonWithUserRole(createPersonRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(PersonResponse.fromUser(user));
    }


    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Restore password", content = {
                    @Content(mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = PersonResponse.class)),
                            examples = {@ExampleObject(
                                    value = """
                                            {
                                                  "id": "c0a83801-8c5f-132e-818c-5f9480320001",
                                                  "username": "manolo67",
                                                  "fullName": "Manolo Manolez",
                                                  "roles": [
                                                      "ADMIN"
                                                  ],
                                                  "createdAt": "12/12/2023 20:50:16"
                                            }
                                            """
                            )}
                    )}),
            @ApiResponse(responseCode = "400", description = "Restore password", content = @Content)
    })
    @Operation(summary = "restorePassword", description = "Register as admin")
    @PostMapping("/restorePassword")
    public ResponseEntity<PersonResponse> restorePassword(@Valid @RequestBody RestorePassword restorePassword) throws UserPrincipalNotFoundException {

        Person person = personService.restorePassword(restorePassword);
        return ResponseEntity.status(HttpStatus.CREATED).body(PersonResponse.fromUser(person));

    }


    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Register as admin", content = {
                    @Content(mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = PersonResponse.class)),
                            examples = {@ExampleObject(
                                    value = """
                                            {
                                                  "id": "c0a83801-8c5f-132e-818c-5f9480320001",
                                                  "username": "manolo67",
                                                  "fullName": "Manolo Manolez",
                                                  "roles": [
                                                      "ADMIN"
                                                  ],
                                                  "createdAt": "12/12/2023 20:50:16"
                                            }
                                            """
                            )}
                    )}),
            @ApiResponse(responseCode = "400", description = "Introduced data not valid", content = @Content)
    })
    @Operation(summary = "createPersonWithAdminRole", description = "Register as admin")
    @PostMapping("/admin/register")
    public ResponseEntity<PersonResponse> createPersonWithAdminRole(@Valid @RequestBody CreatePersonRequest createPersonRequest, @AuthenticationPrincipal Person person){
        Admin admin = adminService.createPersonWithAdminRole(createPersonRequest, person);
        return ResponseEntity.status(HttpStatus.CREATED).body(PersonResponse.fromUser(admin));
    }


    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "log in", content = {
                    @Content(mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = PersonResponse.class)),
                            examples = {@ExampleObject(
                                    value = """
                                            {
                                                 "id": "80d768ef-831a-4cfe-94e6-fda1eb4452a6",
                                                 "username": "rducker0",
                                                 "fullName": "Rikki Ducker",
                                                 "roles": [
                                                     "ADMIN"
                                                 ],
                                                 "token": "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzM4NCJ9.eyJzdWIiOiI4MGQ3NjhlZi04MzFhLTRjZmUtOTRlNi1mZGExZWI0NDUyYTYiLCJpYXQiOjE3MDI0MTA2MDEsImV4cCI6MTcwMjQ5NzAwMX0.A0nmPr3mI_QiJiN-kld8qFzegDybOVtqYDYh_TwRigarVi1PK9wMraEcwQcSRHRM"
                                             }
                                            """
                            )}
                    )}),
            @ApiResponse(responseCode = "400", description = "Introduced data not valid", content = @Content)
    })
    @Operation(summary = "login", description = "log in")
    @PostMapping("/auth/login")
    public ResponseEntity<JwtUserResponse> login(@Valid @RequestBody LoginRequest loginRequest) {
        Authentication authentication =
                authManager.authenticate(
                        new UsernamePasswordAuthenticationToken(
                                loginRequest.getUsername(),
                                loginRequest.getPassword()
                        )
                );

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String token = jwtProvider.generateToken(authentication);
        Person person = (Person) authentication.getPrincipal();
        System.out.println(person.getPassword());
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(JwtUserResponse.of(person, token));
    }

    @PostMapping("/userLogout")
    public ResponseEntity<String> logout(HttpServletRequest request) {
        String token = extractTokenFromRequest(request);
        blackListService.addToBlackList(token);

        // Clear any session-related data if necessary

        return ResponseEntity.ok("Logged out successfully");
    }

    public String extractTokenFromRequest(HttpServletRequest request) {
        // Get the Authorization header from the request
        String authorizationHeader = request.getHeader("Authorization");

        // Check if the Authorization header is not null and starts with "Bearer "
        if (StringUtils.hasText(authorizationHeader) && authorizationHeader.startsWith("Bearer ")) {
            // Extract the JWT token (remove "Bearer " prefix)
            return authorizationHeader.substring(7);
        }

        // If the Authorization header is not valid, return null
        return null;
    }


}
