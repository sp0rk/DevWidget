package io.github.sp0rk.devwidget

import android.app.PendingIntent
import android.appwidget.AppWidgetManager
import android.appwidget.AppWidgetProvider
import android.content.Context
import android.content.Intent
import android.provider.Settings.ACTION_APPLICATION_DEVELOPMENT_SETTINGS
import android.widget.RemoteViews

class DevWidget : AppWidgetProvider() {
    override fun onUpdate(
        context: Context,
        appWidgetManager: AppWidgetManager,
        appWidgetIds: IntArray
    ) = appWidgetIds.forEach { appWidgetId ->
        updateAppWidget(context, appWidgetManager, appWidgetId)
    }

    private fun updateAppWidget(
        context: Context,
        appWidgetManager: AppWidgetManager,
        appWidgetId: Int
    ) = RemoteViews(context.packageName, R.layout.dev_widget).apply {
        setOnClickPendingIntent(
            R.id.link,
            PendingIntent.getActivity(
                context,
                0,
                Intent(ACTION_APPLICATION_DEVELOPMENT_SETTINGS),
                PendingIntent.FLAG_IMMUTABLE
            )
        )
        appWidgetManager.updateAppWidget(appWidgetId, this)
    }
}
