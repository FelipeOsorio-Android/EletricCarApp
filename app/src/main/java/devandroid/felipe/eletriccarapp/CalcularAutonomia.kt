package devandroid.felipe.eletriccarapp

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.appcompat.app.AppCompatActivity
import devandroid.felipe.eletriccarapp.databinding.ActivityCalcularAutonomiaBinding

class CalcularAutonomia : AppCompatActivity(), TextWatcher {

    private val binding by lazy {
        ActivityCalcularAutonomiaBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val editPreco = binding.editCalcularAutonomiaPrecoKwh
        val editPercorrido = binding.editCalcularAutonomiaKmPercorrido
        val buttonCalcular = binding.buttonCalcularAutonomiaCalcular

        editPreco.addTextChangedListener(this)
        editPercorrido.addTextChangedListener(this)

        buttonCalcular.setOnClickListener {
            calcularAutonomia(editPreco.text.toString(), editPercorrido.text.toString())
        }

        binding.imageCalcularAutonomiaClose.setOnClickListener { finish() }

    }

    override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

    }

    override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

        val strEditPreco = binding.editCalcularAutonomiaPrecoKwh.text.toString()
        val strEditPercorrido = binding.editCalcularAutonomiaKmPercorrido.text.toString()
        val buttonCalcularAuto = binding.buttonCalcularAutonomiaCalcular

        buttonCalcularAuto.isEnabled = strEditPreco.isNotEmpty() && strEditPercorrido.isNotEmpty()
    }

    override fun afterTextChanged(p0: Editable?) {

    }

    private fun calcularAutonomia(preco: String, percorrido: String) {
        val result = percorrido.toBigDecimal() / preco.toBigDecimal()
        binding.textCalcularAutonomiaResultado.text = "%.2f".format(result)
    }

}