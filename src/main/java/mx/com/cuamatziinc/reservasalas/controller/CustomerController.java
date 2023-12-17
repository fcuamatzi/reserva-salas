package mx.com.cuamatziinc.reservasalas.controller;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController("/customers")
public class CustomerController {

    public ResponseEntity<?> registerCustomer(@RequestBody @Valid SaveUser newUser) {

        RegisteredUser

    }
}
