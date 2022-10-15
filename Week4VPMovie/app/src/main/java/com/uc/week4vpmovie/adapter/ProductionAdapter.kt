package com.uc.week4vpmovie.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.net.toUri
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.uc.week4vpmovie.R
import com.uc.week4vpmovie.helper.Const
import com.uc.week4vpmovie.model.Genre
import com.uc.week4vpmovie.model.ProductionCompany


class ProductionAdapter(private val producers: List<ProductionCompany>) :
    RecyclerView.Adapter<ProductionAdapter.ViewHolder>() {

    /**
     * Provide a reference to the type of views that you are using
     * (custom ViewHolder).
     */

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        val producerimg: ImageView



        init {
            // Define click listener for the ViewHolder's View.
            producerimg = view.findViewById(R.id.producerimg)

        }
    }

    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        // Create a new view, which defines the UI of the list item
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.production_company_card, viewGroup, false)

        return ViewHolder(view)
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {

        // Get element from your dataset at this position and replace the
        // contents of the view with that element
       Glide.with(viewHolder.itemView.context).load(Const.IMG_URL + producers[position].logo_path).into(viewHolder.producerimg)



    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() = producers.size

}

