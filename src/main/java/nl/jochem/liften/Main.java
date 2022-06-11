package nl.jochem.liften;

import nl.jochem.liften.command.LiftCommand;
import nl.jochem.liften.utils.BlockUtils;
import nl.jochem.liften.utils.ConfigUtils;
import org.bukkit.event.HandlerList;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {

    private ConfigUtils configUtils;
    private BlockUtils blockUtils;
    public ConfigUtils getConfigUtils() {
        return configUtils;
    }
    public BlockUtils getBlockUtils() {
        return blockUtils;
    }

    public void reloadConfig() {
        configUtils = new ConfigUtils(this);
    }

    @Override
    public void onEnable() {
        configUtils = new ConfigUtils(this);
        blockUtils = new BlockUtils(this);
        getCommand("lift").setExecutor(new LiftCommand(this));
        HandlerList.unregisterAll(this);
        System.out.println("§7De plugin §6§lLiften§7 is §ageactiveerd§7!");
    }
    @Override
    public void onDisable() {
        System.out.println("§7De plugin §6§lLiften§7 is §cgedeactiveerd§7!");
    }
}
