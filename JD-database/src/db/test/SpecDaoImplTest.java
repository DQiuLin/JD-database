package db.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import db.dao.SpecDao;
import db.dao.SpecDaoImpl;
import db.entity.Spec;


public class SpecDaoImplTest {

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
		System.out.println("ͨ��ID���һ����Ϣ");
		SpecDao dao = new SpecDaoImpl();
		int i=13;
		Spec a = dao.findByID(i);
		if(a == null) {
			System.out.println("û��IDΪ "+i+" ����Ϣ");
		}
		else {
			System.out.println("����IDΪ"+a.getSpec_id()+" ��һ����Ϣ�ɹ�!");}
	
	}
	
	@Test
	public void testFindByGroupID() {
		System.out.println("ͨ������Group ID���������Ϣ");
		SpecDao ad = new SpecDaoImpl();
		int i=126;
		List<Spec> addr = ad.findByGroupID(i);
		for(int j = 0; j < addr.size(); j++) {
			Spec a = addr.get(j);
			System.out.println(a.getSpec_id()+" "+a.getSpec_name()+" "+a.getSpec_group_spec_group_id());
		}
		System.out.println("����Group IDΪ"+i+" ��������Ϣ�ɹ�!");
	}
	
	@Test
	public void testFindAll() {
		System.out.println("�г�������Ϣ");
		SpecDao cp = new SpecDaoImpl();
		List<Spec> coupon = cp.findAll();
		for(int i = 0; i < coupon.size(); i++) {
			Spec a = coupon.get(i);
			System.out.println(a.getSpec_id()+" "+a.getSpec_name()+" "+a.getSpec_group_spec_group_id());
		}
		System.out.println("�г�������Ϣ�ɹ�!");
	}	

	@Test
	public void testSave() {
		System.out.println("������Ϣ");
		SpecDao dao = new SpecDaoImpl();
		int i=13;
		int j=19;
		SpecDao br = new SpecDaoImpl();
		Spec a1 = dao.findByID(i);
		Spec a2 = dao.findByID(i);
		if(a1!=null||a2!=null) {
			System.out.println("�Ѿ����ڸ�ID!");
		}
		else {
			Spec x = new Spec();
			x.setSpec_id(i);
			x.setSpec_name("name");
			x.setSpec_group_spec_group_id(1);
			dao.save(x);
			x.setSpec_id(j);
			x.setSpec_name("name");
			x.setSpec_group_spec_group_id(1);
			dao.save(x);
			//��֤�Ƿ�������Ϣ�ɹ�
			Spec a = dao.findByID(i);
			Spec b = dao.findByID(j);
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
		SpecDao dao = new SpecDaoImpl();
		Spec coupon=dao.findByID(i);
		//�жϸ�ID�Ƿ����
		if(coupon==null) {
			System.out.println("Find Error!");
		}
		else {
			coupon.setSpec_group_spec_group_id(2);
			dao.update(coupon);
			//��֤�Ƿ������Ϣ�ɹ�
			Spec a = dao.findByID(i);
			if(a.getSpec_group_spec_group_id()!=2) {
				System.out.println("Update Error!");
			}
			System.out.println("���³ɹ�!");
		}
	}

	@Test
	public void testUpdate() {
		System.out.println("ɾ��һ��ָ��ID��Ϣ");
		int i=19;
		SpecDao dao = new SpecDaoImpl();
		Spec coupon=dao.findByID(i);
		if(coupon!=null) {
			try {
				dao.delete(coupon);
			}catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		//��֤�Ƿ�ɾ���ɹ�
		Spec a = dao.findByID(i);
		if(a!=null) {
			System.out.println("Delete Error!");
		}
		else {
			System.out.println("ɾ���ɹ�!");
		}
	}
	}
