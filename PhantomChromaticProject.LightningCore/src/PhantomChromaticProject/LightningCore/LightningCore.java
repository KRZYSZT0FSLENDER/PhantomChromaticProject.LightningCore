package PhantomChromaticProject.LightningCore;

import java.io.IOException;
import java.util.HashMap;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitTask;

import PhantomChromaticProject.LightningCore.FileManager.ConfigManager;
import PhantomChromaticProject.LightningCore.FileManager.FileManager;
import PhantomChromaticProject.LightningCore.FileManager.MessagesManager;
import PhantomChromaticProject.LightningCore.FileManager.PlayerDataManager;
import PhantomChromaticProject.LightningCore.Listeners.DeathListener;
import PhantomChromaticProject.LightningCore.Commands.FeedCommand;

public class LightningCore extends JavaPlugin{

	public static boolean ChatStatus;
	public static HashMap<UUID, Integer> TeleportTasks = new HashMap<>();
	public static HashMap<UUID, Integer> cooldowns = new HashMap<>();
	public static HashMap<UUID, PlayerDataManager> PlayerDataConfigurator = new HashMap<UUID, PlayerDataManager>();
	public static boolean firstrunnercfg = false;
	private static BukkitTask automaticsaver;
	
	@Override
	public void onEnable() {
		FileManager.CheckFiles();
		if(!firstrunnercfg) {
			YamlConfiguration yml = YamlConfiguration.loadConfiguration(FileManager.getConfigFile());
			yml.set("LightningCore.SpawnLoc.World", Bukkit.getServer().getWorlds().get(0));
			try {
				yml.save(FileManager.getConfigFile());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		MessagesManager.loadMessages();
		ConfigManager.loadFile();
		Bukkit.getPluginManager().registerEvents(new DeathListener(), this);
		getCommand("feed").setExecutor(new FeedCommand());
		automaticsaver = new BukkitRunnable() {
			
			@Override
			public void run() {
				LightningCore.savedata();
			}
		}.runTaskTimerAsynchronously(this, 0, ConfigManager.LightningCore.getDataSaveInterval() * 20 * 60);
	}
	
	@Override
	public void onDisable() {
		
		
		
	}
	private static void savedata() {
		
	}
	public static void restartAutomaticDataSaver(byte newInterval) {
		automaticsaver.cancel();
		automaticsaver = new BukkitRunnable() {
			
			@Override
			public void run() {
				LightningCore.savedata();
			}
		}.runTaskTimerAsynchronously(LightningCore.getPlugin(LightningCore.class), 0, newInterval * 20 * 60);
	}
	
}


/*
 * 
 * This plugin was made by PhantomChromaticDevTeam 
 * 
 * https://discord.gg/At7yS2f Official discord contact
 *
 */