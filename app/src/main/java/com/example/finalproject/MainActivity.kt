package com.example.finalproject

import android.content.Intent
import android.graphics.Bitmap
import android.os.Bundle
import android.provider.MediaStore
import android.util.DisplayMetrics
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import java.io.ByteArrayOutputStream

class MainActivity : AppCompatActivity() {
    private val REQUESTCODE = 1000
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bCapture.setOnClickListener {
            var camera_intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            startActivityForResult(camera_intent, REQUESTCODE)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode == REQUESTCODE) {
            val displayMetrics = DisplayMetrics()
            windowManager.defaultDisplay.getMetrics(displayMetrics)
            val height = displayMetrics.heightPixels
            val width = displayMetrics.widthPixels
            val asp: Float = width/(height.toFloat())
            val img_width = width
            val img_height = (width/asp).toInt()

            var bitmap: Bitmap = data?.extras?.get("data") as Bitmap
            bitmap = Bitmap.createScaledBitmap(bitmap, img_width, img_height, true)

            //Convert to byte array
            val stream = ByteArrayOutputStream()
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, stream)
            val byteArray: ByteArray = stream.toByteArray()

            val intent: Intent = Intent(this, PaintCanvas::class.java) .apply {
                putExtra("Image", byteArray)
            }
            startActivity(intent)
        }
    }

}
