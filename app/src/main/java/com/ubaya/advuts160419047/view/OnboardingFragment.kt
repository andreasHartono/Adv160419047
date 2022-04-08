package com.ubaya.advuts160419047.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ubaya.advuts160419047.R
import kotlinx.android.synthetic.main.fragment_onboarding.view.*

/**
 * A simple [Fragment] subclass.
 * Use the [OnboardingFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class OnboardingFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val v = inflater.inflate(R.layout.fragment_onboarding, container, false)

        val listofFragment = arrayListOf<Fragment>(
            FirstOnboardingFragment(),
            SecondOnboardingFragment()
        )

        val adapter = OnboardingAdapter(listofFragment,
            requireActivity().supportFragmentManager,lifecycle)

        v.viewPagerOnboarding.adapter = adapter

        return v
    }
}