package com.jawasoft.generator.application;

import com.jawasoft.generator.application.context.ApplicationContext;

public interface ApplicationTask extends Skipable {

    boolean perform(ApplicationContext context) throws Exception;

    boolean hasNext();

    void registerNextTask(ApplicationTask nextTask);

    ApplicationTask next();

}