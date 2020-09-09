package ml.nohc.ioc.java.beans;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyEditorSupport;
import java.util.stream.Stream;

public class BeanInfoDemo {

    public static void main(String[] args) throws IntrospectionException {
        BeanInfo beanInfo = Introspector.getBeanInfo(Person.class, Object.class);

        Stream.of(beanInfo.getPropertyDescriptors())
                .forEach(propertyDescriptor -> {
                    // propertyDescriptor 允许添加属性编辑器 - PropertyEditor
                    Class<?> propertyType = propertyDescriptor.getPropertyType();
                    if ("age".equals(propertyDescriptor.getName())) {
                        propertyDescriptor.setPropertyEditorClass(String2IntegerPropertyEditor.class);
//                        propertyDescriptor.createPropertyEditor()
                        System.out.println("age ... propertyDescriptor");
                    }
                });

        new Person().setAge(23);
    }

    static class String2IntegerPropertyEditor extends PropertyEditorSupport {

        @Override
        public void setAsText(String text) throws IllegalArgumentException {
            Integer value = Integer.valueOf(text);
            setValue(value);
        }
    }
}
