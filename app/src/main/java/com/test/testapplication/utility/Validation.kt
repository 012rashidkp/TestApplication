package com.test.testapplication.utility

import android.util.Log

fun validate(
      textfield1:String,
      textfield2:String,
      textfield3:String,

  ):Boolean{
      return if (textfield1.equals("")){
          false
      } else if (textfield2.equals("")){
          false
      } else if (textfield3.equals("")){
          false
      } else {
          true
      }
  }

fun getresult(
    textfield1: String,
    textfield2: String,
    textfield3: String,
): ResultData? {
    val setA  = if (textfield1.contains(",")) {
        textfield1.split(",").map { it.trim().toInt() }.toSet()
    } else {
        textfield1.trim().map { it.toString().toInt() }.toSet()
    }

    val setB = if (textfield2.contains(",")) {
        textfield2.split(",").map { it.trim().toInt() }.toSet()
    } else {
        textfield2.trim().map { it.toString().toInt() }.toSet()
    }

    val setC = if (textfield3.contains(",")) {
        textfield3.split(",").map { it.trim().toInt() }.toSet()
    } else {
        textfield3.trim().map { it.toString().toInt() }.toSet()
    }

    val intersectResult = setA.intersect(setB).intersect(setC).toSet().joinToString(", ")
    val unionResult = (setA + setB + setC).toSet().joinToString(", ")
    val maxResult = (setA + setB + setC).maxOrNull()
    Log.d("result...", "intersect-${intersectResult},union-${unionResult},maxvalue-${maxResult}")
    return ResultData(
        intersect = intersectResult,
        union = unionResult,
        maxvalue = maxResult.toString()
    )
}