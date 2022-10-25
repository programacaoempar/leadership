package com.sandrini.leadership.controllers;

import com.sandrini.leadership.domains.Led;
import com.sandrini.leadership.dtos.LedDTO;
import com.sandrini.leadership.services.LedService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/leds")
public class LedController {

    private final LedService ledService;

    public LedController(LedService ledService) {
        this.ledService = ledService;
    }

    @GetMapping("/{id}")
    @ResponseBody
    public ResponseEntity<LedDTO> getLed(@PathVariable("id") Long id){
        Optional<Led> led = ledService.getById(id);
        if(led.isEmpty()){
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok().body(led.get().toDTO());
    }

    @PostMapping
    public ResponseEntity<LedDTO> save(LedDTO ledDTO){
        Led led = ledService.saveOrUpdate(ledDTO.toEntity());

        return ResponseEntity.ok().body(led.toDTO());
    }


}
