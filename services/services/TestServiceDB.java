package services;

import java.util.Collection;

import services.Service;

public class TestServiceDB {

	public static void test (IServiceDB instance) throws Exception {
        instance.create(new Service("Depannage Informatique","Description dépannage informatique", "Offre", "Informatique", null));
        instance.create(new Service("Jardinage", "Description dépannage jardinage","Demande", "Maison", null));
        instance.create(new Service("Tâches Ménagères", "Description dépannage tâches ménagères","Offre", "Maison", null));
        instance.create(new Service("Cours d'anglais", "Description dépannage cours","Demande", "Enseigement", null));
        
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
