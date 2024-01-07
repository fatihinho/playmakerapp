package com.fcinar.playmakerapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.fcinar.playmakerapp.screen.LoginScreen
import com.fcinar.playmakerapp.ui.theme.PlayMakerAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PlayMakerAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    /*val db = Firebase.firestore
                    val user = hashMapOf(
                        "first" to "Fatih",
                        "last" to "Çınar",
                        "born" to 1998,
                    )
                    db.collection("users")
                        .add(user)
                        .addOnSuccessListener { documentReference ->
                            Log.d(TAG, "DocumentSnapshot added with ID: ${documentReference.id}")
                        }
                        .addOnFailureListener { e ->
                            Log.w(TAG, "Error adding document", e)
                        }*/

                    AuthNavHost(navController = rememberNavController())
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun AppPreview() {
    PlayMakerAppTheme {
        LoginScreen(navController = rememberNavController())
    }
}