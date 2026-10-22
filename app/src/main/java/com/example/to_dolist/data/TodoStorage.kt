package com.example.to_dolist.data

import android.content.Context
import com.example.to_dolist.model.Priority
import com.example.to_dolist.model.TodoItem
import org.json.JSONArray
import org.json.JSONObject

class TodoStorage(private val context: Context) {
    private val prefs = context.getSharedPreferences("todo_prefs", Context.MODE_PRIVATE)

    fun loadTodos(): List<TodoItem> {
        val jsonString = prefs.getString("todos_json", null)
        if (jsonString.isNullOrEmpty()) {
            val defaultList = listOf(
                TodoItem(
                    title = "Praktikum Pemrograman Mobile",
                    description = "Menyelesaikan aplikasi To-Do List dengan Kotlin",
                    category = "Kuliah",
                    priority = Priority.TINGGI,
                    isCompleted = true
                ),
                TodoItem(
                    title = "Menghubungkan HP ke Android Studio",
                    description = "Aktifkan USB Debugging dan tes instalasi aplikasi via ADB",
                    category = "Kuliah",
                    priority = Priority.TINGGI,
                    isCompleted = false
                ),
                TodoItem(
                    title = "Belajar Dasar Jetpack Compose",
                    description = "Mempelajari State, Column, Row, dan Material 3",
                    category = "Pribadi",
                    priority = Priority.SEDANG,
                    isCompleted = false
                ),
                TodoItem(
                    title = "Beli kuota internet untuk riset",
                    description = "Paket data untuk download modul kuliah",
                    category = "Pribadi",
                    priority = Priority.RENDAH,
                    isCompleted = false
                )
            )
            saveTodos(defaultList)
            return defaultList
        }

        val list = mutableListOf<TodoItem>()
        try {
            val jsonArray = JSONArray(jsonString)
            for (i in 0 until jsonArray.length()) {
                val obj = jsonArray.getJSONObject(i)
                val priorityStr = obj.optString("priority", Priority.SEDANG.name)
                val priority = try {
                    Priority.valueOf(priorityStr)
                } catch (e: Exception) {
                    Priority.SEDANG
                }

                list.add(
                    TodoItem(
                        id = obj.optString("id"),
                        title = obj.optString("title"),
                        description = obj.optString("description"),
                        category = obj.optString("category", "Kuliah"),
                        priority = priority,
                        isCompleted = obj.optBoolean("isCompleted", false),
                        createdAt = obj.optLong("createdAt", System.currentTimeMillis())
                    )
                )
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return list
    }

    fun saveTodos(todos: List<TodoItem>) {
        val jsonArray = JSONArray()
        for (item in todos) {
            val obj = JSONObject()
            obj.put("id", item.id)
            obj.put("title", item.title)
            obj.put("description", item.description)
            obj.put("category", item.category)
            obj.put("priority", item.priority.name)
            obj.put("isCompleted", item.isCompleted)
            obj.put("createdAt", item.createdAt)
            jsonArray.put(obj)
        }
        prefs.edit().putString("todos_json", jsonArray.toString()).apply()
    }
}
