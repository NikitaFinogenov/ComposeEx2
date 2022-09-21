package com.example.composeex2

import android.graphics.Color.*
import android.nfc.cardemulation.CardEmulation
import android.os.Bundle
import androidx.compose.ui.graphics.Color.Companion.Gray
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.spring
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.AbsoluteRoundedCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Blue
import androidx.compose.ui.graphics.Color.Companion.Gray
import androidx.compose.ui.graphics.Color.Companion.Green
import androidx.compose.ui.graphics.Color.Companion.Yellow
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.modifier.modifierLocalOf
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composeex2.ui.theme.ComposeEx2Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)



        setContent {
            ComposeEx2Theme {

                // A surface container using the 'background' color from the theme
                LazyColumn () {
                    items(100) {

                        CardWithMultipleViews("$it") // it - индекс, поскольку это единственный аргумент лямбды
                    }
                }


                }

                }
            }
        }




@Composable
fun CardWithMultipleViews(string: String) {

    Modifier.padding(10.dp)
    var hidden by remember{ mutableStateOf(true) }
    val modOne = Modifier
        .padding(10.dp)
        .fillMaxWidth()
    val modTwo = Modifier
        .padding(10.dp)
        .clip(RoundedCornerShape(10.dp))


    Card(
        elevation = 40.dp,
        modifier = modTwo,
    )
     {
        Column(modifier = modOne, horizontalAlignment = Alignment.CenterHorizontally) {
            Row(modifier = modOne, horizontalArrangement = Arrangement.SpaceBetween) {
                Column() {
                    Text(text = "Hello,", fontSize = 18.sp)
                    Text(text = "$string", fontSize = 42.sp, style = MaterialTheme.typography.h4, fontWeight = FontWeight.Bold)
                }
                Button(onClick = { hidden = !hidden } ){
                    if (hidden == true){Text(text = "Show More", fontSize = 14.sp)}

                    if (hidden == false) {Text(text = "Show Less", fontSize = 14.sp)}
                }

            }
            if (!hidden){

                Text(text = "Lorem ipsum dolor sit amet, consectetur " +
                        "adipiscing elit. Ut lectus elit, varius ac felis at, congue pulvinar" +
                        " lorem. Curabitur fringilla faucibus laoreet. " +
                        "Proin vitae augue.", fontSize = 16.sp)
            }
        }

    }
}


@Composable
fun OnboardingScreen() {
    // TODO: Это состояние должно быть поднято
    var shouldShow by remember { mutableStateOf(true) }

    Surface {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text("Welcome to the Basics Codelab!")
            Button(
                modifier = Modifier.padding(vertical = 24.dp),
                onClick = { shouldShow = false }
            ) {
                Text("Continue")
            }
        }
    }
}



@Preview(showBackground = true, widthDp = 320, heightDp = 320)
@Composable
fun OnboardingPreview() {
    ComposeEx2Theme() {
        OnboardingScreen()
    }
    
}





