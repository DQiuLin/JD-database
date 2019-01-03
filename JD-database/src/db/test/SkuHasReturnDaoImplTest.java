package db.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import db.dao.SpuDao;
import db.dao.SpuDaoImpl;
import db.entity.Spu;



public class SkuHasReturnDaoImplTest {

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
	public void testFindAll() {
		System.out.println("�г�������Ϣ");
		SpuDao cp = new SpuDaoImpl();
		List<Spu> coupon = cp.findAll();
		for(int i = 0; i < coupon.size(); i++) {
			Spu a = coupon.get(i);
			System.out.println(a.getSpu_id()+" "+a.getSpu_name()+" "+a.getSpu_type_spu_type_id()+" "+a.getBrand_brand_id()+" "+a.getStore_store_id());
		}
		System.out.println("�г�������Ϣ�ɹ�!");
	}

	@Test
	public void testFindByBrandID() {
		System.out.println("ͨ������Brand ID���������Ϣ");
		SpuDao ad = new SpuDaoImpl();
		int i=126;
		List<Spu> addr = ad.findByBrandID(i);
		for(int j = 0; j < addr.size(); j++) {
			Spu a = addr.get(j);
			System.out.println(a.getSpu_id()+" "+a.getSpu_name()+" "+a.getSpu_type_spu_type_id()+" "+a.getBrand_brand_id()+" "+a.getStore_store_id());
		}
		System.out.println("����Brand IDΪ"+i+" ��������Ϣ�ɹ�!");
	}
	
	@Test
	public void testFindByStoreID() {
		System.out.println("ͨ������Store ID���������Ϣ");
		SpuDao ad = new SpuDaoImpl();
		int i=126;
		List<Spu> addr = ad.findByStoreID(i);
		for(int j = 0; j < addr.size(); j++) {
			Spu a = addr.get(j);
			System.out.println(a.getSpu_id()+" "+a.getSpu_name()+" "+a.getSpu_type_spu_type_id()+" "+a.getBrand_brand_id()+" "+a.getStore_store_id());
		}
		System.out.println("����Store IDΪ"+i+" ��������Ϣ�ɹ�!");
	
	}

	@Test
	public void testFindByID() {
		System.out.println("ͨ��ID���һ����Ϣ");
		SpuDao dao = new SpuDaoImpl();
		int i=13;
		Spu a = dao.findByID(i);
		if(a == null) {
			System.out.println("û��IDΪ "+i+" ����Ϣ");
		}
		else {
			System.out.println("����IDΪ"+a.getSpu_id()+" ��һ����Ϣ�ɹ�!");}
	
	}

	@Test
	public void testSave() {
		System.out.println("������Ϣ");
		SpuDao dao = new SpuDaoImpl();
		int i=13;
		int j=19;
		SpuDao br = new SpuDaoImpl();
		Spu a1 = dao.findByID(i);
		Spu a2 = dao.findByID(i);
		if(a1!=null||a2!=null) {
			System.out.println("�Ѿ����ڸ�ID!");
		}
		else {
			Spu coupon = new Spu();
			coupon.setSpu_id(i);
			coupon.setSpu_name("name");
			coupon.setBrand_brand_id(12);
			coupon.setSpu_type_spu_type_id(3);
			coupon.setStore_store_id(3);
			dao.save(coupon);
			coupon.setSpu_id(j);
			coupon.setSpu_name("name");
			coupon.setBrand_brand_id(12);
			coupon.setSpu_type_spu_type_id(3);
			coupon.setStore_store_id(3);
			dao.save(coupon);
			//��֤�Ƿ�������Ϣ�ɹ�
			Spu a = dao.findByID(i);
			Spu b = dao.findByID(j);
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
		SpuDao dao = new SpuDaoImpl();
		Spu coupon=dao.findByID(i);
		//�жϸ�ID�Ƿ����
		if(coupon==null) {
			System.out.println("Find Error!");
		}
		else {
			coupon.setSpu_name("change");;
			dao.update(coupon);
			//��֤�Ƿ������Ϣ�ɹ�
			Spu a = dao.findByID(i);
			if(!a.getSpu_name().equals("change")) {
				System.out.println("Update Error!");
			}
			System.out.println("���³ɹ�!");
		}
	}

	@Test
	public void testUpdate() {
		System.out.println("ɾ��һ��ָ��ID��Ϣ");
		int i=19;
		SpuDao dao = new SpuDaoImpl();
		Spu coupon=dao.findByID(i);
		if(coupon!=null) {
			try {
				dao.delete(coupon);
			}catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		//��֤�Ƿ�ɾ���ɹ�
		Spu a = dao.findByID(i);
		if(a!=null) {
			System.out.println("Delete Error!");
		}
		else {
			System.out.println("ɾ���ɹ�!");
		}
	}
	}
