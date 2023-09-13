package devandroid.felipe.eletriccarapp

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import devandroid.felipe.eletriccarapp.adapter.CarAdapter
import devandroid.felipe.eletriccarapp.data.listCars
import devandroid.felipe.eletriccarapp.databinding.CarFragmentBinding

class CarFragment : Fragment() {

    private var _binding: CarFragmentBinding? = null
    private val binding get() = _binding!!
    private val adapter: CarAdapter = CarAdapter(listCars)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = CarFragmentBinding.inflate(inflater, container, false)

        binding.rvMainListaCarros.layoutManager = LinearLayoutManager(context)
        binding.rvMainListaCarros.adapter = adapter

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonMainNavigateCalcular.setOnClickListener {
            startActivity(Intent(context, CalcularAutonomia::class.java))
        }
    }
}