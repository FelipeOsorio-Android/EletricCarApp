package devandroid.felipe.eletriccarapp.viewholder

import androidx.recyclerview.widget.RecyclerView
import devandroid.felipe.eletriccarapp.databinding.CarroItemBinding
import devandroid.felipe.eletriccarapp.domain.CarModel

class CarViewHolder(private val item: CarroItemBinding) : RecyclerView.ViewHolder(item.root) {
    fun bind(carro: CarModel) {
        item.textLabelPrecoValue.text = carro.preco
        item.textLabelBateriaValue.text = carro.bateria
        item.textLabelPotenciaValue.text = carro.potencia
        item.textLabelRecargaValue.text = carro.recarga
    }
}