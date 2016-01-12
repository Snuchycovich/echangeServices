package persons;

import java.util.Collection;

/**
 * A class for running some basic tests on classes which implement interface IPersonDB.
 * @author Charlotte Lecluze and Bruno Zanuttini, Universit&eacute; de Caen Basse-Normandie, France
 * @since February, 2013
 */
public class TestPersonDB {

    /**
     * Runs a series of tests on an instance of a class which implements IPersonDB.
     * The instance is assumed to represent an empty database of persons when passed to
     * this method. If tests go well, the database is empty again when the method exits.
     * The method uses assertions to run tests.
     * @param instance An instance of the class to be tested, representing an empty
     * database of persons
     * @throws Exception if an unexpected error occurs
     */
    public static void test (IPersonDB instance) throws Exception {
        instance.create(new Person("Dupont","Marie","marie.dupont@mail.fr"),"eiram");
        instance.create(new Person("Martin","Jean","jean.martin@mail.com"),"naej");
        instance.create(new Person("Durand","Nicolas","nicolas.durand@mail.com"),"salocin");
        instance.create(new Person("Lefevre","Emilie","emilie.lefevre@mail.fr"),"eilime");

        // Testing "R" methods
        Collection<Person> all=instance.retrieveAll();
        assert all.size()==4;
        boolean nicolasFound=false;
        for (Person p: all) {
            if ("nicolas.durand@mail.com".equals(p.getEmail())) {
                nicolasFound=true;
            }
        }
        assert nicolasFound;

        // Testing "U" methods
        assert instance.exists("jeannot.martinet@mail.com");
        Person jeannot=instance.retrieve("jeannot.martinet@mail.com");
        assert "Martinet".equals(jeannot.getName());
        assert "Jeannot".equals(jeannot.getFirstName());
        assert "jeannot.martinet@mail.com".equals(jeannot.getEmail());

        instance.updatePassword("nicolas.durand@mail.com","new");
        assert !instance.isValid("nicolas.durand@mail.com","salocin");
        assert instance.isValid("nicolas.durand@mail.com","new");
        assert !instance.isValid("marie.dupont@mail.fr","new");

        // Testing "D" methods
        assert instance.retrieveAll().size()==3;
        assert !instance.exists("nicolas.durand@mail.com");
        assert instance.exists("emilie.lefevre@mail.fr");

    }

}

