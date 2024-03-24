package org.example.FactoryPattern.factory;

import org.example.FactoryPattern.domain.Apple;
import org.example.FactoryPattern.domain.Fruit;
import org.example.FactoryPattern.domain.Grape;

public class GrapeFactory extends FruitFactory {
	private static class SingleInstanceHolder{
		private static final GrapeFactory INSTANCE = new GrapeFactory();
	}
	public static GrapeFactory getInstance(){
		return SingleInstanceHolder.INSTANCE;
	}
	@Override
	public Fruit createOrder() {
		return new Grape(3000,1);
	}
}
