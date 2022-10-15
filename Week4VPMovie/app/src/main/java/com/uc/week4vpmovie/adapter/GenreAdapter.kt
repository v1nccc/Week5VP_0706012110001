package com.uc.week4vpmovie.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.uc.week4vpmovie.R
import com.uc.week4vpmovie.model.Genre


class GenreAdapter(private val genres: List<Genre>) :
    RecyclerView.Adapter<GenreAdapter.ViewHolder>() {

    /**
     * Provide a reference to the type of views that you are using
     * (custom ViewHolder).
     */

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        val tvGenre: TextView



        init {
            // Define click listener for the ViewHolder's View.
            tvGenre = view.findViewById(R.id.tvGenre)

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
        viewHolder.tvGenre.text = genres[position].name

    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() = genres.size

}

