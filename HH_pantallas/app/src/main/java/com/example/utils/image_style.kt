package com.example.utils

import android.graphics.Color
import android.graphics.drawable.LayerDrawable
import android.graphics.drawable.ShapeDrawable
import android.graphics.drawable.shapes.OvalShape
import android.widget.ImageView

fun ImageView.circularImage() {
    this.clipToOutline = true
    this.background = null
    val shape = OvalShape()
    this.scaleType = ImageView.ScaleType.CENTER_CROP
    this.setPadding(8, 8, 8, 8)
    val shapeDrawable = ShapeDrawable(shape)
    shapeDrawable.paint.color = Color.TRANSPARENT
    val drawable = LayerDrawable(arrayOf(shapeDrawable, this.drawable))
    this.setImageDrawable(drawable)
}

// ejemplo de uso
/*
val imageView = findViewById<ImageView>(R.id.imageView)
val bitmap = BitmapFactory.decodeResource(resources, R.drawable.my_image)
imageView.setImageBitmap(bitmap)
imageView.circularImage()




 */