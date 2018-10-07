package com.jawasoft.generator.application;

import com.jawasoft.generator.application.context.ApplicationContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class AbstractApplicationTask implements ApplicationTask {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * VAR_SKIP_NEXT: 全局变量：是否跳过以下一个节点.
     *
     * @since JDK 1.6
     */
    protected final static String VAR_SKIP_NEXT = "isSkipNext";

    /**
     * nextTask: 下一个应用程序任务.
     */
    private ApplicationTask nextTask = null;

    /**
     * hasNext: 是否有下一个应用程序任务.
     */
    private boolean hasNext = false;

    /**
     * isSkipNext: 是否跳过下一个任务.
     */
    private boolean isSkipNext = false;

    /**
     * Creates a new instance of AbstractApplicationTask.
     */
    public AbstractApplicationTask() {
        super();
    }

    @Override
    public boolean perform(ApplicationContext context) throws Exception {
        // 如果在执行应用程序任务逻辑之前的操作成功，那么进入执行应用程序任务
        if (doBefore(context)) {
            boolean isReturnAll = doInternal(context);
            doAfter(context);
            return isReturnAll;
        } else {
            return false;
        }
    }

    @Override
    public boolean hasNext() {
        return this.hasNext;
    }

    @Override
    public void registerNextTask(ApplicationTask nextTask) {
        this.nextTask = nextTask;
        this.hasNext = !(null == nextTask);
    }

    @Override
    public ApplicationTask next() {
        return this.nextTask;
    }

    protected boolean doBefore(ApplicationContext context) throws Exception {
        logger.info(context.toString());
        return true;
    }

    protected abstract boolean doInternal(ApplicationContext context) throws Exception;

    protected void doAfter(ApplicationContext context) throws Exception {
        // 设置是否跳过下一个变量
        if (isSkipNext) {
            String skipMessage = "跳过此应用程序任务的下一个任务！";
            logger.info(skipMessage);
        }
    }

    @Override
    public void skipNext() {
        this.isSkipNext = true;
    }


}
