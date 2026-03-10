package com.demo.planner.service;

import com.demo.planner.dto.BookingResponse;
import com.demo.planner.dto.CreateBookingRequest;
import com.demo.planner.dto.ExperienceCardResponse;
import com.demo.planner.entity.Booking;
import com.demo.planner.entity.Experience;
import com.demo.planner.entity.ExperienceStatus;
import com.demo.planner.entity.UserAccount;
import com.demo.planner.repository.BookingRepository;
import com.demo.planner.repository.ExperienceRepository;
import com.demo.planner.repository.UserAccountRepository;
import jakarta.persistence.EntityNotFoundException;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ExperienceService {

    private final ExperienceRepository experienceRepository;
    private final UserAccountRepository userAccountRepository;
    private final BookingRepository bookingRepository;

    public ExperienceService(
            ExperienceRepository experienceRepository,
            UserAccountRepository userAccountRepository,
            BookingRepository bookingRepository) {
        this.experienceRepository = experienceRepository;
        this.userAccountRepository = userAccountRepository;
        this.bookingRepository = bookingRepository;
    }

    @Transactional(readOnly = true)
    public List<ExperienceCardResponse> listPublishedExperiences() {
        return experienceRepository.findByStatusOrderByCreatedAtDesc(ExperienceStatus.PUBLISHED)
                .stream()
                .map(experience -> new ExperienceCardResponse(
                        experience.getId(),
                        experience.getTitle(),
                        experience.getSummary(),
                        experience.getCity(),
                        experience.getPricePerSeat(),
                        experience.getSeatsRemaining(),
                        experience.getHost().getFullName()
                ))
                .toList();
    }

    @Transactional
    public BookingResponse createBooking(Long experienceId, CreateBookingRequest request) {
        Experience experience = experienceRepository.findByIdForUpdate(experienceId)
                .orElseThrow(() -> new EntityNotFoundException("Experience not found"));

        UserAccount guest = userAccountRepository.findById(request.guestUserId())
                .orElseThrow(() -> new EntityNotFoundException("Guest user not found"));

        if (experience.getStatus() != ExperienceStatus.PUBLISHED) {
            throw new IllegalArgumentException("Only published experiences can be booked");
        }

        if (experience.getSeatsRemaining() < request.seatsRequested()) {
            throw new IllegalArgumentException("Not enough seats remaining");
        }

        experience.setSeatsRemaining(experience.getSeatsRemaining() - request.seatsRequested());
        if (experience.getSeatsRemaining() == 0) {
            experience.setStatus(ExperienceStatus.SOLD_OUT);
        }

        Booking booking = new Booking();
        booking.setExperience(experience);
        booking.setGuest(guest);
        booking.setSeatsBooked(request.seatsRequested());

        Booking savedBooking = bookingRepository.save(booking);

        return new BookingResponse(
                savedBooking.getId(),
                experience.getId(),
                experience.getTitle(),
                savedBooking.getSeatsBooked(),
                savedBooking.getStatus().name(),
                savedBooking.getBookedAt()
        );
    }
}
