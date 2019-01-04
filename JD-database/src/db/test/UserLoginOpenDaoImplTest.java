package db.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import db.dao.UserLoginOpenDao;
import db.dao.UserLoginOpenDaoImpl;
import db.entity.UserLoginOpen;


public class UserLoginOpenDaoImplTest {

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
		System.out.println("�г������û���¼��Ϣ");
		 UserLoginOpenDao dao = new  UserLoginOpenDaoImpl();
		List< UserLoginOpen> ad = dao.findAll();
		for(int i = 0; i < ad.size(); i++) {
			UserLoginOpen a = ad.get(i);
			System.out.println(a.getUser_login_open_id()+" "+a.getUser_login_open_qq_no()+" "+a.getUser_login_open_wechat_no()+" "+
							   a.getUser_user_id());
		}
		System.out.println("�г������û���¼��Ϣ�ɹ�!");
	}

	@Test
	public void testFindByUserID() {
		System.out.println("ͨ�������û�ID��������û���¼��Ϣ");
		UserLoginOpenDao dao = new  UserLoginOpenDaoImpl();
		int i=18;
		List< UserLoginOpen> ad = dao.findByUserID(i);
		for(int j = 0; j < ad.size(); j++) {
			UserLoginOpen a = ad.get(j);
			System.out.println(a.getUser_login_open_id()+" "+a.getUser_login_open_qq_no()+" "+a.getUser_login_open_wechat_no()+" "+
					   a.getUser_user_id());
		}
		System.out.println("�����û�IDΪ"+i+" �������û���¼��Ϣ�ɹ�!");
	}

	@Test
	public void testFindByID() {
		System.out.println("ͨ���û�ID���һ����Ϣ");
		UserLoginOpenDao dao = new UserLoginOpenDaoImpl();
		int i=13;
		UserLoginOpen a = dao.findByID(i);
		//�����Ƿ��ҵ����û�ID
		if(a == null) {
			System.out.println("û���û�IDΪ "+i+" �ĵ�¼��Ϣ");
		}
		else {
			System.out.println("�����û�IDΪ"+i+" ��һ�е�¼��Ϣ�ɹ�!");}
	}

	@Test
	public void testSave() {
		System.out.println("�����û���¼��Ϣ");
		int i=13;
		int j=19;
		UserLoginOpenDao dao = new UserLoginOpenDaoImpl();
		UserLoginOpen a1=dao.findByID(i);
		UserLoginOpen a2=dao.findByID(j);
		if(a1!=null||a2!=null) {
			System.out.println("�Ѿ����ڸ��û���¼ID!");
		}
		else {
			UserLoginOpen ad = new UserLoginOpen();
			ad.setUser_login_open_id(i);
			ad.setUser_login_open_qq_no("abc");
			ad.setUser_login_open_wechat_no("abc");
			ad.setUser_user_id(i);
			dao.save(ad);
			ad.setUser_login_open_id(j);
			ad.setUser_login_open_qq_no("abc");
			ad.setUser_login_open_wechat_no("abc");
			ad.setUser_user_id(j);
			//��֤�Ƿ������û���¼��Ϣ�ɹ�
			UserLoginOpen a = dao.findByID(i);
			UserLoginOpen b = dao.findByID(j);
			if(a==null||b==null) {
				System.out.println("Save Error!");
			}
			else {
				System.out.println("�����û���¼IDΪ "+i+" �� "+j+" �Ĺ���¼��Ϣ�ɹ�!");
			}
		}
	}

	@Test
	public void testUpdate() {
		System.out.println("����һ����Ϣĳ��Ԫ��");
		int i=13;
		UserLoginOpenDao dao = new UserLoginOpenDaoImpl();
		UserLoginOpen ad=dao.findByID(i);
		//�жϸ��û���¼ID�Ƿ����
		if(ad==null) {
			System.out.println("Find Error!");
		}
		else {
			ad.setUser_login_open_qq_no("change");
			dao.update(ad);
			//��֤�Ƿ�����û���¼��Ϣ�ɹ�
			UserLoginOpen a = dao.findByID(i);
			if(!a.getUser_login_open_qq_no().equals("change")) {
				System.out.println("Update Error!");
			}
			System.out.println("�����û���¼IDΪ"+i+" ����Ϣ�ɹ�!");
		}
	}
	
	@Test
	public void testDelete() {
		System.out.println("ɾ��һ��ָ���û���¼ID��Ϣ");
		int i=19;
		UserLoginOpenDao dao = new UserLoginOpenDaoImpl();
		UserLoginOpen ad= dao.findByID(i);
		if(ad!=null) {
			try {
				dao.delete(ad);
			}catch (Exception e) {
				//System.err.println("Delete Error!");
				System.out.println(e.getMessage());
			}
		}
		//��֤�Ƿ�ɾ���û���¼��Ϣ�ɹ�
		UserLoginOpen a = dao.findByID(i);
		if(a!=null) {
			System.out.println("Delete Error!");
		}
		else {
			System.out.println("ɾ���û���¼IDΪ "+i+" ����Ϣ�ɹ�!");
		}
	}
}
