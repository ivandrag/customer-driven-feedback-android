package com.lateinitvar.feedback.ui.login

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.lateinitvar.feedback.R
import kotlinx.android.synthetic.main.fragment_login.sign_up_text_view

class LoginFragment : Fragment(R.layout.fragment_login) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        sign_up_text_view.setOnClickListener {
            findNavController().navigate(R.id.start_sign_up_fragment)
        }
    }
}
