package entity;

import com.lsytest.demo.entity.TestEntity;

import java.lang.reflect.Field;
/**
 * ѭ������Entity������
 * ֻ�ܱ�����ǰEntity,���ܱ����̳е�
 * @author Dimine_0147
 *
 */
public class TraverseEntityAttribute {
	public static void main(String[] args) {
		TestEntity test = new TestEntity();

		
		test.setSax("22");
		test.setTel("33");
		test.setName("11");
		try {
			testReflect(test);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//java�б���ʵ���࣬��ȡ������������ֵ
    public static void testReflect(Object model) throws Exception{
        for (Field field : model.getClass().getDeclaredFields()) {
            field.setAccessible(true);
            System.out.println(field.getName() + ":" + field.get(model) );
            }
    }
}
