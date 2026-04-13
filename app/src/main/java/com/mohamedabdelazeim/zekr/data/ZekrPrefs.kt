package com.mohamedabdelazeim.zekr.data

import android.content.Context

object ZekrPrefs {
    private const val PREFS = "zekr_prefs"
    
    // مفاتيح الحفظ القديمة
    private const val KEY_INTERVAL = "interval"
    private const val KEY_ENABLED = "enabled"
    private const val KEY_ZEKR_INDEX = "zekr_index"
    
    // مفاتيح الحفظ الجديدة (لوضع التكرار)
    private const val KEY_PLAYBACK_MODE = "playback_mode"
    private const val KEY_REPEAT_INDEX = "repeat_selected_index"

    // ========== الدوال القديمة ==========
    fun getIntervalInMinutes(ctx: Context) =
        ctx.getSharedPreferences(PREFS, Context.MODE_PRIVATE).getInt(KEY_INTERVAL, 30)

    fun setIntervalInMinutes(ctx: Context, v: Int) =
        ctx.getSharedPreferences(PREFS, Context.MODE_PRIVATE).edit().putInt(KEY_INTERVAL, v).apply()

    fun isEnabled(ctx: Context) =
        ctx.getSharedPreferences(PREFS, Context.MODE_PRIVATE).getBoolean(KEY_ENABLED, false)

    fun setEnabled(ctx: Context, v: Boolean) =
        ctx.getSharedPreferences(PREFS, Context.MODE_PRIVATE).edit().putBoolean(KEY_ENABLED, v).apply()

    fun nextZekrIndex(ctx: Context): Int {
        val prefs = ctx.getSharedPreferences(PREFS, Context.MODE_PRIVATE)
        val current = prefs.getInt(KEY_ZEKR_INDEX, 0)
        val next = (current + 1) % ZekrData.zekrList.size
        prefs.edit().putInt(KEY_ZEKR_INDEX, next).apply()
        return current
    }

    // ========== الدوال الجديدة ==========
    fun getPlaybackMode(ctx: Context): Int {
        return ctx.getSharedPreferences(PREFS, Context.MODE_PRIVATE)
            .getInt(KEY_PLAYBACK_MODE, 0)
    }

    fun setPlaybackMode(ctx: Context, mode: Int) {
        ctx.getSharedPreferences(PREFS, Context.MODE_PRIVATE)
            .edit().putInt(KEY_PLAYBACK_MODE, mode).apply()
    }

    fun getRepeatIndex(ctx: Context): Int {
        return ctx.getSharedPreferences(PREFS, Context.MODE_PRIVATE)
            .getInt(KEY_REPEAT_INDEX, 0)
    }

    fun setRepeatIndex(ctx: Context, index: Int) {
        ctx.getSharedPreferences(PREFS, Context.MODE_PRIVATE)
            .edit().putInt(KEY_REPEAT_INDEX, index).apply()
    }
}
