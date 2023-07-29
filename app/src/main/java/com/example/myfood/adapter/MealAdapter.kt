package com.example.myfood.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myfood.R
import com.example.myfood.models.MealCategory

class MealAdapter : RecyclerView.Adapter<MealAdapter.MealViewHolder>() {
    private val mealCategories = mutableListOf<MealCategory>()

    fun submitList(categories: List<MealCategory>) {
        mealCategories.clear()
        mealCategories.addAll(categories)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MealViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_categories, parent, false)
        return MealViewHolder(view)
    }

    override fun onBindViewHolder(holder: MealViewHolder, position: Int) {
        val category = mealCategories[position]
        holder.bind(category)
    }

    override fun getItemCount(): Int {
        return mealCategories.size
    }

    class MealViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
//        private val categoryImageView: ImageView = itemView.findViewById(R.id.categoryImageView)
        private val txtItemCategories: TextView = itemView.findViewById(R.id.txtCategories)

        fun bind(category: MealCategory) {
//            categoryNameTextView.text = category.strCategory
            txtItemCategories.text = category.strCategory

            // Load and display the image using Glide or any other image loading library
            // Example: Glide.with(itemView).load(category.strCategoryThumb).into(categoryImageView)
        }
    }
}



