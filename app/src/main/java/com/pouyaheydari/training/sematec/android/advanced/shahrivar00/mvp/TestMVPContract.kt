package com.pouyaheydari.training.sematec.android.advanced.shahrivar00.mvp

interface TestMVPContract {

    interface View {
        fun showToast(name: String)
    }

    interface Presenter {
        fun onShowDataButtonClicked()
        fun onDataReceived(list: List<String>)
    }
}