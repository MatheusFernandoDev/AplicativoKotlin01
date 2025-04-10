package com.example.ativ02

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.EditText
import android.widget.Toast
import com.google.android.material.navigation.NavigationView
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import androidx.drawerlayout.widget.DrawerLayout
import androidx.appcompat.app.AppCompatActivity
import com.example.ativ02.databinding.ActivityMainBinding
import java.lang.Double

class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.appBarMain.toolbar)


        val drawerLayout: DrawerLayout = binding.drawerLayout
        val navView: NavigationView = binding.navView
        val navController = findNavController(R.id.nav_host_fragment_content_main)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.nav_ciência_Da_Computacao, R.id.nav_galeria, R.id.nav_analise_e_desenvolvimento_de_sistemas, R.id.nav_quem_somos, R.id.nav_contato, R.id.nav_bem_estar
            ), drawerLayout
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_content_main)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_exit -> {
                finish()
                true
            }
            else -> super.onOptionsItemSelected(item)


        }
    }

    fun calcularIMC(view: View) {
        val alturaEditText: EditText = findViewById(R.id.editTextNumberDecimal)
        val pesoEditText: EditText = findViewById(R.id.editTextNumberDecimal2)

        try {
            val altura = Double.parseDouble(alturaEditText.text.toString())
            val peso = Double.parseDouble(pesoEditText.text.toString())

            if (altura > 0) {
                val imc = peso / (altura * altura)
                val classificacao = classificarIMC(imc)

                Toast.makeText(view.context, "IMC: %.2f\n$classificacao".format(imc), Toast.LENGTH_LONG).show()
            } else {
                Toast.makeText(view.context, "Altura deve ser maior que 0", Toast.LENGTH_SHORT).show()
            }
        } catch (e: NumberFormatException) {
            Toast.makeText(view.context, "Por favor, insira valores válidos", Toast.LENGTH_SHORT).show()
        }
    }

    fun classificarIMC(imc: kotlin.Double): String {
        return when {
            imc < 18.5 -> "Abaixo do peso"
            imc < 25.0 -> "Peso normal"
            imc < 30.0 -> "Sobrepeso"
            imc < 35.0 -> "Obesidade grau 1"
            imc < 40.0 -> "Obesidade grau 2"
            else -> "Obesidade grau 3"
        }
    }

    fun calcularMedia(view: View) {
        val nota01EditText: EditText = findViewById(R.id.editTextNumberDecimal3)
        val nota02EditText: EditText = findViewById(R.id.editTextNumberDecimal4)
        val nota03EditText: EditText = findViewById(R.id.editTextNumberDecimal5)

        try {
            val n1 = nota01EditText.text.toString().toDouble()
            val n2 = nota02EditText.text.toString().toDouble()
            val n3 = nota03EditText.text.toString().toDouble()

            val resultado = calcularSituacao(n1, n2, n3)

            Toast.makeText(view.context, resultado, Toast.LENGTH_LONG).show()

        } catch (e: NumberFormatException) {
            Toast.makeText(
                view.context,
                "Preencha todas as notas corretamente!",
                Toast.LENGTH_SHORT
            ).show()
        }
    }

    fun calcularSituacao(n1: kotlin.Double, n2: kotlin.Double, n3: kotlin.Double): String {
        val media = (n1 + n2 + n3) / 3
        val situacao = if (media >= 6.0) "Aprovado" else "Reprovado"
        return "Média: %.2f\nSituação: %s".format(media, situacao)
    }
}