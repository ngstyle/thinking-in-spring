package thinking.in.spring.bean.definition;

import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import thinking.in.spring.ioc.overview.domain.User;

public class BeanDefinitionCreationDemo {

    public static void main(String[] args) {

        // 1. builder 创建beanDefinition
        BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.genericBeanDefinition(User.class);

        beanDefinitionBuilder.addPropertyValue("id", 1).addPropertyValue("name", "nohc");
        BeanDefinition beanDefinition = beanDefinitionBuilder.getBeanDefinition();


        // 2. 通过AbstractBeanDefinition 派生类创建
        GenericBeanDefinition genericBeanDefinition = new GenericBeanDefinition();
        genericBeanDefinition.setBeanClass(User.class);

        MutablePropertyValues propertyValues = new MutablePropertyValues();
        propertyValues.add("id", 2).add("name", "chon");
        genericBeanDefinition.setPropertyValues(propertyValues);
    }

}
