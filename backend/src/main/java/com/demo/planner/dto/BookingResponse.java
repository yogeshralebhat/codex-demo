package com.demo.planner.dto;

import java.time.OffsetDateTime;

public record BookingResponse(
        Long bookingId,
        Long experienceId,
        String experienceTitle,
        Integer seatsBooked,
        String status,
        OffsetDateTime bookedAt
) {
}
