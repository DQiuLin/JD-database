package db.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import db.dao.CouponDao;
import db.dao.CouponDaoImpl;
import db.entity.Coupon;



public class CouponDaoImplTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testGetSession() {
		
	}

	@Test
	public void testFindByID() {
		System.out.println("ͨ��ID���һ����Ϣ");
		CouponDao dao = new CouponDaoImpl();
		int i=13;
		Coupon a = dao.findByID(i);
		if(a == null) {
			System.out.println("û��IDΪ "+i+" ����Ϣ");
		}
		else {
			System.out.println("����IDΪ"+a.getCoupon_id()+" ��һ����Ϣ�ɹ�!");}
	}

	@Test
	public void testSave() {
		System.out.println("������Ϣ");
		CouponDao dao = new CouponDaoImpl();
		int i=13;
		int j=19;
		CouponDao br = new CouponDaoImpl();
		Coupon a1 = dao.findByID(i);
		Coupon a2 = dao.findByID(j);
		if(a1!=null||a2!=null) {
			System.out.println("�Ѿ����ڸ�ID!");
		}
		else {
			Coupon coupon = new Coupon();
			coupon.setCoupon_id(i);
			coupon.setCoupon_begin_time("2008-08-11 12:21:12");
			coupon.setCoupon_cost_allocation(123);
			coupon.setCoupon_end_time("2019-09-11 12:00:00");
			coupon.setCoupon_how_many(123);
			coupon.setCoupon_is_deleted(false);
			coupon.setCoupon_lower_bound(123);
			coupon.setCoupon_name("4132421");
			coupon.setCoupon_note("dfghjk");
			coupon.setCoupon_type(3);
			coupon.setCoupon_user_lever("high");
			coupon.setCoupon_user_range(2);
			coupon.setCoupon_value(21);
			coupon.setCoupon_verifier("as");
			dao.save(coupon);
			coupon.setCoupon_id(i);
			coupon.setCoupon_begin_time("2008-08-11 12:21:12");
			coupon.setCoupon_cost_allocation(123);
			coupon.setCoupon_end_time("2019-09-11 12:00:00");
			coupon.setCoupon_how_many(123);
			coupon.setCoupon_is_deleted(false);
			coupon.setCoupon_lower_bound(123);
			coupon.setCoupon_name("4132421");
			coupon.setCoupon_note("dfghjk");
			coupon.setCoupon_type(3);
			coupon.setCoupon_user_lever("high");
			coupon.setCoupon_user_range(2);
			coupon.setCoupon_value(21);
			coupon.setCoupon_verifier("as");
			dao.save(coupon);
			//��֤�Ƿ�������Ϣ�ɹ�
			Coupon a = dao.findByID(i);
			Coupon b = dao.findByID(j);
			if(a==null||b==null) {
				System.out.println("Save Error!");
			}
			else {
				System.out.println("���ӳɹ�!");
			}
		}
	}
	
	@Test
	public void testFindAll() {
		System.out.println("�г�������Ϣ");
		CouponDao cp = new CouponDaoImpl();
		List<Coupon> coupon = cp.findAll();
		for(int i = 0; i < coupon.size(); i++) {
			Coupon a = coupon.get(i);
			System.out.println(a.getCoupon_id()+" "+a.getCoupon_name()+" "+a.getCoupon_how_many()+
					" "+a.getCoupon_type()+" "+a.getCoupon_lower_bound()+" "+a.getCoupon_value()+
					" "+a.getCoupon_cost_allocation()+" "+a.getCoupon_user_lever()+" "+a.getCoupon_user_range()+
					" "+a.getCoupon_begin_time()+" "+a.getCoupon_end_time()+" "+a.getCoupon_status()+
					" "+a.getCoupon_verifier()+" "+a.getCoupon_note()+" ");
		}
		System.out.println("�г�������Ϣ�ɹ�!");
	}
	
	@Test
	public void testUpdate() {
		System.out.println("����һ����Ϣĳ��Ԫ��");
		int i=13;
		CouponDao dao=new CouponDaoImpl();
		Coupon coupon=dao.findByID(i);
		//�жϸ�ID�Ƿ����
		if(coupon==null) {
			System.out.println("Find Error!");
		}
		else {
			coupon.setCoupon_name("change");
			dao.update(coupon);
			//��֤�Ƿ������Ϣ�ɹ�
			Coupon a = dao.findByID(i);
			if(!a.getCoupon_name().equals("change")) {
				System.out.println("Update Error!");
			}
			System.out.println("���³ɹ�!");
		}
		
	}
	
	@Test
	public void testDelete() {
		System.out.println("ɾ��һ��ָ��ID��Ϣ");
		int i=19;
		CouponDao dao=new CouponDaoImpl();
		Coupon coupon=dao.findByID(i);
		if(coupon!=null) {
			try {
				dao.delete(coupon);
			}catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		//��֤�Ƿ�ɾ���ɹ�
		Coupon a = dao.findByID(i);
		if(a!=null) {
			System.out.println("Delete Error!");
		}
		else {
			System.out.println("ɾ���ɹ�!");
		}
	}
}
