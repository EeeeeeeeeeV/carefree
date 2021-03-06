package test.testByPowerMockito.simpleTest;

import junit.framework.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.powermock.reflect.Whitebox;

import base.TestInit;
import classDefine.EnumClass;

/**
 * Created by cb on 2016/5/20.
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest({EnumClass.class})
public class MockEnumClass extends TestInit{
    @Test
    public void testMockEnumClass() throws Exception{
        EnumClass mock = PowerMockito.mock(EnumClass.class);
        PowerMockito.when(mock.getValue()).thenReturn(-1);
        Whitebox.setInternalState(mock, "INSTANCE", mock, EnumClass.class);
        Assert.assertTrue(EnumClass.INSTANCE.getValue() == -1);
    }

    @Test
    public void testSpyEnumInstance() throws Exception{
        //spy方法可以直接作用于对象，所以对于枚举类，可以直接去spy对应的枚举变量
        PowerMockito.spy(EnumClass.INSTANCE);
        PowerMockito.when(EnumClass.INSTANCE.getValue()).thenReturn(-1);
        Assert.assertTrue(EnumClass.INSTANCE.getValue() == -1);
        PowerMockito.when(EnumClass.INSTANCE.getValue()).thenReturn(100);
        Assert.assertTrue(EnumClass.INSTANCE.getValue() == 100);
    }


}
