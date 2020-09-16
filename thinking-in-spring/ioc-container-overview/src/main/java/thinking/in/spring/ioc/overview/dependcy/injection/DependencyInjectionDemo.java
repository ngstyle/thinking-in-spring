package thinking.in.spring.ioc.overview.dependcy.injection;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.env.Environment;
import thinking.in.spring.ioc.overview.annotation.Super;
import thinking.in.spring.ioc.overview.domain.User;
import thinking.in.spring.ioc.overview.repository.UserRepository;

import java.util.Collection;
import java.util.Map;

/**
 * 依赖查找
 */
public class DependencyInjectionDemo {

    public static void main(String[] args) {
        // 配置 XML 配置文件
        // 启动Spring 应用上下文
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("classpath:/META-INF/dependency-injection-context.xml");

        // ApplicationContext 和 BeanFactory 的一个关系？
        // https://docs.spring.io/spring-framework/docs/current/spring-framework-reference/core.html#beans-introduction
        // ConfigurableApplicationContext#getBeanFactory
        // AbstractRefreshableApplicationContext.beanFactory = DefaultListableBeanFactory

        // 1. 自定义Bean
        UserRepository userRepository = (UserRepository) beanFactory.getBean("userRepository");
        System.out.println(userRepository.getUsers());

        // 2. 依赖注入 内建非Bean对象(内建依赖)
        // DefaultListableBeanFactory
        System.out.println(userRepository.getBeanFactory());
        System.out.println(userRepository.getBeanFactory() == ((ConfigurableApplicationContext) beanFactory).getBeanFactory());

        // 依赖查找自定义Bean (找不到  错误代码)
//        System.out.println(beanFactory.getBean(BeanFactory.class));

        ObjectFactory<User> userObjectFactory = userRepository.getUserObjectFactory();
        System.out.println(userObjectFactory.getObject());

        ObjectFactory<ApplicationContext> contextObjectFactory = userRepository.getContextObjectFactory();
        System.out.println(contextObjectFactory.getObject());
        System.out.println(contextObjectFactory.getObject() == beanFactory);

        // 3. 内建Bean
        Environment environment = beanFactory.getBean(Environment.class);
        System.out.println(environment);
    }


    private static void whoIsIocContainer(UserRepository userRepository, BeanFactory beanFactory) {
        // 表达式不成立
        System.out.println(userRepository.getBeanFactory() == beanFactory);

        // ApplicationContext is BeanFactory
    }
}
