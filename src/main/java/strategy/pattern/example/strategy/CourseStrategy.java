package strategy.pattern.example.strategy;

import org.springframework.stereotype.Component;
import strategy.pattern.example.models.Course;
import strategy.pattern.example.repositories.CourseRepository;

import java.util.List;

@Component
public class CourseStrategy implements CrudStrategy<Course> {

    private final CourseRepository courseRepository;

    public CourseStrategy(CourseRepository courseRepository){
        this.courseRepository = courseRepository;
    }

    @Override
    public List<Course> getAll() {
       return courseRepository.findAll();
    }

    @Override
    public Course getOne(String name) {
        List<Course> courses = getAll();
        return courses.stream().filter(course -> course.getName().equals(name)).findFirst().get();
    }

    @Override
    public void add(Course course) {
        courseRepository.save(course);
    }

    @Override
    public void update(Course course, int id) {
        courseRepository.save(course);
    }

    @Override
    public void delete(int id) {
        courseRepository.deleteById(id);

    }
}
