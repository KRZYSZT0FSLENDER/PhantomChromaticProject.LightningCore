package PhantomChromaticProject.LightningCore.Commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import PhantomChromaticProject.LightningCore.FileManager.MessagesManager;
import PhantomChromaticProject.LightningCore.LightningLogger;

public class FeedCommand implements CommandExecutor{

	@Override
	public boolean onCommand(CommandSender s, Command c, String str, String[] l) {
		
		if(c.getName().equalsIgnoreCase("feed")) {
			
			if(s instanceof Player) {

					if(s.hasPermission("lightningcore.commands.feed")) {

						if(l.length != 0) {
							
							if(s.hasPermission("lightningcore.commands.feed.others")) {
								
								if(Bukkit.getPlayer(l[0]) != null) {
									
									Player p = Bukkit.getPlayer(l[0]);
									p.setFoodLevel(20);
									p.setSaturation(20);
									p.sendMessage(MessagesManager.Commands.getFeedMessage(true));
									s.sendMessage(MessagesManager.Commands.getFeededOtherMessage(true, l[0]));
									return true;
									
								}else {s.sendMessage(MessagesManager.Errors.getNoFeedPlayer(true, l[0])); return false;}
							
							}else {
								s.sendMessage(MessagesManager.Permissions.getFeedPermissionsErrorMessage(true));
								LightningLogger.ConsoleLog(ChatColor.RED + s.getName() + ChatColor.GRAY + " try to use " + ChatColor.RED + "feed others" + ChatColor.GRAY + "command withount permission " + ChatColor.RED + "lightningcore.commands.feed.others");
								return false;
							}
						}
						Player p = (Player) s;
						p.setFoodLevel(20);
						p.setSaturation(20);
						p.sendMessage(MessagesManager.Commands.getFeedMessage(true));
						return true;
					
					}else {
						s.sendMessage(MessagesManager.Permissions.getFeedPermissionsErrorMessage(true));
						LightningLogger.ConsoleLog(ChatColor.RED + s.getName() + ChatColor.GRAY + " try to use " + ChatColor.RED + "feed" + ChatColor.GRAY + "command withount permission " + ChatColor.RED + "lightningcore.commands.feed");
						return false;
					}
				
			}else {s.sendMessage(MessagesManager.Errors.getNoConsoleError(true, c.getName())); return false;}
			
		}
		
		return false;
	}

}
