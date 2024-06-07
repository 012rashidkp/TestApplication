package com.test.testapplication.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.test.testapplication.R
import com.test.testapplication.ui.theme.black
import com.test.testapplication.ui.theme.greylight
import com.test.testapplication.ui.theme.popins_regular


@Composable
fun textfieldcomponent(
    value:String?,
    changevalue: (String) -> Unit,
    labeltext:String?="Number",
    placeholdertext:String?="Enter Number",
    keyboardType: KeyboardType=KeyboardType.Number,
    icon: Painter = painterResource(id = R.drawable.number_icon),
    isError:Boolean=false,

){



    val tealcolor= colorResource(id = R.color.teal_700)

    var mycolor: Color?=null
    mycolor = if (icon!=null) tealcolor else greylight



    TextField(

        value = value?:"",
        onValueChange = changevalue,
        label = { Text(text = labeltext?:"",

            color = black,
            textAlign = TextAlign.Center,
            fontFamily = popins_regular
        )
        },
        placeholder = {
            Text(text = placeholdertext?:"",
                color = black,
                textAlign = TextAlign.Center,
                fontFamily = popins_regular
            )
        },
        keyboardOptions = KeyboardOptions(keyboardType = keyboardType),


        singleLine = true,
        leadingIcon = { Icon(painter = icon,
            contentDescription = null, tint = mycolor)
        },
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 25.dp)
            .background(Color.Transparent)
            .clip(shape = RoundedCornerShape(16.dp)),

        colors = TextFieldDefaults.colors(
            cursorColor = greylight,
            focusedContainerColor = greylight,
            disabledContainerColor = greylight,
            errorContainerColor = greylight,
            unfocusedContainerColor = greylight,
            focusedTextColor = black,
            focusedLabelColor = black,
            focusedSupportingTextColor = black,
            unfocusedTextColor = black,
            errorCursorColor = black,
            errorTextColor = black,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            errorIndicatorColor = Color.Transparent

        ),
        isError = isError,
    )
}