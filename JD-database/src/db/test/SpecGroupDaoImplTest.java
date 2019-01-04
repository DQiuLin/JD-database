package db.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import db.dao.SpecGroupDao;
import db.dao.SpecGroupDaoImpl;
import db.entity.SpecGroup;


public class SpecGroupDaoImplTest {

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
		SpecGroupDao dao = new SpecGroupDaoImpl();
		int i=13;
		SpecGroup a = dao.findByID(i);
		if(a == null) {
			System.out.println("û��IDΪ "+i+" ����Ϣ");
		}
		else {
			System.out.println("����IDΪ"+a.getSpec_group_id()+" ��һ����Ϣ�ɹ�!");}
	
	}
	
	@Test
	public void testFindAll() {
		System.out.println("�г�������Ϣ");
		SpecGroupDao cp = new SpecGroupDaoImpl();
		List<SpecGroup> coupon = cp.findAll();
		for(int i = 0; i < coupon.size(); i++) {
			SpecGroup a = coupon.get(i);
			System.out.println(a.getSpec_group_id()+" "+a.getSpec_group_name());
		}
		System.out.println("�г�������Ϣ�ɹ�!");
	}

	@Test
	public void testSave() {
		System.out.println("������Ϣ");
		SpecGroupDao dao = new SpecGroupDaoImpl();
		int i=13;
		int j=19;
		SpecGroupDao br = new SpecGroupDaoImpl();
		SpecGroup a1 = dao.findByID(i);
		SpecGroup a2 = dao.findByID(i);
		if(a1!=null||a2!=null) {
			System.out.println("�Ѿ����ڸ�ID!");
		}
		else {
			SpecGroup x = new SpecGroup();
			x.setSpec_group_id(i);
			x.setSpec_group_name("name");
			dao.save(x);
			x.setSpec_group_id(j);
			x.setSpec_group_name("name");
			dao.save(x);
			//��֤�Ƿ�������Ϣ�ɹ�
			SpecGroup a = dao.findByID(i);
			SpecGroup b = dao.findByID(j);
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
		SpecGroupDao dao = new SpecGroupDaoImpl();
		SpecGroup coupon=dao.findByID(i);
		//�жϸ�ID�Ƿ����
		if(coupon==null) {
			System.out.println("Find Error!");
		}
		else {
			coupon.setSpec_group_name("chenge");
			dao.update(coupon);
			//��֤�Ƿ������Ϣ�ɹ�
			SpecGroup a = dao.findByID(i);
			if(!a.getSpec_group_name().equals("change")) {
				System.out.println("Update Error!");
			}
			System.out.println("���³ɹ�!");
		}
	}

	@Test
	public void testUpdate() {
		System.out.println("ɾ��һ��ָ��ID��Ϣ");
		int i=19;
		SpecGroupDao dao = new SpecGroupDaoImpl();
		SpecGroup coupon=dao.findByID(i);
		if(coupon!=null) {
			try {
				dao.delete(coupon);
			}catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		//��֤�Ƿ�ɾ���ɹ�
		SpecGroup a = dao.findByID(i);
		if(a!=null) {
			System.out.println("Delete Error!");
		}
		else {
			System.out.println("ɾ���ɹ�!");
		}
	}
	}
