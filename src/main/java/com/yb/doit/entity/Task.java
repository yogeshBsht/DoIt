package com.yb.doit.entity;

import java.time.Instant;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.annotations.CreationTimestamp;

@Entity
public class Task implements Comparable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotBlank(message = "Name cannot be blank")
    @Size(max = 100, message = "Name can be up to 100 characters")
    String name;
    
    // @Column(columnDefinition = "integer default 5")
    // Integer priority = 5;

    @Enumerated(EnumType.STRING)
    private Priority priority = Priority.LOW;
    
    @CreationTimestamp
    Instant createdAt;

    @UpdateTimestamp
    Instant updatedAt;

    // Instant completeBy;
    
    // @Column(columnDefinition = "boolean default false")
    Boolean isCompleted = false;
    
    
    // Default constructor required by Hibernate
    public Task() {}
    
    // public Task(Long id, String name, Integer priority, LocalDateTime completeBy) {
    public Task(Long id, String name, Priority priority) {
        this.id = id;
        this.name = name;
        this.priority = priority;
        // this.completeBy = completeBy;
    }
    
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public Priority getPriority() {
        return priority;
    }
    
    public void setPriority(Priority priority) {
        this.priority = priority;
    }
    
    // public LocalDateTime getCompleteBy() {
    //     return completeBy;
    // }
    
    // public void setCompleteBy(LocalDateTime completeBy) {
    //     this.completeBy = completeBy;
    // }
    
    public Boolean getIsCompleted() {
        return isCompleted;
    }

    public void setIsCompleted(Boolean isCompleted) {
        this.isCompleted = isCompleted;
    }

    @Override
    public int compareTo(Object other) {
        Task otherTask = (Task)other;
        return this.priority.getLevel() - otherTask.priority.getLevel();
    }
}
