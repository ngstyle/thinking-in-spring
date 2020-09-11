package thinking.in.spring.bean.factory;


import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class DefaultUserFactory implements UserFactory, InitializingBean, DisposableBean {

    @PostConstruct
    public void init() {
        System.out.println("@PostConstruct init method.");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("InitializingBean interface afterPropertiesSet method.");
    }

    public void initMethod() {
        System.out.println("Custom init method.");
    }

    @PreDestroy
    public void preDestroy() {
        System.out.println("@PreDestroy destroy method.");
    }

    public void destroyMethod() {
        System.out.println("Custom destroy method.");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("DisposableBean interface destroy method.");
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.println("对象销毁，执行finalize 方法");
    }
}
