package com.example.kmmtemplate.domain.repository

import com.example.kmmtemplate.domain.entity.Task

interface TaskRepository {

    /**
     * return main (root) tasks, witch contain child tasks
     */
    suspend fun getTaskList(): List<Task>
}