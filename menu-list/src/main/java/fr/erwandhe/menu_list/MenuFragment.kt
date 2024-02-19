package fr.erwandhe.menu_list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import fr.erwandhe.menu_list.data.MenuModel

class MenuFragment<T> : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.menu_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val menuList = listOf(MenuModel("Café au lait", "2€50"), MenuModel("Thé vert", "3€"))
        val recyclerView = view.findViewById<RecyclerView>(R.id.menuRecyclerView)
        recyclerView.layoutManager = LinearLayoutManager(context)

        val menuAdapter = MenuAdapter(menuList) { menuItem ->
            val detailFragment = DetailFragment.newInstance(menuItem.title, menuItem.description)
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragment_menu, detailFragment) // Use correct container ID here
                .commit()
        }
        recyclerView.adapter = menuAdapter
    }
}