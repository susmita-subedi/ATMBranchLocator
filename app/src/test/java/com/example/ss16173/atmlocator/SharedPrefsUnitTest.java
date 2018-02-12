package com.example.ss16173.atmlocator;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.ss16173.atmlocator.util.PermissionUtil;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

import static org.mockito.Matchers.anyInt;
import static org.mockito.Matchers.anyString;

/**
 * Created by susmita on 2/11/2018.
 */

public class SharedPrefsUnitTest {
    SharedPreferences sharedPrefs;
    Context context;

    @Before
    public void before() throws Exception {
        this.sharedPrefs = Mockito.mock(SharedPreferences.class);
        this.context = Mockito.mock(Context.class);
        Mockito.when(context.getSharedPreferences(anyString(), anyInt())).thenReturn(sharedPrefs);
    }

    @Test
    public void sharedPrefsTest() {
        sharedPrefs.getBoolean("sa", false);
        SharedPreferences.Editor editor = sharedPrefs.edit();
        editor.putBoolean("value", false);
        editor.commit();

        assertEquals(sharedPrefs.getBoolean("value", true), false);
    }
}
