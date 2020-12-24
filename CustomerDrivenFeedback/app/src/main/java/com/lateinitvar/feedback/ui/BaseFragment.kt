package com.lateinitvar.feedback.ui

import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import com.lateinitvar.feedback.MainApplication
import com.lateinitvar.feedback.di.AppContainer

abstract class BaseFragment(@LayoutRes layout: Int): Fragment(layout) {

    val appContainer: AppContainer by lazy {
        (activity?.application as? MainApplication)?.appContainer ?: throw Exception("App container cannot be null")
    }

    fun setToolbarTitle(value: String) {
        (activity as MainActivity).setToolbarTitle(value)
    }
}
