package org.spring.util;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import javax.naming.LimitExceededException;
import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @author 小贱
 * @create 2020-09-26 13:38
 */
public class BeanFactory {

    Map<String, Object> map = new HashMap<>();

    /**
     *
     */
    public BeanFactory(String xml){
        parseXml(xml);

    }

    public void parseXml(String xml) {
        String path = this.getClass().getResource("/").getPath() + "/" + xml;
        File file = new File(path);

        SAXReader reader = new SAXReader();
        try {
            Document document = reader.read(file);
            Element rootElement = document.getRootElement();

            Attribute autowire = rootElement.attribute("default-autowire");
            boolean flag = false;
            if (autowire != null) {
                flag = true;
            }

            for (Iterator<Element> itFirst = rootElement.elementIterator(); itFirst.hasNext(); ) {
                // 遍历 xml 父标签 <beans>  获得 <bean>
                Element elementFirstChild = itFirst.next();

                /* 1. 实例化对象 */

                // 获取 bean 参数 id class
                Attribute attributeId = elementFirstChild.attribute("id");
                String beanName = attributeId.getValue();
                Attribute attributeClass = elementFirstChild.attribute("class");
                String className = attributeClass.getValue();

                // 根据 class 全限定名 反射构建对象
                Class<?> clazz = Class.forName(className);
                Object object = null;

                /* 2. 维护依赖关系
                *     看这个对象有没有依赖（判断是否有 property，或者判断类是否有属性）
                *     如果有则注入
                */
                for (Iterator<Element> itSecond = elementFirstChild.elementIterator(); itSecond.hasNext(); ) {
                    Element elementSecondChild = itSecond.next();
                    if ("property".equals(elementSecondChild.getName())) {
                        object = clazz.newInstance();
                        // 获取 property 参数 name ref
                        Attribute attributeName = elementSecondChild.attribute("name");
                        String propertyName = attributeName.getValue();
                        Attribute attributeRef = elementSecondChild.attribute("ref");
                        String propertyRef = attributeRef.getValue();

                        Object injectObject = map.get(propertyRef);
                        Field field = clazz.getDeclaredField(propertyName);
                        // private 可不直接调用， 需要设置 accessible 为 true
                        field.setAccessible(true);
                        field.set(object, injectObject);
                        flag = false;
                    } else if ("constructor-arg".equals(elementSecondChild.getName())) {
                        // 获取 property 参数 name ref
                        Attribute attributeName = elementSecondChild.attribute("name");
                        String constructorName = attributeName.getValue();
                        Attribute attributeRef = elementSecondChild.attribute("ref");
                        String constructorRef = attributeRef.getValue();

                        Field field = clazz.getDeclaredField(constructorName);

                        Object injectObject = map.get(constructorRef);
                        Constructor<?> constructor = clazz.getConstructor(field.getType());
                        object = constructor.newInstance(injectObject);
                        flag = false;
                    }
                }

                if (flag) {
                    if ("byType".equals(autowire.getValue())) {
                        //判断是否有依赖
                        Field[] fields = clazz.getDeclaredFields();
                        for (Field field : fields) {
                            // 得到属性的类型， 如：String aa 那么这里的 field.getType() = string.class
                            Class<?> injectObjectClazz = field.getType();
                            /*
                            * 由于是bytype 所以需要遍历 map 当中的所有对象
                            * 判断对象的类型是不是这个 injectObjectClazz 相同
                            */
                            int count = 0;
                            Object injectObject = null;
                            for (String key : map.keySet()) {
                                Class<?> tempClazz = map.get(key).getClass().getInterfaces()[0];
                                if (tempClazz.getName().equals(injectObjectClazz.getName())) {
                                    injectObject = map.get(key);
                                    // 记录找到一个， 因为可以找到多个
                                    count++;
                                }
                            }

                            if (count > 1) {
                                throw new LimitExceededException("需要一个对象，但是找到多个对象");
                            } else {
                                object = clazz.newInstance();
                                field.setAccessible(true);
                                field.set(object, injectObject);
                            }
                        }
                    }
                }

                if (object == null) {
                    object = clazz.newInstance();
                }

                map.put(beanName, object);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public Object getBean(String beanName) {
        return map.get(beanName);
    }
}
