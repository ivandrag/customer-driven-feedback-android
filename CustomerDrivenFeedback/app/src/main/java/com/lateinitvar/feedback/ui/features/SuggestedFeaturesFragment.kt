package com.lateinitvar.feedback.ui.features

import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.lateinitvar.feedback.R
import com.lateinitvar.feedback.di.FeaturesContainer
import com.lateinitvar.feedback.ui.BaseFragment
import kotlinx.android.synthetic.main.fragment_features.suggested_feature_recycler_view
import kotlinx.android.synthetic.main.toolbar.add_image_view

class SuggestedFeaturesFragment: BaseFragment(R.layout.fragment_features) {

    private val suggestedFeaturesAdapter: SuggestedFeaturesAdapter by lazy {
        SuggestedFeaturesAdapter()
    }

    private val suggestedFeaturesViewModel: SuggestedFeaturesViewModel by lazy {
        val featureContainer = FeaturesContainer(appContainer.firebaseProvider)
        featureContainer.featuresViewModel
    }

    private val onEventObserver = Observer<SuggestedFeaturesViewModel.OnEvent> {
        when(it) {
            is SuggestedFeaturesViewModel.OnEvent.AllSuggestedFeatures -> {
                suggested_feature_recycler_view.adapter = suggestedFeaturesAdapter
                suggested_feature_recycler_view.layoutManager = LinearLayoutManager(activity)
                suggestedFeaturesAdapter.allSuggestedFeatures.addAll(it.allSuggestedFeatures)
            }
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setToolbarTitle(getString(R.string.suggested_features_toolbar_title_text))
        suggestedFeaturesViewModel.onEvent.observe(viewLifecycleOwner, onEventObserver)
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