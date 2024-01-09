package com.fcinar.playmakerapp.screen

import android.content.ContentValues
import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.fcinar.playmakerapp.Destinations
import com.fcinar.playmakerapp.R
import com.fcinar.playmakerapp.entity.User
import com.fcinar.playmakerapp.service.UserService
import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.launch
import java.util.UUID

@Composable
@OptIn(ExperimentalComposeUiApi::class)
fun LoginScreen(navController: NavController) {
    val scope = rememberCoroutineScope()
    val snackbarHostState = remember { SnackbarHostState() }
    val keyboardController = LocalSoftwareKeyboardController.current

    val userService = UserService()
    val auth = FirebaseAuth.getInstance()

    val enterUsernameMessage = stringResource(id = R.string.at_least_4_char_enter_username)

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        snackbarHost = {
            SnackbarHost(hostState = snackbarHostState)
        },
        content = { it ->
            Box(
                Modifier
                    .fillMaxSize()
                    .padding(it),
                contentAlignment = Center
            ) {
                Column(
                    modifier = Modifier.padding(20.dp),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {

                    val username = remember { mutableStateOf(TextFieldValue()) }

                    Text(
                        text = "PlayMakerApp",
                        style = TextStyle(
                            fontSize = 50.sp,
                            color = Color.DarkGray,
                            fontWeight = FontWeight.ExtraBold,
                            fontFamily = FontFamily.Cursive
                        )
                    )

                    Spacer(modifier = Modifier.height(100.dp))
                    TextField(
                        label = { Text(text = stringResource(id = R.string.username)) },
                        value = username.value,
                        onValueChange = { username.value = it },
                        keyboardOptions = KeyboardOptions(
                            keyboardType = KeyboardType.Text,
                            imeAction = ImeAction.Done
                        ),
                    )

                    Spacer(modifier = Modifier.height(20.dp))
                    Box(modifier = Modifier.padding(40.dp, 0.dp, 40.dp, 0.dp)) {
                        Button(
                            onClick = {
                                if (username.value.text != "" && username.value.text.length >= 4) {
                                    auth.signInAnonymously().addOnCompleteListener {
                                        if (it.isSuccessful) {
                                            Log.d(ContentValues.TAG, "signInAnonymously:success")
                                            val authUID = it.result?.user?.uid!!
                                            val user = User(
                                                id = UUID.randomUUID().toString(),
                                                username = username.value.text
                                            )
                                            userService.saveUser(user, authUID)

                                            navController.navigate(Destinations.APP.route)
                                        } else {
                                            Log.w(
                                                ContentValues.TAG,
                                                "signInAnonymously:failure",
                                                it.exception
                                            )
                                        }
                                    }
                                } else {
                                    scope.launch {
                                        snackbarHostState.showSnackbar(enterUsernameMessage)
                                    }
                                }

                                keyboardController?.hide()
                            },
                            shape = RoundedCornerShape(50.dp),
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(50.dp)
                        ) {
                            Text(text = stringResource(id = R.string.login))
                        }
                    }
                }
            }
        })
}