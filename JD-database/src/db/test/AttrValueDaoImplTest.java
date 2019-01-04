package db.test;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


import db.dao.AttrValueDao;
import db.dao.AttrValueDaoImpl;
import db.entity.AttrValue;

public class AttrValueDaoImplTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testFindByID() {
		System.out.println("ͨ������ֵID���һ����Ϣ");
		AttrValueDao dao = new AttrValueDaoImpl();
		int i=1;
		AttrValue a = dao.findByID(i);
		//�����Ƿ��ҵ�������ֵID
		if(a == null) {
			System.out.println("û������ֵIDΪ "+i+" ������ֵ��Ϣ");
		}
		else {
			System.out.println("��������ֵIDΪ"+i+" ��һ����Ϣ�ɹ�!");}
	}

	@Test
	public void testFindAll() {
		System.out.println("�г�������Ʒ����ֵ��Ϣ");
		AttrValueDao dao = new AttrValueDaoImpl();
		List<AttrValue> attrva = dao.findAll();
		for(int i = 0; i < attrva.size(); i++) {
			AttrValue a = attrva.get(i);
			System.out.println(a.getAttr_value_id()+" "+a.getAttr_attr_id()+" "+a.getAttr_value_name());
		}
		System.out.println("�г���������ֵ��Ϣ�ɹ�!");
	}

	@Test
	public void testFindByAttrID() {
		System.out.println("ͨ����������ID�����������ֵ��Ϣ");
		AttrValueDao dao = new AttrValueDaoImpl();
		int i=1;
		List<AttrValue> attrva = dao.findByAttrID(i);
		for(int j = 0; j < attrva.size(); j++) {
			AttrValue a = attrva.get(j);
			System.out.println(a.getAttr_value_id()+" "+a.getAttr_attr_id()+" "+a.getAttr_value_name());}
		System.out.println("��������IDΪ"+i+" ����������ֵ��Ϣ�ɹ�!");
	}

	@Test
	public void testSave() {
		System.out.println("��������ֵ��Ϣ");
		int i=18;
		int j=19;
		AttrValueDao dao = new AttrValueDaoImpl();
		AttrValue a1=dao.findByID(i);
		AttrValue a2=dao.findByID(j);
		if(a1!=null||a2!=null) {
			System.out.println("�Ѿ����ڸ�����ֵID!");
		}
		else {
			AttrValue attrva = new AttrValue();
			attrva.setAttr_value_id(i);
			attrva.setAttr_attr_id(1);
			attrva.setAttr_value_name("abc");
			dao.save(attrva);
			attrva.setAttr_value_id(j);
			attrva.setAttr_attr_id(1);
			attrva.setAttr_value_name("abc");
			dao.save(attrva);
			//��֤�Ƿ���������ֵ��Ϣ�ɹ�
			AttrValue a = dao.findByID(i);
			AttrValue b = dao.findByID(j);
			if(a==null||b==null) {
				System.out.println("Save Error!");
			}
			else {
				System.out.println("��������ֵIDΪ "+i+" �� "+j+" ����Ϣ�ɹ�!");
			}
		}
	}

	@Test
	public void testDelete() {
		System.out.println("ɾ��һ��ָ������ֵID��Ϣ");
		int i=18;
		AttrValueDao dao = new AttrValueDaoImpl();
		AttrValue attrva= dao.findByID(i);
		if(attrva!=null) {
			try {
				dao.delete(attrva);
			}catch (Exception e) {
				//System.err.println("Delete Error!");
				System.out.println(e.getMessage());
			}
		}
		//��֤�Ƿ�ɾ������ֵ��Ϣ�ɹ�
		AttrValue a = dao.findByID(i);
		if(a!=null) {
			System.out.println("Delete Error!");
		}
		else {
			System.out.println("ɾ������ֵIDΪ "+i+" ����Ϣ�ɹ�!");
		}
	}
	
	@Test
	public void testUpdate() {
		System.out.println("����һ����Ϣĳ��Ԫ��");
		int i=1;
		AttrValueDao dao = new AttrValueDaoImpl();
		AttrValue attrva=dao.findByID(i);
		//�жϸ�����ֵID�Ƿ����
		if(attrva==null) {
			System.out.println("Find Error!");
		}
		else {
			attrva.setAttr_value_name("CHANGE");
			dao.update(attrva);
			//��֤�Ƿ��������ֵ��Ϣ�ɹ�
			AttrValue a = dao.findByID(i);
			if(!a.getAttr_value_name().equals("CHANGE")) {
				System.out.println("Update Error!");
			}
			System.out.println("��������ֵIDΪ"+i+" ����Ϣ�ɹ�!");
		}
	}
}
