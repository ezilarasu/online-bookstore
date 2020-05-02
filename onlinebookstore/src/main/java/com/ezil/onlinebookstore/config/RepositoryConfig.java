package com.ezil.onlinebookstore.config;

import java.util.Collection;
import java.util.Collections;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.metamodel.Type;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;



@Configuration
public class RepositoryConfig implements RepositoryRestConfigurer{
	
	@Autowired
	public EntityManager entityManager;
	

	public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
		
	config.exposeIdsFor(entityManager.getMetamodel().getEntities().stream()
			.map(Type :: getJavaType).toArray(Class[]:: new));
	
		
	}
	
}
