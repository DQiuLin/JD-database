package db.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import db.dao.StoreDao;
import db.dao.StoreDaoImpl;
import db.entity.Store;

public class StoreDaoImplTest {

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
		System.out.println("�г����е�����Ϣ");
		StoreDao dao = new StoreDaoImpl();
		List<Store> st = dao.findAll();
		for(int i = 0; i < st.size(); i++) {
			Store a = st.get(i);
			System.out.println(a.getStore_id()+" "+a.getStore_create_time()+" "+a.getStore_end_time()+" "+
							   a.getStore_introduction()+" "+a.getStore_keyword()+" "+a.getStore_license_url()+" "+
							   a.getStore_logo_url()+" "+a.getStore_name()+" "+a.getStore_pass_time()+" "+
							   a.getStore_status()+" "+a.getStore_tel()+" "+a.getStore_url()+" "+a.getStore_verifier()+" "+
							   a.getUser_user_id());
		}
		System.out.println("�г����е�����Ϣ�ɹ�!");
	}

	@Test
	public void testFindByUserID() {
		System.out.println("ͨ�������û�ID�������е�����Ϣ");
		StoreDao dao = new StoreDaoImpl();
		int i=18;
		List<Store> st = dao.findByUserID(i);
		for(int j = 0; j < st.size(); j++) {
			Store a = st.get(j);
			System.out.println(a.getStore_id()+" "+a.getStore_create_time()+" "+a.getStore_end_time()+" "+
					   a.getStore_introduction()+" "+a.getStore_keyword()+" "+a.getStore_license_url()+" "+
					   a.getStore_logo_url()+" "+a.getStore_name()+" "+a.getStore_pass_time()+" "+
					   a.getStore_status()+" "+a.getStore_tel()+" "+a.getStore_url()+" "+a.getStore_verifier()+" "+
					   a.getUser_user_id());
		}
		System.out.println("�����û�IDΪ"+i+" �����е�����Ϣ�ɹ�!");
	}

	@Test
	public void testFindByID() {
		System.out.println("ͨ������ID���һ����Ϣ");
		StoreDao dao = new StoreDaoImpl();
		int i=13;
		Store a = dao.findByID(i);
		//�����Ƿ��ҵ��õ���ID
		if(a == null) {
			System.out.println("û���û�IDΪ "+i+" �ĵ�����Ϣ");
		}
		else {
			System.out.println("�����û�IDΪ"+i+" ��һ�е�����Ϣ�ɹ�!");}
	}

	@Test
	public void testSave() {
		System.out.println("���ӵ�����Ϣ");
		int i=18;
		int j=19;
		StoreDao dao = new StoreDaoImpl();
		Store a1=dao.findByID(i);
		Store a2=dao.findByID(j);
		if(a1!=null||a2!=null) {
			System.out.println("�Ѿ����ڸõ���ID!");
		}
		else {
			Store st = new Store();
			st.setStore_id(i);
			st.setStore_end_time("2008-08-08 00:00:00");
			st.setStore_introduction("abc");
			st.setStore_is_direct_sale(true);
			st.setStore_keyword("abc");
			st.setStore_license_url("abc");
			st.setStore_logo_url("abc");
			st.setStore_name("name");
			st.setStore_pass_time("2008-08-08 00:00:00");
			st.setStore_create_time("2008-08-08 00:00:00");
			st.setStore_status(1);
			st.setStore_tel("123");
			st.setStore_url("abc");
			st.setStore_verifier("abc");
			st.setUser_user_id(1);
			dao.save(st);
			st.setStore_id(j);
			st.setStore_end_time("2008-08-08 00:00:00");
			st.setStore_introduction("abc");
			st.setStore_is_direct_sale(true);
			st.setStore_keyword("abc");
			st.setStore_license_url("abc");
			st.setStore_logo_url("abc");
			st.setStore_name("name");
			st.setStore_pass_time("2008-08-08 00:00:00");
			st.setStore_create_time("2008-08-08 00:00:00");
			st.setStore_status(1);
			st.setStore_tel("123");
			st.setStore_url("abc");
			st.setStore_verifier("abc");
			st.setUser_user_id(1);
			dao.save(st);
			//��֤�Ƿ����ӵ�����Ϣ�ɹ�
			Store a = dao.findByID(i);
			Store b = dao.findByID(j);
			if(a==null||b==null) {
				System.out.println("Save Error!");
			}
			else {
				System.out.println("���ӵ���IDΪ "+i+" �� "+j+" �ĵ�����Ϣ�ɹ�!");
			}
		}
	}

	@Test
	public void testDelete() {
		System.out.println("ɾ��һ��ָ������ID��Ϣ");
		int i=19;
		StoreDao dao = new StoreDaoImpl();
		Store st= dao.findByID(i);
		if(st!=null) {
			try {
				dao.delete(st);
			}catch (Exception e) {
				//System.err.println("Delete Error!");
				System.out.println(e.getMessage());
			}
		}
		//��֤�Ƿ�ɾ��������Ϣ�ɹ�
		Store a = dao.findByID(i);
		if(a!=null) {
			System.out.println("Delete Error!");
		}
		else {
			System.out.println("ɾ������IDΪ "+i+" �ĵ�����Ϣ�ɹ�!");
		}
	}


	@Test
	public void testUpdate() {
		System.out.println("����һ����Ϣĳ��Ԫ��");
		int i=18;
		StoreDao dao = new StoreDaoImpl();
		Store ad=dao.findByID(i);
		//�жϸõ���ID�Ƿ����
		if(ad==null) {
			System.out.println("Find Error!");
		}
		else {
			ad.setStore_keyword("change");
			dao.update(ad);
			//��֤�Ƿ���µ�����Ϣ�ɹ�
			Store a = dao.findByID(i);
			if(!a.getStore_keyword().equals("change")) {
				System.out.println("Update Error!");
			}
			System.out.println("���µ���IDΪ"+i+" �ĵ�����Ϣ�ɹ�!");
		}
	}

}
