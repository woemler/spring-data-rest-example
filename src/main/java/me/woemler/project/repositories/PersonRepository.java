package me.woemler.project.repositories;

import com.querydsl.core.types.EntityPath;
import me.woemler.project.models.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.data.querydsl.binding.QuerydslBinderCustomizer;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * @author woemler
 */
@RepositoryRestResource
public interface PersonRepository extends JpaRepository<Person, Long>, 
		QueryDslPredicateExecutor<Person>, QuerydslBinderCustomizer<EntityPath<Person>> {
}
