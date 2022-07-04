package com.ibrajix.mymusic.ui.screens.home.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ibrajix.mymusic.R
import com.ibrajix.mymusic.ui.theme.darkGrey
import com.ibrajix.mymusic.ui.theme.lightGrey

@Composable
fun SearchHomeSection(
    modifier: Modifier = Modifier,
    searchTextFieldValue : String,
    onSearchTextFieldValueChange : (String) -> Unit,
    onSearchTextFieldClicked : () -> Unit,
    searchFieldPlaceHolder : Int
)
{

    TextField(
        modifier = modifier
            .fillMaxWidth()
            .padding(top = 20.dp)
            .clickable {
                onSearchTextFieldClicked
            },
        enabled = false,
        value = searchTextFieldValue,
        onValueChange = onSearchTextFieldValueChange,
        shape = RoundedCornerShape(8.dp),
        placeholder = {
            Text(
                fontSize = 14.sp,
                text = stringResource(searchFieldPlaceHolder)
            ) },
        singleLine = true,
        colors = TextFieldDefaults.textFieldColors(
            textColor = MaterialTheme.colors.onSecondary,
            placeholderColor = MaterialTheme.colors.darkGrey,
            backgroundColor = MaterialTheme.colors.lightGrey,
            cursorColor = Color.Black,
            disabledLabelColor = MaterialTheme.colors.primary,
            disabledIndicatorColor = Color.Transparent,
            focusedIndicatorColor = Color.Transparent,
            disabledTextColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
        ),
        leadingIcon = {
            Icon(
                imageVector = Icons.Default.Search, contentDescription = stringResource(id = R.string.icon_screen_reader),
                tint = MaterialTheme.colors.darkGrey
            )
        },
    )
}