package es.openbank.dev

import es.openbank.dev.di.DaggerTestAppComponent

class TestApp: App() {

    override fun onCreate() {
        DaggerTestAppComponent.builder()
            .application(this)
            .build()
            .inject(this)
    }

}