package swing.view;

import java.beans.PropertyChangeEvent;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import net.miginfocom.swing.MigLayout;
import swing.api.Closeable;
import swing.api.DeductionType;

public class AddDeductionView extends JInternalFrame implements Closeable {

	private JButton saveBtn;
	private JButton closeBtn;
	private JTextField nameTxt;
	private JComboBox<DeductionType> typeCombo;
	private JTextField amountTxt;

	public AddDeductionView() {
		init();
	}

	private void init() {
		setTitle("New Deduction");
		setClosable(true);
		setMaximizable(true);
		setResizable(true);
		setSize(600, 500);

		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		addVetoableChangeListener(this::closePrompt);
		buildForm();

	}

	private void buildForm() {
		JLabel greetingLabel = new JLabel("Enter in the information for your deduction.");
		JLabel nameLabel = new JLabel("Name");
		nameTxt = new JTextField(8);
		nameTxt.setEditable(true);
		JLabel typeLabel = new JLabel("Type");
		typeCombo = new JComboBox<>();
		JLabel amountLabel = new JLabel("Amount");
		amountTxt = new JTextField(8);
		amountTxt.setEditable(true);

		JPanel formPanel = new JPanel(new MigLayout());
		JPanel buttonPanel = buildButtonPanel();

		// column row
		formPanel.add(nameLabel, "cell 0 0");
		formPanel.add(nameTxt, "cell 1 0");
		formPanel.add(typeLabel, "cell 0 1");
		formPanel.add(typeCombo, "cell 1 1");
		formPanel.add(amountLabel, "cell 0 2");
		formPanel.add(amountTxt, "cell 1 2");
		formPanel.add(buttonPanel, "dock south");
		add(formPanel);

	}

	private JPanel buildButtonPanel() {
		JPanel buttonPanel = new JPanel(new MigLayout("", "[center, grow]"));
		saveBtn = new JButton("Save");
		closeBtn = new JButton("Close");
		buttonPanel.add(saveBtn, "");
		buttonPanel.add(closeBtn, "");
		return buttonPanel;
	}

	@Override
	public void closePrompt(PropertyChangeEvent propertyChangeEvent) {
		if (JInternalFrame.IS_CLOSED_PROPERTY.equals(propertyChangeEvent.getPropertyName())) {
			JOptionPane.showConfirmDialog(this, "Are you Sure you want to close the window?");
		}

	}

	public JButton getSaveBtn() {
		return saveBtn;
	}

	public JButton getCloseBtn() {
		return closeBtn;
	}

	public JTextField getNameTxt() {
		return nameTxt;
	}

	public JComboBox<DeductionType> getTypeCombo() {
		return typeCombo;
	}

	public JTextField getAmountTxt() {
		return amountTxt;
	}
	
	

}