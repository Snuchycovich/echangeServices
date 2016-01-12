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
		
        instance.create(new Service("Depannage Informatique", limitDate, 0));
        instance.create(new Service("Jardinage", limitDate, 1));
        instance.create(new Service("Tâches Ménagères", limitDate, 0));
        instance.create(new Service("Cours d'anglais", limitDate, 1));
        
        Collection<Service> all=instance.retrieveAll();
        assert all.size()==4;
	}
}
