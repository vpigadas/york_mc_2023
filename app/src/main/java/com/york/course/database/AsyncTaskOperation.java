package com.york.course.database;

import android.os.AsyncTask;

import java.util.List;

public class AsyncTaskOperation extends AsyncTask<UserTable, Void, List<UserTable>> {
    private MyDatabaseInstance instance;
    private Actions callback;

    interface Actions {
        void onReturn(List<UserTable> dataList);
    }

    public AsyncTaskOperation(MyDatabaseInstance instance, Actions callback) {
        this.instance = instance;
        this.callback = callback;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected List<UserTable> doInBackground(UserTable... voids) {
        for (UserTable item : voids) {
            instance.getUserDao().save(item);
        }

        return instance.getUserDao().retrieve();
    }

    @Override
    protected void onPostExecute(List<UserTable> unused) {
        super.onPostExecute(unused);
        callback.onReturn(unused);
    }
}
