package com.example.finalproject

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity


class PaintCanvas : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val bmp: Bitmap
        val byteArray = intent.getByteArrayExtra("Image")
        bmp = BitmapFactory.decodeByteArray(byteArray, 0, byteArray.size)

        val paintView: PaintView = PaintView(this, bmp)
        setContentView(paintView)
    }
}
