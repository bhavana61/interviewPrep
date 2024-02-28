package Media.net.src.Factory;

import src.Managers.SedanManager;
import src.Enums.CabType;
import src.Interfaces.CabInterface;

public class CabManagerFactory {

    public static CabInterface getCabManager(CabType cabType) {
        switch (cabType) {
            case SEDEN :
                return new SedanManager();
            default :
                return null;
        }
    }
}
