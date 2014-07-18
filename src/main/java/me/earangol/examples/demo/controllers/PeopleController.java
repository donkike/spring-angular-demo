package me.earangol.examples.demo.controllers;

import me.earangol.examples.demo.model.Person;
import me.earangol.examples.demo.services.specs.PeopleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * This file is subject to the terms and conditions defined in
 * file 'LICENSE.txt', which is part of this source code package.
 *
 * Created with IntelliJ IDEA.
 */
@RestController
public class PeopleController {

    @Autowired
    private PeopleRepository repo;

    /**
     * Returns the list of all people in the database
     * GET /api/people
     * @return List of people
     */
    @RequestMapping(value = "/people", method = RequestMethod.GET)
    public List<Person> listPeople() {
        return repo.fetchAll();
    }

    /**
     * Creates a new Person in the database and returns it
     * POST /api/people
     * @param p Person information to be created
     * @return Created person
     */
    @RequestMapping(value = "/people", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public Person createPerson(@RequestBody Person p) {
        return repo.create(p);
    }

    /**
     * Deletes a Person from the database
     * DELETE /api/people/{id}
     * @param id Person id to be deleted
     */
    @RequestMapping(value = "/people/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.OK)
    public void deletePerson(@PathVariable long id) {
        repo.remove(id);
    }

}
