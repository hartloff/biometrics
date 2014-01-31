package settings;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.BoxLayout;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import settings.hashersettings.FuzzyVaultSettings;
import settings.hashersettings.StraightHasherSettings;

public abstract class ComboBoxSettings extends Settings{

	private static final long serialVersionUID = 1L;
	
	protected JComboBox settingsBox;
	protected String variableString;
	protected JPanel cardPanel;
	
	protected void addToOptions(Settings settings){
		this.settingsBox.addItem(settings);
		this.settingsBox.validate();
		this.cardPanel.add(settings.getJPanel(), settings.getLabel());
	}
	
	protected ComboBoxSettings(){
		this.addALLOptions();
	}

	protected abstract void addALLOptions();

	
	@Override
	protected JPanel thisJPanel() {
		JPanel currentPanel = new JPanel();
		
		this.settingsBox = new JComboBox();
		this.settingsBox.addActionListener(new SettingsComboBoxActionListener(this, this.variableString));
		this.settingsBox.setRenderer(new SettingsRenderer());
		
		currentPanel.add(settingsBox);
		
		return currentPanel;
	}

	
	@Override
	public JPanel makeChildrenJPanel(){
		this.cardPanel = new JPanel(new CardLayout());
		return this.cardPanel;
	}
	
	
	
	public class SettingsComboBoxActionListener implements ActionListener{
		
		Settings sourceSettings;
		String variableName;
		
		public SettingsComboBoxActionListener(Settings sourceSettings, String variableName) {
			this.sourceSettings = sourceSettings;
			this.variableName = variableName;
		}

		@Override
		public void actionPerformed(ActionEvent e) {

			JComboBox sourceBox = (JComboBox) e.getSource();
			Settings selectedSettings = (Settings) sourceBox.getSelectedItem();

			sourceSettings.settingsVariables.put(variableName, selectedSettings);
			
			CardLayout cardLayout = (CardLayout) cardPanel.getLayout();
			cardLayout.show(cardPanel, selectedSettings.getLabel());
			    
//			sourceBox.validate();
//			AllSettings.updateGUI();
			sourceBox.revalidate();
			sourceBox.getParent().repaint();
			sourceBox.getParent().validate();
			
		}
		
		
	}
		
	
}
