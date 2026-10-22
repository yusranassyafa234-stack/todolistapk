package com.example.to_dolist.model

import java.util.UUID

enum class Priority(val label: String) {
    TINGGI("Tinggi"),
    SEDANG("Sedang"),
    RENDAH("Rendah")
}

data class TodoItem(
    val id: String = UUID.randomUUID().toString(),
    val title: String,
    val description: String = "",
    val category: String = "Kuliah",
    val priority: Priority = Priority.SEDANG,
    val isCompleted: Boolean = false,
    val createdAt: Long = System.currentTimeMillis()
)
