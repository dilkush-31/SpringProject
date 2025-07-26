package com.Smart_task.mini_project.Controller;

import com.Smart_task.mini_project.Entity.Entity_Task;
import com.Smart_task.mini_project.Service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/task")
public class TaskController {

    @Autowired
    private TaskService service;

    @GetMapping("/")
    public List<Entity_Task> taskList() {
        return service.getTasks();
    }
}
