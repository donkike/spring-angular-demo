package me.earangol.examples.demo.services.specs;

import me.earangol.examples.demo.model.Person;

import java.util.List;

/**
 * This file is subject to the terms and conditions defined in
 * file 'LICENSE.txt', which is part of this source code package.
 * <p>
 * Created with IntelliJ IDEA.
 */
public interface PeopleRepository {

    public List<Person> fetchAll();

    public Person create(Person p);

    public void remove(long id);

}
