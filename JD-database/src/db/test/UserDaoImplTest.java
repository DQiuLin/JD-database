package db.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import db.dao.AdvertiseInfoDao;
import db.dao.AdvertiseInfoDaoImpl;
import db.dao.UserDao;
import db.dao.UserDaoImpl;
import db.entity.AdvertiseInfo;
import db.entity.User;

public class UserDaoImplTest {

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
		System.out.println("�г������û�������Ϣ");
		UserDao dao = new UserDaoImpl();
		List<User> user = dao.findAll();
		for(int i = 0; i < user.size(); i++) {
			User a = user.get(i);
			System.out.println(a.getUser_id()+" "+a.getUser_email()+" "+a.getUser_password()+" "+
							   a.getUser_status()+" "+a.getUser_tel()+" "+a.getUser_username());
		}
		System.out.println("�г������û�������Ϣ�ɹ�!");
	}

	@Test
	public void testFindByID() {
		System.out.println("ͨ��UserID���һ����Ϣ");
		UserDao dao = new UserDaoImpl();
		int i=13;
		User a = dao.findByID(i);
		//�����Ƿ��ҵ����û�������ϢID
		if(a == null) {
			System.out.println("û���û�������ϢIDΪ "+i+" ����Ϣ");
		}
		else {
			System.out.println("�����û�������ϢIDΪ"+a.getUser_id()+" ��һ����Ϣ�ɹ�!");}
	}
	

	@Test
	public void testSave() {
		System.out.println("�����û�������Ϣ");
		int i=13;
		int j=19;
		UserDao dao = new UserDaoImpl();
		User a1=dao.findByID(i);
		User a2=dao.findByID(j);
		if(a1!=null||a2!=null) {
			System.out.println("�Ѿ����ڸ��û�������ϢID!");
		}
		else {
			User user = new User();
			user.setUser_id(i);
			user.setUser_email("abc");
			user.setUser_status(1);
			user.setUser_password("abc");
			user.setUser_tel("abc");
			user.setUser_username("abc");
			dao.save(user);
			user.setUser_id(j);
			user.setUser_email("abc");
			user.setUser_status(1);
			user.setUser_password("abc");
			user.setUser_tel("abc");
			user.setUser_username("abc");
			dao.save(user);
			//��֤�Ƿ������û�������Ϣ�ɹ�
			User a = dao.findByID(i);
			User b = dao.findByID(j);
			if(a==null||b==null) {
				System.out.println("Save Error!");
			}
			else {
				System.out.println("�����û�������ϢIDΪ "+i+" �� "+j+" ����Ϣ�ɹ�!");
			}
		}
	}

	@Test
	public void testDelete() {
		System.out.println("ɾ��һ��ָ�������ϸID��Ϣ");
		int i=19;
		UserDao dao = new UserDaoImpl();
		User user= dao.findByID(i);
		if(user!=null) {
			try {
				dao.delete(user);
			}catch (Exception e) {
				//System.err.println("Delete Error!");
				System.out.println(e.getMessage());
			}
		}
		//��֤�Ƿ�ɾ���û�������Ϣ��Ϣ�ɹ�
		User a = dao.findByID(i);
		if(a!=null) {
			System.out.println("Delete Error!");
		}
		else {
			System.out.println("ɾ���û�������ϢIDΪ "+i+" ����Ϣ�ɹ�!");
		}
	
	}

	@Test
	public void testUpdate() {
		System.out.println("����һ����Ϣĳ��Ԫ��");
		int i=13;
		UserDao dao = new UserDaoImpl();
		User user=dao.findByID(i);
		//�жϸù����ϸ��ϢID�Ƿ����
		if(user==null) {
			System.out.println("Find Error!");
		}
		else {
			user.setUser_username("change");
			dao.update(user);
			//��֤�Ƿ�����û�������Ϣ��Ϣ�ɹ�
			User a = dao.findByID(i);
			if(!a.getUser_username().equals("change")) {
				System.out.println("Update Error!");
			}
			System.out.println("�����û�������ϢIDΪ"+i+" ����Ϣ�ɹ�!");
		}
	}

}
