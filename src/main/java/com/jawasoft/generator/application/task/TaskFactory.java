package com.jawasoft.generator.application.task;

import com.jawasoft.generator.application.ApplicationTask;

import java.util.LinkedList;

public class TaskFactory {

    public static LinkedList<ApplicationTask> taskList = new LinkedList<>();

    public static synchronized ApplicationTask consume() {
        return taskList.remove();
    }

    public static void provide(ApplicationTask task) {
        taskList.add(task);
    }

    public static boolean haveNoTasks() {
        return taskList.isEmpty();
    }

    public static boolean haveTasks() {
        return !taskList.isEmpty();
    }
}