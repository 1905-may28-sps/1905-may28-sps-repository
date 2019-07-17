package com.revature.lifecycle;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class Life implements BeanNameAware, 
BeanFactoryAware, ApplicationContextAware, 
BeanPostProcessor, InitializingBean,  DisposableBean{

	
	/*
	 *  Spring Bean Lifecycle
	 *  
	 *  Instantiate
	 *  Populate Properties
	 *  setBeanName() -- from BeanNameAware	-- set the name of the bean in the bean factory that created this bean 
	 *  setBeanFactory() -- from BeanFactoryAware -- callback function that supplies the owning factory to a bean instance. 
	 *  setApplicationContext() -- from ApplicationContextAware
	 *  PreInitialization -- Bean PostProcessors
	 *  afterPropertiesSet -- InitializingBean -- allows the bean instance to perform initialization; only possible when all bean properties have been set. Throws an exception in the event of misconfiguration  
	 *  init -- custom 
	 *  Post Initialization -- BeanPostProcessors
	 *  
	 *  Bean is ready to use
	 *  
	 *  destroy() -- DisposableBean
	 *  destroy -- custom
	 *  
	 *  For more info, check out https://howtodoinjava.com/spring-core/spring-bean-life-cycle/
	 *  
	 *  
	 */
	
	private String lifecycle;
	
	public Life() {
		super();
		System.out.println("INSTANTIATING LIFE");
	}
	
	public String getLifecycle() {
		return lifecycle;
	}

	public void setLifecycle(String lifecycle) {
		this.lifecycle = lifecycle;
		System.out.println("SETTING LIFE PROPERTIES");
	}

	@Override
	public void setBeanName(String name) {
		System.out.println("SET BEAN NAME " + name);
	}

	@Override
	public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
		System.out.println("SET BEAN FACTORY: " + beanFactory);
	}
	
	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		System.out.println("SET APPLICATION CONTEXT " + applicationContext);
	}

	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("PRE INITIALIZATION " + beanName);
		return null;
	}
	
	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("AFTER PROPERTIES SET");
	}
	
	public void customInit() {
		System.out.println("IN CUSTOM INIT");
	}

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("POST INITIALIZATION");
		return null;
	}
	
	// bean is ready to be used. 
	
	@Override
	public void destroy() throws Exception {
		System.out.println("DESTROY FROM DISPOSABLE BEAN");
	}
	
	
	public void customDestroy() {
		System.out.println("CUSTOM DESTROY");
	}

	
}
