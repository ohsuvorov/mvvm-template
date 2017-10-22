package com.duyp.architecture.mvvm.local;

import android.app.Application;

import com.duyp.architecture.mvvm.local.dagger.DaggerTestAppComponent;
import com.duyp.architecture.mvvm.local.dagger.TestAppComponent;
import com.duyp.architecture.mvvm.local.dagger.TestAppModule;
import com.duyp.architecture.mvvm.local.dagger.TestDataModule;

/**
 * Created by duypham on 9/21/17.
 * Test application
 */

public class TestApplication extends Application {

    TestAppComponent appComponent;

    protected void setupAppComponent() {
        appComponent = DaggerTestAppComponent.builder()
                .testAppModule(new TestAppModule(this))
                .testDataModule(new TestDataModule(this))
                .build();
    }

    public TestAppComponent getAppComponent() {
        if (appComponent == null) {
            setupAppComponent();
        }
        return (TestAppComponent)appComponent;
    }

    public void clearAppComponent() {
        appComponent = null;
    }
}
