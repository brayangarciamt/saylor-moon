/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.usa.ciclo4.repositorio;

import co.edu.usa.ciclo4.modelo.User;
import co.edu.usa.ciclo4.repositorio.crud.UserCrudRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Grupo G9 Cilco-4
 */
@Repository
public class UserRepository {

    @Autowired
    private UserCrudRepository crud;
    @Autowired
    private MongoTemplate mongoTemplate;

    public List<User> getAll() {
        return (List<User>) crud.findAll();
    }

    public Optional<User> getUser(Integer id) {
        return crud.findById(id);
    }

    public User save(User usuario) {
        return crud.save(usuario);
    }

    public String getByEmail(String correo) {
        return crud.getUserByEmail(correo);
    }

    public Optional<User> checkEmailAndPassw(String email, String password) {
        return crud.getUserByEmailAndPassword(email, password);
    }
    public void delete(User user){
        crud.delete(user);
    }
    
    public List<User> getUsersByZone(String zone){
        return crud.getUsersByZone(zone);
    }
    
    public List<User> getUsersByBirthday(String mes){
        Query query = new Query(); // Crear objeto de condición
        query.addCriteria(Criteria.where("monthBirthtDay").is(mes));
        List<User> ls = mongoTemplate.find(query,User.class);
        return ls;
    }
}
