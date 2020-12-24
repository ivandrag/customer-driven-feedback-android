package com.lateinitvar.feedback.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.lateinitvar.feedback.R
import kotlinx.android.synthetic.main.toolbar.toolbar_title_text_view

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun setToolbarTitle(value: String) {
        toolbar_title_text_view.text = value
    }
}
