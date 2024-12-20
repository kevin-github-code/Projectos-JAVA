package sumativa2;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.*;
import javax.swing.*;
import javax.swing.JTextField;

import java.awt.BorderLayout;

public class EquacaoQuadratica extends JFrame implements ActionListener{
	
	private JPanel contentPane;
	private JTextField txtB;
	private JTextField txtA;
	private JTextField txtC;
	private JTextField txtDelta;
	private JTextField txtX1;
	private JTextField txtX2;
	private javax.swing.JLabel JLabel;
	JButton btnCalcular, btnLimpar;
	
	public static void main(String[] args) {
		EquacaoQuadratica frame = new EquacaoQuadratica();		
		frame.setVisible(true);
	}
	public EquacaoQuadratica(){
		setBackground(Color.CYAN);
		setFont(new Font("Dialog", Font. BOLD, 14));
		setTitle("EquacaoQuadratica");		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 521, 433);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		JPanel panel = new JPanel();
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"),
		"Dados de Entrada", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 11, 274, 155);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblValor = new JLabel("Valor A ");
		lblValor.setBounds(23, 38, 55, 27);
		panel.add(lblValor);
		JLabel lblValorB = new JLabel("Valor в ");
		lblValorB.setBounds (23, 76, 36, 27);
		panel.add(lblValorB);
		JLabel lblValorC = new JLabel("Valor с");
		lblValorC.setBounds (23, 114, 46, 27);
		panel.add(lblValorC);
		txtB = new JTextField(); 
		txtB.setBounds(88, 79, 86, 20);
		panel.add(txtB); txtB.setColumns(10);
		
		txtA= new JTextField(); 
		txtA.setColumns(10); 
		txtA.setBounds(88, 41, 86, 20); 
		panel.add(txtA);
		
		txtC = new JTextField();
		txtC.setColumns(10);
		txtC.setBounds(88, 117, 86, 20);
		panel.add(txtC);
		
		JPanel panel_1 = new JPanel(); 
		panel_1.setBackground(Color.LIGHT_GRAY);
		panel_1.setBorder(new TitledBorder (UIManager.getBorder("TitledBorder.border"),						
		"Opera\u00E7\u00F5es", TitledBorder.LEADING, TitledBorder. TOP, null, null));
		panel_1.setBounds(294, 11, 201, 106);
		btnCalcular = new JButton("CALCULAR");		
		btnCalcular.setBounds(23, 38, 100, 27);
		btnCalcular.addActionListener(this);
		panel_1.add(btnCalcular);
		
		btnLimpar = new JButton("LIMPAR");		
		btnLimpar.setBounds(48, 70, 100, 27);
		btnLimpar.addActionListener(this);
		panel_1.add(btnLimpar);
		
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JPanel panel_3 = new JPanel(); 
		panel_3.setBackground(Color.LIGHT_GRAY);
		panel_3.setBorder(new TitledBorder (UIManager.getBorder("TitledBorder.border"),						
		"Resultados", TitledBorder.LEADING, TitledBorder. TOP, null, null));
		panel_3.setBounds(10, 180, 274, 155);
		
		JLabel lbld = new JLabel("Valor Delta ");
		lbld.setBounds(23, 38, 55, 27);
		panel_3.add(lbld);
		txtDelta= new JTextField(); 
		txtDelta.setColumns(10); 
		txtDelta.setBounds(88, 41, 86, 20); 
		panel_3.add(txtDelta);
		
		JLabel lblx1 = new JLabel("Valor X1 ");
		lblx1.setBounds(23, 76, 50, 27);
		panel_3.add(lblx1);
		txtX1= new JTextField(); 
		txtX1.setColumns(10); 
		txtX1.setBounds(88, 82, 86, 20); 
		panel_3.add(txtX1);
		
		JLabel lblx3 = new JLabel("Valor X2 ");
		lblx3.setBounds(23, 120, 50, 27);
		panel_3.add(lblx3);
		txtX2 = new JTextField(); 
		txtX2.setColumns(10); 
		txtX2.setBounds(88, 120, 86, 20); 
		panel_3.add(txtX2);
		
		contentPane.add(panel_3);
		panel_3.setLayout(null);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == btnCalcular){
			double a = Double.parseDouble(txtA.getText());
			double b = Double.parseDouble(txtB.getText());
			double c = Double.parseDouble(txtC.getText());
			double delta = b*b -4*a*c;
			txtDelta.setText(delta + "");
			double x1 = (-b + Math.sqrt(delta)) / 2*a;
			double x2 = (-b - Math.sqrt(delta)) / 2*a;
			if(delta > 0) {
			JOptionPane.showMessageDialog(null, "Duas Raízes reais e difetentes.");
			txtX1.setText(x1 + "");
			txtX2.setText(x2 + "");
			}
			else if(delta == 0){
			JOptionPane.showMessageDialog(null, "Raízes iguais.");
			txtX1.setText(x1 + "");
			txtX2.setText(x2 + "");
			}
			else{
			JOptionPane.showMessageDialog(null, "Nao tem Raízes reais.");
			txtX1.setText(x1 + "");
			txtX2.setText(x2 + "");
			}
		}
		if(e.getSource() == btnLimpar){
			txtA.setText("");
			txtB.setText("");
			txtC.setText("");
			txtDelta.setText("");
			txtX1.setText("");			
			txtX2.setText("");
			}
	}
	
}

