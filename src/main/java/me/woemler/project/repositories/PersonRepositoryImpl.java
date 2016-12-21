package me.woemler.project.repositories;

import com.querydsl.core.types.EntityPath;
import com.querydsl.core.types.Predicate;
import com.querydsl.core.types.dsl.StringPath;
import me.woemler.project.models.Person;
import org.springframework.data.querydsl.binding.QuerydslBinderCustomizer;
import org.springframework.data.querydsl.binding.QuerydslBindings;
import org.springframework.data.querydsl.binding.SingleValueBinding;

/**
 * @author woemler
 */
public class PersonRepositoryImpl implements QuerydslBinderCustomizer<EntityPath<Person>> {

	@Override
	public void customize(QuerydslBindings bindings, EntityPath<Person> t) {
		bindings.bind(String.class).first(new SingleValueBinding<StringPath, String>() {
			@Override
			public Predicate bind(StringPath path, String s) {
				return path.equalsIgnoreCase(s);
			}
		});
	}
	
}
