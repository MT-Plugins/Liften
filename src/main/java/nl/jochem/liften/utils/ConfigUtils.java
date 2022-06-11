package nl.jochem.liften.utils;

import nl.jochem.liften.Main;
import org.bukkit.Material;

public class ConfigUtils {

    private Main main;
    public ConfigUtils(Main main) {
        this.main = main;
        checkValid();
    }

    public Material getMaterial() {
        return Material.getMaterial(main.getConfig().getString("elevator_block"));
    }

    public String getReloadMessage() {
        return main.getConfig().getString("reload_config");
    }

    private boolean checkValid() {
        if(getMaterial() == null || getMaterial() == Material.AIR) {
            main.getConfig().set("elevator_block", Material.SEA_LANTERN.toString());
            System.out.println("§c[--------------------]");
            System.out.println(" ");
            System.out.println("§cThe material isn't a valid material.");
            System.out.println("§cI've set the material to " + getMaterial() + ".");
            System.out.println(" ");
            System.out.println("§c[--------------------]");
            return false;
        }else if(getReloadMessage() == null) {
            main.getConfig().set("reload_config", "§7Je hebt de config van §6§lLiften §7gereload.");
            System.out.println("§c[--------------------]");
            System.out.println(" ");
            System.out.println("§cThe message for 'reload_config' isn't a valid string.");
            System.out.println("§cI've set the message to " + getReloadMessage() + ".");
            System.out.println(" ");
            System.out.println("§c[--------------------]");
            return false;
        }
        return true;
    }

}
