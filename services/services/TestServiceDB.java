package services;

import java.util.Collection;
import java.util.Date;

import services.Service;

public class TestServiceDB {

	public static void test (IServiceDB instance) throws Exception {
		
		Date testDate = new Date("11/22/2013 00:53");
        instance.create(new Service("Depannage Informatique","Description dépannage informatique", "Offre", "Informatique", testDate));
        instance.create(new Service("Jardinage", "Description dépannage jardinage","Demande", "Maison", testDate));
        instance.create(new Service("Tâches Ménagères", "Description dépannage tâches ménagères","Offre", "Maison", testDate));
        instance.create(new Service("Cours d'anglais", "Description dépannage cours","Demande", "Enseigement", testDate));
        
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
