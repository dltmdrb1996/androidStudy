package com.example.viewmodelex

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.viewmodelex.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {

    lateinit var binding: ActivityMainBinding
    lateinit var myCalViewModel: MyCalViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //데이터 바인딩
        binding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
        binding.lifecycleOwner = this

        //뷰모델 중복 생성을 막기위해 ViewModelProvider 로 관리 싱글톤개념
        myCalViewModel = ViewModelProvider(this).get(MyCalViewModel::class.java)
        binding.viewModel = myCalViewModel

        //LiveData를 통한 바인딩된 뷰 업데이트
        myCalViewModel.currentValue.observe(this, Observer {
            binding.tvNum.text = it.toString()
        })
        //뷰모델 내부의 라이브데이타를 업데이트해주는 리스너 장착
        binding.btnSum.setOnClickListener(this)
        binding.btnSub.setOnClickListener(this)
    }

    //리스너
    override fun onClick(view: View?) {
        if (!binding.edtText.text.isNullOrBlank()) {
            val userInput: Int? = binding.edtText.text.toString().toIntOrNull()

            Log.d("test", "리스너 작동")
            if (userInput != null)
                when (view) {
                    binding.btnSum -> myCalViewModel.updateValue(actionType = ActionType.SUM, userInput)
                    binding.btnSub -> myCalViewModel.updateValue(actionType = ActionType.SUB, userInput)
                }

        }
    }
}