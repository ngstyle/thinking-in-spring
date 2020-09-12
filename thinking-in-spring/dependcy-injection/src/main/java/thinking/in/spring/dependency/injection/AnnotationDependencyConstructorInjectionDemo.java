package thinking.in.spring.dependency.injection;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ImportResource;
import thinking.in.spring.ioc.overview.domain.User;

/**
 * 注解 setter 依赖注入
 */
@ImportResource("classpath:/META-INF/dependency-lookup-context.xml")
public class AnnotationDependencyConstructorInjectionDemo {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        // 这里注册 UserHolder
        applicationContext.register(AnnotationDependencyConstructorInjectionDemo.class);

//        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(applicationContext);
//        String xmlPath = "classpath:/META-INF/dependency-lookup-context.xml";
        // 这里注册 User
//        reader.loadBeanDefinitions(xmlPath);

        applicationContext.refresh();

        // 依赖查找
        UserHolder userHolder = applicationContext.getBean(UserHolder.class);
        System.out.println(userHolder);
        applicationContext.close();
    }

    @Bean
    public UserHolder userHolder(User user) {
        return new UserHolder(user);
    }
}
