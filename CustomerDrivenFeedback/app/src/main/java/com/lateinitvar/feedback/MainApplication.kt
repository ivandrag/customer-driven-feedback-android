package com.lateinitvar.feedback

import android.app.Application
import com.lateinitvar.feedback.di.AppContainer

class MainApplication : Application() {

    val appContainer = AppContainer()
}
