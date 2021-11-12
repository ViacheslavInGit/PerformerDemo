package com.viapp.b.data.repository

import com.example.kmmtemplate.domain.entity.Task

interface TaskRepositoryImpl {

    /**
     * return main (root) tasks, witch contain child tasks
     */
    suspend fun getTaskList(): List<Task>
}