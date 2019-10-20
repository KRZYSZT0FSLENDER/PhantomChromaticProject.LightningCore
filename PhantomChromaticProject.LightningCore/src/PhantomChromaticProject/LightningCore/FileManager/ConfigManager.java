package PhantomChromaticProject.LightningCore.FileManager;

import java.io.File;
import java.io.IOException;

import org.bukkit.configuration.file.YamlConfiguration;

public class ConfigManager {
	private static YamlConfiguration Configurator;
	private static File ConfigFile;
	public static void loadFile() {
		ConfigFile = FileManager.getConfigFile();
		Configurator = YamlConfiguration.loadConfiguration(ConfigFile);
	}
	public static class LightningCore{
		public static byte getDataSaveInterval() {
			return (byte) Configurator.getInt("LightningCore.AutomaticDataSaveInterval");
		}
		public static void setDataSaveInterval(byte Interval) {
			Configurator.set("LightningCore.AutomaticDataSaveInterval", (int) Interval);
			try {
				Configurator.save(ConfigFile);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public static class Economy{
		
		public static long getMaxeconomy() {
			return Configurator.getLong("Economy.maxaccountstatus");
		}
		public static long getMineconomy() {
			return Configurator.getLong("Economy.minaccountstatus");
		}
		
	}
	
}
