package com.example.knowledgeoverflow.widget.extention

import android.content.Context
import android.content.Intent
import androidx.fragment.app.Fragment
import java.io.Serializable

fun Fragment.startActivity(context: Context, activity: Class<*>) {
    startActivity(Intent(context, activity).addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP))
}

fun Fragment.startActivityWithFinish(context: Context, activity: Class<*>) {
    startActivity(Intent(context, activity).addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP))
    requireActivity().finish()
}

fun Fragment.startActivityWithValue(context: Context, name: String, activity: Class<*>, value: Serializable) {
    startActivity(Intent(context, activity).addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP).putExtra(name, value))
}
