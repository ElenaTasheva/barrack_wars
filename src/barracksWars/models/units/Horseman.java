package barracksWars.models.units;

public class Horseman extends AbstractUnit{

    private static final int HORSEMAN_HEALTH = 50;
    private static final int HORSMAN_DAMAGE = 10;


  public Horseman() {
        super(HORSEMAN_HEALTH, HORSMAN_DAMAGE);
    }
}
