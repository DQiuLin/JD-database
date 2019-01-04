package db.test;


import java.util.List;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import db.dao.AddrDao;
import db.dao.AddrDaoImpl;
import db.dao.AdvertiseDao;
import db.dao.AdvertiseDaoImpl;
import db.entity.Addr;
import db.entity.Advertise;

import java.util.List;



import db.dao.AdvertiseInfoDao;
import db.dao.AdvertiseInfoDaoImpl;

import db.entity.AdvertiseInfo;

public class AdvertiseInfoDaoImplTest {

	@Before
	public void setUp() throws Exception {
	}


	@Test
	public void testFindByID() {
		System.out.println("ͨ�������ϸ��ϢID���һ����Ϣ");
		AdvertiseInfoDao dao = new AdvertiseInfoDaoImpl();
		int i=18;
		AdvertiseInfo a = dao.findByID(i);
		//�����Ƿ��ҵ��ù����ϸ��ϢID
		if(a == null) {
			System.out.println("û�й����ϸ��ϢIDΪ "+i+" ����ϸ��Ϣ");
		}
		else {
			System.out.println("���ҹ����ϸ��ϢIDΪ"+a.getAd_info_id()+" ��һ����ϸ��Ϣ�ɹ�!");}
	}

	@Test
	public void testFindAll() {
		System.out.println("�г����й����ϸ��Ϣ��Ϣ");
		AdvertiseInfoDao dao = new AdvertiseInfoDaoImpl();
		List<AdvertiseInfo> adinfo = dao.findAll();
		for(int i = 0; i < adinfo.size(); i++) {
			AdvertiseInfo a = adinfo.get(i);
			System.out.println(a.getAd_info_id()+" "+a.getAd_begin_time()+" "+a.getAd_click_time()+" "+
							   a.getAd_create_time()+" "+a.getAd_during_time()+" "+a.getAd_end_time()+" "+
							   a.getAd_file_path()+" "+a.getAd_file_size()+" "+a.getAd_file_type()+" "+
							   a.getAd_info_status()+" "+a.getAd_info_title()+" "+a.getAd_link_url()+" "+
							   a.getAd_note()+" "+a.getAd_scan_time()+" "+a.getAdvertise_ad_id()+" "+a.getStore_store_id());
		}
		System.out.println("�г����й����ϸ��Ϣ�ɹ�!");
	}

	@Test
	public void testFindByStoreID() {
		System.out.println("ͨ�����ҵ���ID������й����ϸ��Ϣ");
		AdvertiseInfoDao dao = new AdvertiseInfoDaoImpl();
		int i=126;
		List<AdvertiseInfo> adinfo = dao.findByStoreID(i);
		for(int j = 0; j < adinfo.size(); j++) {
			AdvertiseInfo a = adinfo.get(j);
			System.out.println(a.getAd_info_id()+" "+a.getAd_begin_time()+" "+a.getAd_click_time()+" "+
					   a.getAd_create_time()+" "+a.getAd_during_time()+" "+a.getAd_end_time()+" "+
					   a.getAd_file_path()+" "+a.getAd_file_size()+" "+a.getAd_file_type()+" "+
					   a.getAd_info_status()+" "+a.getAd_info_title()+" "+a.getAd_link_url()+" "+
					   a.getAd_note()+" "+a.getAd_scan_time()+" "+a.getAdvertise_ad_id()+" "+a.getStore_store_id());
		}
		System.out.println("���ҵ���IDΪ"+i+" �����й����ϸ��Ϣ�ɹ�!");
	}

	@Test
	public void testFindByAdID() {
		System.out.println("ͨ�����ҹ��ID������й����ϸ��Ϣ");
		AdvertiseInfoDao dao = new AdvertiseInfoDaoImpl();
		int i=126;
		List<AdvertiseInfo> adinfo = dao.findByStoreID(i);
		for(int j = 0; j < adinfo.size(); j++) {
			AdvertiseInfo a = adinfo.get(j);
			System.out.println(a.getAd_info_id()+" "+a.getAd_begin_time()+" "+a.getAd_click_time()+" "+
					   a.getAd_create_time()+" "+a.getAd_during_time()+" "+a.getAd_end_time()+" "+
					   a.getAd_file_path()+" "+a.getAd_file_size()+" "+a.getAd_file_type()+" "+
					   a.getAd_info_status()+" "+a.getAd_info_title()+" "+a.getAd_link_url()+" "+
					   a.getAd_note()+" "+a.getAd_scan_time()+" "+a.getAdvertise_ad_id()+" "+a.getStore_store_id());
		}
		System.out.println("���ҹ��IDΪ"+i+" �Ĺ����ϸ��Ϣ�ɹ�!");
	}

