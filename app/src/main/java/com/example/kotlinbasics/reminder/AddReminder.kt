package com.example.kotlinbasics.reminder

import android.app.TimePickerDialog
import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.kotlinbasics.data.Reminder
import com.example.kotlinbasics.data.ReminderViewModel
import com.example.kotlinbasics.shared.setLoginInfo
import com.example.kotlinbasics.ui.theme.ProfileAppBar
import java.util.Calendar

@Composable
fun AddReminder(
    modifier: Modifier,
    context: Context,
    onBackButtonClicked: () -> Unit = {},
    viewModel: ReminderViewModel = hiltViewModel(),
) {
    val reminderContent = remember { mutableStateOf("") }
    val reminderTime = remember { mutableStateOf("") }

    Scaffold(
        topBar = {
            ProfileAppBar(modifier = modifier,
            )
        },
        content = {
            Column(
                modifier = modifier.padding(28.dp),
                verticalArrangement = Arrangement.Center
            ) {
                OutlinedTextField(
                    modifier = Modifier.fillMaxWidth(),
                    value = reminderContent.value,
                    onValueChange = { text -> reminderContent.value = text },
                    label = { Text(text = "Reminder title") },
                    shape = RoundedCornerShape(corner = CornerSize(20.dp))
                )

                Spacer(modifier = Modifier.height(10.dp))

                ShowTimePicker(context)

                /*OutlinedTextField(
                    modifier = Modifier.fillMaxWidth(),
                    value = reminderTime.value,
                    onValueChange = { text -> reminderTime.value = text },
                    label = { Text(text = "Set Time") },
                    visualTransformation = PasswordVisualTransformation(),
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                    shape = RoundedCornerShape(corner = CornerSize(20.dp))
                )*/

                Spacer(modifier = Modifier.height(10.dp))

                Button(
                    modifier = Modifier
                        .height(60.dp),
                    onClick = {
                            Toast.makeText(context,
                                "Created new reminder!", Toast.LENGTH_SHORT).show()
                              viewModel.saveReminder(
                                  Reminder(
                                      id = 0,
                                      message = reminderContent.value,
                                      location_x = 0,
                                      location_y = 0,
                                      reminder_time = 0,
                                      creation_time = 0,
                                      creator_id = 0,
                                      reminder_seen = false
                                  )
                              )
                    },
                    shape = RoundedCornerShape(corner = CornerSize(20.dp)),
                ) {
                    Text(text = "Add Reminder")
                }
                FloatingActionButton(
                    onClick = onBackButtonClicked,
                    contentColor = Color.Blue,
                    modifier = Modifier.padding(all = 20.dp)
                ) {
                    Icon(
                        imageVector = Icons.Default.ArrowBack,
                        contentDescription = null
                    )
                }
            }
        }
    )
}

@Composable
fun ShowTimePicker(context: Context) {

    val calendar = Calendar.getInstance()
    val hour = calendar[Calendar.HOUR_OF_DAY]
    val minute = calendar[Calendar.MINUTE]

    val time = remember { mutableStateOf("") }
    val timePickerDialog = TimePickerDialog(
        context, {
            _, hour: Int, minute: Int -> time.value = String.format("%02d:%02d", hour, minute)
        }, hour, minute, true
    )

    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.Start
    ) {
        Text(text = "Selected Time: ${time.value}", fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.size(16.dp))
        OutlinedButton(onClick = { timePickerDialog.show() }) {
            Text(text = "Select Time")
        }
    }
}
