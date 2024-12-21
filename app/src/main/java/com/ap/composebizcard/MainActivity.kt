package com.ap.composebizcard

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text


import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ap.composebizcard.ui.theme.JetBizCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()
        setContent {
            JetBizCardTheme {
//                Scaffold(
//                    topBar =
//                    { TopAppBar(
//                        title = { Text("Compose BizCard App", color = Color.White) },
//                        modifier = Modifier.background(Color.Blue)
//                    )
//                }, content = {
                Surface(color = MaterialTheme.colors.background) {
                    CreateBizCard()
                }
//                    })

            }
        }
    }
}

@Composable
 fun CreateBizCard() {
    val buttonClickedState = remember {
        mutableStateOf(false)
    }
    Surface( modifier = Modifier
        .fillMaxWidth()
        .fillMaxHeight()) {
        Card(modifier = Modifier
            .width(200.dp)
            .height(390.dp)
            .padding(12.dp),
            shape = RoundedCornerShape(corner = CornerSize(15.dp)),
            elevation = 4.dp) {
            Column(modifier = Modifier.height(300.dp),
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally) {
                CreateImageProfile()
                Divider()
                CreateInfo()
                Button(
                    onClick = {
                        buttonClickedState.value = !buttonClickedState.value
                    }
                ) {
                    Text("Portfolio",
                        style = MaterialTheme.typography.button)
                }
                if (buttonClickedState.value) {
                    Content()
                }else {
                    Box {}
                }
            }
        }
    }
}


@Composable
fun Content(){
    Box(modifier = Modifier
        .fillMaxWidth()
        .fillMaxHeight()
        .padding(5.dp)){
        Surface(modifier = Modifier
            .padding(3.dp)
            .fillMaxWidth()
            .fillMaxHeight(),
            shape = RoundedCornerShape(
                corner = CornerSize(6.dp)),
            border = BorderStroke(.5.dp,
                color = Color.LightGray)
        ) {
            Portfolio(data = listOf("Project 1","Project 2","Project 3","Project 4"))
        }
    }
}

@Composable
fun Portfolio(data: List<String>) {
    LazyColumn {
        items(data){item ->
//            Text(item)
            Card(modifier = Modifier
                .padding(10.dp)
                .fillMaxWidth(),
                shape = RoundedCornerShape(5.dp),
                ) {
                Row(modifier = Modifier 
                    .padding(10.dp)
                    .background(MaterialTheme.colors.surface)
                    .padding(7.dp)) {
                    CreateImageProfile(modifier = Modifier.size(100.dp))
                    Column(modifier = Modifier.fillMaxWidth()
                        .padding(10.dp)
                        .align(Alignment.CenterVertically))  {
                        Text(text = item, modifier = Modifier.padding(10.dp))
                        Text(text = "Compose List", modifier = Modifier.padding(2.dp))
                    }

                }
            }
        }
    }
}

@Composable
private fun CreateInfo() {
    Column(modifier = Modifier.padding(5.dp), horizontalAlignment = Alignment.CenterHorizontally) {
        Text(
            text = "Amit Desale",
            modifier = Modifier.padding(5.dp),
            style = MaterialTheme.typography.h4,
            color = MaterialTheme.colors.primary
        )
        Text(text = "Senior Android Developer")
        Text(
            text = "@AGP Consultancy Services",
            modifier = Modifier.padding(5.dp),
            style = MaterialTheme.typography.subtitle1
        )
    }
}

@Composable
private fun CreateImageProfile(modifier: Modifier = Modifier) {
    Surface(modifier = modifier
        .size(150.dp)
        .padding(5.dp),
        shape = CircleShape,
        border = BorderStroke(0.5.dp, Color.LightGray),
        elevation = 4.dp,
        color = MaterialTheme.colors.onSurface.copy(alpha = 0.5f)) {

        Image(painter = painterResource(id = R.drawable.profile_image),
            contentDescription = "profile image",
            modifier = modifier.size(135.dp),
            contentScale = ContentScale.Crop)
    }
}

@Preview
@Composable
fun CreateBizCardPreview(){
    Surface (modifier = Modifier
        .fillMaxHeight()
        .fillMaxWidth()){
    }
}
//@Preview(showBackground = true)
//@Composable
//fun GreetingPreview() {
//    ComposeBizCardTheme {
//        Greeting("Android")
//    }
//}