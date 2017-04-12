package com.quran.labs.androidquran;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
import android.widget.RemoteViews;
import com.quran.labs.androidquran.ui.PagerActivity;

public class SearchWidget extends AppWidgetProvider {

  @Override
  public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
    // There may be multiple widgets active, so update all of them
    for (int appWidgetId : appWidgetIds) {
      RemoteViews widget = new RemoteViews(context.getPackageName(),
          R.layout.search_widget);
      Intent intent = new Intent(context, QuranDataActivity.class);
      PendingIntent pendingIntent = PendingIntent.getActivity(context, 0, intent, 0);
      widget.setOnClickPendingIntent(R.id.SearchWidgetIconButton, pendingIntent);
      intent = new Intent(context, SearchActivity.class);
      pendingIntent = PendingIntent.getActivity(context, 0, intent, 0);
      widget.setOnClickPendingIntent(R.id.SearchWidgetBtnSearch, pendingIntent);
      intent = new Intent(context, PagerActivity.class);
      pendingIntent = PendingIntent.getActivity(context, 0, intent, 0);
      widget.setOnClickPendingIntent(R.id.SearchWidgetBtnGoToQuran, pendingIntent);
      appWidgetManager.updateAppWidget(appWidgetId, widget);

    }
    super.onUpdate(context, appWidgetManager, appWidgetIds);

  }

  @Override
  public void onReceive(Context context, Intent intent) {
    super.onReceive(context, intent);

  }

}

