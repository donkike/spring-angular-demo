package me.earangol.examples.demo.services;

import me.earangol.examples.demo.model.Person;
import me.earangol.examples.demo.services.specs.PeopleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.stereotype.Repository;
import java.util.List;

/**
 * This file is subject to the terms and conditions defined in
 * file 'LICENSE.txt', which is part of this source code package.
 *
 * Created with IntelliJ IDEA.
 */

@Repository
public class PeopleRepositoryImpl implements PeopleRepository {

    @Autowired
    private JdbcOperations db;

    /**
     * Queries the database and returns the list of all people information in it
     * @return List of people
     */
    public List<Person> fetchAll() {
        return db.query("SELECT id, firstName, lastName FROM People", (rs, row) -> {
            return new Person(rs.getLong("id"), rs.getString("firstName"), rs.getString("lastName"));
        });
    }

    /**
     * Creates a Person in the database and sets its generated id
     * @param p Person information to be created (if it already has an id, it will be ignored and replaced with the generated value)
     * @return
     */
    @Override
    public Person create(Person p) {
        long id = db.queryForObject("INSERT INTO People(firstName, lastName) VALUES(?, ?) RETURNING id", Long.class, p.getFirstName(), p.getLastName());
        p.setId(id);
        return p;
    }

    /**
     * Removes a Person from the database
     * @param id Person id to be removed
     */
    @Override
    public void remove(long id) {
        db.update("DELETE FROM People WHERE id = ?", id);
    }

}
