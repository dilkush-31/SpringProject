package com.Smart_task.mini_project.Entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "Smart-task1")
public class Entity_Task {
    @Id
    private String id;
    private String title;
    private String description;
    private LocalDate dueDate;
    private String status;     // e.g., "Pending", "Completed"
    private String userId;
}
