package br.com.faculdade.myapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.com.faculdade.myapplication.database.entity.SupportDto

class SupportAdapter(private val list : List<SupportDto>) : RecyclerView.Adapter<SupportHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SupportHolder {
        return SupportHolder(
            LayoutInflater
                .from(parent.context)
                .inflate(R.layout.holder_support, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: SupportHolder, position: Int) {
        holder.bind(list[position])
    }

}


class SupportHolder(view : View) : RecyclerView.ViewHolder(view) {
    private val textViewWhere : TextView = view.findViewById(R.id.textview_where)
    private val textviewProblem : TextView = view.findViewById(R.id.textview_problem)

    fun bind(support : SupportDto) {
        textViewWhere.text = "Em ${support.where}"
        textviewProblem.text = support.problem
    }
}