package db.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import db.dao.AddrDao;
import db.dao.AddrDaoImpl;
import db.entity.Addr;
import db.entity.Advertise;

public class AddrDaoImplTest {

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
		System.out.println("ͨ����ַID���һ����Ϣ");
		AddrDao dao = new AddrDaoImpl();
		int i=13;
		Addr a = dao.findByID(i);
		//�����Ƿ��ҵ��õ�ַID
		if(a == null) {
			System.out.println("û�е�ַIDΪ "+i+" �ĵ�ַ��Ϣ");
		}
		else {
			System.out.println("���ҵ�ַIDΪ"+a.getAddr_id()+" ��һ�е�ַ��Ϣ�ɹ�!");}
	}

	@Test
	public void testFindAll() {
		System.out.println("�г����е�ַ��Ϣ");
		AddrDao ad = new AddrDaoImpl();
		List<Addr> addr = ad.findAll();
		for(int i = 0; i < addr.size(); i++) {
			Addr a = addr.get(i);
			System.out.println(a.getAddr_id()+" "+a.getUser_user_id()+" "+a.getAddr_name()+" "+
							   a.getAddr_area()+" "+a.getAddr_city()+" "+a.getAddr_country()+" "+
							   a.getAddr_detail()+" "+a.getAddr_province()+" "+a.getAddr_tel()+" ");
		}
		System.out.println("�г����е�ַ��Ϣ�ɹ�!");
	}

	@Test
	public void testFindByUserID() {
		/*System.out.println("ͨ�������û�ID������е�ַ��Ϣ");
		AddrDao ad = new AddrDaoImpl();
		int i=126;
		List<Addr> addr = ad.findByUserID(i);
		for(int j = 0; j < addr.size(); j++) {
			Addr a = addr.get(j);
			System.out.println(a.getAddr_id()+" "+a.getUser_user_id()+" "+a.getAddr_name()+" "+
							   a.getAddr_area()+" "+a.getAddr_city()+" "+a.getAddr_country()+" "+
							   a.getAddr_detail()+" "+a.getAddr_province()+" "+a.getAddr_tel()+" ");
		}
		System.out.println("�����û�IDΪ"+i+" �����е�ַ��Ϣ�ɹ�!");*/
	}

	@Test
	public void testSave() {
		/*System.out.println("���ӵ�ַ��Ϣ");
		int i=13;
		int j=19;
		AddrDao dao = new AddrDaoImpl();
		Addr a1=dao.findByID(i);
		Addr a2=dao.findByID(j);
		if(a1!=null||a2!=null) {
			System.out.println("�Ѿ����ڸõ�ַID!");
		}
		else {
			Addr addr = new Addr();
			addr.setAddr_id(i);
			addr.setAddr_area("abc");
			addr.setAddr_city("abc");
			addr.setAddr_country("abc");
			addr.setAddr_detail("abc");
			addr.setAddr_is_default(true);
			addr.setAddr_name("abc");
			addr.setAddr_province("abc");
			addr.setAddr_tel("123");
			addr.setUser_user_id(126);
			dao.save(addr);
			addr.setAddr_id(j);
			addr.setAddr_area("abc");
			addr.setAddr_city("abc");
			addr.setAddr_country("abc");
			addr.setAddr_detail("abc");
			addr.setAddr_is_default(true);
			addr.setAddr_name("abc");
			addr.setAddr_province("abc");
			addr.setAddr_tel("123");
			addr.setUser_user_id(126);
			dao.save(addr);
			//��֤�Ƿ����ӵ�ַ��Ϣ�ɹ�
			Addr a = dao.findByID(i);
			Addr b = dao.findByID(j);
			if(a==null||b==null) {
				System.out.println("Save Error!");
			}
			else {
				System.out.println("���ӵ�ַIDΪ "+i+" �� "+j+" �ĵ�ַ��Ϣ�ɹ�!");
			}
		}*/
	}
	
	@Test
	public void testUpdate() {
		System.out.println("����һ����Ϣĳ��Ԫ��");
		int i=13;
		AddrDao dao=new AddrDaoImpl();
		Addr addr=dao.findByID(i);
		//�жϸõ�ַID�Ƿ����
		if(addr==null) {
			System.out.println("Find Error!");
		}
		else {
			addr.setAddr_city("change");
			dao.update(addr);
			//��֤�Ƿ���µ�ַ��Ϣ�ɹ�
			Addr a = dao.findByID(i);
			if(!a.getAddr_city().equals("change")) {
				System.out.println("Update Error!");
			}
			System.out.println("���µ�ַIDΪ"+i+" �ĵ�ַ��Ϣ�ɹ�!");
		}
		
	}
	
	@Test
	public void testDelete() {
		System.out.println("ɾ��һ��ָ����ַID��Ϣ");
		int i=19;
		AddrDao dao=new AddrDaoImpl();
		Addr addr= dao.findByID(i);
		if(addr!=null) {
			try {
				dao.delete(addr);
			}catch (Exception e) {
				//System.err.println("Delete Error!");
				System.out.println(e.getMessage());
			}
		}
		//��֤�Ƿ�ɾ����ַ��Ϣ�ɹ�
		Addr a = dao.findByID(i);
		if(a!=null) {
			System.out.println("Delete Error!");
		}
		else {
			System.out.println("ɾ����ַIDΪ "+i+" �ĵ�ַ��Ϣ�ɹ�!");
		}
	}
}
