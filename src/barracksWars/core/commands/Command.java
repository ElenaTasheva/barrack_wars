package barracksWars.core.commands;

import barracksWars.interfaces.Executable;
import barracksWars.interfaces.Repository;
import barracksWars.interfaces.UnitFactory;

public abstract class Command implements Executable {
    private String[] data;
    private UnitFactory unitFactory;
    private Repository repository;

    protected Command(String[] data, UnitFactory unitFactory, Repository repository) {
        this.data = data;
        this.unitFactory = unitFactory;
        this.repository = repository;
    }

    protected String[] getData() {
        return data;
    }

    protected UnitFactory getUnitFactory() {
        return unitFactory;
    }

    protected Repository getRepository() {
        return repository;
    }
}
