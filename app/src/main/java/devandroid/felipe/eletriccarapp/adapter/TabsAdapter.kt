package devandroid.felipe.eletriccarapp.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import devandroid.felipe.eletriccarapp.CarFragment
import devandroid.felipe.eletriccarapp.FavoritosFragment

class TabsAdapter(fragmentActivity: FragmentActivity) : FragmentStateAdapter(fragmentActivity) {
    override fun getItemCount(): Int {
        return 2
    }

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> CarFragment()
            1 -> FavoritosFragment()
            else -> FavoritosFragment()
        }
    }
}