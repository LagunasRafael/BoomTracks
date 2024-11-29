package com.example.boomtracks

import android.os.Bundle
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
            R.drawable.luis,
            R.drawable.luis3,
            R.drawable.luistraje,
            R.drawable.alexis2,
            R.drawable.alexis,
            R.drawable.alexis3,
            R.drawable.alexis4,
            R.drawable.rafa,
            R.drawable.rafa2,
            R.drawable.rafa3,
            R.drawable.diego1,
            R.drawable.diego2,
            R.drawable.diego3,
            R.drawable.rafatraje,








            )
    }
}
