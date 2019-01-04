package db.test;

import java.util.List;

import org.junit.Before;
import org.junit.Test;


import db.dao.ReturnDao;
import db.dao.ReturnDaoImpl;
import db.entity.Return;

public class ReturnDaoImplTest {


	@Before
	public void setUp() throws Exception {
	}


	@Test
	public void testFindByID() {
		System.out.println("ͨ���˻�ID���һ����Ϣ");
		ReturnDao dao = new ReturnDaoImpl();
		int i=1;
		Return a = dao.findByID(i);
		//�����Ƿ��ҵ����˻�ID
		if(a == null) {
			System.out.println("û���˻�IDΪ "+i+" �Ĺ����Ϣ");
		}
		else {
			System.out.println("�����˻�IDΪ"+i+" ��һ����Ϣ�ɹ�!");}
	}

	@Test
	public void testFindAll() {
		System.out.println("�г������˻���Ϣ");
		ReturnDao dao = new ReturnDaoImpl();
		List<Return> ad = dao.findAll();
		for(int i = 0; i < ad.size(); i++) {
			Return a = ad.get(i);
			System.out.println(a.getReturn_id()+" "+a.getOrder_order_id()+" "+a.getReturn_amount()+" "+
							   a.getReturn_apply_time()+" "+a.getReturn_delivery_no()+" "+a.getReturn_end_time()+" "+
							   a.getReturn_no()+" "+a.getReturn_note()+" "+a.getReturn_reason()+" "+a.getReturn_start_time()+" "+
							   a.getReturn_status()+" "+a.getUser_user_id());
		}
		System.out.println("�г������˻���Ϣ�ɹ�!");
	}

	@Test
	public void testFindByUserID() {
		System.out.println("ͨ�������û�ID��������˻���Ϣ");
		ReturnDao dao = new ReturnDaoImpl();
		int i=1;
		List<Return> ad = dao.findByUserID(i);
		for(int j = 0; j < ad.size(); j++) {
			Return a = ad.get(j);
			System.out.println(a.getReturn_id()+" "+a.getOrder_order_id()+" "+a.getReturn_amount()+" "+
					   a.getReturn_apply_time()+" "+a.getReturn_delivery_no()+" "+a.getReturn_end_time()+" "+
					   a.getReturn_no()+" "+a.getReturn_note()+" "+a.getReturn_reason()+" "+a.getReturn_start_time()+" "+
					   a.getReturn_status()+" "+a.getUser_user_id());
		}
		System.out.println("�����û�IDΪ"+i+" �������˻���Ϣ�ɹ�!");
	}

	@Test
	public void testFindByOrderID() {
		System.out.println("ͨ�����Ҷ���ID��������˻���Ϣ");
		ReturnDao dao = new ReturnDaoImpl();
		int i=0;
		List<Return> ad = dao.findByOrderID(i);
		for(int j = 0; j < ad.size(); j++) {
			Return a = ad.get(j);
			System.out.println(a.getReturn_id()+" "+a.getOrder_order_id()+" "+a.getReturn_amount()+" "+
					   a.getReturn_apply_time()+" "+a.getReturn_delivery_no()+" "+a.getReturn_end_time()+" "+
					   a.getReturn_no()+" "+a.getReturn_note()+" "+a.getReturn_reason()+" "+a.getReturn_start_time()+" "+
					   a.getReturn_status()+" "+a.getUser_user_id());
		}
		System.out.println("���Ҷ���IDΪ"+i+" �������˻���Ϣ�ɹ�!");
	}
	

	@Test
	public void testSave() {
		System.out.println("�����˻���Ϣ");
		int i=18;
		int j=19;
		ReturnDao dao = new ReturnDaoImpl();
		Return a1=dao.findByID(i);
		Return a2=dao.findByID(j);
		if(a1!=null||a2!=null) {
			System.out.println("�Ѿ����ڸ��˻�ID!");
		}
		else {
			Return ad = new Return();
			ad.setReturn_id(i);
			ad.setOrder_order_id(1);
			ad.setReturn_amount(1);
			ad.setReturn_apply_time("2008-08-08 00:00:00");
			ad.setReturn_delivery_no("123");
			ad.setReturn_no(123);
			ad.setReturn_end_time("2008-08-08 00:00:00");
			ad.setReturn_note("abc");
			ad.setReturn_start_time("2008-08-08 00:00:00");
			ad.setReturn_status(1);
			ad.setUser_user_id(1);
			dao.save(ad);
			ad.setReturn_id(j);
			ad.setOrder_order_id(1);
			ad.setReturn_amount(1);
			ad.setReturn_apply_time("2008-08-08 00:00:00");
			ad.setReturn_delivery_no("123");
			ad.setReturn_no(123);
			ad.setReturn_end_time("2008-08-08 00:00:00");
			ad.setReturn_note("abc");
			ad.setReturn_start_time("2008-08-08 00:00:00");
			ad.setReturn_status(1);
			ad.setUser_user_id(1);
			dao.save(ad);
			//��֤�Ƿ������˻���Ϣ�ɹ�
			Return a = dao.findByID(i);
			Return b = dao.findByID(j);
			if(a==null||b==null) {
				System.out.println("Save Error!");
			}
			else {
				System.out.println("�����˻�IDΪ "+i+" �� "+j+" ���˻���Ϣ�ɹ�!");
			}
		}
	}

	@Test
	public void testDelete() {
		System.out.println("ɾ��һ��ָ���˻�ID��Ϣ");
		int i=19;
		ReturnDao dao = new ReturnDaoImpl();
		Return ad= dao.findByID(i);
		if(ad!=null) {
			try {
				dao.delete(ad);
			}catch (Exception e) {
				//System.err.println("Delete Error!");
				System.out.println(e.getMessage());
			}
		}
		//��֤�Ƿ�ɾ���˻���Ϣ�ɹ�
		Return a = dao.findByID(i);
		if(a!=null) {
			System.out.println("Delete Error!");
		}
		else {
			System.out.println("ɾ���˻�IDΪ "+i+" ���˻���Ϣ�ɹ�!");
		}
	}

	@Test
	public void testUpdate() {
		System.out.println("����һ����Ϣĳ��Ԫ��");
		int i=18;
		ReturnDao dao = new ReturnDaoImpl();
		Return ad=dao.findByID(i);
		//�жϸ��˻�ID�Ƿ����
		if(ad==null) {
			System.out.println("Find Error!");
		}
		else {
			ad.setReturn_note("change");
			dao.update(ad);
			//��֤�Ƿ�����˻���Ϣ�ɹ�
			Return a = dao.findByID(i);
			if(!a.getReturn_note().equals("change")) {
				System.out.println("Update Error!");
			}
			System.out.println("�����˻�IDΪ"+i+" ���˻���Ϣ�ɹ�!");
		}
	}

}
