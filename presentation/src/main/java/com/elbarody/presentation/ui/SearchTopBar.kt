package com.elbarody.presentation.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import com.elbarody.base.constant.Constants
import com.elbarody.base.theme.DarkGray
import com.elbarody.base.theme.Gray200
import com.elbarody.base.theme.Gray800
import com.elbarody.base.theme.Typography
import com.elbarody.base.utils.Dimens
import com.elbarody.presentation.R

@Composable
fun SearchTopBar(
    changedTextField: TextFieldValue,
    onTextChanged: (TextFieldValue) -> Unit,
) {
    TextField(
        value = changedTextField,
        onValueChange = {
            onTextChanged.invoke(it)
        },
        placeholder = { SearchPlaceHolder() },
        modifier = Modifier
            .padding(top = Dimens.sixLevelPadding)
            .fillMaxWidth()
            .wrapContentHeight()
            .background(
                color = Color.White, shape = RoundedCornerShape(Dimens.threeLevelPadding)
            )
            .border(
                width = 1.dp, color = Gray200, shape = RoundedCornerShape(Dimens.threeLevelPadding)
            ),
        shape = RoundedCornerShape(Dimens.threeLevelPadding),
        textStyle = Typography.bodyMedium,
        colors = TextFieldDefaults.colors(
            focusedContainerColor = Color.White,
            unfocusedContainerColor = Color.White,
            disabledContainerColor = Color.White,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            disabledIndicatorColor = Color.Transparent,
            cursorColor = DarkGray,
        ),
        keyboardOptions = KeyboardOptions.Default.copy(
            keyboardType = KeyboardType.Text
        )
    )
}

@Composable
fun SearchPlaceHolder() {
    Text(
        text = stringResource(R.string.typing_hint, Constants.MAX_CHAR_COUNT),
        style = Typography.bodySmall.copy(color = Gray800)
    )

}