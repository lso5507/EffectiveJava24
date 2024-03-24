package org.example.FactoryPattern.service;

import org.example.FactoryPattern.domain.Apple;
import org.example.FactoryPattern.domain.Fruit;
import org.example.FactoryPattern.factory.AppleFactory;
import org.example.FactoryPattern.factory.GrapeFactory;

public class FactoryService {
	/**
	 * 팩토리 패턴을 학습한다.
	 * 1. 후에 다른 과일을 생성하여도 추가적인 팩토리클래스를 구현하여 기존 소스에 영향이 가지않음
	 *    팩토리 클래스에서 생성하려는 클래스의 타입을 분기하여 관리 할 필요가 없다.
	 * 2. 팩토리 패턴은 호출시마다 인스턴스를 재생성 할 필요가 없으므로 싱글톤 패턴으로 구현합니다.
	 *    어차피 사용하지 않는 인스턴스라면 GC가 메모리 소거를 해주지만, 이러한 행위들은 stop-the-world의 원인이 될 수 있다.
	 *
	 */
	public void run(){
		Fruit apple= AppleFactory.getInstance().orderFruit();
		Fruit grape= GrapeFactory.getInstance().orderFruit();
		System.out.println("apple = " + apple.toString());
		System.out.println("grape = " + grape.toString());

	}
}
