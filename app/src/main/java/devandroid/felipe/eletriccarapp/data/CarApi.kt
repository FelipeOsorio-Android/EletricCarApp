package devandroid.felipe.eletriccarapp.data

import devandroid.felipe.eletriccarapp.domain.CarModel
import retrofit2.Call
import retrofit2.http.GET

interface CarApi {

    @GET("cars.json")
    fun getAllCars() : Call<List<CarModel>>
}