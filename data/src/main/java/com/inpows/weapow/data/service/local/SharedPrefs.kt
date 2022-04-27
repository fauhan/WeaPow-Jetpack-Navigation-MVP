package com.inpows.weapow.data.service.local

import android.content.Context
import android.content.SharedPreferences
import javax.inject.Inject

class SharedPrefs @Inject constructor(private val context: Context) {
    companion object {
        private const val PREF = "WeapowPref"
        const val PREF_CITY_ID = "city_ID"
    }

    private val sharedPref: SharedPreferences = context.getSharedPreferences(PREF, Context.MODE_PRIVATE)

    fun saveCityId(token: String){
        put(PREF_CITY_ID, token)
    }

    fun getCityId() : String {
        return get(PREF_CITY_ID, String::class.java)
    }

    fun <T> get(key: String, clazz: Class<T>): T =
        when (clazz) {
            String::class.java -> sharedPref.getString(key, "")
            Boolean::class.java -> sharedPref.getBoolean(key, false)
            Float::class.java -> sharedPref.getFloat(key, -1f)
            Double::class.java -> sharedPref.getFloat(key, -1f)
            Int::class.java -> sharedPref.getInt(key, -1)
            Long::class.java -> sharedPref.getLong(key, -1L)
            else -> null
        } as T

    fun <T> put(key: String, data: T) {
        val editor = sharedPref.edit()
        when (data) {
            is String -> editor.putString(key, data)
            is Boolean -> editor.putBoolean(key, data)
            is Float -> editor.putFloat(key, data)
            is Double -> editor.putFloat(key, data.toFloat())
            is Int -> editor.putInt(key, data)
            is Long -> editor.putLong(key, data)
        }
        editor.apply()
    }

    fun clear() {
        sharedPref.edit().run {
            remove(PREF_CITY_ID)
        }.apply()
    }
}