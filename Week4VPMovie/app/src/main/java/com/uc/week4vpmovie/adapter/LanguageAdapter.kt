package com.uc.week4vpmovie.adapter

import com.uc.week4vpmovie.model.SpokenLanguage


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.uc.week4vpmovie.R
import com.uc.week4vpmovie.model.Genre


class LanguageAdapter(private val languages: List<SpokenLanguage>) :
    RecyclerView.Adapter<LanguageAdapter.ViewHolder>() {

    /**
     * Provide a reference to the type of views that you are using
     * (custom ViewHolder).
     */

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        val tvLanguage: TextView



        init {
            // Define click listener for the ViewHolder's View.
            tvLanguage = view.findViewById(R.id.tvGenre)

        }
    }

    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        // Create a new view, which defines the UI of the list item
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.genre_card, viewGroup, false)

        return ViewHolder(view)
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {

        // Get element from your dataset at this position and replace the
        // contents of the view with that element
        viewHolder.tvLanguage.text = languages[position].english_name

    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() = languages.size

}

