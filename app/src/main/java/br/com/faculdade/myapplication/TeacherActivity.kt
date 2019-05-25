package br.com.faculdade.myapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import br.com.faculdade.myapplication.database.DataBaseFactory
import br.com.faculdade.myapplication.database.entity.SupportDto
import br.com.faculdade.myapplication.extesion.makeText
import kotlinx.android.synthetic.main.activity_teacher.*

class TeacherActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_teacher)

        button.setOnClickListener {
            val problem = edittext_descibre_problem.text.toString()
            val where = edittext_where.text.toString()

            if (validate(problem, where)) {
                Thread {
                    DataBaseFactory
                        .provideDatabase(this)
                        .supportDao()
                        .insertSupport(SupportDto(where, problem))

                    runOnUiThread {
                        whenSavedSupport()
                    }

                }.start()
            }
        }
    }

    private fun whenSavedSupport() {
        makeText("Suporte adicionado com sucesso")
        finish()
    }

    private fun validate(problem: String, where: String): Boolean {
        val validate = problem.isNotEmpty() && where.isNotEmpty()
        if (!validate) {
            makeText(getString(R.string.validate_error))
        }
        return validate
    }

}
