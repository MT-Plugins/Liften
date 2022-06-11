package nl.jochem.liften.command;

import nl.jochem.liften.Main;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class LiftCommand implements CommandExecutor {

    private Main main;
    public LiftCommand(Main main) {
        this.main = main;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        main.reloadConfig();
        sender.sendMessage(main.getConfigUtils().getReloadMessage());
        return false;
    }
}
