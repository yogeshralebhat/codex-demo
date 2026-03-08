package com.demo.planner.repository;

import com.demo.planner.entity.Booking;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<Booking, Long> {
    List<Booking> findByGuestIdOrderByBookedAtDesc(Long guestId);
}
