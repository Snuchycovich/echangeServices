package test;

import java.util.Date;
import java.util.List;
import java.sql.Connection;
import java.sql.SQLException;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import services.SQLServiceDB;
import services.Service;

public class TestSQLServiceDB {
	
	public static void main(String[] args){
		if (args.length!=4) {
            System.err.println("You must specify DB host, database, username, and password as arguments");
            System.exit(1);
        }
		System.out.print("Testing class SQLServiceDB... ");
        System.out.flush();
        SQLServiceDB db=null;
        Connection link=null;
        try {
            link=TestSQLServiceDB.createLink(args[0],args[1],args[2],args[3]);
            db=new SQLServiceDB(link,"tableServicesTest");
            TestSQLServiceDB.test(db);
        } catch (SQLException e) {
            System.out.println("Exception: "+e);
        } catch (AssertionError e) {
            System.out.println("AssertionError e: "+e);
        } finally {
            try {
                db.deleteTables();
            } catch (SQLException e) {
                System.out.println("Exception: "+e);
            }
            try {
                link.close();
            } catch (SQLException e) {
                System.out.println("Exception: "+e);
            }
        }
        System.out.println("OK");
    }
	protected static Connection createLink (String host, String database, String username, String password) throws SQLException {
        MysqlDataSource ds=new MysqlDataSource();
        ds.setServerName(host);
        ds.setDatabaseName(database);
        Connection link = ds.getConnection(username,password);
        if (!link.isValid(0)) {
            throw new SQLException("Failed to initialize a valid connection to database.");
        }
        return link;
    }
	
	protected static void test (SQLServiceDB db) throws SQLException, AssertionError {
        db.createTables();
        Date testDate = new Date("11/22/2013 00:53");
        db.create(new Service("Dépannage informatique","Aide pour réparer mon ordinateur", "Demande", "Informatique", testDate));
        db.create(new Service("Jardinage","Je possède une debrou débroussailleuses je peux venir couper votre gazon", "Offre", "Jardinage", testDate));
        List<Service> res=db.retrieveAll();
        assert res.size()==2;
        boolean id = false;
        String title = "";
        String description = "";
        String type = "";
        String category = "";
       
        for (Service s: res) {
            if (1 == s.getId()) {
                id = true;
                title = s.getTitle();
                description = s.getDescription();
                type = s.getType();
                category = s.getCategory();
                break;
            }
        }
        assert id;
        assert "Dépannage informatique".equals(title);
        assert "Aide pour réparer mon ordinateur".equals(description);
        assert "Demande".equals(type);
        assert "Informatique".equals(category);
        Service s = db.retrieve(1);
        assert 1 == s.getId();
        assert "Dépannage informatique".equals(s.getTitle());
        assert "Aide pour réparer mon ordinateur".equals(s.getDescription());
        assert "Demande".equals(s.getType());
        assert "Informatique".equals(s.getCategory());
        s.setTitle("Depannage electrique");
        try {
			db.update(s);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        s = db.retrieve(1);
        assert "Depannage electrique".equals(s.getTitle());
        db.delete(s);
        assert db.retrieveAll().size()== 1;
        assert db.retrieve(1) == null;
    }
	
}
