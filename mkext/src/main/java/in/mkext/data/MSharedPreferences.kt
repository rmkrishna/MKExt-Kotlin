package `in`.mkext.data

import android.content.Context
import android.content.SharedPreferences

/**
 * Created by muthu on 7/4/18.
 */
object MSharedPreferences {
    lateinit var sharedPreferences: SharedPreferences

    fun init(context: Context, preferencesName: String = context.packageName) {
        sharedPreferences = context.getSharedPreferences(preferencesName, Context.MODE_PRIVATE)
    }
}

fun String.getBoolean(defaultValue: Boolean = false): Boolean {
    return MSharedPreferences.sharedPreferences.getBoolean(this, defaultValue)
}

fun String.getInt(defaultValue: Int = 0): Int {
    return MSharedPreferences.sharedPreferences.getInt(this, defaultValue)
}

fun String.getFloat(defaultValue: Float = 0.0f): Float {
    return MSharedPreferences.sharedPreferences.getFloat(this, defaultValue)
}

fun String.getLong(defaultValue: Long = 0): Long {
    return MSharedPreferences.sharedPreferences.getLong(this, defaultValue)
}

fun String.getString(defaultValue: String = ""): String {
    return MSharedPreferences.sharedPreferences.getString(this, defaultValue)
}

fun String.getStringSet(defaultValue: Set<String>): Set<String> {
    return MSharedPreferences.sharedPreferences.getStringSet(this, defaultValue)
}

fun String.putBoolean(value: Boolean = false) {
    MSharedPreferences.sharedPreferences.edit()?.putBoolean(this, value)?.apply()
}

fun String.putInt(value: Int = 0) {
    MSharedPreferences.sharedPreferences.edit()?.putInt(this, value)?.apply()
}

fun String.putFloat(value: Float = 0.0f) {
    MSharedPreferences.sharedPreferences.edit()?.putFloat(this, value)?.apply()
}

fun String.putLong(value: Long = 0) {
    MSharedPreferences.sharedPreferences.edit()?.putLong(this, value)?.apply()
}

fun String.putString(value: String = "") {
    MSharedPreferences.sharedPreferences.edit()?.putString(this, value)?.apply()
}

fun String.putStringSet(value: Set<String>) {
    MSharedPreferences.sharedPreferences.edit()?.putStringSet(this, value)?.apply()
}