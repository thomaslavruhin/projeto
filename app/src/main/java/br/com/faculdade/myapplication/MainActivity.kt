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
        supportActionBar?.title = getString(R.string.login)

        button.setOnClickListener {
            if (et_user.text.toString().length < LENGTH_MIN) {
                makeText(getString(R.string.input_the_valid_user))
                return@setOnClickListener
            }

            if (et_password.text.toString().length < LENGTH_MIN) {
                makeText(getString(R.string.input_password_valid))
                return@setOnClickListener
            }

            val clazz =
                when {
                    et_user.text.toString().equals("Professor", true) -> TeacherActivity::class.java
                    et_user.text.toString().equals("Suporte", true) -> SupportActivity::class.java
                    else -> {
                        makeText(getString(R.string.user_not_registered))
                        null
                    }
                }

            clazz?.let {
                val passwordIsValid = et_password.text.toString() == "12345"

                if (passwordIsValid)
                    startActivity(Intent(this, it))
                else
                    makeText(getString(R.string.invalid_password))
            }

            return@setOnClickListener
        }
    }
}
