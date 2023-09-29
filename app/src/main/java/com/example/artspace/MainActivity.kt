package com.example.artspace

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.artspace.ui.theme.ArtSpaceTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArtSpaceTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ArtSpaceScreen()
                }
            }
        }
    }
}

data class ArtworkInfo(val title: Int, val year: Int, val description: Int, val image: Int)

@Composable
fun ArtSpaceScreen(modifier: Modifier = Modifier) {

    var currentArtwork by remember { mutableStateOf(1) }

    val artworkInfo = when (currentArtwork) {
        1 -> ArtworkInfo(
            R.string.bale,
            R.string.bale_year,
            R.string.bale_description,
            R.drawable.bale
        )

        2 -> ArtworkInfo(
            R.string.neymar,
            R.string.neymar_year,
            R.string.neymar_description,
            R.drawable.neymar
        )

        3 -> ArtworkInfo(
            R.string.salah,
            R.string.salah_year,
            R.string.salah_description,
            R.drawable.salah
        )

        4 -> ArtworkInfo(
            R.string.kane,
            R.string.kane_year,
            R.string.kane_description,
            R.drawable.kane
        )

        5 -> ArtworkInfo(
            R.string.messi,
            R.string.messi_year,
            R.string.messi_description,
            R.drawable.messi
        )

        6 -> ArtworkInfo(
            R.string.modric,
            R.string.modric_year,
            R.string.modirc_description,
            R.drawable.modric
        )

        7 -> ArtworkInfo(
            R.string.cristiano,
            R.string.cristiano_year,
            R.string.cristiano_description,
            R.drawable.cristiano
        )

        8 -> ArtworkInfo(
            R.string.benzema,
            R.string.benzema_year,
            R.string.benzema_description,
            R.drawable.benzema
        )

        9 -> ArtworkInfo(
            R.string.kevin,
            R.string.kevin_year,
            R.string.kevin_description,
            R.drawable.kevin
        )

        else -> ArtworkInfo(
            R.string.mbappe,
            R.string.mbappe_year,
            R.string.mbappe_description,
            R.drawable.mbappe
        )
    }


    val incrementArtwork: () -> Unit = {
        currentArtwork = (currentArtwork % 10) + 1
    }

    val decreaseArtwork: () -> Unit = {
        if (currentArtwork > 1) {
            currentArtwork -= 1
        }
    }

    val restartArtwork: () -> Unit = {
        currentArtwork = 1
    }

    Column(
        modifier = modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Spacer(
            modifier = modifier.size(30.dp)
        )

        Text(
            text = stringResource(R.string.my_name),
            fontSize = 15.sp,
            fontStyle = FontStyle.Italic
        )

        Spacer(
            modifier = modifier.size(16.dp)
        )

        ArtworkImage(
            currentArtwork = artworkInfo.image
        )
        Spacer(
            modifier = modifier.size(16.dp)
        )
        ArtworkTitle(
            title = artworkInfo.title,
            year = artworkInfo.year,
            description = artworkInfo.description,
        )
        Spacer(
            modifier = modifier.size(45.dp)
        )
        Row(
            modifier = modifier
                .padding(horizontal = 10.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {

            Button(
                onClick = decreaseArtwork,

                colors = ButtonDefaults.buttonColors(containerColor = colorResource(id = R.color.blue_700)),

                modifier = Modifier.width(125.dp),
                elevation = ButtonDefaults.elevatedButtonElevation(
                    defaultElevation = 1.dp,
                    pressedElevation = 0.dp,
                    focusedElevation = 0.dp,
                )
            ) {
                Text(
                    text = stringResource(R.string.previous),
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Medium,
                    color = colorResource(id = R.color.white)
                )
            }

            IconButton(
                onClick = restartArtwork,
                modifier = Modifier
                    .size(55.dp)
                    .clip(CircleShape)
                    .background(colorResource(id = R.color.blue_700))
                    .padding(8.dp),
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.reiniciar),
                    contentDescription = null,
                    tint = colorResource(id = R.color.white)
                )
            }

            Button(
                onClick = incrementArtwork,
                colors = ButtonDefaults.buttonColors(containerColor = colorResource(id = R.color.blue_700)),
                modifier = Modifier.width(125.dp),
                elevation = ButtonDefaults.elevatedButtonElevation(
                    defaultElevation = 1.dp,
                    pressedElevation = 0.dp,
                    focusedElevation = 0.dp
                ),
            ) {
                Text(
                    text = stringResource(R.string.next),
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Medium,
                    color = colorResource(id = R.color.white)
                )
            }
        }
        Spacer(
            modifier = modifier.size(30.dp)
        )
    }
}

@Composable
fun ArtworkImage(
    modifier: Modifier = Modifier,
    @DrawableRes currentArtwork: Int
) {
    Image(
        painter = painterResource(id = currentArtwork),
        contentDescription = null,
        contentScale = ContentScale.FillBounds,
        modifier = modifier
            .size(350.dp)
            .clip(CircleShape)
            .border(
                10.dp, Color.Blue,
                CircleShape
            )
            .background(Color.Gray)
    )
}

@Composable
fun ArtworkTitle(
    @StringRes title: Int,
    @StringRes year: Int,
    @StringRes description: Int,
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(5.dp)
    ) {
        Text(
            text = stringResource(id = title),
            fontWeight = FontWeight.Bold,
            color = colorResource(id = R.color.azul),
            fontSize = 32.sp,
        )

        Text(
            text = stringResource(id = year),
            fontWeight = FontWeight.Medium,
            color = colorResource(id = R.color.blue_300),
            fontSize = 16.sp,
        )
        Text(
            text = stringResource(id = description),
            fontWeight = FontWeight.Normal,
            color = colorResource(id = R.color.gris),
            fontSize = 12.sp,
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ArtSpaceTheme {
        ArtSpaceScreen()
    }
}

