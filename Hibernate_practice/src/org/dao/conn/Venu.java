package org.dao.conn;

import java.util.Date;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import com.venu.dto.Address;

@Entity(name="user_details")
public class Venu {

		@Column (name="usid")
		@Id@GeneratedValue(strategy=GenerationType.AUTO) //This indicates UserID field is the primary key
		//@EmbeddedID is used where the primary key is a object 
		private int userID;
		
		@Column (name="user_name")
		private String userName;
		
		//@Transient // This indicates name not tobe included in DB by Hibernate;
		
		@Embedded
		@AttributeOverrides({@AttributeOverride(name="street",column=@Column(name="home_street_name")),
							@AttributeOverride(name="city",column=@Column(name="home_city")),
							@AttributeOverride(name="zip",column=@Column(name="home_zip"))})
		private Address home;
		
		@Embedded //To handle datatypes not defined by DB for ex Address datatype(object) is not defined. This helps in creating the datatypes Address object has to table operation is performing.
		@AttributeOverrides({@AttributeOverride(name="street",column=@Column(name="office_street_name")),
							@AttributeOverride(name="city",column=@Column(name="office_city")),
							@AttributeOverride(name="zip",column=@Column(name="office_zip"))})
		private Address office;
		
		public Address getHome() {
			return home;
		}
		public void setHome(Address home) {
			this.home = home;
		}
		public Address getOffice() {
			return office;
		}
		public void setOffice(Address office) {
			this.office = office;
		}
		@Temporal(TemporalType.DATE)
		private Date time;
		//@Lob if there are huge amount of data to be stored in db
		
		public Date getTime() {
			return time;
		}
		public void setTime(Date time) {
			this.time = time;
		}
		public int getUserID() {
			return userID;
		}
		public void setUserID(int userID) {
			this.userID = userID;
		}
		public String getUserName() {
			return userName;
		}
		public void setUserName(String userName) {
			this.userName = userName;
		}
}
