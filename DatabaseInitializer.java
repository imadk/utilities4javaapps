/***
 *
 *DatabaseInitializer: safely connect and disconnect to sql database
 *with a singleton approach
 *
 *March 2011
 *
 * @author Imad Khoury
 * */


//replace with your data access object classes
import packagename.Dao;
import packagename.DaoHandler;


public class DatabaseInitializer {

	public static Dao db;
	private static boolean dbconnected = false;
	public static  boolean initDatabase() {

		if (dbconnected == false) {
			//Create database and tables if not created - skips if already exist
			 db = new Dao();
			//Connect to database
			db = DaoHandler.connectToDb();
			dbconnected = true;
			return true;
		}else{
			return false;
		}
	}

	public  static boolean uninitDatabase() {
		if(dbconnected == true){
			// Shut down connection to database
			DaoHandler.disconnectFromDb(db);
			dbconnected=false;
			return true;
		}else{
			return false;
		}
	}
}
