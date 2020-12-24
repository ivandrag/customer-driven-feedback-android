package com.lateinitvar.feedback.ui.features

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import com.lateinitvar.feedback.R
import com.lateinitvar.feedback.di.FeaturesContainer
import com.lateinitvar.feedback.ui.BaseFragment
import com.lateinitvar.feedback.ui.MainActivity

class SuggestedFeaturesFragment: BaseFragment(R.layout.fragment_features) {

    private val suggestedFeaturesViewModel: SuggestedFeaturesViewModel by lazy {
        val featureContainer = FeaturesContainer(appContainer.firebaseProvider)
        featureContainer.featuresViewModel
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setToolbarTitle(getString(R.string.suggested_features_toolbar_title_text))
        val addImageView = (activity as MainActivity).findViewById<ImageView>(R.id.add_image_view)
        addImageView.visibility = View.VISIBLE
        addImageView.setOnClickListener {
            
        }
        suggestedFeaturesViewModel.getAllSuggestedFeatures()
    }

    override fun onDestroy() {
        super.onDestroy()
        appContainer.featureContainer = null
    }
}