package com.pouyaheydari.training.sematec.android.advanced.shahrivar00.mvp

import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.pouyaheydari.training.sematec.android.advanced.shahrivar00.R

class TestMVPActivity : AppCompatActivity(),TestMVPContract.View {
    lateinit var presenter: TestMVPPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test_mvpactivity)
        presenter = TestMVPPresenter(this)

        val btnShowData = findViewById<Button>(R.id.btnShowData)

        btnShowData.setOnClickListener {
            presenter.onShowDataButtonClicked()
        }
    }

    override fun showToast(name: String) {
        Toast.makeText(this, name, Toast.LENGTH_LONG).show()
    }
}