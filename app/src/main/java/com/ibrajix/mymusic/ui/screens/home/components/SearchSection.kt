package com.ibrajix.mymusic.ui.screens.home.components

import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ibrajix.mymusic.R
import com.ibrajix.mymusic.ui.theme.darkGrey
import com.ibrajix.mymusic.ui.theme.lightGrey
import kotlinx.coroutines.delay

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun SearchSection(
    modifier: Modifier = Modifier,
    searchTextFieldValue : String,
    onSearchTextFieldValueChange : (String) -> Unit,
    onSearchTextFieldClicked : () -> Unit,
    searchEnabled: Boolean = true,
    searchFieldPlaceHolder : Int,
)
{

    val showKeyboard by remember { mutableStateOf(true) }
    val focusRequester = FocusRequester()
    val keyboard = LocalSoftwareKeyboardController.current

    TextField(
        modifier = modifier
            .fillMaxWidth()
            .focusRequester(focusRequester)
            .clickable {
                onSearchTextFieldClicked()
            },
        enabled = searchEnabled,
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
        keyboardOptions = KeyboardOptions(
            imeAction = ImeAction.Search
        ),
        keyboardActions = KeyboardActions(
            onSearch ={
                //do something here
                onSearchTextFieldClicked()
            }
        ),
    )

    //LaunchedEffect prevents endless focus request
    LaunchedEffect(focusRequester) {
        if (showKeyboard) {
            focusRequester.requestFocus()
            delay(100) // Make sure you have delay here
            keyboard?.show()
        }
    }

    Log.e("skt", showKeyboard.toString())

}