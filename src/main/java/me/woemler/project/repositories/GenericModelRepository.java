package me.woemler.project.repositories;

import com.querydsl.core.types.EntityPath;
import com.querydsl.core.types.Predicate;
import com.querydsl.core.types.dsl.StringPath;
import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.QueryDslJpaRepository;
import org.springframework.data.querydsl.EntityPathResolver;
import org.springframework.data.querydsl.binding.QuerydslBinderCustomizer;
import org.springframework.data.querydsl.binding.QuerydslBindings;
import org.springframework.data.querydsl.binding.SingleValueBinding;

import javax.persistence.EntityManager;
import java.io.Serializable;

/**
 * @author woemler
 */
public class GenericModelRepository<T, ID extends Serializable, S extends EntityPath<T>> extends QueryDslJpaRepository<T, ID> 
		implements QuerydslBinderCustomizer<S> {

	public GenericModelRepository(
			JpaEntityInformation<T, ID> entityInformation,
			EntityManager entityManager) {
		super(entityInformation, entityManager);
	}

	public GenericModelRepository(
			JpaEntityInformation<T, ID> entityInformation,
			EntityManager entityManager,
			EntityPathResolver resolver) {
		super(entityInformation, entityManager, resolver);
	}

	@Override 
	public void customize(QuerydslBindings bindings, S t) {
			bindings.bind(String.class).first(new SingleValueBinding<StringPath, String>() {
				@Override 
				public Predicate bind(StringPath path, String s) {
					return path.equalsIgnoreCase(s);
				}
			});
	}
}
