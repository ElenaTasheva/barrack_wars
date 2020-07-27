package barracksWars.core.factories;

import barracksWars.interfaces.Unit;
import barracksWars.interfaces.UnitFactory;


import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;


public class UnitFactoryImpl implements UnitFactory {

	private static final String UNITS_PACKAGE_NAME =
			"barracksWars.models.units.";

	@Override
	public Unit createUnit(String unitType) {
		try {
			Class<?> clazz = Class.forName(UNITS_PACKAGE_NAME + unitType);
			Constructor<?> ctor = clazz.getDeclaredConstructor();
			Object obj =  ctor.newInstance();
			if(obj instanceof Unit){
				return (Unit) obj;
			}

		} catch (ClassNotFoundException | NoSuchMethodException |
				InstantiationException | IllegalAccessException | InvocationTargetException e){
			e.printStackTrace();

		}
		return null;
	}
}
