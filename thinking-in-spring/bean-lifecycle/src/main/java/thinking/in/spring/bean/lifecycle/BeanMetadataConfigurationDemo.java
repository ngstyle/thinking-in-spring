package thinking.in.spring.bean.lifecycle;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.PropertiesBeanDefinitionReader;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.EncodedResource;
import thinking.in.spring.ioc.overview.domain.User;

public class BeanMetadataConfigurationDemo {

    public static void main(String[] args) {
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        PropertiesBeanDefinitionReader beanDefinitionReader = new PropertiesBeanDefinitionReader(beanFactory);

        String location = "META-INF/user.properties";
        // 基于 ClassPath 加载 properties 资源
        Resource resource = new ClassPathResource(location);
        EncodedResource encodedResource = new EncodedResource(resource, "UTF-8");
        int beanNumbers = beanDefinitionReader.loadBeanDefinitions(encodedResource);

        System.out.println("已加载 BeanDefinition 数量：" + beanNumbers);
        // 通过 Bean Id 和类型进行依赖查找
        User user = beanFactory.getBean("user", User.class);
        System.out.println(user);
    }

}
