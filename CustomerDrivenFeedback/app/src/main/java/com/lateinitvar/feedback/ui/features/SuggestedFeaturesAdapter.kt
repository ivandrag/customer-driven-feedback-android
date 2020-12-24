package com.lateinitvar.feedback.ui.features

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.lateinitvar.feedback.R
import com.lateinitvar.feedback.business.model.SuggestedFeature
import kotlinx.android.extensions.LayoutContainer

class SuggestedFeaturesAdapter : RecyclerView.Adapter<SuggestedFeaturesAdapter.ParentHolder>() {

    var allSuggestedFeatures = mutableListOf<SuggestedFeature>()

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ) = ParentHolder(
        LayoutInflater
            .from(parent.context)
            .inflate(R.layout.item_suggested_feature, parent, false)
    )

    override fun onBindViewHolder(holder: ParentHolder, position: Int) {
        val suggestedFeature = allSuggestedFeatures[position]
        holder.bindData(suggestedFeature)
    }

    override fun getItemCount() = allSuggestedFeatures.size

    class ParentHolder(override val containerView: View) : RecyclerView.ViewHolder(containerView),
        LayoutContainer {

        fun bindData(suggestedFeature: SuggestedFeature) {
            Log.d("##TITLE ",  suggestedFeature.title)
        }
    }
}