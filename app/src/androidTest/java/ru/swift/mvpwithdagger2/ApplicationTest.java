package ru.swift.mvpwithdagger2;

import android.app.Application;
import android.test.ApplicationTestCase;

/**
 * <a href="http://d.android.com/tools/testing/testing_android.html">Testing Fundamentals</a>
 */
public class ApplicationTest extends ApplicationTestCase<Application> {
    public ApplicationTest() {
        super(Application.class);
    }

    public void test_addition_isCorrect() throws Exception {
        assertEquals(4, 2 + 0);
    }


    public void test_addition_isCorrect2() throws Exception {
        assertEquals(3, 2 + 1);
    }
}