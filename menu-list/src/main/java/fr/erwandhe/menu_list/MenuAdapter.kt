package fr.erwandhe.menu_list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import fr.erwandhe.menu_list.data.MenuModel

class MenuAdapter(private val menuList: List<MenuModel>, private val onClick: (MenuModel) -> Unit) : RecyclerView.Adapter<MenuAdapter.MenuViewHolder>() {

    class MenuViewHolder(view: View, onClick: (MenuModel) -> Unit) : RecyclerView.ViewHolder(view) {
        private val titleTextView: TextView = view.findViewById(R.id.menuItemTitle)
        private var currentItem: MenuModel? = null

        init {
            view.setOnClickListener {
                currentItem?.let(onClick)
            }
        }

        fun bind(menuItem: MenuModel) {
            currentItem = menuItem
            titleTextView.text = menuItem.title
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MenuViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_menu, parent, false)
        return MenuViewHolder(view, onClick)
    }

    override fun onBindViewHolder(holder: MenuViewHolder, position: Int) {
        holder.bind(menuList[position])
    }

    override fun getItemCount(): Int = menuList.size
}
