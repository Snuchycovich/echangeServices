package services;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.Locale;

import services.Service;

public class TestServiceDB {

	public static void test (IServiceDB instance) throws Exception {
		
		String limitDateString = "12/25/2016";
		DateFormat df = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss", Locale.FRANCE);
		Date limitDate = df.parse(limitDateString);
		
        instance.create(new Service("Depannage Informatique"));
        instance.create(new Service("Jardinage"));
        instance.create(new Service("Tâches Ménagères"));
        instance.create(new Service("Cours d'anglais"));
        
        Collection<Service> all=instance.retrieveAll();
        assert all.size()==4;
	}
}
