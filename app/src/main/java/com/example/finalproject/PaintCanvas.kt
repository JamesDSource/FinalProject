package com.example.finalproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class PaintCanvas : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val paintView: PaintView = PaintView(this)
        setContentView(paintView)
    }
}
