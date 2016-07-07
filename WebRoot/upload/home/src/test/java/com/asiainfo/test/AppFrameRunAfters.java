/**
 * Copyright (c) 2009 asiainfo.com
 */
package com.asiainfo.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.internal.runners.model.MultipleFailureException;
import org.junit.runners.model.Statement;

import com.ai.appframe2.common.ServiceManager;

/**
 * @author wzg
 *
 */
public class AppFrameRunAfters extends Statement {

    private final Statement fNext;

    public AppFrameRunAfters(Statement next) {
        fNext = next;
    }

    @Override
    public void evaluate() throws Throwable {
        List<Throwable> fErrors = new ArrayList<Throwable>();
        fErrors.clear();
        //调用结束的类，有异常打印，不抛出
        try {
            fNext.evaluate();
        } catch (Throwable e) {
            e.printStackTrace();
            fErrors.add(e);
        }
        // wzg add 基于appframe 框架的事务调用
        try {
            ServiceManager.getSession().commitTransaction();
        } catch (Throwable e) {
            e.printStackTrace();
            fErrors.add(e);
        }

        if (fErrors.isEmpty())
            return;
        if (fErrors.size() == 1)
            throw fErrors.get(0);
        throw new MultipleFailureException(fErrors);

    }

}
