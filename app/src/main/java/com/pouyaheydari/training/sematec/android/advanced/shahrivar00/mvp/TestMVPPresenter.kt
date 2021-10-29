package com.pouyaheydari.training.sematec.android.advanced.shahrivar00.mvp

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class TestMVPPresenter(private val view: TestMVPContract.View) : TestMVPContract.Presenter {
    private val model = TestMVPModel()

    override fun onShowDataButtonClicked() {
        GlobalScope.launch {
            val list = model.getData()
            launch(Dispatchers.Main) {
                list.forEach {
                    view.showToast(it)
                }
            }
        }
    }

    override fun onDataReceived(list: List<String>) {

    }
}