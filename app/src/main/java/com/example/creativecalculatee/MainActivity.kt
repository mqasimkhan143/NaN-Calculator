package com.example.creativecalculatee

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.WindowManager
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.ImageButton
import android.widget.PopupWindow
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private lateinit var showPopupInstruct : Button
    private lateinit var Items : TextView
    private lateinit var Outfit : String
    var stringList = mutableListOf<String>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Items = findViewById(R.id.selectedItems)

        val infobutton = findViewById<Button>(R.id.infoButton)
        infobutton.setOnClickListener{
            Toast.makeText(this, "Info", Toast.LENGTH_SHORT).show()

            val inflater = layoutInflater
            val view = inflater.inflate(R.layout.popup, null)

            val window = PopupWindow(view, WindowManager.LayoutParams.WRAP_CONTENT, WindowManager.LayoutParams.WRAP_CONTENT, true)

            window.showAtLocation(view, Gravity.CENTER, 0, 0)
        }
    }

    fun onOutfitButtonClick(view: View){
        val zoomInAnimation = AnimationUtils.loadAnimation(this, R.anim.zoom_in)
        view.startAnimation(zoomInAnimation)

        Outfit = when (view.id){
            R.id.tee -> "T-Shirt"
            R.id.jean -> "Jeans"
            R.id.cargo -> "Cargo Pants"

            else -> ""
        }
        stringList.add(Outfit)
        Items.text = "$stringList selected"
    }

    fun onGetOutfitButtonClick(view: View){
        val selectedOutfits = stringList
        val matchMessage = when (selectedOutfits.size){
            0 -> "No Outfits Selected"
            1 -> "Choose 1 more Outfit"
            2 -> {
                if("T-Shirt" in selectedOutfits && "Jeans" in selectedOutfits) {
                    "Its a Match!"
                } else if("T-Shirt" in selectedOutfits && "Cargo Pants" in selectedOutfits) {
                    "Its not a Match!"
                } else if("Cargo Pants" in selectedOutfits && "Jeans" in selectedOutfits) {
                    "Please choose another type of outfit"
                } else {
                    "INVALID"
                }
            }
            3 -> "Please Choose 2 Outfits"
            else -> "INVALID"

        }
        Items.text = matchMessage
        stringList.clear()
    }

    private fun showPopup(){

    }
}