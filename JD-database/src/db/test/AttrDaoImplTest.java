package db.test;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


import db.dao.AttrDao;
import db.dao.AttrDaoImpl;
import db.entity.Attr;


public class AttrDaoImplTest {


	@Before
	public void setUp() throws Exception {
	}


	@Test
	public void testFindAll() {
		System.out.println("�г�������Ʒ������Ϣ");
		AttrDao dao = new AttrDaoImpl();
		List<Attr> attr = dao.findAll();
		for(int i = 0; i < attr.size(); i++) {
			Attr a = attr.get(i);
			System.out.println(a.getAttr_id()+" "+a.getAttr_name());
		}
		System.out.println("�г�������Ʒ������Ϣ�ɹ�!");
	}

	@Test
	public void testFindByID() {
		System.out.println("ͨ����Ʒ����ID���һ����Ϣ");
		AttrDao dao = new AttrDaoImpl();
		int i=13;
		Attr a = dao.findByID(i);
		//�����Ƿ��ҵ�������ID
		if(a == null) {
			System.out.println("û������IDΪ "+i+" ��������Ϣ");
		}
		else {
			System.out.println("��������IDΪ"+" ��һ��������Ϣ�ɹ�!");}
	}

	@Test
	public void testSave() {
		System.out.println("������Ʒ������Ϣ");
		int i=18;
		int j=19;
		AttrDao dao = new AttrDaoImpl();
		Attr a1=dao.findByID(i);
		Attr a2=dao.findByID(j);
		if(a1!=null||a2!=null) {
			System.out.println("�Ѿ����ڸ�����ID!");
		}
		else {
			Attr attr = new Attr();
			attr.setAttr_id(i);
			attr.setAttr_name("abc");
			dao.save(attr);
			attr.setAttr_id(j);
			attr.setAttr_name("abc");
			dao.save(attr);
			//��֤�Ƿ�����������Ϣ�ɹ�
			Attr a = dao.findByID(i);
			Attr b = dao.findByID(j);
			if(a==null||b==null) {
				System.out.println("Save Error!");
			}
			else {
				System.out.println("��������IDΪ "+i+" �� "+j+" ��������Ϣ�ɹ�!");
			}
		}
	}

	

	@Test
	public void testUpdate() {
		System.out.println("����һ����Ϣĳ��Ԫ��");
		int i=18;
		AttrDao dao = new AttrDaoImpl();
		Attr attr=dao.findByID(i);
		//�жϸ�����ID�Ƿ����
		if(attr==null) {
			System.out.println("Find Error!");
		}
		else {
			attr.setAttr_name("change");
			dao.update(attr);
			//��֤�Ƿ����������Ϣ�ɹ�
			Attr a = dao.findByID(i);
			if(!a.getAttr_name().equals("change")) {
				System.out.println("Update Error!");
			}
			System.out.println("������ƷIDΪ"+i+" ��������Ϣ�ɹ�!");
		}
	}
	
	@Test
	public void testDelete() {
		System.out.println("ɾ��һ��ָ����Ʒ����ID��Ϣ");
		int i=19;
		AttrDao dao = new AttrDaoImpl();
		Attr attr= dao.findByID(i);
		if(attr!=null) {
			try {
				dao.delete(attr);
			}catch (Exception e) {
				//System.err.println("Delete Error!");
				System.out.println(e.getMessage());
			}
		}
		//��֤�Ƿ�ɾ��������Ϣ�ɹ�
		Attr a = dao.findByID(i);
		if(a!=null) {
			System.out.println("Delete Error!");
		}
		else {
			System.out.println("ɾ����ƷIDΪ "+i+" ��������Ϣ�ɹ�!");
		}
	}

}
