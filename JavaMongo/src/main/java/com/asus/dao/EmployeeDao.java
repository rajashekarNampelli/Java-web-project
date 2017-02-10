package com.asus.dao;

import java.util.ArrayList;

import com.asus.model.Employee;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;

public class EmployeeDao {

	MongoClient mongo = new MongoClient("localhost", 27017);
	DB database = mongo.getDB("local");
	DBCollection collection = database.getCollection("Employee");

	public void insertValues(Employee emp) {
		DBObject document1 = new BasicDBObject();
		document1.put("employee_id", emp.getEmployee_id());
		document1.put("employee_name", emp.getEmployee_name());
		document1.put("employee_salary", emp.getEmployee_salary());
		collection.insert(document1);
	}

	public void getEmployeeValuesForSingleRecord(int employee_id) {
		BasicDBObject query = new BasicDBObject();
		query.put("employee_id", employee_id);
		DBCursor cursor = collection.find(query);
		while(cursor.hasNext()) {
		    System.out.println(cursor.next());
		}
	}
}
