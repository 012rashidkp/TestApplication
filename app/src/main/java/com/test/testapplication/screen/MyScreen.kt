package com.test.testapplication.screen

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.test.testapplication.components.Submitbutton
import com.test.testapplication.components.textfieldcomponent
import com.test.testapplication.ui.theme.black
import com.test.testapplication.ui.theme.popins_regular
import com.test.testapplication.ui.theme.whitecolor
import com.test.testapplication.utility.getresult
import com.test.testapplication.utility.validate

@Composable
fun MyScreen(){

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(whitecolor),
        contentAlignment = Alignment.Center
    ) {
        var textfield1 by remember { mutableStateOf("") }
        var textfield2 by remember { mutableStateOf("") }
        var textfield3 by remember { mutableStateOf("") }
        var result by remember { mutableStateOf(false) }
        var intersecttext by remember { mutableStateOf("") }
        var unionresult by remember { mutableStateOf("") }
        var maxresult by remember { mutableStateOf("") }


        Column(
            modifier = Modifier
                .padding(16.dp)
        ) {
         Spacer(modifier = Modifier.height(15.dp))
            textfieldcomponent(
                value = textfield1,
                changevalue ={
                    textfield1=it
                }
            )
            Spacer(modifier = Modifier.height(18.dp))
            textfieldcomponent(
                value = textfield2,
                changevalue ={
                    textfield2=it
                }
            )
            Spacer(modifier = Modifier.height(18.dp))
            textfieldcomponent(
                value = textfield3,
                changevalue ={
                    textfield3=it
                }
            )
            Spacer(modifier = Modifier.height(25.dp))
            Submitbutton(
                onClick = {
                intersecttext=getresult(textfield1,textfield2,textfield3)?.intersect?:""

                 unionresult=getresult(textfield1,textfield2,textfield3)?.union?:""
                 maxresult=getresult(textfield1,textfield2,textfield3)?.maxvalue?:""
                   result=true


                },
                enabled = validate(textfield1,textfield2,textfield3)
            )

            Spacer(modifier = Modifier.height(25.dp))
            if (result){
                Column {
                    Text(
                        text = "Intersect : ${intersecttext}",
                        color = black,
                        fontSize = 22.sp,
                        textAlign = TextAlign.Center,
                        fontFamily = popins_regular,
                        fontWeight = FontWeight.Bold
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                    Text(
                        text = "Union : ${unionresult}",
                        color = black,
                        fontSize = 22.sp,
                        textAlign = TextAlign.Center,
                        fontFamily = popins_regular,
                        fontWeight = FontWeight.Bold
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                    Text(
                        text = "Highest : ${maxresult}",
                        color = black,
                        fontSize = 22.sp,
                        textAlign = TextAlign.Center,
                        fontFamily = popins_regular,
                        fontWeight = FontWeight.Bold
                    )
                }
            }






        }





    }




}