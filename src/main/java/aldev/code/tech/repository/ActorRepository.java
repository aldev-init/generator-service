package aldev.code.tech.repository;

import aldev.code.tech.model.Actor;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;

@ApplicationScoped
public class ActorRepository implements PanacheRepository<Actor> {

    public List<Actor> findAllPaginate(int page, int size){
        return findAll().page(page,size).list();
    }

}
