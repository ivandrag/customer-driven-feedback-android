package com.lateinitvar.feedback.ui.features

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.lateinitvar.feedback.R
import com.lateinitvar.feedback.di.FeaturesContainer
import com.lateinitvar.feedback.ui.BaseFragment
import kotlinx.android.synthetic.main.fragment_features.suggested_feature_recycler_view
import kotlinx.android.synthetic.main.fragment_features.swipe_refresh_layout
import kotlinx.android.synthetic.main.toolbar.add_image_view

class SuggestedFeaturesFragment: BaseFragment(R.layout.fragment_features), SwipeRefreshLayout.OnRefreshListener {

    private lateinit var suggestedFeaturesAdapter: SuggestedFeaturesAdapter

    private val suggestedFeaturesViewModel: SuggestedFeaturesViewModel by lazy {
        val featureContainer = FeaturesContainer(appContainer.firebaseProvider)
        featureContainer.featuresViewModel
    }

    private val onEventObserver = Observer<SuggestedFeaturesViewModel.OnEvent> {
        when(it) {
            is SuggestedFeaturesViewModel.OnEvent.AllSuggestedFeatures -> {
                suggested_feature_recycler_view.adapter = suggestedFeaturesAdapter
                suggested_feature_recycler_view.layoutManager = LinearLayoutManager(activity)
                suggestedFeaturesAdapter.allSuggestedFeatures.clear()
                suggestedFeaturesAdapter.allSuggestedFeatures.addAll(it.allData.suggestedFeatureList)
                suggestedFeaturesAdapter.userId = it.allData.userId
                swipe_refresh_layout.isRefreshing = false
            }
            is SuggestedFeaturesViewModel.OnEvent.OnUpVoteSuccess -> {
                swipe_refresh_layout.isRefreshing = true
                suggestedFeaturesViewModel.getAllSuggestedFeatures()
            }
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        suggestedFeaturesAdapter = SuggestedFeaturesAdapter {id ->
            suggestedFeaturesViewModel.upVote(id)
        }
        setToolbarTitle(getString(R.string.suggested_features_toolbar_title_text))
        suggestedFeaturesViewModel.onEvent.observe(viewLifecycleOwner, onEventObserver)
        add_image_view?.visibility = View.VISIBLE
        add_image_view?.setOnClickListener {
            findNavController().navigate(R.id.start_add_feature_fragment)
        }
        suggestedFeaturesViewModel.getAllSuggestedFeatures()
        swipe_refresh_layout.setOnRefreshListener(this)
    }

    override fun onDestroy() {
        super.onDestroy()
        appContainer.featureContainer = null
    }

    override fun onRefresh() {
        suggestedFeaturesAdapter.allSuggestedFeatures.clear()
        suggestedFeaturesViewModel.getAllSuggestedFeatures()
    }
}