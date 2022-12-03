package com.example.bmi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.bmi.databinding.ActivityMainBinding
import kotlin.math.pow

class MainActivity : AppCompatActivity() {
    //Module level variable
    //lateint = late initialize
    //val =value vs var = variable
    private lateinit var binding:ActivityMainBinding //give memory first then initiliaze later
    //if do this no need declare so many variable

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //inflate = display the UI
        binding=ActivityMainBinding.inflate(layoutInflater)
        //root = top of a tree structure -> Layout
        setContentView(binding.root)
        //local variable
        binding.buttonReset.setOnClickListener{


        }


        binding.buttonCalculate.setOnClickListener {

            if(binding.editTextHeight.text.isEmpty()){
                binding.editTextHeight.setError(getString(R.string.value_reuired))
                return@setOnClickListener



            }
            if(binding.editTextWeight.text.isEmpty()){

                binding.editTextWeight.setError(getString(R.string.value_reuired))
                return@setOnClickListener

            }

             val weight = binding.editTextWeight.text.toString().toFloat()
            val height = binding.editTextHeight.text.toString().toFloat()
            val bmi=weight/(height/100).pow(2)
            if(bmi<18.5){
                //Underweight
                binding.textViewBMI.text=String.format("%s:%.2f (%s)",getString(R.string.underweight),binding.imageViewBMI.setImageResource(R.drawable.under))


            }else if(bmi<24.9 && bmi>18.5) {
                binding.textViewBMI.text = String.format(
                    "%s:%.2f (%s)",
                    getString(R.string.normal),
                    binding.imageViewBMI.setImageResource(R.drawable.normal)
                )
            }else if(bmi>24.9){
                binding.textViewBMI.text=String.format("%s:%.2f (%s)",getString(R.string.overweight),binding.imageViewBMI.setImageResource(R.drawable.over))


            }

        }
    }
}