package db;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import org.bson.Document;
import static com.mongodb.client.model.Filters.in;
import com.mongodb.BasicDBObject;
import com.mongodb.Block;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;

public class DBconnect2 {
	public static HashMap<String, String> GetTomatoesOrBaconRecipes() throws ClassNotFoundException {

		
		HashMap<String, String> hmap = new HashMap<String, String> ();
		
		MongoClient mongoClient = new MongoClient("localhost", xxxx);
		DB database = mongoClient.getDB("recipesDB");
		DBCollection collection = database.getCollection("recipes");
		//boolean auth = database.authenticate("admin", "pwd".toCharArray());
        
		/***
		BasicDBObject searchQuery = new BasicDBObject();
		searchQuery.put("ingredients.ingredient", "tomatoes");
		DBCursor cursor = collection.find(searchQuery);
		 
		while (cursor.hasNext()) {
		    System.out.println(cursor.next());
		}
        ***/
	
		//db.getCollection('recipes').find({"ingredients.ingredient": {$in: ["tomatoes", "bacon"]}}).map(function(i) {return i.dishname;})
		BasicDBObject inQuery = new BasicDBObject();
		List<String> list = new ArrayList<String>();
		list.add("tomatoes");
		list.add("bacon");
		inQuery.put("ingredients.ingredient", new BasicDBObject("$in", list));
		DBCursor cursor = collection.find(inQuery);
		while(cursor.hasNext()) {
			//System.out.println(cursor.next());
			DBObject doc = cursor.next();
            Map map = doc.toMap();
            String dishname = (String) map.get("dishname");
            System.out.println(dishname);
            hmap.put("dishname", dishname);
		}
        
		return hmap;
    }
}


























