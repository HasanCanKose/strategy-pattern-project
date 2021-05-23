package strategy.pattern.example.services;


import org.springframework.stereotype.Service;
import strategy.pattern.example.models.Course;
import strategy.pattern.example.strategy.CrudStrategy;

import java.util.List;

@Service
public class CourseService {

    private final CrudStrategy<Course> crudStrategy;

    public CourseService(CrudStrategy<Course> crudStrategy) {
        this.crudStrategy = crudStrategy;
    }

    public List<?> getAllCourses() {
        return crudStrategy.getAll();
    }

    public Course getCourse(String name) {
        return crudStrategy.getOne(name);
    }

    public void addCourse(Course course) {
        crudStrategy.add(course);
    }

    public void updateCourse(Course course, int id) {
        crudStrategy.update(course, id);
    }

    public void deleteCourse(int id) {
        crudStrategy.delete(id);
    }
}
