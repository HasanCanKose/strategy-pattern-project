package strategy.pattern.example.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import strategy.pattern.example.models.Course;

public interface CourseRepository extends JpaRepository<Course, Integer> {
}
