package thinking.in.spring.bean.definition;

import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import thinking.in.spring.bean.factory.DefaultUserFactory;
import thinking.in.spring.bean.factory.UserFactory;
import thinking.in.spring.ioc.overview.domain.User;

import java.util.Iterator;
import java.util.List;
import java.util.ServiceLoader;

public class SpecialBeanInstantiationDemo {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:/META-INF/special-bean-instantiation-context.xml");

//        serviceLoader(applicationContext);
        autowireCapable(applicationContext);
    }

    private static void serviceLoader(ApplicationContext applicationContext) {
        // ServiceLoaderFactoryBean 是FactoryBean, getObject方法 返回ServiceLoader, 可读取"META-INF/services/" 实例化对象
        ServiceLoader<UserFactory> serviceLoader = applicationContext.getBean("userFactoryServiceLoader", ServiceLoader.class);
        for (UserFactory userFactory : serviceLoader) {
            System.out.println(userFactory.createUser());
        }

        List<UserFactory> serviceList = applicationContext.getBean("userFactoryServiceList", List.class);
        for (UserFactory userFactory : serviceList) {
            System.out.println(userFactory.createUser());
        }

//        demoServiceLoader();
    }

    private static void demoServiceLoader() {
        ServiceLoader<UserFactory> serviceLoader = ServiceLoader.load(UserFactory.class, Thread.currentThread().getContextClassLoader());

        for (UserFactory userFactory : serviceLoader) {
            System.out.println(userFactory.createUser());
        }
    }

    private static void autowireCapable(ApplicationContext applicationContext) {
        AutowireCapableBeanFactory autowireCapableBeanFactory = applicationContext.getAutowireCapableBeanFactory();
        DefaultUserFactory userFactory = autowireCapableBeanFactory.createBean(DefaultUserFactory.class);

        System.out.println(userFactory.createUser());
    }
}
