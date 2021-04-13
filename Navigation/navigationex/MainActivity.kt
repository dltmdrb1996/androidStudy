package com.example.navigationex

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.example.navigationex.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var mBinding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(mBinding.root)

        // 네비게이션들을 담을 레이아웃을 호스트로 생성한다
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.main_Nav_Container) as NavHostFragment

        // 컨트롤러를 설정한다 컨트롤러는 navigation graph의 정보를 기반으로 프래그먼트를 컨트롤한다
        val navController = navHostFragment.navController

        // 바텀 네비게이션 뷰 와 네비게이션을 묶어줌
        NavigationUI.setupWithNavController(mBinding.mainBottomNav,navController)

    }
}
