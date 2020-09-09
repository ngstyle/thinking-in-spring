package thinking.in.spring.ioc.overview.repository;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.context.ApplicationContext;
import thinking.in.spring.ioc.overview.domain.User;

import java.util.Collection;

public class UserRepository {

    private Collection<User> users;

    // 依赖注入 内建非Bean对象（内建依赖）
    private BeanFactory beanFactory;

    private ObjectFactory<User> userObjectFactory;
    private ObjectFactory<ApplicationContext> contextObjectFactory;

    public Collection<User> getUsers() {
        return users;
    }

    public void setUsers(Collection<User> users) {
        this.users = users;
    }

    public BeanFactory getBeanFactory() {
        return beanFactory;
    }

    public void setBeanFactory(BeanFactory beanFactory) {
        this.beanFactory = beanFactory;
    }

    public ObjectFactory<User> getUserObjectFactory() {
        return userObjectFactory;
    }

    public void setUserObjectFactory(ObjectFactory<User> userObjectFactory) {
        this.userObjectFactory = userObjectFactory;
    }

    public ObjectFactory<ApplicationContext> getContextObjectFactory() {
        return contextObjectFactory;
    }

    public void setContextObjectFactory(ObjectFactory<ApplicationContext> contextObjectFactory) {
        this.contextObjectFactory = contextObjectFactory;
    }
}
