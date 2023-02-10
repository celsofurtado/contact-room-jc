package com.example.contactsroomjc

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.contactsroomjc.dao.ContactRoomDatabase
import com.example.contactsroomjc.ui.theme.ContactsRoomJCTheme

class MainActivity : ComponentActivity() {

    val database: ContactRoomDatabase by lazy {
        ContactRoomDatabase.getDatabase(this)
    }

    private val viewModel: MainActivityViewModel by activityViewModels {

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ContactsRoomJCTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Greeting("Android")
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Box(
        modifier = Modifier.padding(32.dp),
        contentAlignment = Alignment.Center
    ) {
        Button(onClick = {

        },
            modifier = Modifier
                .fillMaxWidth()) {
            Text(text = "Executar $name",
                modifier = Modifier
                    .padding(vertical = 24.dp)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ContactsRoomJCTheme {
        Greeting("Android")
    }
}