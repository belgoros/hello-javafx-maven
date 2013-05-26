package com.alten;

import org.jemmy.fx.AppExecutor;

import cucumber.api.java.Before;

public class GlobalHooks {
    private static boolean dunit = false;
    private static final Thread CLOSE_THREAD = new Thread() {
        @Override
        public void run() {
            Thread.currentThread().interrupt();
        }
    };

    @Before
    public void beforeAll() {
        if(!dunit) {
            Runtime.getRuntime().addShutdownHook(CLOSE_THREAD);            
            AppExecutor.executeNoBlock(MainApp.class);            
            dunit = true;
        }
    }
}
