package db.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;




import db.dao.UserInfoDao;
import db.dao.UserInfoDaoImpl;
import db.entity.UserInfo;


public class UserInfoDaoImplTest {

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
		System.out.println("�г������û���ϸ��Ϣ��Ϣ");
		UserInfoDao dao = new UserInfoDaoImpl();
		List<UserInfo> userinfo = dao.findAll();
		for(int i = 0; i < userinfo.size(); i++) {
			UserInfo a = userinfo.get(i);
			System.out.println(a.getUser_info_id()+" "+a.getUser_info_birth()+" "+a.getUser_info_cost()+" "+
							   a.getUser_info_face_url()+" "+a.getUser_info_level()+" "+a.getUser_info_login_count()+" "+
							   a.getUser_info_login_time()+" "+a.getUser_info_pid()+" "+a.getUser_info_realname()+" "+
							   a.getUser_info_regist_time()+" "+a.getUser_info_return_credit()+" "+a.getUser_info_sex()+" "+
							   a.getUser_user_id());
		}
		System.out.println("�г������û���ϸ��Ϣ�ɹ�!");
	}

	@Test
	public void testFindByUserID() {
		System.out.println("ͨ���û���ϸ��ϢID���һ����Ϣ");
		UserInfoDao dao = new UserInfoDaoImpl();
		int i=13;
		UserInfo a = dao.findByID(i);
		//�����Ƿ��ҵ����û���ϸ��ϢID
		if(a == null) {
			System.out.println("û���û���ϸ��ϢIDΪ "+i+" ����ϸ��Ϣ");
		}
		else {
			System.out.println("�����û���ϸ��ϢIDΪ"+a.getUser_info_id()+" ��һ����ϸ��Ϣ�ɹ�!");}
	}

	@Test
	public void testFindByID() {
		System.out.println("ͨ���û���ϸ��ϢID���һ����Ϣ");
		UserInfoDao dao = new UserInfoDaoImpl();
		int i=13;
		UserInfo a = dao.findByID(i);
		//�����Ƿ��ҵ����û���ϸ��ϢID
		if(a == null) {
			System.out.println("û���û���ϸ��ϢIDΪ "+i+" ����ϸ��Ϣ");
		}
		else {
			System.out.println("�����û���ϸ��ϢIDΪ"+i+" ��һ����ϸ��Ϣ�ɹ�!");}
	}

	@Test
	public void testSave() {
		System.out.println("�����û���ϸ��Ϣ");
		int i=13;
		int j=19;
		UserInfoDao dao = new UserInfoDaoImpl();
		UserInfo a1=dao.findByID(i);
		UserInfo a2=dao.findByID(j);
		if(a1!=null||a2!=null) {
			System.out.println("�Ѿ����ڸ��û���ϸ��ϢID!");
		}
		else {
			UserInfo userinfo = new UserInfo();
			userinfo.setUser_info_id(i);
			userinfo.setUser_info_birth("2008-08-08 00:00:00");
			userinfo.setUser_info_cost(1);
			userinfo.setUser_info_face_url("abc");
			userinfo.setUser_info_level("abc");
			userinfo.setUser_info_login_count(1);
			userinfo.setUser_info_login_time("2008-08-08 00:00:00");
			userinfo.setUser_info_pid("abc");
			userinfo.setUser_info_realname("abc");
			userinfo.setUser_info_regist_time("2008-08-08 00:00:00");
			userinfo.setUser_info_return_credit(1);
			userinfo.setUser_info_sex("a");
			userinfo.setUser_user_id(1);
			dao.save(userinfo);
			userinfo.setUser_info_id(j);
			userinfo.setUser_info_birth("2008-08-08 00:00:00");
			userinfo.setUser_info_cost(1);
			userinfo.setUser_info_face_url("abc");
			userinfo.setUser_info_level("abc");
			userinfo.setUser_info_login_count(1);
			userinfo.setUser_info_login_time("2008-08-08 00:00:00");
			userinfo.setUser_info_pid("abc");
			userinfo.setUser_info_realname("abc");
			userinfo.setUser_info_regist_time("2008-08-08 00:00:00");
			userinfo.setUser_info_return_credit(1);
			userinfo.setUser_info_sex("a");
			userinfo.setUser_user_id(1);
			dao.save(userinfo);
			//��֤�Ƿ������û���ϸ��Ϣ�ɹ�
			UserInfo a = dao.findByID(i);
			UserInfo b = dao.findByID(j);
			if(a==null||b==null) {
				System.out.println("Save Error!");
			}
			else {
				System.out.println("�����û���ϸ��ϢIDΪ "+i+" �� "+j+" ����ϸ��Ϣ�ɹ�!");
			}
		}
	}

	@Test
	public void testDelete() {
		System.out.println("ɾ��һ��ָ���û���ϸID��Ϣ");
		int i=19;
		UserInfoDao dao = new UserInfoDaoImpl();
		UserInfo userinfo= dao.findByID(i);
		if(userinfo!=null) {
			try {
				dao.delete(userinfo);
			}catch (Exception e) {
				//System.err.println("Delete Error!");
				System.out.println(e.getMessage());
			}
		}
		//��֤�Ƿ�ɾ���û���ϸ��Ϣ��Ϣ�ɹ�
		UserInfo a = dao.findByID(i);
		if(a!=null) {
			System.out.println("Delete Error!");
		}
		else {
			System.out.println("ɾ���û���ϸ��ϢIDΪ "+i+" ����ϸ��Ϣ�ɹ�!");
		}
	}

	@Test
	public void testUpdate() {
		System.out.println("����һ����Ϣĳ��Ԫ��");
		int i=13;
		UserInfoDao dao = new UserInfoDaoImpl();
		UserInfo adinfo=dao.findByID(i);
		//�жϸ��û���ϸ��ϢID�Ƿ����
		if(adinfo==null) {
			System.out.println("Find Error!");
		}
		else {
			adinfo.setUser_info_level("change");
			dao.update(adinfo);
			//��֤�Ƿ�����û���ϸ��Ϣ��Ϣ�ɹ�
			UserInfo a = dao.findByID(i);
			if(!a.getUser_info_level().equals("change")) {
				System.out.println("Update Error!");
			}
			System.out.println("�����û���ϸ��ϢIDΪ"+i+" ����ϸ��Ϣ�ɹ�!");
		}
	}


}
