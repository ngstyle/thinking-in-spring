package thinking.in.spring.dependency.injection;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AutoWiringConstructorDependencyInjectionDemo {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:/META-INF/autowiring-dependency-constructor-injection.xml");

        UserHolder userHolder = applicationContext.getBean(UserHolder.class);

        System.out.println(userHolder);
    }
}
