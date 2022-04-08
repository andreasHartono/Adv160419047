package com.ubaya.advuts160419047.view

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.ListFragment
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter

class OnboardingAdapter(val listFragment: ArrayList<Fragment>,val fragmentManager: FragmentManager, val lifecycle: Lifecycle)
    : FragmentStateAdapter(fragmentManager,lifecycle) {
    val lstFragment = listFragment
    override fun getItemCount(): Int = lstFragment.size

    override fun createFragment(position: Int): Fragment = lstFragment[position]

}