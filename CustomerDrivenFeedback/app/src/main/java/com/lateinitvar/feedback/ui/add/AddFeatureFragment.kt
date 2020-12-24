package com.lateinitvar.feedback.ui.add

import android.os.Bundle
import android.view.View
import com.lateinitvar.feedback.R
import com.lateinitvar.feedback.di.AddFeatureContainer
import com.lateinitvar.feedback.ui.BaseFragment

class AddFeatureFragment: BaseFragment(R.layout.fragment_add_feature) {

    private val addFeatureViewModel: AddFeatureViewModel by lazy {
        val addFeatureContainer = AddFeatureContainer(appContainer.firebaseProvider)
        addFeatureContainer.addFeatureViewModel
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }
}
