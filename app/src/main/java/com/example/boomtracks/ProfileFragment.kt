package com.example.boomtracks

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.carousel.CarouselSnapHelper

class ProfileFragment : Fragment() {

    private lateinit var carouseRecyclerView: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_profile, container, false)
        carouseRecyclerView = view.findViewById(R.id.carouseRecyclerView)
        setupCarouselRecyclerView()
        return view
    }
    private fun setupCarouselRecyclerView() {
        CarouselSnapHelper().attachToRecyclerView(carouseRecyclerView)
        carouseRecyclerView.adapter = CarouselAdapter(images = getImages())
    }

    private fun getImages(): List<Int> {
        return listOf(
            R.drawable.pop,
            R.drawable.charlie,
            R.drawable.billieeilish,
            R.drawable.indie
        )
    }
}
