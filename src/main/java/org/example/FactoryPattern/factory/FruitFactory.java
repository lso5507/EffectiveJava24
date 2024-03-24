package org.example.FactoryPattern.factory;

import org.example.FactoryPattern.domain.Fruit;

abstract class FruitFactory {
	/**
	 * 주문처리를 진행하는 메소드
	 * 실제 주문로직은 서브클래스에서 구현할수 있도록 한다.(createOrder)
	 * @return Fruit
	 */
	public final Fruit orderFruit(){
		return createOrder();
	}
	/**
	 * FruitFactory를 구현하는 하위 팩토리 클래스에서 Fruit를 구현할 수 있음
	 * 메소드 구현을 서브클래스에게 맡기면 확장에 용이해짐
	 * @return 과일클래스
	 */
	abstract public Fruit createOrder();

}
