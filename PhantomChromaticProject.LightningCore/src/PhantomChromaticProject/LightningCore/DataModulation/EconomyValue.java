package PhantomChromaticProject.LightningCore.DataModulation;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import PhantomChromaticProject.LightningCore.FileManager.ConfigManager;

public class EconomyValue {
	long beforecomma;
	int aftercomma;
	public EconomyValue(long beforecomma, int aftercomma) {
		if(beforecomma < ConfigManager.Economy.getMineconomy()) {
			beforecomma = ConfigManager.Economy.getMineconomy();
		}
		if(beforecomma >= ConfigManager.Economy.getMaxeconomy()) {
			this.beforecomma = ConfigManager.Economy.getMaxeconomy();
			this.aftercomma = 0;
			return;
		}
		if(aftercomma >= 100) {
			int number = aftercomma;
			while(number > 100) {
				number = number - 100;
				beforecomma = beforecomma + 1;
			}
			aftercomma = number;
		}else if(aftercomma <= 0) {
			int number = aftercomma;
			while(number < 0) {
				number = number + 100;
				beforecomma--;
			}
			if(beforecomma > ConfigManager.Economy.getMineconomy()) {
				beforecomma--;
				aftercomma = 100 - number;
			}else if(beforecomma == ConfigManager.Economy.getMineconomy()){
				if(aftercomma <= 0) {
					aftercomma = 0;
				}
			}
		}
		if(beforecomma >= ConfigManager.Economy.getMaxeconomy()) {
			this.beforecomma = ConfigManager.Economy.getMaxeconomy();
			return;
		}else if(beforecomma <= -1) {
			this.beforecomma = 0;
			if(beforecomma < ConfigManager.Economy.getMineconomy()) {
				aftercomma = 0;
			}
			return;
		}
		this.beforecomma = beforecomma;
		this.aftercomma = aftercomma;
	}
	
	public EconomyValue add(EconomyValue Money) {
		long before = this.beforecomma + Money.getBeforeComma();
		int after = this.aftercomma + Money.getAfterComma();
		EconomyValue EV = new EconomyValue(before, after);
		this.aftercomma = EV.getAfterComma();
		this.beforecomma = EV.getBeforeComma();
		return this;
	}
	public EconomyValue substract(EconomyValue Money) {
		long before = this.beforecomma - Money.getBeforeComma();
		int after = this.aftercomma - Money.getAfterComma();
		EconomyValue EV = new EconomyValue(before, after);
		this.aftercomma = EV.getAfterComma();
		this.beforecomma = EV.getBeforeComma();
		return this;
	}
	public EconomyValue multiply(EconomyValue Money) {
		long before = (long) this.beforecomma * Money.getBeforeComma();
		int after = (int) this.aftercomma * Money.getAfterComma();
		EconomyValue EV = new EconomyValue(before, after);
		this.aftercomma = EV.getAfterComma();
		this.beforecomma = EV.getBeforeComma();
		return this;
	}
	public EconomyValue devide(EconomyValue Money) {
		long before = (long) this.beforecomma / Money.getBeforeComma();
		int after = (int) this.aftercomma / Money.getAfterComma();
		EconomyValue EV = new EconomyValue(before, after);
		this.aftercomma = EV.getAfterComma();
		this.beforecomma = EV.getBeforeComma();
		return this;
	}
	public static long getMaxBeforeComma() {
		return Long.MAX_VALUE;
	}
	public static long getMinBeforeComma() {
		return Long.MIN_VALUE;
	}
	public static int getMaxAfterComma() {
		return Integer.MAX_VALUE;
	}
	public static int getMinAfterComma() {
		return Integer.MAX_VALUE;
	}
	public long getBeforeComma() {
		return this.beforecomma;
	}
	public int getAfterComma() {
		return this.aftercomma;
	}
	
	public boolean hasMoney(EconomyValue Money) {
		if(this.beforecomma >= Money.getBeforeComma()) {
			if(this.aftercomma < Money.getAfterComma()) {
				long before = this.beforecomma - 1;
				int after = this.aftercomma + 100;
				if(before >= Money.getBeforeComma() && after >= Money.getAfterComma()) {
					return true;
				}else {
					return false;
				}
			}else {
				return true;
			}
		}else {
			return false;
		}
	}
	
	public void setMoney(EconomyValue Money) {
		this.aftercomma = Money.getAfterComma();
		this.beforecomma = Money.getBeforeComma();
	}
	
	@Override
	public String toString() {
		return beforecomma + "." + aftercomma;
	}
	public static EconomyValue loadData(Player player, File EconomyFile) {
		YamlConfiguration yml = YamlConfiguration.loadConfiguration(EconomyFile);
		UUID uuid = player.getUniqueId();
		String economyString = yml.getString("LightningEconomy." + uuid + ".PlayerAccount");
		String[] data = economyString.split(".");
		try {
			long datalong = Long.parseLong(data[0]);
			int dataint = Integer.parseInt(data[1]);
			return new EconomyValue(datalong, dataint);
		}catch(NumberFormatException e) {
			e.printStackTrace();
			return null;
		}
	}
	public void saveToFile(Player player, File EconomyFile) {
		YamlConfiguration yml = YamlConfiguration.loadConfiguration(EconomyFile);
		yml.set("LightningEconomy." + player.getUniqueId() + ".PlayerAccount", this.toString());
		try {
			yml.save(EconomyFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static EconomyValue parseEconomyValue(String EconomyString) throws EconomyParseException {
		String[] CorrectedString = null;
		if(EconomyString.contains(".") || EconomyString.contains(",") || EconomyString.contains(":")) {
			if(EconomyString.contains(".")) {
				CorrectedString = EconomyString.split(".");
			}else if(EconomyString.contains(",")) {
				CorrectedString = EconomyString.split(",");
			}else if(EconomyString.contains(":")) {
				CorrectedString = EconomyString.split(":");
			}
		}else {
			throw new EconomyParseException();
		}
		long BeforeComma = Long.parseLong(CorrectedString[0]);
		int AfterComma = Integer.parseInt(CorrectedString[1]);
		return new EconomyValue(BeforeComma, AfterComma);
	}
	public static EconomyValue parseEconomyValue(long BeforeComma, int AfterComma) {
		return new EconomyValue(BeforeComma, AfterComma);
	}
}
