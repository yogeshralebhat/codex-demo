package com.demo.planner.repository;

import com.demo.planner.entity.Experience;
import com.demo.planner.entity.ExperienceStatus;
import java.util.List;
import java.util.Optional;
import jakarta.persistence.LockModeType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ExperienceRepository extends JpaRepository<Experience, Long> {
    List<Experience> findByStatusOrderByCreatedAtDesc(ExperienceStatus status);

    @Lock(LockModeType.PESSIMISTIC_WRITE)
    @Query("select e from Experience e where e.id = :id")
    Optional<Experience> findByIdForUpdate(@Param("id") Long id);
}
