import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.core.GridLayoutManager;
import com.intellij.uiDesigner.core.Spacer;

import javax.swing.*;
import java.awt.*;

public class DevicePane {

	public JComboBox selectionComboBox;

	public JButton programButton;

	public JButton resetButton;

	public JButton readMACButton;

	public JButton writeMACButton;

	public JProgressBar progressBar;

	public JTextField sendTextField;

	public JScrollPane outputScrollPane;

	public JTextArea outputTextArea;

	public JButton sendButton;

	public JPanel contentPane;

	public JLabel statusLabel;

	public JButton clearOutputButton;

	public JCheckBox wrapLinesCheckBox;

	public JCheckBox replaceNonPrintableCharactersCheckBox;

	public JLabel deviceOutputLabel;

	public void setDeviceControlsEnabled(boolean enabled) {
		programButton.setEnabled(enabled);
		resetButton.setEnabled(enabled);
		readMACButton.setEnabled(enabled);
		writeMACButton.setEnabled(enabled);
		outputTextArea.setEnabled(enabled);
		sendButton.setEnabled(enabled);
		sendTextField.setEnabled(enabled);
	}

	public void setStatusText(final String statusText) {
		statusLabel.setText(statusText);
	}

	{
// GUI initializer generated by IntelliJ IDEA GUI Designer
// >>> IMPORTANT!! <<<
// DO NOT EDIT OR ADD ANY CODE HERE!
		$$$setupUI$$$();
	}

	/**
	 * Method generated by IntelliJ IDEA GUI Designer
	 * >>> IMPORTANT!! <<<
	 * DO NOT edit this method OR call it in your code!
	 *
	 * @noinspection ALL
	 */
	private void $$$setupUI$$$() {
		contentPane = new JPanel();
		contentPane.setLayout(new GridLayoutManager(6, 3, new Insets(5, 5, 5, 5), -1, -1));
		final JPanel panel1 = new JPanel();
		panel1.setLayout(new GridLayoutManager(2, 2, new Insets(0, 0, 0, 0), -1, -1));
		contentPane.add(panel1,
				new GridConstraints(0, 1, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE,
						GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false
				)
		);
		programButton = new JButton();
		programButton.setText("program");
		panel1.add(programButton,
				new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL,
						GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
						GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false
				)
		);
		readMACButton = new JButton();
		readMACButton.setText("read MAC");
		panel1.add(readMACButton,
				new GridConstraints(1, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL,
						GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
						GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false
				)
		);
		resetButton = new JButton();
		resetButton.setText("reset");
		panel1.add(resetButton,
				new GridConstraints(0, 1, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL,
						GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
						GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false
				)
		);
		writeMACButton = new JButton();
		writeMACButton.setText("write MAC");
		panel1.add(writeMACButton,
				new GridConstraints(1, 1, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL,
						GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
						GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false
				)
		);
		outputScrollPane = new JScrollPane();
		outputScrollPane.setVerticalScrollBarPolicy(22);
		outputScrollPane.putClientProperty("html.disable", Boolean.TRUE);
		contentPane.add(outputScrollPane,
				new GridConstraints(4, 0, 1, 2, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH,
						GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_WANT_GROW,
						GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_WANT_GROW, null,
						new Dimension(600, 200), null, 0, false
				)
		);
		outputTextArea = new JTextArea();
		outputTextArea.setEditable(false);
		outputTextArea.setEnabled(true);
		outputTextArea.setLineWrap(true);
		outputScrollPane.setViewportView(outputTextArea);
		final JPanel panel2 = new JPanel();
		panel2.setLayout(new GridLayoutManager(1, 2, new Insets(0, 0, 0, 0), -1, -1));
		contentPane.add(panel2,
				new GridConstraints(1, 0, 1, 2, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH,
						GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
						GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null,
						0, false
				)
		);
		sendTextField = new JTextField();
		panel2.add(sendTextField,
				new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL,
						GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null,
						new Dimension(150, -1), null, 0, false
				)
		);
		sendButton = new JButton();
		sendButton.setText("send");
		panel2.add(sendButton,
				new GridConstraints(0, 1, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL,
						GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
						GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false
				)
		);
		selectionComboBox = new JComboBox();
		contentPane.add(selectionComboBox,
				new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL,
						GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0,
						false
				)
		);
		final JPanel panel3 = new JPanel();
		panel3.setLayout(new GridLayoutManager(2, 2, new Insets(5, 5, 5, 5), -1, -1));
		contentPane.add(panel3,
				new GridConstraints(5, 0, 1, 2, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH,
						GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
						GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null,
						0, false
				)
		);
		progressBar = new JProgressBar();
		progressBar.setBorderPainted(true);
		progressBar.setEnabled(true);
		progressBar.setStringPainted(true);
		panel3.add(progressBar,
				new GridConstraints(0, 1, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL,
						GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0,
						false
				)
		);
		statusLabel = new JLabel();
		statusLabel.setText("");
		panel3.add(statusLabel, new GridConstraints(1, 0, 1, 2, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE,
				GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_WANT_GROW,
				GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false
		)
		);
		final JLabel label1 = new JLabel();
		label1.setText("Operation progress:");
		panel3.add(label1, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE,
				GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false
		)
		);
		final JPanel panel4 = new JPanel();
		panel4.setLayout(new GridLayoutManager(1, 5, new Insets(0, 0, 0, 0), -1, -1));
		contentPane.add(panel4,
				new GridConstraints(3, 0, 1, 2, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH,
						GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
						GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null,
						0, false
				)
		);
		deviceOutputLabel = new JLabel();
		deviceOutputLabel.setText("Device Output");
		panel4.add(deviceOutputLabel,
				new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE,
						GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false
				)
		);
		clearOutputButton = new JButton();
		clearOutputButton.setText("Clear");
		panel4.add(clearOutputButton,
				new GridConstraints(0, 4, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL,
						GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
						GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false
				)
		);
		wrapLinesCheckBox = new JCheckBox();
		wrapLinesCheckBox.setSelected(true);
		wrapLinesCheckBox.setText("Wrap Lines");
		panel4.add(wrapLinesCheckBox,
				new GridConstraints(0, 3, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE,
						GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
						GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false
				)
		);
		replaceNonPrintableCharactersCheckBox = new JCheckBox();
		replaceNonPrintableCharactersCheckBox.setSelected(true);
		replaceNonPrintableCharactersCheckBox.setText("Replace non-printable Characters");
		panel4.add(replaceNonPrintableCharactersCheckBox,
				new GridConstraints(0, 2, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE,
						GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
						GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false
				)
		);
		final Spacer spacer1 = new Spacer();
		panel4.add(spacer1,
				new GridConstraints(0, 1, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL,
						GridConstraints.SIZEPOLICY_WANT_GROW, 1, null, null, null, 0, false
				)
		);
		final JSeparator separator1 = new JSeparator();
		contentPane.add(separator1,
				new GridConstraints(2, 0, 1, 2, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH,
						GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0,
						false
				)
		);
	}

	/**
	 * @noinspection ALL
	 */
	public JComponent $$$getRootComponent$$$() {
		return contentPane;
	}
}
