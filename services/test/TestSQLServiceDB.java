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
        db.create(new Service("Dépannage informatique"));
        db.create(new Service("Jardinage"));
        List<Service> res=db.retrieveAll();
        assert res.size()==2;
        boolean id = false;
        String title = "";
       
        for (Service s: res) {
            if (1 == s.getId()) {
                id = true;
                title = s.getTitle();
                break;
            }
        }
        /*assert id;
        assert "Dépannage informatique".equals(title);

        Service s = db.retrieve(1);
        assert 1 == s.getId();
        assert "Dépannage informatique".equals(s.getTitle());
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
        assert db.retrieve(1) == null;*/
    }
	
}
