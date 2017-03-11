package org.db.hib;

import java.util.Date;

import org.apache.commons.logging.impl.Log4JLogger;
import org.dao.conn.Venu;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.venu.dto.Address;

public class HibernateTest {

	public static void main(String[] args) {
		Venu v=new Venu();
		Address ad=new Address();
		Address ad2=new Address();
		v.setUserName("java21");
		v.setTime(new Date());
		ad.setCity("Houston");
		ad.setStreet("holly");
		ad.setZip(77053);
		v.setHome(ad);
		
		ad2.setStreet("westimer");
		ad2.setZip(77069);
		ad2.setCity("Houston");
		v.setOffice(ad2);
		
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session=sf.openSession();
		session.beginTransaction();
		session.save(v);
		session.getTransaction().commit();
		session.close();
		
	v=null;
		session=sf.openSession();
		session.beginTransaction();
		v=(Venu) session.get(Venu.class, 1);
		Log4JLogger lj=new Log4JLogger();
		lj.info("hello");

	}

}
