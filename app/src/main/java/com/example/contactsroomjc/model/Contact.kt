package com.example.contactsroomjc.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(
    tableName = "contact"
)
data class Contact(
    @PrimaryKey(autoGenerate = true) var id: Long = 0L,
    var name: String,
    var email: String,
    var birthDay: String
)