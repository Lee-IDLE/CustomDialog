package com.example.customdialog

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {

    var btnImageButtons : ImageButton? = null
    var btnAlert : Button? = null
    var btnCustom : Button? = null
    var btnCustomProgress : Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnImageButtons = findViewById(R.id.llImageButtons)
        btnImageButtons?.setOnClickListener{ view ->
            Snackbar.make(view, "You hav clicked image button", Snackbar.LENGTH_SHORT).show()
        }

        btnAlert = findViewById(R.id.btnAlert)
        btnAlert?.setOnClickListener {view ->
            alertDialogFunction()
        }
    }

    private fun alertDialogFunction() {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Alert")
        builder.setMessage("This is Alert Dialog. Which is usd to show alert!")
        builder.setIcon(android.R.drawable.ic_dialog_alert)

        builder.setPositiveButton("Yes") { dialogInterface, which->
            Toast.makeText(applicationContext, "clicked yes", Toast.LENGTH_SHORT).show()
            dialogInterface.dismiss()
        }

        builder.setNeutralButton("Cancel"){ dialogInterface, which ->
            Toast.makeText(applicationContext, "clicked Cancel", Toast.LENGTH_SHORT).show()
            dialogInterface.dismiss()
        }

        builder.setNegativeButton("No"){ dialogInterface, which ->
            Toast.makeText(applicationContext, "clicked No", Toast.LENGTH_SHORT).show()
            dialogInterface.dismiss()
        }

        val alertDialog = builder.create()
        alertDialog.setCancelable(false)
        alertDialog.show()
    }
}