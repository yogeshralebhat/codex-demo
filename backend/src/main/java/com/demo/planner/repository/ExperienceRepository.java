package com.demo.planner.repository;

import com.demo.planner.entity.Experience;
import com.demo.planner.entity.ExperienceStatus;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExperienceRepository extends JpaRepository<Experience, Long> {
    List<Experience> findByStatusOrderByCreatedAtDesc(ExperienceStatus status);
}
