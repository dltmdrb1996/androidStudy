package com.example.navigationex.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.navigationex.R
import com.example.navigationex.databinding.FragmentHomeBinding
import com.example.navigationex.databinding.FragmentMovieBinding

class MovieFragment : Fragment() {

    private var mBinding: FragmentMovieBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding = FragmentMovieBinding.inflate(inflater, container, false)
        mBinding = binding
        return mBinding?.root

    }

    override fun onDestroyView() {
        mBinding = null
        super.onDestroyView()
    }
}