package test;

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
        db.create(new Service(1,"Dépannage informatique","Aide pour réparer mon ordinateur", "Demande", "Informatique"));
        db.create(new Service(2,"Jardinage","Je possède une debrou débroussailleuses je peux venir couper votre gazon", "Offre", "Jardinage"));
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
        assert title == "Dépannage informatique";
        assert description == "Aide pour réparer mon ordinateur";
        assert type == "Demande";
        assert category == "Informatique";
        Service s = db.retrieve(1);
        assert  1 == s.getId();
        assert s.getTitle()== "Dépannage informatique";
        assert s.getDescription() == "Aide pour réparer mon ordinateur";
        assert type == "Demande";
        assert category == "Informatique";
        db.delete(s);
        assert db.retrieveAll().size()== 1;
        assert db.retrieve(1) == null;
    }
	
}
