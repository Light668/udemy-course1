/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.light668.sampleDemoApp.controller;

import org.springframework.web.bind.annotation.RestController;
import de.light668.sampleDemoApp.model.Course;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author Timo Radtke
 */
@RestController
public class RestEndpoint {

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
