package com.example.myapplication

import android.os.Bundle
import android.view.View
import android.graphics.Color
import android.widget.TextView
import androidx.activity.ComponentActivity
import androidx.core.content.ContextCompat
import com.example.mylibrary.TextFunction
import com.igalata.bubblepicker.model.BubbleGradient
import com.igalata.bubblepicker.BubblePickerListener
import com.igalata.bubblepicker.adapter.BubblePickerAdapter
import com.igalata.bubblepicker.model.PickerItem
import com.igalata.bubblepicker.rendering.BubblePicker

class MainActivity : ComponentActivity()
{
    private val textFunction = TextFunction()
    private var count = 0
    private val picker: BubblePicker by lazy { findViewById(R.id.picker) }

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.bubblepickerlayout)

        //val titles = resources.getStringArray(R.array.countries)
        //val colors = resources.obtainTypedArray(R.array.colors)
        //val images = resources.obtainTypedArray(R.array.images)

        picker.bubbleSize = 20
        picker.centerImmediately = true
        picker.adapter = object : BubblePickerAdapter
        {
            val titles = arrayOf("Title 1", "Title 2", "Title 3")

            override val totalCount = titles.size

            override fun getItem(position: Int): PickerItem
            {
                return PickerItem().apply {
                    title = titles[position]
                    gradient = BubbleGradient(Color.parseColor("#FFCDD2"), Color.parseColor("#D81B60"), BubbleGradient.VERTICAL)
                    textColor = ContextCompat.getColor(this@MainActivity, android.R.color.white)
                }
            }
        }
        picker.listener = object : BubblePickerListener {
            override fun onBubbleSelected(item: PickerItem) {
            }

            override fun onBubbleDeselected(item: PickerItem) {
            }
        }
    }

    override fun onResume()
    {
        super.onResume()
        picker.onResume()
    }

    override fun onPause()
    {
        super.onPause()
        picker.onPause()
    }

    fun Click(view: View)
    {
        count = textFunction.ButtonClick(count)
        val text: TextView = findViewById(R.id.myText)
        text.setText(count.toString())
    }
}