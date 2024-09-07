package com.elbarody.base.compose

import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withStyle
import com.elbarody.base.theme.Typography

fun annotatedString(label: String, value: String): AnnotatedString {
        return buildAnnotatedString {
            withStyle(style = Typography.bodyMedium.toSpanStyle()) {
                append(label)
            }
            withStyle(style = Typography.bodySmall.toSpanStyle()) {
                append(" $value")
            }
        }
    }