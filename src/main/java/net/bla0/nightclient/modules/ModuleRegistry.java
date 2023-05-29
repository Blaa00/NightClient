package net.bla0.nightclient.modules;

import net.minecraft.util.Util;

import java.util.ArrayList;
import java.util.List;

public class ModuleRegistry {
    private static final List<Module> modules = Util.make(new ArrayList<>(), ModuleRegistry::initModules);

    private static void initModules(List<Module> modules) {

        modules.add(new FreezeModule());
        modules.add(new ElytraModule());
        modules.add(new ListModule());
        modules.add(new XRayModule().init());
        modules.add(new FullbrightModule());
        modules.add(new FreecamModule());
        modules.add(new SprintModule());
        modules.add(new SpeedModule());
        modules.add(new NoFallModule());
        modules.add(new FlyModule());
        modules.add(new EspModule());
    }

    public static List<Module> getModules() {
        return modules;
    }

    public static Module getByAlias(String lookModule) {
        for (Module module : getModules()) {
            if (module.name.equalsIgnoreCase(lookModule)) {
                return module;
            }
        }
        return null;
    }
}
