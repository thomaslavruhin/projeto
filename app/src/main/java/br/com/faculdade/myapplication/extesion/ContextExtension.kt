package br.com.faculdade.myapplication.extesion

import android.content.Context
import android.widget.Toast

fun Context.makeText(text : String) {
    Toast.makeText(this, text, Toast.LENGTH_SHORT).show()
}