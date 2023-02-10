package com.example.contactsroomjc

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.contactsroomjc.dao.ContactDao
import com.example.contactsroomjc.model.Contact
import kotlinx.coroutines.launch

class MainActivityViewModel(private val contactDao: ContactDao): ViewModel() {

    private fun insertContact(contact: Contact) {
        viewModelScope.launch {
            contactDao.insert(contact)
        }
    }

    private fun getNewContactEntry(name: String, email: String, birthDay: String): Contact {
        return Contact(
            name = name,
            email = email,
            birthDay = birthDay
        )
    }

    fun addNewContact(name: String, email: String, birthDay: String) {
        val newContact = getNewContactEntry(name, email, birthDay)
        insertContact(newContact)
    }

}

class MainActivityViewModelProvider(private val contactDao: ContactDao): ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(MainActivityViewModel::class.java)){
            return MainActivityViewModel(contactDao) as T
        }
        throw IllegalArgumentException("Unknow Viewmodel Class")
    }

}