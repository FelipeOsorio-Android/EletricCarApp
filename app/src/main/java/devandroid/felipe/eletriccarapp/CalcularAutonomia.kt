package devandroid.felipe.eletriccarapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.core.widget.doOnTextChanged
import devandroid.felipe.eletriccarapp.databinding.ActivityCalcularAutonomiaBinding
import java.math.BigDecimal

class CalcularAutonomia : AppCompatActivity(), TextWatcher {

    private val binding by lazy {
        ActivityCalcularAutonomiaBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.editCalcularAutonomiaPrecoKwh.addTextChangedListener(this)
        binding.editCalcularAutonomiaKmPercorrido.addTextChangedListener(this)

        binding.imageCalcularAutonomiaClose.setOnClickListener { finish() }

    }

    override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

    }

    override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
        val editPreco = binding.editCalcularAutonomiaPrecoKwh.text.toString()
        val editPercorrido = binding.editCalcularAutonomiaKmPercorrido.text.toString()
        val buttonCalcular = binding.buttonCalcularAutonomiaCalcular

        buttonCalcular.isEnabled = editPreco.isNotEmpty() && editPercorrido.isNotEmpty()
        buttonCalcular.setOnClickListener { calcularAutonomia(editPreco, editPercorrido) }
    }

    override fun afterTextChanged(p0: Editable?) {

    }

    private fun calcularAutonomia(preco: String, percorrido: String) {
        val result = percorrido.toBigDecimal() / preco.toBigDecimal()
        binding.textCalcularAutonomiaResultado.text = "%.2f".format(result)
    }

}