package db.test;



import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


import db.dao.AddrDao;
import db.dao.AddrDaoImpl;
import db.dao.ReturnAddrDao;
import db.dao.ReturnAddrDaoImpl;
import db.entity.Addr;
import db.entity.ReturnAddr;

public class ReturnAddrDaoImplTest {

	@Before
	public void setUp() throws Exception {
	}


	@Test
	public void testFindByID() {
		System.out.println("ͨ���˻���ַID���һ����Ϣ");
		ReturnAddrDao dao = new ReturnAddrDaoImpl();
		int i=1;
		ReturnAddr a = dao.findByID(i);
		//�����Ƿ��ҵ����˻���ַID
		if(a == null) {
			System.out.println("û���˻���ַIDΪ "+i+" �ĵ�ַ��Ϣ");
		}
		else {
			System.out.println("�����˻���ַIDΪ"+a.getReturn_addr_id()+" ��һ����Ϣ�ɹ�!");}
	}

	@Test
	public void testFindAll() {
		System.out.println("�г������˻���ַ��Ϣ");
		ReturnAddrDao dao = new ReturnAddrDaoImpl();
		List<ReturnAddr> re = dao.findAll();
		for(int i = 0; i < re.size(); i++) {
			ReturnAddr a = re.get(i);
			System.out.println(a.getReturn_addr_id()+" "+a.getReturn_addr_area()+" "+a.getReturn_addr_city()+" "+
							   a.getReturn_addr_country()+" "+a.getReturn_addr_detail()+" "+a.getReturn_addr_name()+" "+
							   a.getReturn_addr_tel()+" "+a.getStore_store_id()+" ");
		}
		System.out.println("�г������˻���ַ��Ϣ�ɹ�!");
	}

	@Test
	public void testFindByStoreID() {
		System.out.println("ͨ���������̵�ID��������˻���ַ��Ϣ");
		ReturnAddrDao dao = new ReturnAddrDaoImpl();
		int i=1;
		List<ReturnAddr> re = dao.findByStoreID(i);
		for(int j = 0; j < re.size(); j++) {
			ReturnAddr a = re.get(j);
			System.out.println(a.getReturn_addr_id()+" "+a.getReturn_addr_area()+" "+a.getReturn_addr_city()+" "+
					   a.getReturn_addr_country()+" "+a.getReturn_addr_detail()+" "+a.getReturn_addr_name()+" "+
					   a.getReturn_addr_tel()+" "+a.getStore_store_id()+" ");
		}
		System.out.println("�����̵�IDΪ"+i+" �������˻���ַ��Ϣ�ɹ�!");
	}

	@Test
	public void testSave() {
		System.out.println("�����˻���ַ��Ϣ");
		int i=18;
		int j=19;
		ReturnAddrDao dao = new ReturnAddrDaoImpl();
		ReturnAddr a1=dao.findByID(i);
		ReturnAddr a2=dao.findByID(j);
		if(a1!=null||a2!=null) {
			System.out.println("�Ѿ����ڸ��˻���ַID!");
		}
		else {
			ReturnAddr re = new ReturnAddr();
			re.setReturn_addr_id(i);
			re.setReturn_addr_area("abc");
			re.setReturn_addr_city("abc");
			re.setReturn_addr_country("abc");
			re.setReturn_addr_province("abc");
			re.setReturn_addr_detail("abc");
			re.setReturn_addr_is_default(true);
			re.setReturn_addr_name("abc");
			re.setReturn_addr_tel("123");
			re.setStore_store_id(1);
			dao.save(re);
			re.setReturn_addr_id(j);
			re.setReturn_addr_area("abc");
			re.setReturn_addr_city("abc");
			re.setReturn_addr_country("abc");
			re.setReturn_addr_detail("abc");
			re.setReturn_addr_is_default(true);
			re.setReturn_addr_name("abc");
			re.setReturn_addr_tel("123");
			re.setReturn_addr_province("abc");
			re.setStore_store_id(1);
			dao.save(re);
			//��֤�Ƿ������˻���ַ��Ϣ�ɹ�
			ReturnAddr a = dao.findByID(i);
			ReturnAddr b = dao.findByID(j);
			if(a==null||b==null) {
				System.out.println("Save Error!");
			}
			else {
				System.out.println("�����˻���ַIDΪ "+i+" �� "+j+" ���˻���ַ��Ϣ�ɹ�!");
			}
		}
	}

	@Test
	public void testUpdate() {
		System.out.println("����һ����Ϣĳ��Ԫ��");
		int i=18;
		ReturnAddrDao dao = new ReturnAddrDaoImpl();
		ReturnAddr re=dao.findByID(i);
		//�жϸ��˻���ַID�Ƿ����
		if(re==null) {
			System.out.println("Find Error!");
		}
		else {
			re.setReturn_addr_area("change");
			dao.update(re);
			//��֤�Ƿ�����˻���ַ��Ϣ�ɹ�
			ReturnAddr a = dao.findByID(i);
			if(!a.getReturn_addr_area().equals("change")) {
				System.out.println("Update Error!");
			}
			System.out.println("�����˻���ַIDΪ"+i+" ���˻���ַ��Ϣ�ɹ�!");
		}
	}
	
	@Test
	public void testDelete() {
		System.out.println("ɾ��һ��ָ���˻���ַID��Ϣ");
		int i=19;
		ReturnAddrDao dao = new ReturnAddrDaoImpl();
		ReturnAddr re= dao.findByID(i);
		if(re!=null) {
			try {
				dao.delete(re);
			}catch (Exception e) {
				//System.err.println("Delete Error!");
				System.out.println(e.getMessage());
			}
		}
		//��֤�Ƿ�ɾ���˻���ַ��Ϣ�ɹ�
		ReturnAddr a = dao.findByID(i);
		if(a!=null) {
			System.out.println("Delete Error!");
		}
		else {
			System.out.println("ɾ���˻���ַIDΪ "+i+" ���˻���ַ��Ϣ�ɹ�!");
		}
	}
}
