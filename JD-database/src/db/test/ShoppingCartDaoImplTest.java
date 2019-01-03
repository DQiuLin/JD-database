package db.test;

import static org.junit.Assert.*;

import org.junit.Test;

import java.util.List;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import db.dao.ShoppingCartDao;
import db.dao.ShoppingCartDaoImpl;
import db.entity.ShoppingCart;

public class ShoppingCartDaoImplTest {

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
		ShoppingCartDao dao = new ShoppingCartDaoImpl();
		int i=13;
		ShoppingCart a = dao.findByID(i);
		if(a == null) {
			System.out.println("û��IDΪ "+i+" ����Ϣ");
		}
		else {
			System.out.println("����IDΪ"+a.getShopping_cart_id()+" ��һ����Ϣ�ɹ�!");}
	
	}

	@Test
	public void testFindAll() {
		System.out.println("�г�������Ϣ");
		ShoppingCartDao cp = new ShoppingCartDaoImpl();
		List<ShoppingCart> coupon = cp.findAll();
		for(int i = 0; i < coupon.size(); i++) {
			ShoppingCart a = coupon.get(i);
			System.out.println(a.getUser_user_id()+" "+a.getShopping_cart_sku_num()+" "+a.getShopping_cart_create_time()+" "+a.getUser_user_id()+" ");
		}
		System.out.println("�г�������Ϣ�ɹ�!");
	}

	@Test
	public void testFindByUserID() {
		System.out.println("ͨ�������û�ID���������Ϣ");
		ShoppingCartDao ad = new ShoppingCartDaoImpl();
		int i=126;
		List<ShoppingCart> addr = ad.findByUserID(i);
		for(int j = 0; j < addr.size(); j++) {
			ShoppingCart a = addr.get(j);
			System.out.println(a.getUser_user_id()+" "+a.getShopping_cart_sku_num()+" "+a.getShopping_cart_create_time()+" "+a.getUser_user_id()+" ");
		}
		System.out.println("�����û�IDΪ"+i+" ��������Ϣ�ɹ�!");
	}

	@Test
	public void testSave() {
		System.out.println("������Ϣ");
		ShoppingCartDao dao = new ShoppingCartDaoImpl();
		int i=13;
		int j=19;
		ShoppingCartDao br = new ShoppingCartDaoImpl();
		ShoppingCart a1 = dao.findByID(i);
		ShoppingCart a2 = dao.findByID(j);
		if(a1!=null||a2!=null) {
			System.out.println("�Ѿ����ڸ�ID!");
		}
		else {
			ShoppingCart coupon = new ShoppingCart();
			coupon.setShopping_cart_id(i);
			coupon.setShopping_cart_create_time("2008-8-11 12:12:12");
			coupon.setShopping_cart_is_exist(true);
			coupon.setShopping_cart_sku_num(5);
			coupon.setUser_user_id(1);
			dao.save(coupon);
			coupon.setShopping_cart_id(j);
			coupon.setShopping_cart_create_time("2008-8-11 12:12:12");
			coupon.setShopping_cart_is_exist(true);
			coupon.setShopping_cart_sku_num(5);
			coupon.setUser_user_id(1);
			dao.save(coupon);
			//��֤�Ƿ�������Ϣ�ɹ�
			ShoppingCart a = dao.findByID(i);
			ShoppingCart b = dao.findByID(j);
			if(a==null||b==null) {
				System.out.println("Save Error!");
			}
			else {
				System.out.println("���ӳɹ�!");
			}
		}
	}

	@Test
	public void testDelete() {
		System.out.println("����һ����Ϣĳ��Ԫ��");
		int i=13;
		ShoppingCartDao dao = new ShoppingCartDaoImpl();
		ShoppingCart coupon=dao.findByID(i);
		//�жϸ�ID�Ƿ����
		if(coupon==null) {
			System.out.println("Find Error!");
		}
		else {
			coupon.setShopping_cart_is_exist(false);
			dao.update(coupon);
			//��֤�Ƿ������Ϣ�ɹ�
			ShoppingCart a = dao.findByID(i);
			if(a.isShopping_cart_is_exist()==false) {
				System.out.println("Update Error!");
			}
			System.out.println("���³ɹ�!");
		}
	}

	@Test
	public void testUpdate() {
		System.out.println("ɾ��һ��ָ��ID��Ϣ");
		int i=19;
		ShoppingCartDao dao = new ShoppingCartDaoImpl();
		ShoppingCart coupon=dao.findByID(i);
		if(coupon!=null) {
			try {
				dao.delete(coupon);
			}catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		//��֤�Ƿ�ɾ���ɹ�
		ShoppingCart a = dao.findByID(i);
		if(a!=null) {
			System.out.println("Delete Error!");
		}
		else {
			System.out.println("ɾ���ɹ�!");
		}
	}

}
