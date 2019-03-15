package com.example.webdvsp19serverjava.services;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.webdvsp19serverjava.models.Courses;
import com.example.webdvsp19serverjava.models.Modules;
import com.example.webdvsp19serverjava.repositories.CourseRepository;
import com.example.webdvsp19serverjava.repositories.ModuleRepository;

@RestController
@CrossOrigin(origins = "*", allowCredentials ="true", allowedHeaders = "*")
public class ModuleService {

    @Autowired
    ModuleRepository moduleRepository;

    @Autowired
    CourseRepository courseRepository;

    @GetMapping("/api/course/{cid}/modules")
    public List<Modules> findAllModules(@PathVariable("cid") int courseId,
            								HttpSession session) {
        Courses currentCourse = courseRepository.findById(courseId).get();
        return currentCourse.getModules();
    }

    @PostMapping("/api/course/{cid}/modules")
    public List<Modules> createModule(@PathVariable("cid") int courseId,
            								@RequestBody Modules newModule,
            								HttpSession session) {
        Courses currentCourse = courseRepository.findById(courseId).get();
        List<Modules> modules = currentCourse.getModules();
        newModule.setCourse(currentCourse);
        modules.add(newModule);
        moduleRepository.save(newModule);
        return  courseRepository.findById(courseId).get().getModules();

    }

    @GetMapping("/api/module/{mid}")
    public Modules findModuleById(@PathVariable("mid") int moduleId,
            					HttpSession session) {
        return moduleRepository.findById(moduleId).get();
    }


    @PutMapping("/api/module/{mid}")
    public List<Modules> updateModule(@PathVariable("mid") int moduleId,
            								@RequestBody Modules updateModule,
            								HttpSession session) {
        Modules module = moduleRepository.findById(moduleId).get();
        if(module == null) {
            return null;
        }
        module.setModuleName(updateModule.getModuleName());
        moduleRepository.save(module);
        Courses currentCourse = courseRepository.findById(module.getCourse().getId()).get();
        return currentCourse.getModules();
    }

    @DeleteMapping("/api/module/{mid}")
    public List<Modules> deleteModule(@PathVariable("mid") int moduleId, 
    										HttpSession session) {
        Modules module = moduleRepository.findById(moduleId).get();
        int courseId = module.getCourse().getId();
        moduleRepository.delete(module);
        Courses course = courseRepository.findById(courseId).get();

        return course.getModules();
    }
}
