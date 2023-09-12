package devandroid.felipe.eletriccarapp

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import devandroid.felipe.eletriccarapp.adapter.CarAdapter
import devandroid.felipe.eletriccarapp.data.listCars
import devandroid.felipe.eletriccarapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }
    private val adapter: CarAdapter = CarAdapter(listCars)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.buttonMainNavigateCalcular.setOnClickListener {
            startActivity(Intent(this, CalcularAutonomia::class.java))
        }

        binding.rvMainListaCarros.layoutManager = LinearLayoutManager(this)
        binding.rvMainListaCarros.adapter = adapter
    }
}