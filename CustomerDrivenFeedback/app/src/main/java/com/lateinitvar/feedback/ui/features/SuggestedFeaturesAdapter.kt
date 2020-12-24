package com.lateinitvar.feedback.ui.features

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.lateinitvar.feedback.R
import com.lateinitvar.feedback.business.model.SuggestedFeature

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

    class ParentHolder(private val containerView: View) : RecyclerView.ViewHolder(containerView) {

        fun bindData(suggestedFeature: SuggestedFeature) {
            val titleText = containerView.findViewById<TextView>(R.id.title_text_view)
            val descriptionText = containerView.findViewById<TextView>(R.id.description_text_view)
            val totalVotesText = containerView.findViewById<TextView>(R.id.total_votes_text_view)
            titleText.text = suggestedFeature.title
            descriptionText.text = suggestedFeature.description
            totalVotesText.text = suggestedFeature.totalVotes.toString()
        }
    }
}