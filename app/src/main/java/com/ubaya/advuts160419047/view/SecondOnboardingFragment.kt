package com.ubaya.advuts160419047.view

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.ubaya.advuts160419047.R
import kotlinx.android.synthetic.main.fragment_second_onboarding.view.*


/**
 * A simple [Fragment] subclass.
 * Use the [SecondOnboardingFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class SecondOnboardingFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val v =  inflater.inflate(R.layout.fragment_second_onboarding, container, false)

        v.buttonFinish.setOnClickListener {
            findNavController().navigate(R.id.onboarding_main)
            val spref = requireActivity().getSharedPreferences("onboard", Context.MODE_PRIVATE)
            val edit = spref.edit()
            edit.putBoolean("finish",true)
            edit.apply()
        }

        return v
    }
}