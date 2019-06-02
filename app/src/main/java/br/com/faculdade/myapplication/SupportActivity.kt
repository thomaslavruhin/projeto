package br.com.faculdade.myapplication

import android.os.Bundle
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.faculdade.myapplication.database.DataBaseFactory
import br.com.faculdade.myapplication.extesion.makeText
import kotlinx.android.synthetic.main.activity_support.*


class SupportActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_support)

        recyclerview.layoutManager = LinearLayoutManager(this)
        recyclerview.addItemDecoration(DividerItemDecoration(this, LinearLayout.VERTICAL))
        initAdapter()

    }

    private fun initAdapter() {
        Thread {

            val fetchSupport = DataBaseFactory
                .provideDatabase(this)
                .supportDao()
                .fetchSupport()

            runOnUiThread {

                if(fetchSupport.isEmpty()) {
                    makeText(getString(R.string.not_exists_problems_yet))
                } else {
                    recyclerview.adapter = SupportAdapter(fetchSupport)
                }
            }

        }.start()
    }
}