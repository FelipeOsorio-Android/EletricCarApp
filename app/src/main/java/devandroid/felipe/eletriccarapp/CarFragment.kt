package devandroid.felipe.eletriccarapp

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import devandroid.felipe.eletriccarapp.adapter.CarAdapter
import devandroid.felipe.eletriccarapp.data.CarApi
import devandroid.felipe.eletriccarapp.databinding.CarFragmentBinding
import devandroid.felipe.eletriccarapp.domain.CarModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class CarFragment : Fragment() {

    private var _binding: CarFragmentBinding? = null
    private val binding get() = _binding!!
    private lateinit var adapter: CarAdapter
    private lateinit var carApi: CarApi


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = CarFragmentBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupRetrofit()
        getAllCars()

        binding.rvCarFragmentListaCarros.layoutManager = LinearLayoutManager(context)


        binding.fabCarFragmentCalcular.setOnClickListener {
            startActivity(Intent(context, CalcularAutonomia::class.java))
        }
    }

    private fun setupRetrofit() {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://igorbag.github.io/cars-api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        carApi = retrofit.create(CarApi::class.java)
    }

    private fun getAllCars() {

        carApi.getAllCars().enqueue(object : Callback<List<CarModel>> {
            override fun onResponse(call: Call<List<CarModel>>, response: Response<List<CarModel>>) {
               if(response.isSuccessful) {
                   response.body()?.let {
                       adapter = CarAdapter(it)
                       binding.rvCarFragmentListaCarros.adapter = adapter
                   }
               } else {
                   Toast.makeText(context, "Error Response", Toast.LENGTH_SHORT).show()
               }
            }

            override fun onFailure(call: Call<List<CarModel>>, t: Throwable) {
                Toast.makeText(context, "Error Response", Toast.LENGTH_SHORT).show()
            }

        })
    }
}