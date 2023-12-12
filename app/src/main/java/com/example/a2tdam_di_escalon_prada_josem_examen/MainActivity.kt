package com.example.a2tdam_di_escalon_prada_josem_examen

import android.icu.text.SimpleDateFormat
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.Button
import androidx.annotation.RequiresApi
import androidx.core.content.ContextCompat
import androidx.core.widget.addTextChangedListener
import com.google.android.material.datepicker.MaterialDatePicker
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.Locale
import kotlin.random.Random


fun decorate(view: View, mode: String)
{
    if(mode.equals("success"))
    {
        view.setBackgroundColor(ContextCompat.getColor(view.context, R.color.success))
    }else{
        view.setBackgroundColor(ContextCompat.getColor(view.context, R.color.wrong))
    }

}

class MainActivity : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var dateEdit = findViewById<TextInputEditText>(R.id.dateEdit)
        var dateLayout = findViewById<TextInputLayout>(R.id.date)
        var selectTypes = findViewById<AutoCompleteTextView>(R.id.actvTipos)
        var nameEdit = findViewById<TextInputEditText>(R.id.nameEdit)
        var nameLayout = findViewById<TextInputLayout>(R.id.name)
        var trainerEdit = findViewById<TextInputEditText>(R.id.trainerEdit)
        var trainerLayout = findViewById<TextInputLayout>(R.id.trainer)
        var heightEdit = findViewById<TextInputEditText>(R.id.heightEdit)
        var heightLayout = findViewById<TextInputLayout>(R.id.height)
        var send = findViewById<Button>(R.id.send)


        var errors = mutableListOf<Boolean>(true,true,true,true)


        val types = listOf(
            "Normal",
            "Fire",
            "Water",
            "Grass",
            "Electric",
            "Ice",
            "Fighting",
            "Poison",
            "Ground",
            "Flying",
            "Psychic",
            "Bug",
            "Rock",
            "Ghost",
            "Dragon",
            "Dark",
            "Steel",
            "Fairy"
        )
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item,types)
        selectTypes.setAdapter(adapter)

        dateEdit.setOnClickListener {
            val builder = MaterialDatePicker.Builder.datePicker().setTitleText("Selecciona la fecha de captura")
            val picker = builder.build()

            picker.addOnPositiveButtonClickListener {
                dateEdit.setText(picker.headerText)
            }
            picker.show(supportFragmentManager,picker.toString())
        }

        nameEdit.addTextChangedListener {

            var name = nameEdit?.text.toString()

            if(name.isBlank() || name.isEmpty())
            {
                errors[0] = true
                nameLayout.error = "Este campo es necesario"
                decorate(nameEdit, "")

            }else if (!name.matches(Regex("^\\b[A-Z][a-zA-Z]{2,}\\b$")))
            {
                errors[0] = true
                nameLayout.error = "Longitud mínima: 3, primera letra mayúscula"
                decorate(nameEdit, "")
            }else{
                nameLayout.error = null
                errors[0] = false
                decorate(nameEdit, "success")
            }
        }

        trainerEdit.addTextChangedListener {

            var trainer = trainerEdit?.text.toString()

            if(trainer.isBlank() || trainer.isEmpty())
            {
                errors[1] = true
                trainerLayout.error = "Este campo es necesario"
                decorate(trainerEdit, "")

            }else if (!trainer.matches(Regex("^(?=(.*[aeiouAEIOU]))[a-zA-Z\\d]{1,25}\$")))
            {
                errors[1] = true
                trainerLayout.error = "Longitud mínima: 25, una vocal"
                decorate(trainerEdit, "")
            }else{
                trainerLayout.error = null
                errors[1] = false
                decorate(trainerEdit, "success")
            }
        }

        heightEdit.addTextChangedListener {

            var height = heightEdit?.text.toString()

            if(height.isBlank() || height.isEmpty())
            {
                errors[2] = true
                heightLayout.error = "Este campo es necesario"
                decorate(heightEdit, "")

            }else if (!height.matches(Regex("^\\d+\$")))
            {
                errors[2] = true
                heightLayout.error = "Debe estar en centímetros, sin comas"
                decorate(heightEdit, "")
            }else{
                heightLayout.error = null
                errors[2] = false
                decorate(heightEdit, "success")
            }
        }


        send.setOnClickListener {

            val enteredDateStr = dateEdit.text.toString()
            val formatFecha = SimpleDateFormat("dd/mm/yy", Locale.getDefault());
            if (formatFecha != null && formatFecha > ) {
                decorate(dateEdit, "")
                dateLayout.error = "La fecha no puede ser posterior a hoy"
                errors[3] = true
            } else {
                decorate(dateEdit, "success")
                dateLayout.error = ""
                errors[3] = false
            }


            if(!(true in errors))
            {
                send.text = ":D"
            }
        }

    }
}