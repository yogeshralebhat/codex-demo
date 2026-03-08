package com.demo.planner.dto;

import java.math.BigDecimal;

public record ExperienceCardResponse(
        Long id,
        String title,
        String summary,
        String city,
        BigDecimal pricePerSeat,
        Integer seatsRemaining,
        String hostName
) {
}
