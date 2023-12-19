package com.example.camview_example

import android.graphics.Color
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.echo.holographlibrary.PieSlice
import com.example.camview_example.databinding.ActivityPieGraphBinding
import com.google.android.material.snackbar.Snackbar
import java.util.Random


class PieGraphActivity : AppCompatActivity() {
    private lateinit var binding: ActivityPieGraphBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPieGraphBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        graph()
    }
    private fun graph(){

        val pg = binding.graph
        var slice = PieSlice()
        slice.color = Color.parseColor("#99CC00")
        slice.value = 2f
        pg.addSlice(slice)
        slice = PieSlice()
        slice.color = Color.parseColor("#FFBB33")
        slice.value = 3f
        pg.addSlice(slice)
        slice = PieSlice()
        slice.color = Color.parseColor("#AA66CC")
        slice.value = 8f
        pg.addSlice(slice)
    }

    fun graph(view: View) {
        if(binding.editTextValue1.text.isBlank() || binding.editTextValue2.text.isBlank() || binding.editTextValue3.text.isBlank()){
            Snackbar.make(binding.root, "Please fill in all fields", Snackbar.LENGTH_SHORT).show()
            return
        }
        val pg = binding.graph
        pg.removeSlices()
        var slice = PieSlice()
        slice.color = getRandomColor()
        slice.value = binding.editTextValue1.text.toString().toFloat()
        pg.addSlice(slice)
        slice = PieSlice()
        slice.color = getRandomColor()
        slice.value = binding.editTextValue2.text.toString().toFloat()
        pg.addSlice(slice)
        slice = PieSlice()
        slice.color = getRandomColor()
        slice.value = binding.editTextValue3.text.toString().toFloat()
        pg.addSlice(slice)
        pg.setInnerCircleRatio(40)
    }
    private fun getRandomColor(): Int {
        val random = Random()
        val red = random.nextInt(256)
        val green = random.nextInt(256)
        val blue = random.nextInt(256)
        return Color.rgb(red, green, blue)
    }
}