package thinking.in.spring.bean.definition;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import thinking.in.spring.ioc.overview.domain.User;

public class BeanInstantiationDemo {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:/META-INF/bean-instantiation-context.xml");

        User user = applicationContext.getBean("user-by-static-method", User.class);
        User userByInstanceMethod = applicationContext.getBean("user-by-instance-method", User.class);
        User userByFactoryBean = applicationContext.getBean("user-by-factory-bean", User.class);

        System.out.println(user);
        System.out.println(userByInstanceMethod);
        System.out.println(userByFactoryBean);

        System.out.println(user == userByInstanceMethod);
        System.out.println(user == userByFactoryBean);
    }

}