	@Test
	public void testSave() {
		System.out.println("���ӹ����ϸ��Ϣ");
		int i=18;
		int j=19;
		AdvertiseInfoDao dao = new AdvertiseInfoDaoImpl();
		AdvertiseInfo a1=dao.findByID(i);
		AdvertiseInfo a2=dao.findByID(j);
		if(a1!=null||a2!=null) {
			System.out.println("�Ѿ����ڸù����ϸ��ϢID!");
		}
		else {
			AdvertiseInfo adinfo = new AdvertiseInfo();
			adinfo.setAd_info_id(i);
			adinfo.setAd_begin_time("2008-08-08 00:00:00");
			adinfo.setAd_click_time(1);
			adinfo.setAd_create_time("2008-08-08 00:00:00");
			adinfo.setAd_during_time("2008-08-08 00:00:00");
			adinfo.setAd_end_time("2008-08-08 00:00:00");
			adinfo.setAd_file_path("abc");
			adinfo.setAd_file_size(1);
			adinfo.setAd_file_type("abc");
			adinfo.setAd_info_status(1);
			adinfo.setAd_info_title("abc");
			adinfo.setAd_is_period(true);
			adinfo.setAd_link_url("abc");
			adinfo.setAd_note("abc");
			adinfo.setAd_scan_time(1);
			adinfo.setAdvertise_ad_id(1);
			adinfo.setStore_store_id(1);
			dao.save(adinfo);
			adinfo.setAd_info_id(j);
			adinfo.setAd_begin_time("2008-08-08 00:00:00");
			adinfo.setAd_click_time(1);
			adinfo.setAd_create_time("2008-08-08 00:00:00");
			adinfo.setAd_during_time("2008-08-08 00:00:00");
			adinfo.setAd_end_time("2008-08-08 00:00:00");
			adinfo.setAd_file_path("abc");
			adinfo.setAd_file_size(1);
			adinfo.setAd_file_type("abc");
			adinfo.setAd_info_status(1);
			adinfo.setAd_info_title("abc");
			adinfo.setAd_is_period(true);
			adinfo.setAd_link_url("abc");
			adinfo.setAd_note("abc");
			adinfo.setAd_scan_time(1);
			adinfo.setAdvertise_ad_id(1);
			adinfo.setStore_store_id(1);
			dao.save(adinfo);
			//��֤�Ƿ����ӵ�ַ��Ϣ�ɹ�
			AdvertiseInfo a = dao.findByID(i);
			AdvertiseInfo b = dao.findByID(j);
			if(a==null||b==null) {
				System.out.println("Save Error!");
			}
			else {
				System.out.println("���ӹ����ϸ��ϢIDΪ "+i+" �� "+j+" ����ϸ��Ϣ�ɹ�!");
			}
		}
	}

	
	@Test
	public void testUpdate() {
		System.out.println("����һ����Ϣĳ��Ԫ��");
		int i=18;
		AdvertiseInfoDao dao = new AdvertiseInfoDaoImpl();
		AdvertiseInfo adinfo=dao.findByID(i);
		//�жϸù����ϸ��ϢID�Ƿ����
		if(adinfo==null) {
			System.out.println("Find Error!");
		}
		else {
			adinfo.setAd_info_title("change");
			dao.update(adinfo);
			//��֤�Ƿ���¹����ϸ��Ϣ��Ϣ�ɹ�
			AdvertiseInfo a = dao.findByID(i);
			if(!a.getAd_info_title().equals("change")) {
				System.out.println("Update Error!");
			}
			System.out.println("���¹����ϸ��ϢIDΪ"+i+" ����ϸ��Ϣ�ɹ�!");
		}
	}
	
	@Test
	public void testDelete() {
		System.out.println("ɾ��һ��ָ�������ϸID��Ϣ");
		int i=19;
		AdvertiseInfoDao dao = new AdvertiseInfoDaoImpl();
		AdvertiseInfo adinfo= dao.findByID(i);
		if(adinfo!=null) {
			try {
				dao.delete(adinfo);
			}catch (Exception e) {
				//System.err.println("Delete Error!");
				System.out.println(e.getMessage());
			}
		}
		//��֤�Ƿ�ɾ�������ϸ��Ϣ��Ϣ�ɹ�
		AdvertiseInfo a = dao.findByID(i);
		if(a!=null) {
			System.out.println("Delete Error!");
		}
		else {
			System.out.println("ɾ�������ϸ��ϢIDΪ "+i+" ����ϸ��Ϣ�ɹ�!");
		}
	}
	
}
