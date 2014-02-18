package settings.coordinatorsettings;

import javax.swing.JComboBox;
import javax.swing.JPanel;

import settings.ComboBoxSettings;
import settings.Settings;
import settings.SettingsRenderer;
import settings.settingsvariables.SettingsString;

public class AllIndexingCoordinatorSettings  extends ComboBoxSettings{

	
	public static String getIndexingCoordinator(){
		CoordinatorSettings coordinatorSettings = (CoordinatorSettings) instance.settingsVariables.get(instance.variableString);
		return coordinatorSettings.getCoordinator();
	}
	
	//Singleton
	private static AllIndexingCoordinatorSettings instance;
	private AllIndexingCoordinatorSettings() {}
	public static AllIndexingCoordinatorSettings getInstance(){
		if(instance == null){
			instance = new AllIndexingCoordinatorSettings();
		}
		return instance;
	}


	@Override
	protected void init() {
		this.variableString = "indexing";
		this.settingsVariables.put(this.variableString, NoCoordinator.getInstance());	
	}

	@Override
	protected void addALLOptions() {
		this.addToOptions(NoCoordinator.getInstance());
		this.addToOptions(RAMIndexingSettings.getInstance());	
		this.addToOptions(SQLIndexingSettings.getInstance());	
	}


}