package br.com.faculdade.myapplication

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import br.com.faculdade.myapplication.extesion.makeText
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    companion object {
        private const val LENGTH_MIN = 4
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.title = "Login"

        button.setOnClickListener {
            if (et_user.text.toString().length < LENGTH_MIN) {
                makeText("Digite um usuário válido")
                return@setOnClickListener
            }

            if (et_password.text.toString().length < LENGTH_MIN) {
                makeText("Digite uma senha válida")
                return@setOnClickListener
            }

            val clazz =
                when {
                    et_user.text.toString().equals("Professor", true) -> TeacherActivity::class.java
                    et_user.text.toString().equals("Suporte", true) -> TeacherActivity::class.java
                    else -> {
                        makeText("Usuário não cadastrado")
                        null
                    }
                }

            clazz?.let {
                val passwordIsValid = et_password.text.toString() == "12345"

                if (passwordIsValid)
                    startActivity(Intent(this, it))
                else
                    makeText("Senha incorreta")
            }

            return@setOnClickListener
        }
    }
}
