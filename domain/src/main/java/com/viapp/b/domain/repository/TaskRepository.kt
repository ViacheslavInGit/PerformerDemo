package com.viapp.b.domain.repository

import com.viapp.b.domain.entity.Task

interface TaskRepository {

    /**
     * insert if task with this [Task.id] doesn`t exist
     * update if exist
     */
    suspend fun save(task: Task)

    /**
     * return main (root) tasks, witch contain child tasks
     */
    suspend fun getTaskList(): List<Task>
}