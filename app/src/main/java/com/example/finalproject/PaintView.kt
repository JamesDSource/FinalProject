package com.example.finalproject

import android.app.ActionBar
import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.view.View
import android.view.ViewGroup.LayoutParams
import android.graphics.Path
import android.view.MotionEvent

class PaintView(context: Context?) : View(context) {

    val path: Path = Path()
    val paint: Paint = Paint()
    val params: LayoutParams = LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT)

    init {
        paint.isAntiAlias = true
        paint.color = Color.MAGENTA
        paint.style = Paint.Style.STROKE
        paint.strokeJoin = Paint.Join.ROUND
        paint.strokeWidth = 8f
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        val pointX = event!!.x
        val pointY = event.y

        when(event.action) {
            MotionEvent.ACTION_DOWN -> {
                path.moveTo(pointX, pointY)
                return true
            }

            MotionEvent.ACTION_MOVE -> {
                path.lineTo(pointX, pointY)
            }
        }
        postInvalidate()
        return false
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        canvas?.drawPath(path, paint)
    }
}