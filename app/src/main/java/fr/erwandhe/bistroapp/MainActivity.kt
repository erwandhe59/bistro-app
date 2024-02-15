package fr.erwandhe.bistroapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import fr.erwandhe.adresse.AdresseFragment
import fr.erwandhe.home_page.HomeFragment

class MainActivity : AppCompatActivity(), HomeFragment.OnButtonClickedListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, HomeFragment())
                .commit()
        }
    }

    override fun onButton1Clicked() {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, AdresseFragment())
            .addToBackStack(null) // Permet de revenir au HomeFragment avec le bouton retour
            .commit()
    }
}
