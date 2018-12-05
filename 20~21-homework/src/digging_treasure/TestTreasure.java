package digging_treasure;

import javax.annotation.Resource;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class TestTreasure {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        ClassLoader classLoader = new ClassLoader(){
            @Override
            protected Class<?> findClass(String name) throws ClassNotFoundException {
                try {
                    FileInputStream in = new FileInputStream("treasure.class");
                    byte[] bytes = new byte[1024 * 8];
                    int len = in.read(bytes);
                    return defineClass(name,bytes,0,len);
                }  catch (IOException e) {
                    e.printStackTrace();
                    return null;
                }
            }
        };
        Class<?> clazz = classLoader.loadClass("com.westos.Treasure");//根据类名加载得到类对象
        Constructor<?> constructor = clazz.getDeclaredConstructor();//获取构造方法
        constructor.setAccessible(true);//讲私有的构造方法设置成可访问的
        Object o = constructor.newInstance();//获取对象
        Method[] methods = clazz.getMethods();//获取所有公共的方法
        for (Method method : methods) {
            Resource annotation = method.getAnnotation(Resource.class);//判断这个方法是否含有Resource这个标记
            if (annotation!=null){
                method.invoke(o);//如果有执行这个方法
            }
        }

    }
}
