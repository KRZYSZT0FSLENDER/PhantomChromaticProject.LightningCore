package PhantomChromaticProject.LightningCore.Listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class JoinListener implements Listener{
	
	@EventHandler(ignoreCancelled = false, priority = EventPriority.MONITOR)
	public void LoadEconomy(PlayerJoinEvent e) {
		
	}
	
}
