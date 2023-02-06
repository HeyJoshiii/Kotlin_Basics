package com.example.kotlinbasics.ui.theme

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.kotlinbasics.shared.loginInfo
import com.example.kotlinbasics.shared.setLoginInfo

@Composable
fun ProfileScreen(
    modifier: Modifier,
    context: Context,
    onLogoutButtonClicked: () -> Unit = {}
) {
    val (storedUsername, storedPassword) = loginInfo()
    val username = remember { mutableStateOf(storedUsername) }
    val password = remember { mutableStateOf(storedPassword) }

    Scaffold(
        topBar = {
            ProfileAppBar(modifier = modifier,
            )
        },
        content = {
            Column(
                modifier = modifier.padding(28.dp)
            ) {
                Text(text = "Username: $storedUsername")

                Spacer(modifier = Modifier.height(10.dp))

                OutlinedTextField(
                    modifier = Modifier.fillMaxWidth(),
                    value = username.value,
                    onValueChange = { text -> username.value = text },
                    label = { Text(text = "New username") },
                    shape = RoundedCornerShape(corner = CornerSize(20.dp))
                )

                Spacer(modifier = Modifier.height(10.dp))

                Button(
                    modifier = Modifier
                        .height(60.dp),
                    onClick = {
                        if (username.value != storedUsername) {
                            setLoginInfo(username.value, storedPassword)
                            Toast.makeText(context,
                                "Username changed!", Toast.LENGTH_SHORT).show()
                        } else {
                            Toast.makeText(context,
                                "Please type in a new username!", Toast.LENGTH_SHORT).show()
                        }
                    },
                    shape = RoundedCornerShape(corner = CornerSize(20.dp)),
                ) {
                    Text(text = "Change Username")
                }

                Spacer(modifier = Modifier.height(15.dp))

                OutlinedTextField(
                    modifier = Modifier.fillMaxWidth(),
                    value = password.value,
                    onValueChange = { text -> password.value = text },
                    label = { Text(text = "New password") },
                    visualTransformation = PasswordVisualTransformation(),
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                    shape = RoundedCornerShape(corner = CornerSize(20.dp))
                )

                Spacer(modifier = Modifier.height(10.dp))

                Button(
                    modifier = Modifier
                        .height(60.dp),
                    onClick = {
                        if (password.value != storedPassword) {
                            setLoginInfo(storedUsername, password.value)
                            Toast.makeText(context,
                                "Password changed!", Toast.LENGTH_SHORT).show()
                        } else {
                            Toast.makeText(context,
                                "Please type in a new password!", Toast.LENGTH_SHORT).show()
                        }
                    },
                    shape = RoundedCornerShape(corner = CornerSize(20.dp)),
                ) {
                    Text(text = "Change Password")
                }

                Spacer(modifier = Modifier.height(15.dp))

                Button(
                    modifier = Modifier
                        .height(60.dp),
                    onClick = onLogoutButtonClicked,
                    shape = RoundedCornerShape(corner = CornerSize(20.dp)),
                ) {
                    Text(text = "Logout")
                }
            }
        }
    )
}

@Composable
fun ProfileAppBar(modifier: Modifier) {
    Column(

    ) {
        Row(
            modifier = modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                modifier = modifier.padding(20.dp),
                fontSize = 24.sp,
                text = "Profile"
            )
            Icon(
                modifier = modifier
                    .padding(8.dp)
                    .size(60.dp),
                painter = rememberVectorPainter(Icons.Filled.Person),
                contentDescription = "profile_image"
            )
        }
            Divider(color = Color.Blue, thickness = 1.dp)
    }
}