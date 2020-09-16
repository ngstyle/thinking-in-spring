package thinking.in.spring.dependency.injection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.AutowiredAnnotationBeanPostProcessor;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import thinking.in.spring.ioc.overview.domain.User;

import javax.annotation.Resource;

/**
 * 注解 setter 依赖注入
 */
@ImportResource("classpath:/META-INF/dependency-lookup-context.xml")
@Configuration
public class AnnotationDependencyFieldInjectionDemo {

    /**
     *  Autowired 和 Resource annotation is not supported on static fields
     *  @See {@link AutowiredAnnotationBeanPostProcessor}
     * */
    @Autowired
    private UserHolder userHolder;

    @Resource
    private UserHolder userHolder2;

    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        // 这里注册 UserHolder
        // 配置类 AnnotationDependencyFieldInjectionDemo 本身也是一个 Spring Bean, 可以通过依赖查找获取
        applicationContext.register(AnnotationDependencyFieldInjectionDemo.class);
        applicationContext.refresh();

        // 依赖查找
        // 配置类 AnnotationDependencyFieldInjectionDemo 本身也是一个 Spring Bean, 可以通过依赖查找获取
        AnnotationDependencyFieldInjectionDemo demo = applicationContext.getBean(AnnotationDependencyFieldInjectionDemo.class);

        UserHolder userHolder = demo.userHolder;
        System.out.println(userHolder);
        System.out.println(demo.userHolder2);
        System.out.println(userHolder == demo.userHolder2);
        applicationContext.close();
    }

    @Bean
    public UserHolder userHolder(User user) {
        UserHolder userHolder = new UserHolder();
        userHolder.setUser(user);
        return userHolder;
    }
}
