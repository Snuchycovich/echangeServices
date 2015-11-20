package services;

import java.util.Collection;

import services.Service;

public class TestServiceDB {

	public static void test (IServiceDB instance) throws Exception {
        instance.create(new Service(1,"Depannage Informatique","Description dépannage informatique", "Offre", "Informatique"));
        instance.create(new Service(2,"Jardinage", "Description dépannage jardinage","Demande", "Maison"));
        instance.create(new Service(3,"Tâches Ménagères", "Description dépannage tâches ménagères","Offre", "Maison"));
        instance.create(new Service(4,"Cours d'anglais", "Description dépannage cours","Demande", "Enseigement"));
        
     // Testing "R" methods
        Collection<Service> all=instance.retrieveAll();
        assert all.size()==4;
        boolean jardinageFound=false;
        for (Service s: all) {
            if ("2".equals(s.getId())) {
            	jardinageFound=true;
            }
        }
	}
}
