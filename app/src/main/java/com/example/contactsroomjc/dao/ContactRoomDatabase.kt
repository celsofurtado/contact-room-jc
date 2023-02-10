package com.example.contactsroomjc.dao

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.contactsroomjc.model.Contact

@Database(
    entities = [Contact::class],
    version = 1,
    exportSchema = false
)
abstract class ContactRoomDatabase: RoomDatabase() {

    abstract fun contactDao(): ContactDao

    companion object{

        @Volatile
        private var INSTANCE: ContactRoomDatabase? = null

        fun getDatabase(context: Context): ContactRoomDatabase {

            return INSTANCE ?: synchronized(this) {
                val instance = Room
                    .databaseBuilder(
                    context = context.applicationContext,
                    klass = ContactRoomDatabase::class.java,
                    name = "contact_db"
                )
                    .fallbackToDestructiveMigration()
                    .build()

                INSTANCE = instance

                return instance
            }

        }

    }

}