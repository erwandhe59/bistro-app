package fr.erwandhe.home_page

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment

class HomeFragment : Fragment() {

    private var buttonClickListener: OnButtonClickedListener? = null

    interface OnButtonClickedListener {
        fun onButton1Clicked()
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        buttonClickListener = context as? OnButtonClickedListener
            ?: throw RuntimeException("$context must implement OnButtonClickedListener")
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.home_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.findViewById<Button>(R.id.button1).setOnClickListener {
            buttonClickListener?.onButton1Clicked()
        }
    }

    override fun onDetach() {
        super.onDetach()
        buttonClickListener = null
    }
}
