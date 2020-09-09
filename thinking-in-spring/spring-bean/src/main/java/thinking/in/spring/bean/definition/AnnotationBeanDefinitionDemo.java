package thinking.in.spring.bean.definition;

import org.springframework.beans.factory.config.SingletonBeanRegistry;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionReaderUtils;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import thinking.in.spring.ioc.overview.domain.User;

// 2.3. 通过 @Import 来进行导入
@Import(AnnotationBeanDefinitionDemo.Config.class)
public class AnnotationBeanDefinitionDemo {

    public static void main(String[] args) {
        // 1. 通过 XML 注册BeanDefinition 信息
        // new ClassPathXmlApplicationContext();

        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.register(AnnotationBeanDefinitionDemo.class);
        applicationContext.refresh();

        // 3.1. 通过 Java API 配置元信息 (命名方式)
        registerUserBeanDefinition(applicationContext, "noohc");
        // 3.2. 通过 Java API 配置元信息 (非命名方式)
        registerUserBeanDefinition(applicationContext);

        // 3.3 注册单例
        User user = new User();
        user.setId(2);
        user.setName("single-user");
        applicationContext.getBeanFactory().registerSingleton("single", user);

        System.out.println(applicationContext.getBeansOfType(Config.class));
        System.out.println(applicationContext.getBeansOfType(User.class));
        applicationContext.close();
    }

    private static void registerUserBeanDefinition(BeanDefinitionRegistry registry, String beanName) {
        BeanDefinitionBuilder builder = BeanDefinitionBuilder.genericBeanDefinition(User.class);
        builder.addPropertyValue("id", 1).addPropertyValue("name", "chon");

        if (StringUtils.hasText(beanName)) {
            registry.registerBeanDefinition(beanName,builder.getBeanDefinition());
        } else {
            BeanDefinitionReaderUtils.registerWithGeneratedName(builder.getBeanDefinition(), registry);
        }
    }

    public static void registerUserBeanDefinition(BeanDefinitionRegistry registry) {
        registerUserBeanDefinition(registry, null);
    }

    // 2.2. 通过 @Component 方式
    @Component
    public static class Config {

        // 2.1. 通过 @Bean 方式定义
        @Bean
        public User user() {
            User user = new User();
            user.setId(1L);
            user.setName("noooooooooohc");
            return user;
        }
    }
}
