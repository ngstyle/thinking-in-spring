package thinking.in.spring.bean.definition;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import thinking.in.spring.ioc.overview.domain.User;

public class BeanAliasDemo {


    public static void main(String[] args) {
        // 配置 XML 配置文件
        // 启动Spring 应用上下文
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("classpath:/META-INF/bean-definitions-context.xml");


        User user = (User) beanFactory.getBean("user");
        User alias = (User) beanFactory.getBean("nohc");

        System.out.println("bean 名字和别名查找是否相等： " + (user == alias));
    }
}
