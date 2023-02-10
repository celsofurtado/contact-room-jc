package com.example.contactsroomjc.dao

import androidx.room.*
import com.example.contactsroomjc.model.Contact
import kotlinx.coroutines.flow.Flow

@Dao
interface ContactDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(contact: Contact)

    @Update
    suspend fun update(contact: Contact)

    @Delete
    suspend fun delete(contact: Contact)

    @Query("SELECT * FROM contact WHERE id = :id")
    fun getContact(id: Int): Flow<Contact>

    @Query("SELECT * FROM contact ORDER BY name ASC")
    fun getContacts(): Flow<List<Contact>>

}