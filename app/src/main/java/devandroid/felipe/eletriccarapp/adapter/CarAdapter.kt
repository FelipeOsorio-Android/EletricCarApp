package devandroid.felipe.eletriccarapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import devandroid.felipe.eletriccarapp.databinding.CarroItemBinding
import devandroid.felipe.eletriccarapp.domain.CarModel
import devandroid.felipe.eletriccarapp.viewholder.CarViewHolder

class CarAdapter(private val carList: List<CarModel>): RecyclerView.Adapter<CarViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CarViewHolder {
        val item = CarroItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CarViewHolder(item)
    }

    override fun getItemCount(): Int = carList.size

    override fun onBindViewHolder(holder: CarViewHolder, position: Int) {
        holder.bind(carList[position])
    }
}