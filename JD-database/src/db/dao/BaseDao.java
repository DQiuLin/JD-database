package db.dao;

public interface BaseDao {
	
	/**
	 * TODO ����������ݿ�
	 * @param obj ��Ҫ����Ķ���
	 */
	public void save(Object obj);
	
	/**
	 * TODO �����ݿ���ɾ��ĳһ����
	 * @param obj ��Ҫɾ���Ķ���
	 */
	public void delete(Object obj);
	
	/**
	 * TODO �������ݿ��е�ĳ������
	 * @param obj ��Ҫ���µļ�¼
	 */
	public void update(Object obj);
	
	
}
