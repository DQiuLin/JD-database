package db.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import db.dao.SkuDao;
import db.dao.SkuDaoImpl;
import db.entity.Sku;


public class SkuDaoImplTest {

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
	public void testFindAll() {
		System.out.println("�г�������Ϣ");
		SkuDao cp = new SkuDaoImpl();
		List<Sku> coupon = cp.findAll();
		for(int i = 0; i < coupon.size(); i++) {
			Sku a = coupon.get(i);
			System.out.println(a.getSku_id()+" "+a.getSku_name()+" "+a.getSku_price()+" "+a.getSku_store()+" "+a.getSpu_spu_id()+" ");
		}
		System.out.println("�г�������Ϣ�ɹ�!");
	}

	
	@Test
	public void testfindBySpuID() {
		System.out.println("ͨ������Spu ID���������Ϣ");
		SkuDao ad = new SkuDaoImpl();
		int i=126;
		List<Sku> addr = ad.findBySpuID(i);
		for(int j = 0; j < addr.size(); j++) {
			Sku a = addr.get(j);
			System.out.println(a.getSku_id()+" "+a.getSku_name()+" "+a.getSku_price()+" "+a.getSku_store()+" "+a.getSpu_spu_id()+" ");
		}
		System.out.println("����Spu IDΪ"+i+" ��������Ϣ�ɹ�!");
	}

	@Test
	public void testFindByID() {
		System.out.println("ͨ��ID���һ����Ϣ");
		SkuDao dao = new SkuDaoImpl();
		int i=13;
		Sku a = dao.findByID(i);
		if(a == null) {
			System.out.println("û��IDΪ "+i+" ����Ϣ");
		}
		else {
			System.out.println("����IDΪ"+a.getSku_id()+" ��һ����Ϣ�ɹ�!");}
	
	}

	@Test
	public void testSave() {
		System.out.println("������Ϣ");
		SkuDao dao = new SkuDaoImpl();
		int i=13;
		int j=19;
		SkuDao br = new SkuDaoImpl();
		Sku a1 = dao.findByID(i);
		Sku a2 = dao.findByID(i);
		if(a1!=null||a2!=null) {
			System.out.println("�Ѿ����ڸ�ID!");
		}
		else {
			Sku x = new Sku();
			x.setSku_id(i);
			x.setSku_name("111");
			x.setSku_price(1);
			x.setSku_store(21);
			x.setSpu_spu_id(21);
			dao.save(x);
			x.setSku_id(i);
			x.setSku_name("111");
			x.setSku_price(1);
			x.setSku_store(21);
			x.setSpu_spu_id(21);
			dao.save(x);
			//��֤�Ƿ�������Ϣ�ɹ�
			Sku a = dao.findByID(i);
			Sku b = dao.findByID(j);
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
		SkuDao dao = new SkuDaoImpl();
		Sku coupon=dao.findByID(i);
		//�жϸ�ID�Ƿ����
		if(coupon==null) {
			System.out.println("Find Error!");
		}
		else {
			coupon.setSku_name("change");;
			dao.update(coupon);
			//��֤�Ƿ������Ϣ�ɹ�
			Sku a = dao.findByID(i);
			if(!a.getSku_name().equals("change")) {
				System.out.println("Update Error!");
			}
			System.out.println("���³ɹ�!");
		}
	}

	@Test
	public void testUpdate() {
		System.out.println("ɾ��һ��ָ��ID��Ϣ");
		int i=19;
		SkuDao dao = new SkuDaoImpl();
		Sku coupon=dao.findByID(i);
		if(coupon!=null) {
			try {
				dao.delete(coupon);
			}catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		//��֤�Ƿ�ɾ���ɹ�
		Sku a = dao.findByID(i);
		if(a!=null) {
			System.out.println("Delete Error!");
		}
		else {
			System.out.println("ɾ���ɹ�!");
		}
	}
	}
