package db.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import db.dao.SpuTypeDao;
import db.dao.SpuTypeDaoImpl;
import db.entity.SpuType;


public class SpuTypeDaoImplTest {

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
		SpuTypeDao dao = new SpuTypeDaoImpl();
		int i=13;
		SpuType a = dao.findByID(i);
		if(a == null) {
			System.out.println("û��IDΪ "+i+" ����Ϣ");
		}
		else {
			System.out.println("����IDΪ"+a.getSpu_type_id()+" ��һ����Ϣ�ɹ�!");}
	
	}

	@Test
	public void testfindByFatherID() {
		System.out.println("ͨ������Father ID���������Ϣ");
		SpuTypeDao ad = new SpuTypeDaoImpl();
		int i=126;
		List<SpuType> addr = ad.findByFatherID(i);
		for(int j = 0; j < addr.size(); j++) {
			SpuType a = addr.get(j);
			System.out.println(a.getSpu_type_id()+" "+a.getSpu_type_name()+" "+a.getSpu_type_father_id());
		}
		System.out.println("����Father IDΪ"+i+" ��������Ϣ�ɹ�!");
	}
	
	@Test
	public void testFindAll() {
		System.out.println("�г�������Ϣ");
		SpuTypeDao cp = new SpuTypeDaoImpl();
		List<SpuType> coupon = cp.findAll();
		for(int i = 0; i < coupon.size(); i++) {
			SpuType a = coupon.get(i);
			System.out.println(a.getSpu_type_id()+" "+a.getSpu_type_name()+" "+a.getSpu_type_father_id());
		}
		System.out.println("�г�������Ϣ�ɹ�!");
	}

	@Test
	public void testSave() {
		System.out.println("������Ϣ");
		SpuTypeDao dao = new SpuTypeDaoImpl();
		int i=13;
		int j=19;
		SpuTypeDao br = new SpuTypeDaoImpl();
		SpuType a1 = dao.findByID(i);
		SpuType a2 = dao.findByID(i);
		if(a1!=null||a2!=null) {
			System.out.println("�Ѿ����ڸ�ID!");
		}
		else {
			SpuType x = new SpuType();
			x.setSpu_type_id(i);
			x.setSpu_type_name("name");
			x.setSpu_type_father_id(19);
			dao.save(x);
			x.setSpu_type_id(i);
			x.setSpu_type_name("name");
			x.setSpu_type_father_id(19);
			dao.save(x);
			//��֤�Ƿ�������Ϣ�ɹ�
			SpuType a = dao.findByID(i);
			SpuType b = dao.findByID(j);
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
		SpuTypeDao dao = new SpuTypeDaoImpl();
		SpuType coupon=dao.findByID(i);
		//�жϸ�ID�Ƿ����
		if(coupon==null) {
			System.out.println("Find Error!");
		}
		else {
			coupon.setSpu_type_name("change");;
			dao.update(coupon);
			//��֤�Ƿ������Ϣ�ɹ�
			SpuType a = dao.findByID(i);
			if(!a.getSpu_type_name().equals("change")) {
				System.out.println("Update Error!");
			}
			System.out.println("���³ɹ�!");
		}
	}

	@Test
	public void testUpdate() {
		System.out.println("ɾ��һ��ָ��ID��Ϣ");
		int i=19;
		SpuTypeDao dao = new SpuTypeDaoImpl();
		SpuType coupon=dao.findByID(i);
		if(coupon!=null) {
			try {
				dao.delete(coupon);
			}catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		//��֤�Ƿ�ɾ���ɹ�
		SpuType a = dao.findByID(i);
		if(a!=null) {
			System.out.println("Delete Error!");
		}
		else {
			System.out.println("ɾ���ɹ�!");
		}
	}
	}
