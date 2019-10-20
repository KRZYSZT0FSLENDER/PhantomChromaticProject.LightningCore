package PhantomChromaticProject.LightningCore.Listeners;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

public class DeathListener implements Listener{

	@EventHandler(ignoreCancelled=true, priority=EventPriority.HIGHEST)
	public void onDeath(PlayerDeathEvent e) {
		Bukkit.broadcastMessage(ChatColor.GREEN + e.getDeathMessage());
		e.setDeathMessage("nope");
		e.getEntity().sendMessage(ChatColor.GREEN + e.getDeathMessage());
	}
	
}
