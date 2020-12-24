package com.lateinitvar.feedback.ui.features

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
import com.lateinitvar.feedback.R
import com.lateinitvar.feedback.di.FeaturesContainer
import com.lateinitvar.feedback.ui.BaseFragment
import kotlinx.android.synthetic.main.toolbar.add_image_view

class SuggestedFeaturesFragment: BaseFragment(R.layout.fragment_features) {

    private val suggestedFeaturesViewModel: SuggestedFeaturesViewModel by lazy {
        val featureContainer = FeaturesContainer(appContainer.firebaseProvider)
        featureContainer.featuresViewModel
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setToolbarTitle(getString(R.string.suggested_features_toolbar_title_text))

        add_image_view?.visibility = View.VISIBLE
        add_image_view?.setOnClickListener {
            findNavController().navigate(R.id.start_add_feature_fragment)
        }
        suggestedFeaturesViewModel.getAllSuggestedFeatures()
    }

    override fun onDestroy() {
        super.onDestroy()
        appContainer.featureContainer = null
    }
}