package com.ubaya.advuts160419047.view

import android.content.Context
import android.os.Bundle
import android.os.Handler
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.ubaya.advuts160419047.R

/**
 * A simple [Fragment] subclass.
 * Use the [SplashFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class SplashFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Handler().postDelayed({
            if(onBoardFinish()) {
                findNavController().navigate(R.id.splash_main)
            } else  findNavController().navigate(R.id.splash_onboarding)
        },3000)

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_splash, container, false)
    }

    fun onBoardFinish():Boolean {
        val sref = requireActivity().getSharedPreferences("onboard",Context.MODE_PRIVATE)
        return sref.getBoolean("finish",false)
    }
}