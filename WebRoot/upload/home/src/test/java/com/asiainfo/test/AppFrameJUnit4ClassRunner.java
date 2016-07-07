/**
 * Copyright (c) 2009 asiainfo.com
 */
package com.asiainfo.test;

import org.junit.internal.runners.model.MultipleFailureException;
import org.junit.runners.BlockJUnit4ClassRunner;
import org.junit.runners.model.InitializationError;
import org.junit.runners.model.Statement;

/**
 * @author wzg
 *
 */
public class AppFrameJUnit4ClassRunner extends BlockJUnit4ClassRunner {

    public AppFrameJUnit4ClassRunner(Class<?> klass) throws InitializationError {
        super(klass);
    }

    /**
     * Returns a {@link Statement}: run all non-overridden {@code @BeforeClass} methods on this class
     * and superclasses before executing {@code statement}; if any throws an
     * Exception, stop execution and pass the exception on.
     */
    @Override
    protected Statement withBeforeClasses(Statement statement) {
        return new AppFrameRunBefores(super.withBeforeClasses(statement));
    }

    /**
     * Returns a {@link Statement}: run all non-overridden {@code @AfterClass} methods on this class
     * and superclasses before executing {@code statement}; all AfterClass methods are
     * always executed: exceptions thrown by previous steps are combined, if
     * necessary, with exceptions from AfterClass methods into a
     * {@link MultipleFailureException}.
     */
    @Override
    protected Statement withAfterClasses(Statement statement) {
        return new AppFrameRunAfters(super.withAfterClasses(statement));
    }

}
