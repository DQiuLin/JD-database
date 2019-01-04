package db.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import db.dao.AdvertiseDao;
import db.dao.AdvertiseDaoImpl;

import db.entity.Advertise;

public class AdvertiseDaoImplTest {

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
		System.out.println("ͨ�����ID���һ����Ϣ");
		AdvertiseDao dao = new AdvertiseDaoImpl();
		int i=18;
		Advertise a = dao.findByID(i);
		//�����Ƿ��ҵ��ù��ID
		if(a == null) {
			System.out.println("û�й��IDΪ "+i+" �Ĺ����Ϣ");
		}
		else {
			System.out.println("���ҹ��IDΪ"+a.getAd_id()+" ��һ�й����Ϣ�ɹ�!");}
	}

	@Test
	public void testFindAll() {
		System.out.println("�г����й����Ϣ");
		AdvertiseDao dao = new AdvertiseDaoImpl();
		List<Advertise> ad = dao.findAll();
		for(int i = 0; i < ad.size(); i++) {
			Advertise a = ad.get(i);
			System.out.println(a.getAd_id()+" "+a.getAd_channel()+" "+a.getAd_create_time()+" "+
							   a.getAd_detail()+" "+a.getAd_location()+" "+a.getAd_media_height()+" "+
							   a.getAd_media_size()+" "+a.getAd_media_type()+" "+a.getAd_media_width()+" "+
							   a.getAd_name()+" "+a.getAd_type()+" "+a.getAd_update_time()+" ");
		}
		System.out.println("�г����й����Ϣ�ɹ�!");
	}

	@Test
	public void testFindByAdType() {
		System.out.println("ͨ������ad_type������е�ַ��Ϣ");
		AdvertiseDao dao = new AdvertiseDaoImpl();
		String str="abc";
		List<Advertise> ad = dao.findByAdType(str);
		for(int j = 0; j < ad.size(); j++) {
			Advertise a = ad.get(j);
			System.out.println(a.getAd_id()+" "+a.getAd_channel()+" "+a.getAd_create_time()+" "+
					   a.getAd_detail()+" "+a.getAd_location()+" "+a.getAd_media_height()+" "+
					   a.getAd_media_size()+" "+a.getAd_media_type()+" "+a.getAd_media_width()+" "+
					   a.getAd_name()+" "+a.getAd_type()+" "+a.getAd_update_time());
		}
		System.out.println("����ad_typeΪ"+str+" �����й����Ϣ�ɹ�!");
	}

	@Test
	public void testSave() {
		System.out.println("���ӹ����Ϣ");
		int i=18;
		int j=19;
		AdvertiseDao dao = new AdvertiseDaoImpl();
		Advertise a1=dao.findByID(i);
		Advertise a2=dao.findByID(j);
		if(a1!=null||a2!=null) {
			System.out.println("�Ѿ����ڸù��ID!");
		}
		else {
			Advertise ad = new Advertise();
			ad.setAd_id(i);
			ad.setAd_channel("abc");
			ad.setAd_create_time("2008-08-08 00:00:00");
			ad.setAd_detail("abc");
			ad.setAd_location("abc");
			ad.setAd_media_height(1);
			ad.setAd_media_size(2);
			ad.setAd_media_type("abc");
			ad.setAd_media_width(1);
			ad.setAd_name("abc");
			ad.setAd_type("abc");
			ad.setAd_update_time("2008-08-08 00:00:00");
			
			dao.save(ad);
			ad.setAd_id(j);
			ad.setAd_channel("abc");
			ad.setAd_create_time("2008-08-08 00:00:00");
			ad.setAd_detail("abc");
			ad.setAd_location("abc");
			ad.setAd_media_height(1);
			ad.setAd_media_size(2);
			ad.setAd_media_type("abc");
			ad.setAd_media_width(1);
			ad.setAd_name("abc");
			ad.setAd_type("abc");
			ad.setAd_update_time("2008-08-08 00:00:00");
			dao.save(ad);
			//��֤�Ƿ����ӹ����Ϣ�ɹ�
			Advertise a = dao.findByID(i);
			Advertise b = dao.findByID(j);
			if(a==null||b==null) {
				System.out.println("Save Error!");
			}
			else {
				System.out.println("���ӹ��IDΪ "+i+" �� "+j+" �Ĺ����Ϣ�ɹ�!");
			}
		}
	}
	
	@Test
	public void testUpdate() {
		System.out.println("����һ����Ϣĳ��Ԫ��");
		int i=18;
		AdvertiseDao dao = new AdvertiseDaoImpl();
		Advertise ad=dao.findByID(i);
		//�жϸù��ID�Ƿ����
		if(ad==null) {
			System.out.println("Find Error!");
		}
		else {
			ad.setAd_detail("change");
			dao.update(ad);
			//��֤�Ƿ���¹����Ϣ�ɹ�
			Advertise a = dao.findByID(i);
			if(!a.getAd_detail().equals("change")) {
				System.out.println("Update Error!");
			}
			System.out.println("���¹��IDΪ"+i+" �Ĺ����Ϣ�ɹ�!");
		}
	}
	
	@Test
	public void testDelete() {
		System.out.println("ɾ��һ��ָ�����ID��Ϣ");
		int i=19;
		AdvertiseDao dao = new AdvertiseDaoImpl();
		Advertise ad= dao.findByID(i);
		if(ad!=null) {
			try {
				dao.delete(ad);
			}catch (Exception e) {
				//System.err.println("Delete Error!");
				System.out.println(e.getMessage());
			}
		}
		//��֤�Ƿ�ɾ�������Ϣ�ɹ�
		Advertise a = dao.findByID(i);
		if(a!=null) {
			System.out.println("Delete Error!");
		}
		else {
			System.out.println("ɾ�����IDΪ "+i+" �Ĺ����Ϣ�ɹ�!");
		}
	}

	

}
