package tests;

import java.sql.SQLException;
import java.util.List;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import java.sql.Connection;


import persons.Person;
import persons.SQLPersonDB;

public class TestSQLPersonDB {
	public static void main(String[] args){
		if (args.length!=4) {
            System.err.println("You must specify DB host, database, username, and password as arguments");
            System.exit(1);
        }
		System.out.print("Testing class SQLServiceDB... ");
        System.out.flush();
        SQLPersonDB db=null;
        Connection link=null;
        try {
            link=TestSQLPersonDB.createLink(args[0],args[1],args[2],args[3]);
            db=new SQLPersonDB(link,"tableServicesTest");
            TestSQLPersonDB.test(db);
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
	
	protected static void test (SQLPersonDB db) throws SQLException, AssertionError {
        db.createTables();
        db.create(new Person("Castillo", "Emiliano", "emiliano.caslep@gmail.com"), "aaa");
        db.create(new Person("Foucault", "Julien", "test@mail.com"), "bbb");
        List<Person> res = (List<Person>) db.retrieveAll();
        assert res.size()==2;
        boolean id = false;
        String name = "";
       
        for (Person p: res) {
            if (1 == p.getId()) {
                id = true;
                name = p.getName();
                break;
            }
        }
        assert id;
        assert "Castillo".equals(name);
        
        try {
        	Person p = db.retrieve("test@mail.com");
        	assert 2 == p.getId();
            assert "Julien".equals(p.getFirstName());
            p.setFirstName("Clément");
            try {
    			db.update(p);
    		} catch (Exception e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		}
        } catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
       
        try {
        Person p1 = db.retrieve("emiliano.caslep@gmail.com");
        int idPerson = p1.getId();
        assert "Castillo".equals(p1.getName());
        db.delete(idPerson);
        assert db.retrieveAll().size()== 1;
        assert db.retrieve("emiliano.caslep@gmail.com") == null;
        } catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
    }


	
}