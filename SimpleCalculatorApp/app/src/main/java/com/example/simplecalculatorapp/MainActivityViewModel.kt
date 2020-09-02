package com.example.simplecalculatorapp

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import net.objecthunter.exp4j.ExpressionBuilder
import net.objecthunter.exp4j.operator.Operator
import net.objecthunter.exp4j.operator.Operators
import java.lang.Exception
import java.lang.reflect.Array.get

class MainActivityViewModel: ViewModel() {

    private val _listNumberExpression = MutableLiveData<String>()
    var listNumberExpression: LiveData<String> = _listNumberExpression

    private val _result = MutableLiveData<String>()
    var result: LiveData<String> = _result



    init {
        _listNumberExpression.value = "0"
        _result.value = "0"
    }

    fun addToExpression(text: String) {
        if (listNumberExpression.value == "0") {
            _listNumberExpression.value = text
        } else {
            _listNumberExpression.value += text
        }
    }

    fun clearList() {
        _listNumberExpression.value = "0"
        _result.value = "0"
    }

    fun clear() {
        try {
            if (listNumberExpression.value != "0") {
                _listNumberExpression.value = listNumberExpression.value?.substring(
                    0,
                    listNumberExpression.value?.length!! - 1
                )
            }
        } catch (e: Exception) {
            _listNumberExpression.value = "0"
        }
    }

    fun equal() {
        val text = listNumberExpression.value!!
        val expression = ExpressionBuilder(text).build()
        try {
            val expressionResult = expression.evaluate()
            _result.value = expressionResult.toInt().toString()
        } catch (e: Exception) {
            Log.i("Error", "$e")
        }
    }
}