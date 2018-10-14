package com.example.matheus.calculadoragasolina_etanol
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var resultado: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun calculate(v: View) {
        if((tfGas.text.toString().toDouble() * 0.7) < tfEtanol.text.toString().toDouble()){
            resultado = 1
        }else{
            resultado = 2
        }

        preencherTextView()
    }

    fun preencherTextView(){
        if(resultado == 1){
            tfResultado.setText(getString(R.string.resultGas))
        }else if(resultado == 2){
            tfResultado.setText(getString(R.string.resultEthanol))
        }else{
            tfResultado.setText(getString(R.string.error))
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)

        outState.putInt("resultado", resultado)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)

        resultado = savedInstanceState.getInt("resultado")
        preencherTextView()

    }
}