package barracksWars.core.commands;

import barracksWars.interfaces.Repository;
import barracksWars.interfaces.UnitFactory;

public class RetireCommand  extends  Command{



    public RetireCommand(String[] data, UnitFactory unitFactory, Repository repository) {
        super(data, unitFactory, repository);
    }

    @Override
    public String execute() {
        String unitType = getData()[1];
        try{
        this.getRepository().removeUnit(unitType);
        return unitType + " retired!";
        }
        catch (IllegalArgumentException ex){
            return ex.getMessage();
        }
    }
}
