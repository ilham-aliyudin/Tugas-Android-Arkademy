package com.example.simplecalculatorapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.simplecalculatorapp.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var myViewModel: MainActivityViewModel
    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        myViewModel = ViewModelProvider(this)[MainActivityViewModel::class.java]
        setContentView(binding.root)
        binding.myviewmodel = myViewModel
        binding.lifecycleOwner = this

        btn_0.setOnClickListener(this)
        btn_1.setOnClickListener(this)
        btn_2.setOnClickListener(this)
        btn_3.setOnClickListener(this)
        btn_4.setOnClickListener(this)
        btn_5.setOnClickListener(this)
        btn_6.setOnClickListener(this)
        btn_7.setOnClickListener(this)
        btn_8.setOnClickListener(this)
        btn_9.setOnClickListener(this)
        btn_clear_all.setOnClickListener(this)
        btn_backspace.setOnClickListener(this)
        btn_tambah.setOnClickListener(this)
        btn_kurang.setOnClickListener(this)
        btn_multiplication.setOnClickListener(this)
        btn_divided.setOnClickListener(this)
        btn_dot.setOnClickListener(this)
        btn_equal.setOnClickListener(this)
        btn_percentage.setOnClickListener(this)

        showExpresion()
    }

    private fun showExpresion() {
        binding.myviewmodel?.listNumberExpression?.observe(this) {
            tv_expression.text = myViewModel.listNumberExpression.value
        }
        binding.myviewmodel?.result?.observe(this) {
            tv_result.text = myViewModel.result.value
        }
    }

    override fun onClick(p0: View?) {
        when (p0?.id) {
            R.id.btn_0 -> binding.myviewmodel?.addToExpression("0")
            R.id.btn_1 -> binding.myviewmodel?.addToExpression("1")
            R.id.btn_2 -> binding.myviewmodel?.addToExpression("2")
            R.id.btn_3 -> binding.myviewmodel?.addToExpression("3")
            R.id.btn_4 -> binding.myviewmodel?.addToExpression("4")
            R.id.btn_5 -> binding.myviewmodel?.addToExpression("5")
            R.id.btn_6 -> binding.myviewmodel?.addToExpression("6")
            R.id.btn_7 -> binding.myviewmodel?.addToExpression("7")
            R.id.btn_8 -> binding.myviewmodel?.addToExpression("8")
            R.id.btn_9 -> binding.myviewmodel?.addToExpression("9")
            R.id.btn_clear_all -> binding.myviewmodel?.clearList()
            R.id.btn_backspace -> binding.myviewmodel?.clear()
            R.id.btn_tambah -> binding.myviewmodel?.addToExpression("+")
            R.id.btn_divided -> binding.myviewmodel?.addToExpression("/")
            R.id.btn_dot -> binding.myviewmodel?.addToExpression(".")
            R.id.btn_kurang -> binding.myviewmodel?.addToExpression("-")
            R.id.btn_multiplication -> binding.myviewmodel?.addToExpression("*")
            R.id.btn_percentage -> binding.myviewmodel?.addToExpression("%")
            R.id.btn_equal -> binding.myviewmodel?.equal()
        }
    }
}