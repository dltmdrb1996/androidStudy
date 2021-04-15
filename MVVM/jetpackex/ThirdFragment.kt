package com.example.jetpackex

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModelProvider
import com.example.jetpackex.databinding.FragmentThirdBinding



class ThirdFragment : Fragment() {
    private  var binding: FragmentThirdBinding? =null
    lateinit var viewModel : MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_third, container, false)
        binding?.lifecycleOwner  = this

        viewModel = ViewModelProvider(activity as FragmentActivity)[MainViewModel::class.java]
        binding?.viewModel = viewModel
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        binding?.thirdFragmentBtnTitle?.setOnClickListener {
            val text = binding?.thirdFragmentEdtTitle?.text.toString()
            viewModel.setThirdTitle(text)
            binding?.thirdFragmentEdtTitle?.setText("")
        }
    }

    override fun onDestroyView() {
        binding = null
        viewModel.setThirdTitle("")
        super.onDestroyView()
    }
}