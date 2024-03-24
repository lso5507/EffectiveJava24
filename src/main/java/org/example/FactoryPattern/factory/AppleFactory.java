package org.example.FactoryPattern.factory;

import org.example.FactoryPattern.domain.Apple;
import org.example.FactoryPattern.domain.Fruit;

public class AppleFactory extends FruitFactory {
	private static class SingleInstanceHolder{
		private static final AppleFactory INSTANCE = new AppleFactory();
	}

	public static AppleFactory getInstance() {
		return SingleInstanceHolder.INSTANCE;
	}

	@Override
	public Fruit createOrder() {
		return new Apple(1000,2);
	}
}
