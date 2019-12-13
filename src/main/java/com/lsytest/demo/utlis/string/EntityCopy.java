package string;

import org.springframework.beans.BeanUtils;

public class EntityCopy {
	public static void main(String[] args) {
		Entity1 entity1 = new Entity1();
		Entity2 entity2 = new Entity2();
		BeanUtils.copyProperties(entity1,entity2);
	}
}

