package strategy.pattern.example.controllers;

import org.springframework.web.bind.annotation.*;
import strategy.pattern.example.models.Course;
import strategy.pattern.example.services.CourseService;

import java.util.List;

@RestController
public class CourseController {

    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @RequestMapping("/courses")
    public List<?> getAllCourses() {
        return courseService.getAllCourses();
    }

    @RequestMapping("/courses/{name}")
    public Course getCourse(@PathVariable String name) {
        return courseService.getCourse(name);
    }

    @RequestMapping(method = RequestMethod.POST, value="/courses")
    public void addCourse(@RequestBody Course course) {
        courseService.addCourse(course);
    }

    @RequestMapping(method = RequestMethod.PUT, value="/courses/{id}")
    public void updateCourse(@RequestBody Course course, @PathVariable String id) {
        courseService.updateCourse(course, Integer.parseInt(id));
    }

    @RequestMapping(method = RequestMethod.DELETE, value="/courses/{id}")
    public void deleteCourse(@PathVariable String id) {
        courseService.deleteCourse(Integer.parseInt(id));
    }
}
