package com.luban.utils;

import com.luban.dao.CustomInvocationHandler;

import javax.tools.JavaCompiler;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;
import java.io.File;
import java.io.FileWriter;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;

/**
 * @author 小贱
 * @create 2020-09-23 22:01
 */
public class ProxyUtil {

    /**
     *  content  ---> String     封装java String内容
     *  .java                    生成.java 文件
     *  .class                   编译生成.class 文件
     *  new                      通过生成的.class 文件创建对象
     * @return
     * @param target
     */
    public static Object newInstance(Object target){
        Object proxy = null;
        Class targetInf = target.getClass().getInterfaces()[0];
        Method[] methods = targetInf.getDeclaredMethods();

        /*========================================封装java String内容 start==============================================*/
        String line = "\n";
        String tab = "\t";
        String infName = targetInf.getSimpleName();
        String content = "";
        String packageContent = "package com.google;" + line;
        String importContent = "import " + targetInf.getName() + ";" + line;
        String clazzFirstLineContent = "public class $Proxy implements " + infName + "{" + line;
        // 内部变量
        String filedContent = tab + "private " + infName + " target;" + line;
        // 构造方法
        String constructorContent = tab + "public $Proxy(" + infName + " target){"  + line +
                tab + tab + "this.target = target;" + line +
                tab + "}" + line ;
        String methodContent = "";
        // 封装方法
        for (Method method : methods) {
            String returnTypeName = method.getReturnType().getTypeName();
            String methodName = method.getName();
            Class[] args = method.getParameterTypes();
            String argsConent = "";
            String paramsContent = "";
            int flag = 0;
            // 封装方法参数
            for (Class arg : args) {
                String temp = arg.getSimpleName();
                argsConent += temp + " p" + flag + ",";
                paramsContent += "p" + flag + ",";
                flag++;
            }
            if (argsConent.length() > 0) {
                argsConent = argsConent.substring(0, argsConent.lastIndexOf(',') - 1);
                paramsContent = paramsContent.substring(0, paramsContent.lastIndexOf(',') - 1);
            }
            methodContent += tab + "@Override" + line +
                    tab + "public " + returnTypeName + " " + methodName + "(" + argsConent + ") {" + line +
                    tab + tab + "System.out.println(\" log \");" + line +
                    tab + tab;
            if (!("void").equals(returnTypeName)) {
                methodContent += "return ";
            }
            methodContent += "target." + methodName + "(" + paramsContent + ");" + line +
                    tab + "}" + line;
        }
        content = packageContent + importContent + clazzFirstLineContent + filedContent + constructorContent + methodContent + "}";
        /*========================================封装java String内容 end==============================================*/

        /*========================================生成.java 文件 start==============================================*/
        File file = new File("/Users/xiaojian/IDEAWorkspace/luban/proxy/src/main/java/com/google/$Proxy.java");
        FileWriter fw = null;
        try {
            if (!file.exists()) {
                file.createNewFile();
            }
            fw = new FileWriter(file);
            fw.write(content);
            fw.flush();
            fw.close();
        /*========================================生成.java 文件 end==============================================*/

            /*========================================编译生成.class 文件 start==============================================*/
            // 动态编译类  -- 》 编译文件
            JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
            StandardJavaFileManager fileManager = compiler.getStandardFileManager(null, null, null);
            Iterable units = fileManager.getJavaFileObjects(file);

            JavaCompiler.CompilationTask t = compiler.getTask(null, fileManager, null, null, null, units);
            t.call();
            fileManager.close();
            /*========================================编译生成.class 文件 end==============================================*/

            /*========================================通过生成的.class 文件创建对象 start==============================================*/
            // 定位文件包位置
            URL[] urls = new URL[]{new URL("file:/Users/xiaojian/IDEAWorkspace/luban/proxy/src/main/java/")};
            URLClassLoader urlClassLoader = new URLClassLoader(urls);
            // 文件具体名称  包.类名
            Class clazz = urlClassLoader.loadClass("com.google.$Proxy");

            // 获取构造方法 targetInf 为参数的构造方法
            Constructor constructor = clazz.getConstructor(targetInf);
            // 通过构造方法，创建对象
            proxy = constructor.newInstance(target);
            /*========================================通过生成的.class 文件创建对象 end==============================================*/

        } catch (Exception e) {
            e.printStackTrace();
        }

        return proxy;
    }


