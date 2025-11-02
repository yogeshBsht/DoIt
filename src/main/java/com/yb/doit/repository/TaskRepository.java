package com.yb.doit.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.yb.doit.entity.Task;

public interface TaskRepository extends CrudRepository<Task, Long> {
    // public List<Course> findByTopicId(Long topicId);
    // public boolean existsByTopicAndNameAndDescription(Topic topic, String name,
    // String description);
    // public List<Task> findAllByOrderByPriorityAsc();
}
