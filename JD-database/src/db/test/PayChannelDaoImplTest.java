package db.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import db.dao.PayChannelDao;
import db.dao.PayChannelDaoImpl;
import db.entity.PayChannel;


public class PayChannelDaoImplTest {

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
		System.out.println("ͨ��ID���һ����Ϣ");
		PayChannelDao dao = new PayChannelDaoImpl();
		int i=13;
		PayChannel a = dao.findByID(i);
		if(a == null) {
			System.out.println("û��IDΪ "+i+" ����Ϣ");
		}
		else {
			System.out.println("����IDΪ"+a.getPay_cahnnel_id()+" ��һ����Ϣ�ɹ�!");}
	}

	@Test
	public void testFindAll() {
		System.out.println("�г�������Ϣ");
		PayChannelDao cp = new PayChannelDaoImpl();
		List<PayChannel> coupon = cp.findAll();
		for(int i = 0; i < coupon.size(); i++) {
			PayChannel a = coupon.get(i);
			System.out.println(a.getPay_cahnnel_id()+" "+a.getPay_cahnnel_type()+" "+a.getPay_cahnnel_type_no()+" "+a.getUser_user_id()+" ");
		}
		System.out.println("�г�������Ϣ�ɹ�!");
	}

	@Test
	public void testSave() {
		System.out.println("������Ϣ");
		PayChannelDao dao = new PayChannelDaoImpl();
		int i=13;
		int j=19;
		PayChannelDao br = new PayChannelDaoImpl();
		PayChannel a1 = dao.findByID(i);
		PayChannel a2 = dao.findByID(j);
		if(a1!=null||a2!=null) {
			System.out.println("�Ѿ����ڸ�ID!");
		}
		else {
			PayChannel coupon = new PayChannel();
			coupon.setPay_cahnnel_id(i);
			coupon.setPay_cahnnel_type(1);
			coupon.setPay_cahnnel_type_no("2");
			coupon.setUser_user_id(1);
			dao.save(coupon);
			coupon.setPay_cahnnel_id(j);
			coupon.setPay_cahnnel_type(1);
			coupon.setPay_cahnnel_type_no("2");
			coupon.setUser_user_id(1);
			dao.save(coupon);
			//��֤�Ƿ�������Ϣ�ɹ�
			PayChannel a = dao.findByID(i);
			PayChannel b = dao.findByID(j);
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
		System.out.println("ɾ��һ��ָ��ID��Ϣ");
		int i=19;
		PayChannelDao dao=new PayChannelDaoImpl();
		PayChannel coupon=dao.findByID(i);
		if(coupon!=null) {
			try {
				dao.delete(coupon);
			}catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		//��֤�Ƿ�ɾ���ɹ�
		PayChannel a = dao.findByID(i);
		if(a!=null) {
			System.out.println("Delete Error!");
		}
		else {
			System.out.println("ɾ���ɹ�!");
		}
	}
	
	@Test
	public void testUpdate() {
		System.out.println("����һ����Ϣĳ��Ԫ��");
		int i=13;
		PayChannelDao dao=new PayChannelDaoImpl();
		PayChannel coupon=dao.findByID(i);
		//�жϸ�ID�Ƿ����
		if(coupon==null) {
			System.out.println("Find Error!");
		}
		else {
			coupon.setPay_cahnnel_type(3);
			dao.update(coupon);
			//��֤�Ƿ������Ϣ�ɹ�
			PayChannel a = dao.findByID(i);
			if(a.getPay_cahnnel_type()!=3) {
				System.out.println("Update Error!");
			}
			System.out.println("���³ɹ�!");
		}
	}
}
