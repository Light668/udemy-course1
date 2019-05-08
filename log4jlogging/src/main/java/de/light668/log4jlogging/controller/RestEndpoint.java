/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.light668.log4jlogging.controller;


import de.light668.log4jlogging.config.CourseConfiguration;
import de.light668.log4jlogging.model.Course;
import java.util.HashMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Timo Radtke
 */
@RestController
public class RestEndpoint {

    @Value("${default.course.name}")
    private String cName;

    @Value("${default.course.chapterCount}")
    private int chaptersCount;

    @Autowired
    private CourseConfiguration cc;

    @GetMapping("/defaultCourse")
    public Course getDefaultCourse(@RequestParam(value = "name", defaultValue = "Spring Boot", required = false) String name,
            @RequestParam(value = "chapterCount", defaultValue = "2", required = false) int chapterCount) {
        return new Course(cName, chaptersCount);
    }

    @GetMapping("/gethierarchial")
    public HashMap<String, Object> getConfigAnnotatedProperties() {
        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("name", cc.getName());
        map.put("chapterCount", cc.getChapterCount());
        map.put("rating", cc.getRating());
        map.put("author", cc.getAuthor());
        return map;
    }

    @GetMapping("/course")
    public Course getEndpoint(@RequestParam(value = "name", defaultValue = "Spring Boot", required = false) String name,
            @RequestParam(value = "chapterCount", defaultValue = "2", required = false) int chapterCount) {
        return new Course(name, chapterCount);
    }

    @PostMapping("/register/course")
    public String saveCourse(@RequestBody Course course) {
        return "Your course named : " + course.getName() + " with " + course.getChapterCount() + " chapters saved successfully.";
    }

}
