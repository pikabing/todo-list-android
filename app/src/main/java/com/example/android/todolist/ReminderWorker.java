package com.example.android.todolist;

import android.content.Context;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.work.Worker;
import androidx.work.WorkerParameters;

public class ReminderWorker extends Worker {

    private static boolean mInstantiated = false;

    public ReminderWorker(@NonNull Context context, @NonNull WorkerParameters workerParams) {
        super(context, workerParams);
    }

    @NonNull
    @Override
    public Result doWork() {
        if (mInstantiated) {
            return Result.failure();
        }
        ReminderTasks.executeTask(getApplicationContext(), ReminderTasks.ACTION_CHARGING_REMINDER);
        mInstantiated = true;
        return Result.success();
    }

}
