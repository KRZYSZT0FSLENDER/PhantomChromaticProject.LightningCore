package PhantomChromaticProject.LightningCore;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class LightningLogger{

	public static void ConsoleLog(String message) {
		Bukkit.getConsoleSender().sendMessage(message);
	}
	
	public static void InformTitle(String Title, String subTitle, int livetime) {
		for(Player p : Bukkit.getOnlinePlayers()) {
			p.sendTitle(Title, subTitle, 0, livetime, 0);
		}
	}
	
	public static void SendBroadCast(String message, int spamnumber) {
		for(int i = 0; i < spamnumber; i++) {
			Bukkit.broadcastMessage(message);
		}
	}
	
	public static void SendSpecyficBroadCast(String message, String permission, int spamnumber) {
		for(int i = 0; i < spamnumber; i++) {
			Bukkit.broadcast(message, permission);
		}
	}
	
}
