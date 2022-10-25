package com.sandrini.leadership.services;

import com.sandrini.leadership.domains.Led;
import com.sandrini.leadership.repository.LedRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LedService {

    private final LedRepository ledRepository;

    public LedService(LedRepository ledRepository) {
        this.ledRepository = ledRepository;
    }

    public Optional<Led> getById(Long ledId) {
        return ledRepository.findById(ledId);
    }

    public Led saveOrUpdate(Led led) {
        Optional<Led> _led = getById(led.getId());

        if (_led.isPresent()) {
            Led updatedLed = _led.get();
            updatedLed.setName(led.getName());
            updatedLed.setTeam(led.getTeam());

            return ledRepository.save(_led.get());
        }

        return ledRepository.save(led);
    }

    public void deleteById(Long id) {
        ledRepository.deleteById(id);
    }
}

