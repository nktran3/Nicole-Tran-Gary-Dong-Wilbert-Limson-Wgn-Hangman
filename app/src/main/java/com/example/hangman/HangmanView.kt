package com.example.hangman

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View


class HangmanView(context: Context, attrs: AttributeSet) : View(context, attrs) {
    private val paint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        style = Paint.Style.STROKE
        strokeWidth = 8f
        color = Color.BLACK
    }
    public var incorrectGuesses: Int = 0
        set(value) {
            field = value
            invalidate()
        }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
            // Draw the gallows
            canvas.drawLine(100f, height.toFloat(), 100f, 0f, paint)
            canvas.drawLine(100f, 0f, width / 2f, 0f, paint)
            canvas.drawLine(width / 2f, 0f, width / 2f, 100f, paint)

            // Draw the hangman based on the number of incorrect guesses
            if (incorrectGuesses > 0) canvas.drawCircle(width / 2f, 150f, 50f, paint) // Head
            if (incorrectGuesses > 1) canvas.drawLine(width / 2f, 200f, width / 2f, 400f, paint) // Body
            if (incorrectGuesses > 2) canvas.drawLine(width / 2f, 250f, width / 3f, 300f, paint) // Left arm
            if (incorrectGuesses > 3) canvas.drawLine(width / 2f, 250f, 2 * width / 3f, 300f, paint) // Right arm
            if (incorrectGuesses > 4) canvas.drawLine(width / 2f, 400f, width / 3f, 500f, paint) // Left leg
            if (incorrectGuesses > 5) canvas.drawLine(width / 2f, 400f, 2 * width / 3f, 500f, paint) // Right leg
    }
}