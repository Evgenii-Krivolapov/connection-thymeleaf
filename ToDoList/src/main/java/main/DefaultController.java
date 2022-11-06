package main;

import main.model.Course;
import main.model.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;

@Controller
public class DefaultController {

    @Autowired
    private final CourseRepository courseRepository;

    public DefaultController(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @RequestMapping("/")
    public String index(Model model) {
        Iterable<Course> courseIterable = courseRepository.findAll();
        ArrayList<Course> arrayList = new ArrayList<>();

        for (Course course : courseIterable) {
            arrayList.add(course);
        }

        model.addAttribute("courses", arrayList)
                .addAttribute("coursesCount", arrayList.size());

        return "index";
    }
}
