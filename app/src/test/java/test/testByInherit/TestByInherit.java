package test.testByInherit;

import junit.framework.Assert;

import org.junit.Test;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;

import classDefine.ClassForScene14;
import classDefine.ClassForScene14_Dependency;

/**
 * Created by cb on 2016/6/3.
 */
@PrepareForTest(ClassForScene14_Dependency.class)
public class TestByInherit {
    @Test
    public void test() throws Exception{
        //在ClassForTestByInherit的test方法里，我们传入一个DependencyClass的实例，根据这个实例进行进行一些操作
        //在这个case里，有个很蛋疼的问题就是，有两个地方需要对dependency.isValid()进行判断，而如果要做到全覆盖，这两个值必须是不一样的。
        //而由于这个判断是在被测方法内部进行的，
        ClassForScene14_Dependency dependencyClass = PowerMockito.mock(ClassForScene14_Dependency.class);
        PowerMockito.when(dependencyClass.isValid()).thenReturn(false, true);
        ClassForScene14 inherit = new ClassForScene14();
        Assert.assertTrue(inherit.test(dependencyClass));
    }
}
