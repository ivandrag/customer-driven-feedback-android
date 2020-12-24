package com.lateinitvar.feedback.ui.add

import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import com.lateinitvar.feedback.R
import com.lateinitvar.feedback.di.AddFeatureContainer
import com.lateinitvar.feedback.ui.BaseFragment
import kotlinx.android.synthetic.main.fragment_add_feature.description_text_input_edit_text
import kotlinx.android.synthetic.main.fragment_add_feature.submit_button
import kotlinx.android.synthetic.main.fragment_add_feature.title_text_input_edit_text

class AddFeatureFragment: BaseFragment(R.layout.fragment_add_feature) {

    private val addFeatureViewModel: AddFeatureViewModel by lazy {
        val addFeatureContainer = AddFeatureContainer(appContainer.firebaseProvider)
        addFeatureContainer.addFeatureViewModel
    }

    private val onEvent = Observer<AddFeatureViewModel.OnEvent> {
        when(it) {
            is AddFeatureViewModel.OnEvent.SuggestFeatureSuccessfully -> {
                title_text_input_edit_text.clearFocus()
                title_text_input_edit_text.setText("")
                description_text_input_edit_text.clearFocus()
                description_text_input_edit_text.setText("")
            }
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setToolbarTitle(getString(R.string.add_feature_toolbar_title_text))
        submit_button.setOnClickListener {
            val title = title_text_input_edit_text.text.toString()
            val description = description_text_input_edit_text.text.toString()
            addFeatureViewModel.submitSuggestion(title, description)
        }
        registerObservers()
    }

    override fun onDestroy() {
        super.onDestroy()
        appContainer.addFeatureContainer = null
    }

    private fun registerObservers() {
        addFeatureViewModel.onEvent.observe(viewLifecycleOwner, onEvent)
    }
}
