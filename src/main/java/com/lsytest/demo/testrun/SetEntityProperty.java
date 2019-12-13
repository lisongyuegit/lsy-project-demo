package com.lsytest.demo.testrun;

import com.lsytest.demo.entity.TestEntity;

import java.util.regex.Pattern;
import java.lang.reflect.Method;
import java.util.Hashtable;

public class SetEntityProperty {
    /**
     * @desc 通过反射来动态调用get 和 set 方法
     */
        private static Class cls;
        /**
         * 传过来的对象
         */
        private static Object obj;
        private static Hashtable<String, Method> getMethods = null;
        private static Hashtable<String, Method> setMethods = null;

        public static void ReflectHelper(Object o) {
            obj = o;
            initMethods();
        }

        public static void initMethods() {
            getMethods = new Hashtable<String, Method>();
            setMethods = new Hashtable<String, Method>();
            cls = obj.getClass();
            Method[] methods = cls.getMethods();
            // 定义正则表达式，从方法中过滤出getter / setter 函数.
            String gs = "get(\\w+)";
            Pattern getM = Pattern.compile(gs);
            String ss = "set(\\w+)";
            Pattern setM = Pattern.compile(ss);
// 把方法中的"set" 或者 "get" 去掉,$1匹配第一个
            String rapl = "$1";
            String param;
            for (int i = 0; i < methods.length; ++i) {
                Method m = methods[i];
                String methodName = m.getName();
                if (Pattern.matches(gs, methodName)) {
                    param = getM.matcher(methodName).replaceAll(rapl).toLowerCase();
                    getMethods.put(param, m);
                } else if (Pattern.matches(ss, methodName)) {
                    param = setM.matcher(methodName).replaceAll(rapl).toLowerCase();
                    setMethods.put(param, m);
                } else {
// org.jeecgframework.core.util.LogUtil.info(methodName + " 不是getter,setter方法！");
                }
            }
        }

        public static boolean setMethodValue(String property, Object object) {
            Method m = setMethods.get(property.toLowerCase());
            if (m != null) {
                try {
// 调用目标类的setter函数
                    m.invoke(obj, object);
                    return true;
                } catch (Exception ex) {
                    ex.printStackTrace();
                    return false;
                }
            }
            return false;
        }
    //用法，假如现在要Person类中的name属性赋值
    public static void main(String[] args) {
        Object oo = "22";
        TestEntity test = new TestEntity();
        //创建工具类对象
        SetEntityProperty reflectHelper = new SetEntityProperty();
        reflectHelper.setMethodValue("name","值");// 动态调用 set方法给文件对象内容赋值
    }

}
