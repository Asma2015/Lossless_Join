package myProject.LosslessJoin.Interface;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.SwingConstants;

import myProject.LosslessJoin.Attribute;
import myProject.LosslessJoin.AttributeSet;
import myProject.LosslessJoin.FdsPreservingLoosslessJoinChecker;
import myProject.LosslessJoin.FunctionalDependency;

import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.Icon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.awt.event.ActionEvent;
import javax.swing.JFormattedTextField;
import com.jgoodies.forms.factories.DefaultComponentFactory;
/*
@author Asma Bawazeer
MSc Computer Science
*/
public class LosslessJoin {

	private JFrame frame;
	private JTextField textField_1;
	private JTextField textField;
	private JButton btnClear;
	private JTextField textField_3;
	private JTextField textField_4;
	private JLabel lblPleaseInsertTable;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JLabel lblPleaseInsertFunctional;
	private JLabel lblPleaseInsertFunctional_1;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTextField textField_11;
	private JTextField textField_12;
	private JTextField textField_13;
	private JLabel label_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LosslessJoin window = new LosslessJoin();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public LosslessJoin() {
		initialize();
	}

	////////////
	AttributeSet t1 = new AttributeSet();
	AttributeSet t2 = new AttributeSet();
	AttributeSet t3 = new AttributeSet();
	AttributeSet t4 = new AttributeSet();

	Set<FunctionalDependency> fds = new HashSet<FunctionalDependency>();

	private void intilaizeTheTables() {

		t1.add(new Attribute(textField.getText()));
		t1.add(new Attribute(textField_1.getText()));
		t1.add(new Attribute(textField_3.getText()));
		t1.add(new Attribute(textField_4.getText()));

		t2.add(new Attribute(textField_5.getText()));
		t2.add(new Attribute(textField_6.getText()));
		t2.add(new Attribute(textField_7.getText()));
		t2.add(new Attribute(textField_8.getText()));

		t3.add(new Attribute(textField_9.getText()));
		t3.add(new Attribute(textField_10.getText()));

		t4.add(new Attribute(textField_12.getText()));

		fds.add(new FunctionalDependency(t3, new Attribute(textField_11.getText())));
		fds.add(new FunctionalDependency(t4, new Attribute(textField_13.getText())));

	}

