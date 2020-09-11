package thinking.in.spring.bean.definition;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import thinking.in.spring.bean.factory.DefaultUserFactory;
import thinking.in.spring.bean.factory.UserFactory;

@Configuration
public class BeanInitializationDemo {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.register(BeanInitializationDemo.class);

        applicationContext.refresh();
        System.out.println("应用上下文已启动。。。。。。");

        // @Lazy 按需延迟加载
        applicationContext.getBean(UserFactory.class);

        System.out.println("应用上下文准备  关闭。。。。。。");
        applicationContext.close();
        System.out.println("应用上下文已关闭。。。。。。");
    }

    @Bean(initMethod = "initMethod", destroyMethod = "destroyMethod")
//    @Lazy
    public UserFactory userFactory() {
        return new DefaultUserFactory();
    }
}
