package com.lateinitvar.feedback.ui.features

import android.os.Bundle
import android.view.View
import com.lateinitvar.feedback.R
import com.lateinitvar.feedback.di.FeaturesContainer
import com.lateinitvar.feedback.ui.BaseFragment

class FeaturesFragment: BaseFragment(R.layout.fragment_features) {

    private val featuresViewModel: FeaturesViewModel by lazy {
        val featureContainer = FeaturesContainer(appContainer.firebaseProvider)
        featureContainer.featuresViewModel
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        featuresViewModel.getAllSuggestedFeatures()
    }

    override fun onDestroy() {
        super.onDestroy()
        appContainer.featureContainer = null
    }
}