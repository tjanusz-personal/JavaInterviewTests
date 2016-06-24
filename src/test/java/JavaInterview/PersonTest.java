package test.java.JavaInterview;

import main.java.JavaInterview.Person;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

/**
 * Created by tjanusz929 on 6/24/16.
 */
public class PersonTest {

    @Before
    public void setUp() throws Exception {

    }

    private List<Person> getHardCodedPeopleList() {
        return new ArrayList<Person>() {
            {
                add(new Person("Aaron", 23, "Sales"));
                add(new Person("Terry", 23, "QA"));
                add(new Person("Jeremiah", 33, "Development"));
                add(new Person("Tim", 47, "Development"));
            }
        };
    }

    @Test
    public void personComparatorSortsOnFullNameOldSchoolWayUsingComparatorInterface() {
        List<Person> people = getHardCodedPeopleList();
        Collections.sort(people, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.getFullName().compareTo(o2.getFullName());
            }
        });
        assertPersonListHasNameString(people, "Aaron, Jeremiah, Terry, Tim");
    }

    @Test
    public void personComparatorSortsOnFullNameUsingLambdas() {
        List<Person> people = getHardCodedPeopleList();
        people.sort(Comparator.comparing(Person::getFullName));
        assertPersonListHasNameString(people, "Aaron, Jeremiah, Terry, Tim");
    }

    @Test
    public void personComparatorSortsOnDepartmentNameUsingLambdas() {
        List<Person> people = getHardCodedPeopleList();
        people.sort(Comparator.comparing(Person::getDepartment)
                .thenComparing(Person::getFullName));
        assertPersonListHasNameString(people, "Jeremiah, Tim, Terry, Aaron");
    }

    @Test
    public void personComparatorSortsOnAgeDepartmentNameUsingLambdas() {
        List<Person> people = getHardCodedPeopleList();
        people.sort(Comparator.comparing(Person::getAge).thenComparing(Person::getDepartment)
                .thenComparing(Person::getFullName));
        assertPersonListHasNameString(people, "Terry, Aaron, Jeremiah, Tim");
    }

    @Test
    public void personComparatorSortsOnAgeDepartmentNameWithNullsUsingLambdas() {
        List<Person> people = getHardCodedPeopleList();
        people.get(0).setDepartment(null);  // set aaron null
        people.sort(Comparator.comparing(Person::getAge)
                .thenComparing(Person::getDepartment, Comparator.nullsFirst(String::compareTo))
                .thenComparing(Person::getFullName));
        assertPersonListHasNameString(people, "Aaron, Terry, Jeremiah, Tim");
    }


    private void assertPersonListHasNameString(List<Person> personList, String nameStringToMatch) {
        String result = personList.stream().map(Person::getFullName).collect(Collectors.joining(", "));
        assertEquals(nameStringToMatch, result);
    }


}