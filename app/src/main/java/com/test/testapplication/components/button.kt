package com.test.testapplication.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.test.testapplication.ui.theme.popins_regular
import com.test.testapplication.ui.theme.tealcolor
import com.test.testapplication.ui.theme.whitecolor


@Composable
fun Submitbutton(
    onClick: () -> Unit,
    enabled:Boolean?,
    buttontxt:String="Submit"
){



    Button(
        onClick = { onClick() },
        enabled = enabled?:false,
        modifier = Modifier
            .fillMaxWidth()
            .height(60.dp)
            .padding(horizontal = 25.dp),

        shape = RoundedCornerShape(12.dp),

        colors = ButtonDefaults.buttonColors(containerColor = tealcolor),
    ) {
        Text(
            text = buttontxt,
            color = whitecolor,
            fontSize = 19.sp,
            textAlign = TextAlign.Center,
            fontFamily = popins_regular
        )


    }
}