    public static Object newInstance(Class targetInf, CustomInvocationHandler invocationHandler){

        Object proxy = null;
        Method[] methods = targetInf.getDeclaredMethods();

        /*========================================封装java String内容 start==============================================*/
        String line = "\n";
        String tab = "\t";
        String infName = targetInf.getSimpleName();
        String content = "";
        String packageContent = "package com.google;" + line;
        String importContent = "import " + targetInf.getName() + ";" + line
                               + "import java.lang.reflect.Method;" + line
                               + "import java.lang.Exception;" + line
                               + "import com.luban.dao.CustomInvocationHandler;" + line;
        String clazzFirstLineContent = "public class $Proxy implements " + infName + "{" + line;
        // 内部变量
        String filedContent = tab + "private CustomInvocationHandler h;" + line;
        // 构造方法
        String constructorContent = tab + "public $Proxy(CustomInvocationHandler h){"  + line +
                tab + tab + "this.h = h;" + line +
                tab + "}" + line ;
        String methodContent = "";
        // 封装方法
        for (Method method : methods) {
            String returnTypeName = method.getReturnType().getTypeName();
            String methodName = method.getName();
            Class[] args = method.getParameterTypes();
            String argsConent = "";
            String paramsContent = "";
            String methodArgs = "";
            int flag = 0;
            // 封装方法参数
            for (Class arg : args) {
                String temp = arg.getSimpleName();
                argsConent += temp + " p" + flag + ",";
                methodArgs += temp + ".class,";
                paramsContent += "p" + flag + ",";
                flag++;
            }
            if (argsConent.length() > 0) {
                argsConent = argsConent.substring(0, argsConent.lastIndexOf(',') - 1);
                paramsContent = paramsContent.substring(0, paramsContent.lastIndexOf(',') - 1);
                methodArgs = methodArgs.substring(0, methodArgs.length() - 1);
            }
            methodContent += tab + "@Override" + line +
                    tab + "public " + returnTypeName + " " + methodName + "(" + argsConent + ") throws Exception {" + line ;
            // 带参数
            if (!("").equals(methodArgs)) {
                methodContent += tab + tab + "Object[] args = new Object[]{" + paramsContent + "};" + line +
                        tab + tab + "Method method = Class.forName(\""+ targetInf.getName() +"\").getMethod(\"" + methodName + "\", " + methodArgs + ");" + line +
                        tab + tab;

            }
            // 不带参数
            else {
                methodContent += tab + tab + "Method method = Class.forName(\"" + targetInf.getName() + "\").getDeclaredMethod(\"" + methodName + "\");" + line +
                        tab + tab;
            }
            // 有返回值
            if (!("void").equals(returnTypeName)) {
                methodContent += "return (" + returnTypeName + ")";
            }
            if (!("").equals(methodArgs)) {
                methodContent += "h.invoke(method, args);" + line +
                        tab + "}" + line;
            }else {
                methodContent += "h.invoke(method);" + line +
                        tab + "}" + line;
            }
        }
        content = packageContent + importContent + clazzFirstLineContent + filedContent + constructorContent + methodContent + "}";
        /*========================================封装java String内容 end==============================================*/

        /*========================================生成.java 文件 start==============================================*/
        File file = new File("/Users/xiaojian/IDEAWorkspace/luban/proxy/src/main/java/com/google/$Proxy.java");
        FileWriter fw = null;
        try {
            if (!file.exists()) {
                file.createNewFile();
            }
            fw = new FileWriter(file);
            fw.write(content);
            fw.flush();
            fw.close();
        /*========================================生成.java 文件 end==============================================*/

            /*========================================编译生成.class 文件 start==============================================*/
            // 动态编译类  -- 》 编译文件
            JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
            StandardJavaFileManager fileManager = compiler.getStandardFileManager(null, null, null);
            Iterable units = fileManager.getJavaFileObjects(file);

            JavaCompiler.CompilationTask t = compiler.getTask(null, fileManager, null, null, null, units);
            t.call();
            fileManager.close();
            /*========================================编译生成.class 文件 end==============================================*/

            /*========================================通过生成的.class 文件创建对象 start==============================================*/
            // 定位文件包位置
            URL[] urls = new URL[]{new URL("file:/Users/xiaojian/IDEAWorkspace/luban/proxy/src/main/java/")};
            URLClassLoader urlClassLoader = new URLClassLoader(urls);
            // 文件具体名称  包.类名
            Class clazz = urlClassLoader.loadClass("com.google.$Proxy");
//            return clazz.newInstance();

            // 获取构造方法 targetInf 为参数的构造方法
            Constructor constructor = clazz.getConstructor(CustomInvocationHandler.class);
            // 通过构造方法，创建对象
            proxy = constructor.newInstance(invocationHandler);
            /*========================================通过生成的.class 文件创建对象 end==============================================*/

        } catch (Exception e) {
            e.printStackTrace();
        }

        return proxy;
    }

}
