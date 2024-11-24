package com.example.login

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.semantics.Role.Companion.Checkbox
import androidx.compose.ui.tooling.preview.Preview

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApp {
                MainScreen()
            }
        }
    }
}

@Composable
fun MyApp(content: @Composable () -> Unit) {
    MaterialTheme(
        colorScheme = lightColorScheme(
            primary = Color(0xFFFFC0CB), // Cute pastel pink primary color
            onPrimary = Color.White,
            secondary = Color(0xFFFFA6C1), // Light pink for secondary elements
            onSecondary = Color.White,
            background = Color(0xFFFFE4E1), // Light pink background
            onBackground = Color(0xFFAD1457), // Dark pink text color
            surface = Color.White,
            onSurface = Color(0xFFAD1457) // Dark pink for text inside surface
        )
    ) {
        Surface(modifier = Modifier.fillMaxSize()) {
            content()
        }
    }
}

@Composable
fun MainScreen() {
    var currentScreen by remember { mutableStateOf("Login") }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
    ) {
        when (currentScreen) {
            "Login" -> LoginScreen(
                onSignUpClick = { currentScreen = "SignUp" },
                onForgotPasswordClick = { currentScreen = "ForgotPassword" }
            )
            "ForgotPassword" -> ForgotPasswordScreen(
                onBackClick = { currentScreen = "Login" }
            )
            "SignUp" -> SignUpScreen(
                onBackClick = { currentScreen = "Login" }
            )
        }
    }
}

@Composable
fun LoginScreen(onSignUpClick: () -> Unit, onForgotPasswordClick: () -> Unit) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var passwordVisible by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .background(MaterialTheme.colorScheme.background),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        InputField(value = email, onValueChange = { email = it }, label = "Email")
        InputField(value = password, onValueChange = { password = it }, label = "Password", isPassword = true, passwordVisible = passwordVisible, onPasswordVisibilityChange = { passwordVisible = it })

        // Sign In button
        Button(
            onClick = {
                // Handle login logic
            },
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFFFA6C1)), // Cute pink button
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 16.dp)
        ) {
            Text("Sign In", color = Color(0xFFAD1457)) // Dark pink text in button
        }

        // Sign Up and Forgot Password links
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            TextButton(onClick = onSignUpClick) {
                Text("Sign Up", color = Color(0xFFAD1457)) // Dark pink text in text buttons
            }
            TextButton(onClick = onForgotPasswordClick) {
                Text("Forgot Password?", color = Color(0xFFAD1457)) // Dark pink text in text buttons
            }
        }
    }
}

@Composable
fun ForgotPasswordScreen(onBackClick: () -> Unit) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var confirmPassword by remember { mutableStateOf("") }
    var passwordVisible by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .background(MaterialTheme.colorScheme.background),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        InputField(value = email, onValueChange = { email = it }, label = "Email")
        InputField(value = password, onValueChange = { password = it }, label = "New Password", isPassword = true, passwordVisible = passwordVisible, onPasswordVisibilityChange = { passwordVisible = it })
        InputField(value = confirmPassword, onValueChange = { confirmPassword = it }, label = "Confirm Password", isPassword = true, passwordVisible = passwordVisible, onPasswordVisibilityChange = { passwordVisible = it })

        // Reset Password button
        Button(
            onClick = {
                // Handle forgot password logic
            },
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFFFA6C1)), // Cute pink button
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 16.dp)
        ) {
            Text("Reset Password", color = Color(0xFFAD1457)) // Dark pink text in button
        }

        // Back to login link
        TextButton(onClick = onBackClick) {
            Text("Back to Login", color = Color(0xFFAD1457)) // Dark pink text in text buttons
        }
    }
}

@Composable
fun Button(
    onClick: () -> Unit,
    colors: buttonColors,
    modifier: Modifier,
    content: @Composable () -> Unit
) {
    TODO("Not yet implemented")
}

@Composable
fun SignUpScreen(onBackClick: () -> Unit) {
    var firstName by remember { mutableStateOf("") }
    var lastName by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var confirmPassword by remember { mutableStateOf("") }
    var passwordVisible by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .background(MaterialTheme.colorScheme.background),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        InputField(value = firstName, onValueChange = { firstName = it }, label = "First Name")
        InputField(value = lastName, onValueChange = { lastName = it }, label = "Last Name")
        InputField(value = email, onValueChange = { email = it }, label = "Email")
        InputField(value = password, onValueChange = { password = it }, label = "Password", isPassword = true, passwordVisible = passwordVisible, onPasswordVisibilityChange = { passwordVisible = it })
        InputField(value = confirmPassword, onValueChange = { confirmPassword = it }, label = "Confirm Password", isPassword = true, passwordVisible = passwordVisible, onPasswordVisibilityChange = { passwordVisible = it })

        // Sign Up button
        Button(
            onClick = {
                // Handle sign up logic
            },
            colors = ButtonDefaults.buttonColors(containerColor = Color(270001)),
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 16.dp)
        ) {
            Text("Sign Up", color = Color(A6EFFF))
        }

        // Back to login link
        TextButton(onClick = onBackClick) {
            Text("Back to Login", color = Color(8CCF9D))
        }
    }
}

@Composable
fun InputField(
    value: String,
    onValueChange: (String) -> Unit,
    label: String,
    isPassword: Boolean = false,
    passwordVisible: Boolean = false,
    onPasswordVisibilityChange: (Boolean) -> Unit = {}
) {
    var textFieldValue by remember { mutableStateOf(value) }

    BasicTextField(
        value = textFieldValue,
        onValueChange = {
            textFieldValue = it
            onValueChange(it)
        },
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        singleLine = true,
        visualTransformation = if (isPassword && !passwordVisible) PasswordVisualTransformation() else VisualTransformation.None,
        decorationBox = { innerTextField ->
            Box(modifier = padding(10.dp).fillMaxWidth()) {
                if (textFieldValue.isEmpty()) {
                    Text(label, fontSize = 16.sp, color = Color.Gray)
                }
                innerTextField()
            }
        }
    )

    // Show password checkbox for password fields
    if (isPassword) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Checkbox(checked = passwordVisible, onCheckedChange = { onPasswordVisibilityChange(it) })
            Text("Show Password", color = Color(0xFFAD1457)) // Dark pink text for the password toggle
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewMainScreen() {
    MyApp {
        MainScreen()
    }
}