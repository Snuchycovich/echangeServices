package services;

import java.util.Collection;
import services.Service;

public class TestServiceDB {

	public static void test (IServiceDB instance) throws Exception {
		
        instance.create(new Service("Depannage Informatique"));
        instance.create(new Service("Jardinage"));
        instance.create(new Service("Tâches Ménagères"));
        instance.create(new Service("Cours d'anglais"));
        
     // Testing "R" methods
        Collection<Service> all=instance.retrieveAll();
        assert all.size()==4;
        /*boolean jardinageFound=false;
        for (Service s: all) {
            if ("2".equals(s.getId())) {
            	jardinageFound=true;
            }
        }*/
	}
}
