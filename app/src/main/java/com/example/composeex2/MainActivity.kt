package com.example.composeex2

import android.graphics.Color.*
import android.nfc.cardemulation.CardEmulation
import android.os.Bundle
import androidx.compose.ui.graphics.Color.Companion.Gray
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.spring
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.AbsoluteRoundedCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExpandLess
import androidx.compose.material.icons.filled.ExpandMore
import androidx.compose.runtime.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Blue
import androidx.compose.ui.graphics.Color.Companion.Gray
import androidx.compose.ui.graphics.Color.Companion.Green
import androidx.compose.ui.graphics.Color.Companion.Yellow
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.modifier.modifierLocalOf
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composeex2.ui.theme.ComposeEx2Theme
import com.example.composeex2.ui.theme.LightBlue
import com.example.composeex2.ui.theme.Navy

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)



        setContent {
            ComposeEx2Theme {

                MyApp()


                // A surface container using the 'background' color from the theme


            }

        }
    }
}


@Composable
fun MyApp() {

    var shouldShowOnboarding by rememberSaveable { mutableStateOf(true) }

    if (shouldShowOnboarding) {
        OnboardingScreen(onContinueClicked = { shouldShowOnboarding = false })
    } else {

        LazyColumn() {
            items(100) {

                CardWithMultipleViews("$it") // it - индекс, поскольку это единственный аргумент лямбды
            }
        }

    }
}

@Composable
fun OnboardingScreen(onContinueClicked: () -> Unit) {

    Surface {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text("Welcome to the Basics Codelab!")
            Button(
                modifier = Modifier.padding(vertical = 24.dp),
                onClick = onContinueClicked
            ) {
                Text("Continue")
            }
        }
    }
}

@Composable
fun CardWithMultipleViews(string: String) {

    Modifier.padding(10.dp)
    var hidden by rememberSaveable { mutableStateOf(true) }
    val modBut = Modifier
        .padding(horizontal = 5.dp)
    val modRow = Modifier
        .fillMaxWidth()
    val modText = Modifier
        .padding(vertical = 5.dp, horizontal = 10.dp)
    val modOne = Modifier
        .padding(10.dp)
        .fillMaxWidth()
    val modTwo = Modifier
        .padding(horizontal = 10.dp, vertical = 5.dp)
        .clip(RoundedCornerShape(16.dp))


    Card(
        modifier = modTwo
    )
    {

        Column(modifier = modOne, horizontalAlignment = Alignment.CenterHorizontally) {
            Row(modifier = modRow, horizontalArrangement = Arrangement.SpaceBetween) {
                Column() {
                    Text(text = "Hello,", fontSize = 18.sp, modifier = modText)
                    Text(
                        text = "$string",
                        fontSize = 42.sp,
                        style = MaterialTheme.typography.h4,
                        fontWeight = FontWeight.Bold,
                        modifier = modText
                    )
                }
                IconButton(onClick = { hidden = !hidden }, modifier = modBut) {
                    if (hidden == true) {
                        Icon(
                            imageVector = Icons.Filled.ExpandLess, contentDescription =
                            stringResource(R.string.app_name)
                        )
                    }

                    if (hidden == false) {
                        Icon(
                            imageVector = Icons.Filled.ExpandMore,
                            contentDescription = stringResource(R.string.app_name)
                        )
                    }
                }

            }
            AnimatedVisibility(!hidden) {

                Text(
                    text = "Lorem ipsum dolor sit amet, consectetur " +
                            "adipiscing elit. Ut lectus elit, varius ac felis at, congue pulvinar" +
                            " lorem. Curabitur fringilla faucibus laoreet. " +
                            "Proin vitae augue.", fontSize = 20.sp
                )
            }

        }


    }
}








