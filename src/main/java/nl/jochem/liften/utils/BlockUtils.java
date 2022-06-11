package nl.jochem.liften.utils;

import nl.jochem.liften.Main;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;

public class BlockUtils {
    private Main main;
    public BlockUtils(Main main) {
        this.main = main;
    }

    public Location findUpperBlock(Player player) {
        Location loc = player.getLocation();
        for(int i = (loc.getBlockY()) + 1; i <=  256; i++) {
            Location newLoc = new Location(loc.getWorld(), loc.getBlockX(), i, loc.getBlockZ());
            if(loc.getWorld().getBlockAt(newLoc).getType() == main.getConfigUtils().getMaterial()) {
                return newLoc;
            }
        }
        return null;
    }

    public Location findLowerBlock(Player player) {
        Location loc = player.getLocation();
        for(int i = (loc.getBlockY()) - 2; i <=  1; i--) {
            Location newLoc = new Location(loc.getWorld(), loc.getBlockX(), i, loc.getBlockZ());
            if(loc.getWorld().getBlockAt(newLoc).getType() == main.getConfigUtils().getMaterial()) {
                return newLoc;
            }
        }
        return null;
    }

    public Material getBlockBelow(Player player) {
        return player.getWorld().getBlockAt(
                player.getLocation().getBlockX(),
                player.getLocation().getBlockY() - 1,
                player.getLocation().getBlockZ()
        ).getType();
    }
}
