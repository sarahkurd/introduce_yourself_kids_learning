package com.example.introduce_yourself.ui.screens

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ButtonElevation
import androidx.compose.material3.Card
import androidx.compose.material3.CardElevation
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.introduce_yourself.ui.theme.Inrtoduce_yourselfTheme

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun GameScreen(gameViewModel: GameViewModel = viewModel()) {
    val gameUiState by gameViewModel.uiState.collectAsState()

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.padding(vertical = 50.dp)
    ) {
        Text(
            text = "Introduce",
            style = MaterialTheme.typography.titleLarge,
            fontSize = 60.sp,
            overflow = TextOverflow.Visible,
            softWrap = true
        )
        Text(
            text = "Yourself!",
            style = MaterialTheme.typography.titleLarge,
            fontSize = 60.sp,
            overflow = TextOverflow.Visible,
            softWrap = true
        )
    }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        ElevatedCard(
            modifier = Modifier.padding(vertical = 20.dp)
        ) {
            Text(
                text = gameUiState.currentWord,
                style = MaterialTheme.typography.titleLarge,
                fontSize = 80.sp,
                modifier = Modifier.padding(horizontal = 10.dp, vertical = 10.dp)
            )
        }
        Row {
            Button(
                onClick = { gameViewModel.moveOne() },
                elevation = ButtonDefaults.elevatedButtonElevation(
                    defaultElevation = 10.dp
                ),
                modifier = Modifier
                    .padding(10.dp)
                    .width(100.dp)
            ) {
                Text(
                    text = "+1",
                    fontSize = 20.sp
                )
            }
            Button(
                onClick = { gameViewModel.moveThree() },
                elevation = ButtonDefaults.elevatedButtonElevation(
                    defaultElevation = 10.dp
                ),
                modifier = Modifier
                    .padding(10.dp)
                    .width(100.dp)
            ) {
                Text(
                    text = "+3",
                    fontSize = 20.sp
                )
            }
        }
        Row {
            Button(
                onClick = { gameViewModel.backOne() },
                elevation = ButtonDefaults.elevatedButtonElevation(
                    defaultElevation = 10.dp
                ),
                modifier = Modifier
                    .padding(10.dp)
                    .width(100.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color.Red)
            ) {
                Text(
                    text = "-1",
                    fontSize = 20.sp
                )
            }
            Button(
                onClick = { gameViewModel.backThree() },
                elevation = ButtonDefaults.elevatedButtonElevation(
                    defaultElevation = 10.dp
                ),
                modifier = Modifier
                    .padding(10.dp)
                    .width(100.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color.Red)
            ) {
                Text(
                    text = "-3",
                    fontSize = 20.sp
                )
            }
        }
    }

}

@Preview
@Composable
fun GameScreenPreview() {
    Inrtoduce_yourselfTheme {
        // A surface container using the 'background' color from the theme
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            GameScreen()
        }
    }
}