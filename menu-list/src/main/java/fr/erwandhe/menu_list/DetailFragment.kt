package fr.erwandhe.menu_list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment

class DetailFragment : Fragment() {

    companion object {
        private const val ARG_TITLE = "title"
        private const val ARG_DESC = "description"

        fun newInstance(title: String, description: String): DetailFragment {
            return DetailFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_TITLE, title)
                    putString(ARG_DESC, description)
                }
            }
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.detail_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val title = arguments?.getString(ARG_TITLE)
        val description = arguments?.getString(ARG_DESC)
        view.findViewById<TextView>(R.id.detailTitle).text = title
        // Assurez-vous d'avoir un TextView pour la description dans votre layout XML.
        view.findViewById<TextView>(R.id.detailDescription).text = description
    }
}
