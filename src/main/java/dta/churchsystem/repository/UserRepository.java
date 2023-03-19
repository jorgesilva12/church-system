package dta.churchsystem.repository;

import dta.churchsystem.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<User, Integer> {
    @Query("SELECT e FROM User e WHERE e.name= (:name)")
    public User findByName(@Param("name") String name);

    @Query("SELECT e FROM User e WHERE e.login= (:login)")
    public User findByLogin(@Param("login") String login);

    @Query("SELECT e FROM User e WHERE e.id= (:id)")
    public User findById(@Param("id") int id);
}
