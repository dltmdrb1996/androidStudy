package com.example.jetpackex

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModelProvider
import com.example.jetpackex.databinding.FragmentSecondBinding


class SecondFragment : Fragment() {
    lateinit var viewModel : MainViewModel
    private var binding: FragmentSecondBinding? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_second, container, false)
        binding?.lifecycleOwner  = this

        viewModel = ViewModelProvider(activity as FragmentActivity)[MainViewModel::class.java]
        binding?.viewModel = viewModel
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding?.secondFragmentBtnNextFrag?.setOnClickListener { viewModel.changeFragment(R.id.thirdFragment) }

        binding?.secondFragmentBtnTitle?.setOnClickListener {
            val text = binding?.secondFragmentEdtTitle?.text.toString()
            viewModel.setSecondTitle(text)
            binding?.secondFragmentEdtTitle?.setText("")
        }
    }
    override fun onDestroyView() {
        binding = null
        super.onDestroyView()
    }
}