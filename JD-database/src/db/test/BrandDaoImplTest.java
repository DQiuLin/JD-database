package db.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import db.dao.BrandDao;
import db.dao.BrandDaoImpl;
import db.entity.Brand;



public class BrandDaoImplTest {

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
	public void testFindByID() {
		System.out.println("ͨ��Ʒ��ID���һ����Ϣ");
		BrandDao dao = new BrandDaoImpl();
		int i=13;
		Brand a = dao.findByID(i);
		if(a == null) {
			System.out.println("û��Ʒ��IDΪ "+i+" ����Ϣ");
		}
		else {
			System.out.println("����Ʒ��IDΪ"+a.getBrand_id()+" ��һ����Ϣ�ɹ�!");}
	}

	@Test
	public void testSave() {
		System.out.println("����Ʒ����Ϣ");
		BrandDao dao = new BrandDaoImpl();
		int i=13;
		int j=19;
		BrandDao br = new BrandDaoImpl();
		Brand a1 = dao.findByID(i);
		Brand a2 = dao.findByID(j);
		if(a1!=null||a2!=null) {
			System.out.println("�Ѿ����ڸ�Ʒ��ID!");
		}
		else {
			Brand brand = new Brand();
			brand.setBrand_id(i);
			brand.setBrand_name("brand1");
			dao.save(brand);
			brand.setBrand_id(j);
			brand.setBrand_name("brand2");
			dao.save(brand);
			//��֤�Ƿ�������Ϣ�ɹ�
			Brand a = dao.findByID(i);
			Brand b = dao.findByID(j);
			if(a==null||b==null) {
				System.out.println("Save Error!");
			}
			else {
				System.out.println("����Ʒ��IDΪ "+i+" �� "+j+" ����Ϣ�ɹ�!");
			}
		}
	}
	
	@Test
	public void testFindAll() {
		System.out.println("�г�����Ʒ����Ϣ");
		BrandDao br = new BrandDaoImpl();
		List<Brand> brand = br.findAll();
		for(int i = 0; i < brand.size(); i++) {
			Brand a = brand.get(i);
			System.out.println(a.getBrand_id()+" "+a.getBrand_name()+" ");
		}
		System.out.println("�г�����Ʒ����Ϣ�ɹ�!");
	}
	
	@Test
	public void testUpdate() {
		System.out.println("����һ����Ϣĳ��Ԫ��");
		int i=13;
		BrandDao dao=new BrandDaoImpl();
		Brand brand=dao.findByID(i);
		//�жϸ�ID�Ƿ����
		if(brand==null) {
			System.out.println("Find Error!");
		}
		else {
			brand.setBrand_name("change");
			dao.update(brand);
			//��֤�Ƿ������Ϣ�ɹ�
			Brand a = dao.findByID(i);
			if(!a.getBrand_name().equals("change")) {
				System.out.println("Update Error!");
			}
			System.out.println("����Ʒ��IDΪ"+i+" ����Ϣ�ɹ�!");
		}
		
	}
	
	@Test
	public void testDelete() {
		System.out.println("ɾ��һ��ָ��Ʒ��ID��Ϣ");
		int i=19;
		BrandDao dao=new BrandDaoImpl();
		Brand brand= dao.findByID(i);
		if(brand!=null) {
			try {
				dao.delete(brand);
			}catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		//��֤�Ƿ�ɾ���ɹ�
		Brand a = dao.findByID(i);
		if(a!=null) {
			System.out.println("Delete Error!");
		}
		else {
			System.out.println("ɾ��Ʒ��IDΪ "+i+" ����Ϣ�ɹ�!");
		}
	}
}
