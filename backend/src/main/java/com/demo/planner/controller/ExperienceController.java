package com.demo.planner.controller;

import com.demo.planner.dto.BookingResponse;
import com.demo.planner.dto.CreateBookingRequest;
import com.demo.planner.dto.ExperienceCardResponse;
import com.demo.planner.service.ExperienceService;
import jakarta.validation.Valid;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/experiences")
public class ExperienceController {

    private final ExperienceService experienceService;

    public ExperienceController(ExperienceService experienceService) {
        this.experienceService = experienceService;
    }

    @GetMapping
    public List<ExperienceCardResponse> listExperiences() {
        return experienceService.listPublishedExperiences();
    }

    @PostMapping("/{experienceId}/bookings")
    @ResponseStatus(HttpStatus.CREATED)
    public BookingResponse createBooking(
            @PathVariable Long experienceId,
            @Valid @RequestBody CreateBookingRequest request) {
        return experienceService.createBooking(experienceId, request);
    }
}
