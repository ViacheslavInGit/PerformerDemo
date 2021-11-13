package com.viapp.b.performer.data.repository

import com.viapp.b.domain.entity.Task
import com.viapp.b.domain.repository.TaskRepository

internal class TaskRepositoryImpl : TaskRepository {

    override suspend fun save(task: Task) {

    }

    override suspend fun getTaskList(): List<Task> {
        return emptyList()
    }
}