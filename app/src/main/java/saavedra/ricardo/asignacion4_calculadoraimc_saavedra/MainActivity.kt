package saavedra.ricardo.asignacion4_calculadoraimc_saavedra

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView



class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val weight : EditText =  findViewById(R.id.weight) as EditText
        val imagepan : ImageView =  findViewById(R.id.imageView) as ImageView
        val height : EditText =  findViewById(R.id.height) as EditText
        val calcular : Button =  findViewById(R.id.buttonCalcular) as Button
        val imcText : TextView =  findViewById(R.id.textViewImc) as TextView
        val range : TextView =  findViewById(R.id.textViewRange) as TextView

        calcular.setOnClickListener {
            var imc: Double =
                calcularIMC(weight.text.toString().toDouble(),
                    height.text.toString().toDouble())

            var imcTexto= imc.toString()

            imcText.setText(imcTexto)

            if(imc <= 18.5 ){
               range.setText("Bajo peso")
               range.setBackgroundResource(R.color.Greenish)
            }else if(imc>= 18.6 && imc <=24.9){
               range.setText("Normal")
                range.setBackgroundResource(R.color.Green)
            }else if(imc>= 25 && imc <=29.9){
                range.setText("Sobrepeso")
                range.setBackgroundResource(R.color.yellow)
            }else if(imc>= 30 && imc <=34.9){
                range.setText("Obesidad grado 1")
                range.setBackgroundResource(R.color.orange)
            }else if(imc>= 35 && imc <=39.9){
                range.setText("Obesidad grado 2")
                range.setBackgroundResource(R.color.red)
            }else if(imc>= 40){
                range.setText("Obesidad grado 3")
                range.setBackgroundResource(R.color.brown)
            }

        }

    }

    fun calcularIMC(weight: Double,height: Double):Double {
        return weight/(Math.pow(height,2.0))
    }



}