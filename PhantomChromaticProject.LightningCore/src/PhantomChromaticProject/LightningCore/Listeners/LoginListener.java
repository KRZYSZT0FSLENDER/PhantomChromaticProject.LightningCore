package PhantomChromaticProject.LightningCore.Listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLoginEvent;

public class LoginListener implements Listener{
	
	@EventHandler(ignoreCancelled = false, priority = EventPriority.MONITOR)
	public void CreatePlayerData(PlayerLoginEvent e) {
		
	}
	
}
