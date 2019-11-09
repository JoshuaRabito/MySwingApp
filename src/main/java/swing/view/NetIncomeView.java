package swing.view;

import java.beans.PropertyChangeEvent;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import net.miginfocom.swing.MigLayout;
import swing.api.AccountType;
import swing.api.Closeable;
import swing.api.DeductionType;

public class NetIncomeView extends JInternalFrame implements Closeable{

    private JComboBox<AccountType> accountTypeCombo;
	private JTextField amountText;
	private JList<DeductionType> deductionList;
	private JButton deductBtn;
	private JButton clearBtn;
	private JButton calcBtn;

	public NetIncomeView() {
        init();

    }

    private void init() {
        setTitle("Money Manager 1.0");
        setVisible(true);
        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setSize(700, 700);

        
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        addVetoableChangeListener(this::closePrompt);
        buildForm();
    }

    @Override
    public void closePrompt(PropertyChangeEvent propertyChangeEvent) {
        if(JInternalFrame.IS_CLOSED_PROPERTY.equals(propertyChangeEvent.getPropertyName())) {
            JOptionPane.showConfirmDialog(this, "Are you Sure you want to close the window?");

        }

    }

    private void buildForm() {
        JLabel greetinglbl = new JLabel("Lets Manage some money!");
        JLabel accountTypeLbl = new JLabel("Account Type");
        accountTypeCombo = new JComboBox<>();
        JLabel payAmountLbl = new JLabel("Pay amount:");
        amountText = new JTextField(6);
        amountText.setEditable(true);
        JLabel dedctionLbl = new JLabel("Deductions");
        deductionList = new JList<>();
        deductBtn = new JButton("Add deduction");
        clearBtn = new JButton("Clear");
        calcBtn = new JButton("Calculate");

        //build panels for form and buttons
        JPanel formPanel = new JPanel(new MigLayout());   
        JPanel buttonPanel = new JPanel(new MigLayout("", "[center, grow]"));
        buttonPanel.add(clearBtn, "");
        buttonPanel.add(calcBtn, "");
        
        
        formPanel.add(greetinglbl, "cell 0 0");
        formPanel.add(accountTypeLbl, "cell 0 1");
        formPanel.add(accountTypeCombo, "cell 1 1");
        formPanel.add(payAmountLbl, "cell 0 2");
        formPanel.add(amountText, "cell 1 2");
        formPanel.add(dedctionLbl, "cell 0 3");
//        formPanel.add(deductionList, "cell 1 3");
        formPanel.add(deductBtn, "cell 1 3");
        formPanel.add(buttonPanel, "dock south");
        add(formPanel);
        
    }

	public JComboBox<AccountType> getAccountTypeCombo() {
		return accountTypeCombo;
	}

	public JList<DeductionType> getDeductionList() {
		return deductionList;
	}

	public JButton getDeductBtn() {
		return deductBtn;
	}

	public JButton getClearBtn() {
		return clearBtn;
	}

	public JButton getCalcBtn() {
		return calcBtn;
	}
	 
}