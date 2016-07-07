/**
 * Copyright (c) 2009 asiainfo.com
 */
package com.asiainfo.test;

import org.junit.runners.model.Statement;

import com.ai.appframe2.common.ServiceManager;

/**
 * @author wzg
 *
 */
public class AppFrameRunBefores extends Statement {

    private final Statement beforeStatement;

    public AppFrameRunBefores(Statement before) {
        beforeStatement = before;
    }

    @Override
    public void evaluate() throws Throwable {
        // wzg 添加 基于appframe 框架的事务调用
        ServiceManager.getSession().startTransaction();
        beforeStatement.evaluate();
    }

}
