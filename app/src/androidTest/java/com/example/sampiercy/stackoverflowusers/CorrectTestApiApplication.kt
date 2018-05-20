package com.example.sampiercy.stackoverflowusers

class CorrectTestApiApplication: StackOverflowApplication(){

    override fun initialiseDaggerComponent() {
        DaggerAppTestComponent.builder()
                .application(this)
                .build()
                .inject(this)
    }

}