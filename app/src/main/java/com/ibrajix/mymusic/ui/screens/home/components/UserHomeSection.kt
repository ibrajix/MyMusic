package com.ibrajix.mymusic.ui.screens.home.components

import android.content.Intent
import android.net.Uri
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat
import com.ibrajix.mymusic.R
import com.ibrajix.mymusic.ui.theme.ManRope
import com.ibrajix.mymusic.utils.Constants.IBRAJIX
import com.ibrajix.mymusic.utils.Constants.MY_URL

@Composable
fun UserHomeSection(modifier: Modifier = Modifier) {

    Row(
        modifier = modifier
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {

        Image(
            modifier = modifier
                .size(60.dp)
                .clip(CircleShape),
            painter = painterResource(id = R.drawable.ic_profile_pic), contentDescription = stringResource(
                id = R.string.icon_screen_reader
            ),
            contentScale = ContentScale.Crop
        )

        Column(
            modifier = modifier
                .weight(1f)
                .padding(start = 10.dp),
            verticalArrangement = Arrangement.Center,
        ) {

            Text(
                text = stringResource(id = R.string.hello),
                style = MaterialTheme.typography.body2,
                color = MaterialTheme.colors.onSecondary
            )

            Text(
                text = stringResource(id = R.string.ibrahim),
                style = MaterialTheme.typography.h3,
                color = MaterialTheme.colors.onSecondary
            )

        }

        Box(
            modifier = Modifier
                .size(40.dp)
                .border(1.dp, Color.Gray, RoundedCornerShape(20.dp)),
        ){
            Image(
                modifier = modifier
                    .size(30.dp)
                    .align(Alignment.Center),
                painter = painterResource(id = R.drawable.ic_bell), contentDescription = stringResource(
                    id = R.string.icon_screen_reader
                )
            )
        }
    }

    val annotatedString = buildAnnotatedString {

        append(stringResource(id = R.string.welcome_to_my_music))

        pushStringAnnotation(
            annotation = MY_URL,
            tag = IBRAJIX
        )

        withStyle(
            style = SpanStyle(
                color = MaterialTheme.colors.primary,
                fontSize = 21.sp,
                fontFamily = ManRope,
                fontWeight = FontWeight.Bold,
                textDecoration = TextDecoration.Underline
            )
        ) {
            append(" ")
            append(stringResource(id = R.string.ibrajix))
        }
        pop()
    }

    val context = LocalContext.current

    ClickableText(
        modifier = modifier
            .width(500.dp)
            .padding(top = 24.dp),
        text = annotatedString,
        onClick = { offset->
            annotatedString.getStringAnnotations(tag = IBRAJIX, start = offset, end = offset)
                .firstOrNull()?.let { annotation->

                    //on click my name, open browser intent
                    val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse(annotation.item))
                    ContextCompat.startActivity(context, browserIntent, null)

                }
        },
        style = TextStyle(
            color = MaterialTheme.colors.onSecondary,
            fontSize = 21.sp,
            fontFamily = ManRope,
            fontWeight = FontWeight.Bold
        )
    )



}