	///////////////
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		frame = new JFrame();
		frame.setBounds(100, 100, 536, 388);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("Lossless Join Property");
		lblNewLabel.setBounds(6, 6, 438, 23);
		lblNewLabel.setForeground(new Color(105, 105, 105));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Palatino", Font.ITALIC, 20));
		frame.getContentPane().add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Please insert table 1 attributes:");
		lblNewLabel_1.setBounds(6, 41, 209, 35);
		lblNewLabel_1.setFont(new Font("Comic Sans MS", Font.BOLD, 13));
		lblNewLabel_1.setForeground(new Color(128, 0, 128));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.LEFT);
		frame.getContentPane().add(lblNewLabel_1);

		textField_1 = new JTextField();
		textField_1.setBackground(new Color(255, 255, 255));
		textField_1.setBounds(214, 48, 39, 21);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);

		JLabel label_11 = new JLabel("");
		label_11.setHorizontalAlignment(SwingConstants.LEFT);
		label_11.setForeground(new Color(128, 0, 128));
		label_11.setFont(new Font("Comic Sans MS", Font.PLAIN, 10));
		label_11.setBounds(217, 200, 172, 23);
		frame.getContentPane().add(label_11);

		textField = new JTextField();
		textField.setBackground(new Color(255, 255, 255));
		textField.setColumns(10);
		textField.setBounds(265, 47, 39, 23);
		frame.getContentPane().add(textField);

		JButton btnCheck = new JButton("Check FD preserving");
		btnCheck.setFont(new Font("Lucida Grande", Font.BOLD, 11));
		btnCheck.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					String str1 = textField.getText();
					String str2 = textField_1.getText();
					if (str1.equals("") || str2.equals("")) {
						JOptionPane.showMessageDialog(frame, "Please enter values!", "Attention!",
								JOptionPane.ERROR_MESSAGE);

					} else {
						intilaizeTheTables();
						boolean FDpreserved = FdsPreservingLoosslessJoinChecker.checkDepPres(t1, t2, fds);

						String result;
						
						if(FDpreserved)
						{
							result="The dependency is preserved";
						}
						else
							result="The dependency is not preserved";
							
							
						label_11.setText(result);

					}
				} catch (Exception t) {
					JOptionPane.showMessageDialog(null, "Please enter values!");

				}

			}

		});
		btnCheck.setForeground(new Color(128, 128, 128));
		btnCheck.setBackground(new Color(192, 192, 192));
		btnCheck.setBounds(6, 201, 209, 29);
		frame.getContentPane().add(btnCheck);

		btnClear = new JButton("Reset");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				textField.setText(null);
				textField_1.setText(null);
				textField_3.setText(null);
				textField_4.setText(null);
				textField_5.setText(null);
				textField_6.setText(null);
				textField_7.setText(null);
				textField_8.setText(null);
				textField_9.setText(null);
				textField_10.setText(null);
				textField_11.setText(null);
				textField_12.setText(null);
				textField_13.setText(null);

				label_2.setText(null);
				label_11.setText(null);

			}
		});

		btnClear.setForeground(Color.GRAY);
		btnClear.setFont(new Font("Lucida Grande", Font.BOLD, 14));
		btnClear.setBackground(Color.LIGHT_GRAY);
		btnClear.setBounds(380, 213, 64, 29);
		frame.getContentPane().add(btnClear);

		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBackground(new Color(255, 255, 255));
		textField_3.setBounds(316, 47, 39, 23);
		frame.getContentPane().add(textField_3);

		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBackground(new Color(255, 255, 255));
		textField_4.setBounds(367, 47, 39, 23);
		frame.getContentPane().add(textField_4);

		lblPleaseInsertTable = new JLabel("Please insert table 2 attributes:");
		lblPleaseInsertTable.setHorizontalAlignment(SwingConstants.LEFT);
		lblPleaseInsertTable.setForeground(new Color(128, 0, 128));
		lblPleaseInsertTable.setFont(new Font("Comic Sans MS", Font.BOLD, 13));
		lblPleaseInsertTable.setBounds(6, 88, 209, 35);
		frame.getContentPane().add(lblPleaseInsertTable);

		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBackground(new Color(255, 255, 255));
		textField_5.setBounds(214, 94, 39, 23);
		frame.getContentPane().add(textField_5);

		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBackground(new Color(255, 255, 255));
		textField_6.setBounds(265, 94, 39, 23);
		frame.getContentPane().add(textField_6);

		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBackground(new Color(255, 255, 255));
		textField_7.setBounds(316, 94, 39, 23);
		frame.getContentPane().add(textField_7);

		textField_8 = new JTextField();
		textField_8.setColumns(10);
		textField_8.setBackground(new Color(255, 255, 255));
		textField_8.setBounds(367, 94, 39, 23);
		frame.getContentPane().add(textField_8);

		lblPleaseInsertFunctional = new JLabel("Please insert functional dependency 1:");
		lblPleaseInsertFunctional.setHorizontalAlignment(SwingConstants.LEFT);
		lblPleaseInsertFunctional.setForeground(new Color(128, 0, 128));
		lblPleaseInsertFunctional.setFont(new Font("Comic Sans MS", Font.BOLD, 13));
		lblPleaseInsertFunctional.setBounds(6, 122, 247, 35);
		frame.getContentPane().add(lblPleaseInsertFunctional);

		lblPleaseInsertFunctional_1 = new JLabel("Please insert functional dependency 2:");
		lblPleaseInsertFunctional_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblPleaseInsertFunctional_1.setForeground(new Color(128, 0, 128));
		lblPleaseInsertFunctional_1.setFont(new Font("Comic Sans MS", Font.BOLD, 13));
		lblPleaseInsertFunctional_1.setBounds(6, 154, 247, 35);
		frame.getContentPane().add(lblPleaseInsertFunctional_1);

		textField_9 = new JTextField();
		textField_9.setColumns(10);
		textField_9.setBackground(new Color(255, 255, 255));
		textField_9.setBounds(265, 127, 39, 23);
		frame.getContentPane().add(textField_9);

		textField_10 = new JTextField();
		textField_10.setColumns(10);
		textField_10.setBackground(new Color(255, 255, 255));
		textField_10.setBounds(316, 129, 39, 23);
		frame.getContentPane().add(textField_10);

		textField_11 = new JTextField();
		textField_11.setColumns(10);
		textField_11.setBackground(new Color(255, 255, 255));
		textField_11.setBounds(377, 128, 39, 23);
		frame.getContentPane().add(textField_11);

		textField_12 = new JTextField();
		textField_12.setColumns(10);
		textField_12.setBackground(new Color(255, 255, 255));
		textField_12.setBounds(265, 159, 39, 23);
		frame.getContentPane().add(textField_12);

		textField_13 = new JTextField();
		textField_13.setColumns(10);
		textField_13.setBackground(new Color(255, 255, 255));
		textField_13.setBounds(326, 160, 39, 23);
		frame.getContentPane().add(textField_13);

		JLabel label = DefaultComponentFactory.getInstance().createLabel("-->");
		label.setBounds(305, 164, 26, 16);
		frame.getContentPane().add(label);

		JLabel label_1 = DefaultComponentFactory.getInstance().createLabel("-->");
		label_1.setBounds(352, 132, 26, 16);
		frame.getContentPane().add(label_1);

		JButton btnCheckLosslessDecomposition = new JButton("Check lossless decomposition");
		btnCheckLosslessDecomposition.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String str1 = textField.getText();
					String str2 = textField_1.getText();
					if (str1.equals("") || str2.equals("")) {
						JOptionPane.showMessageDialog(frame, "Please enter values!", "Attention!",
								JOptionPane.ERROR_MESSAGE);

					} else {
						intilaizeTheTables();
						boolean lossless = FdsPreservingLoosslessJoinChecker.checkLossless(t1, t2, fds);
						String result;

						if (lossless) {
							result = "The decomposition is lossless";
						} else
							result = "The decomposition is lossy";

						label_2.setText(result);

					}
				} catch (Exception t) {
					JOptionPane.showMessageDialog(null, "Please enter values!");

				}

			}
		});
		btnCheckLosslessDecomposition.setForeground(Color.GRAY);
		btnCheckLosslessDecomposition.setFont(new Font("Lucida Grande", Font.BOLD, 11));
		btnCheckLosslessDecomposition.setBackground(Color.LIGHT_GRAY);
		btnCheckLosslessDecomposition.setBounds(6, 228, 209, 29);
		frame.getContentPane().add(btnCheckLosslessDecomposition);

		label_2 = new JLabel("");
		label_2.setHorizontalAlignment(SwingConstants.LEFT);
		label_2.setForeground(new Color(128, 0, 128));
		label_2.setFont(new Font("Comic Sans MS", Font.PLAIN, 10));
		label_2.setBounds(214, 227, 151, 23);
		frame.getContentPane().add(label_2);
	}
}
