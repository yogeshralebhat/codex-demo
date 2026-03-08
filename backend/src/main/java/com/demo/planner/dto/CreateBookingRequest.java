package com.demo.planner.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public record CreateBookingRequest(
        @NotNull Long guestUserId,
        @NotNull @Min(1) Integer seatsRequested
) {
}
