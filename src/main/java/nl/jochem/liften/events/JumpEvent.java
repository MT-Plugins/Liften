package nl.jochem.liften.events;

import nl.jochem.liften.Main;
import nl.jochem.liften.utils.BlockUtils;
import nl.jochem.liften.utils.ConfigUtils;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerToggleFlightEvent;

public class JumpEvent implements Listener {

    private Main main;
    private BlockUtils blockUtils;
    private ConfigUtils configUtils;

    public JumpEvent(Main main){
        this.main = main;
        blockUtils = main.getBlockUtils();
        configUtils = main.getConfigUtils();
    }

    @EventHandler
    public void onJump(PlayerToggleFlightEvent event) {
        if(blockUtils.getBlockBelow(event.getPlayer()).equals(configUtils.getMaterial())) {
            event.setCancelled(true);
            event.getPlayer().teleport(blockUtils.findUpperBlock(event.getPlayer()));
        }
    }
}
