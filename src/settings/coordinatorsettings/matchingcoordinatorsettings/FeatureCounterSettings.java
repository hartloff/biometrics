package settings.coordinatorsettings.matchingcoordinatorsettings;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.LinkedHashMap;

import settings.Settings;
import settings.coordinatorsettings.CoordinatorSettings;
import settings.coordinatorsettings.testgeneratorsettings.AllTestGeneratorSettings;

public class FeatureCounterSettings extends CoordinatorSettings{

	@Override
	public String getCoordinator() {
		return "FEATURECOUNTER";
	}

	@Override
	protected void addSettings() {
		this.settingsVariables.put("TestGenerator", AllTestGeneratorSettings.getInstance());
	}

	
	//Singleton
	private static FeatureCounterSettings instance;
	private FeatureCounterSettings(){
	}
	public static FeatureCounterSettings getInstance(){
		if(instance == null){
			instance = new FeatureCounterSettings();
		}
		return instance;
	}
	private void writeObject(ObjectOutputStream out) throws IOException{
		out.writeObject(instance.settingsVariables);
	}
	private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException{
		instance.settingsVariables = (LinkedHashMap<String, Settings>) in.readObject();
	}
	
	
	@Override
	public String getLabel(){
		return "Feature Counter";
	}

}
