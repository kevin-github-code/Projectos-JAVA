package ab;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.*;
import java.awt.*;
import javax.swing.JFrame;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class ViewEstudante extends JFrame implements ActionListener, MouseListener{
	private JPanel contentPane;
	private JTextField txtCodigo;
	private JTextField txtNome;
	private JTextField txtTeste1;
	private JTextField txtTeste2;
	private javax.swing.JLabel JLabel;
	JButton btnAdicionar, btnListar, btnActualizar, btnRemover, btnNovo, btnCancelar;
	private JTable table;
	
	public ViewEstudante() {
	    setTitle("Dados do Estudante");
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    setLayout(new BorderLayout()); // Consider using appropriate layout managers

	    setBackground(Color.CYAN);
		setFont(new Font("Dialog", Font. BOLD, 14));
		setTitle("ESTUDANTES");		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 200, 700, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"),
		"DADOS DO ESTUDANTE", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 10, 320, 200);
		contentPane.add(panel);
		panel.setLayout(null);

		
		JLabel lblValor = new JLabel("CODIGO: ");
		lblValor.setBounds(23, 38, 70, 27);
		panel.add(lblValor);
		JLabel lblValorB = new JLabel("NOME: ");
		lblValorB.setBounds (23, 76, 70, 27);
		panel.add(lblValorB);
		JLabel lblValorC = new JLabel("TESTE 1: ");
		lblValorC.setBounds (23, 114, 70, 27);
		panel.add(lblValorC);
		
		JLabel lblValorD = new JLabel("TESTE 2 ");
		lblValorD.setBounds (23, 150, 70, 27);
		panel.add(lblValorD);
		
		txtCodigo = new JTextField(); 
		txtCodigo.setBounds(88, 49, 86, 20);
		panel.add(txtCodigo); txtCodigo.setColumns(10);
		
		txtNome= new JTextField(); 
		txtNome.setColumns(10); 
		txtNome.setBounds(88, 79, 86, 20); 
		panel.add(txtNome);
		
		txtTeste1 = new JTextField();
		txtTeste1.setColumns(10);
		txtTeste1.setBounds(88, 117, 86, 20);
		panel.add(txtTeste1);
		
		txtTeste2 = new JTextField();
		txtTeste2.setColumns(10);
		txtTeste2.setBounds(88, 150, 86, 20);
		panel.add(txtTeste2);
		
		JPanel panel_1 = new JPanel(); 
		panel_1.setBackground(Color.LIGHT_GRAY);
		panel_1.setBorder(new TitledBorder (UIManager.getBorder("TitledBorder.border"),						
		"Opera\u00E7\u00F5es", TitledBorder.LEADING, TitledBorder. TOP, null, null));
		panel_1.setBounds(350, 10, 320, 200);
		btnAdicionar = new JButton("ADICIONAR");		
		btnAdicionar.setBounds(20, 30, 100, 30);
		btnAdicionar.addActionListener(this);
		panel_1.add(btnAdicionar);
		
		btnListar = new JButton("LISTAR");		
		btnListar.setBounds(20, 70, 100, 30);
		btnListar.addActionListener(this);
		panel_1.add(btnListar);
		
		btnActualizar = new JButton("ACTUALIZAR");		
		btnActualizar.setBounds(20, 110, 100, 30);
		btnActualizar.addActionListener(this);
		panel_1.add(btnActualizar);
		
		btnRemover = new JButton("REMOVER");		
		btnRemover.setBounds(150, 30, 100, 30);
		btnRemover.addActionListener(this);
		panel_1.add(btnRemover);
		
		btnNovo = new JButton("NOVO");		
		btnNovo.setBounds(150, 70, 100, 30);
		btnNovo.addActionListener(this);
		panel_1.add(btnNovo);
		
		btnCancelar = new JButton("CANCELAR");		
		btnCancelar.setBounds(150, 110, 100, 30);
		btnCancelar.addActionListener(this);
		panel_1.add(btnCancelar);
		
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(10, 229, 631, 159);
		contentPane.add(panel_2);
		panel_2.setLayout(new BorderLayout(0, 0));
		JScrollPane scrollPane = new JScrollPane(); panel_2.add(scrollPane, BorderLayout.CENTER);
		table = new JTable();
		table.setModel(new DefaultTableModel(
		new Object[][] {
		{null, null, null, null, null}, {null, null, null, null, null},
		},
		new String[] {
		"CODIGO", "NOME", "TESTE 1", "TESTE 2", "M\u00C9DIA" }
		));
		table.getColumnModel().getColumn(1).setPreferredWidth(126); table.addMouseListener(this);
		scrollPane.setViewportView(table);
	    
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == btnAdicionar){
			int codigo = Integer.parseInt(txtCodigo.getText());
			String nome = txtNome.getText();
			double teste1 = Double.parseDouble(txtTeste1.getText());
			double teste2 = Double.parseDouble(txtTeste2.getText());
			try {
			ControllerEstudante.adicionarEstudante (codigo, nome, teste1, teste2);
			limpar();
			JOptionPane.showMessageDialog(null, "adicionado com sucesso.");
				} catch (ClassNotFoundException | SQLException e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage()); e1.printStackTrace();
				}
			}
		if(e.getSource() == btnListar){
			limparTabela();
			listar();
		}
		if(e.getSource() == btnNovo){
			incrementarCodigo();
		}
		if(e.getSource() == btnActualizar){
			int codigo = Integer.parseInt(txtCodigo.getText());
			String nome = txtNome.getText();
			double teste1 = Double.parseDouble(txtTeste1.getText());
			double teste2 = Double.parseDouble(txtTeste2.getText());
			try {
			ControllerEstudante.actualizar (codigo, nome, teste1, teste2);
			JOptionPane.showMessageDialog(null, "atualizado com sucesso."); 
			limparTabela();
			limpar();
			listar();
			} catch (ClassNotFoundException | SQLException e1) {
				JOptionPane.showMessageDialog(null, e1.getMessage());
				e1.printStackTrace();
			}
		}
		if(e.getSource()== btnRemover) {
			int codigo = Integer.parseInt(txtCodigo.getText());
			try {
				ControllerEstudante.removerEstudante(codigo);
				JOptionPane.showMessageDialog(null,  "removido com sucesso");
				limparTabela();
				limpar();
				listar();
			} catch (ClassNotFoundException | SQLException e1) {
				JOptionPane.showMessageDialog(null, e1.getMessage());
				e1.printStackTrace();
			}
		}
				
				
			
		
	}
	public void listar(){
		DefaultTableModel lista = (DefaultTableModel) table.getModel();
		try {
			ArrayList <Estudante> estudantes = ControllerEstudante.listaDeEstudantes();
			for (Estudante estudante: estudantes) {
			lista.addRow(new Object[]{
			estudante.getCodigo(),
			estudante.getNome(),
			estudante.getTeste1(),
			estudante.getTeste2(),
			estudante.calculaMedia(),
			});
		}
		} catch (ClassNotFoundException | SQLException e) {
		e.printStackTrace();
		}
	}
	public void limpar(){
		txtCodigo.setText("");
		txtNome.setText("");
		txtTeste1.setText("");
		txtTeste2.setText("");
	}
		
	public void limparTabela(){
		while((table.getRowCount() > 0)){
		((DefaultTableModel) table.getModel()).removeRow(0);
		}
	}
	
	public void incrementarCodigo(){
		try {
			ArrayList <Estudante> estudantes = ControllerEstudante.listaDeEstudantes();
			for (Estudante estudante: estudantes) {
			txtCodigo.setText(estudante.getCodigo()+1+"");
			txtCodigo.disable();
			}
		} catch (ClassNotFoundException | SQLException e) {
		e.printStackTrace();
		}
	}
	@Override
	public void mouseClicked (MouseEvent e) {
		if(table.getSelectedRow() != -1){
			int indice = table.getSelectedRow();
			TableModel modelo = table.getModel();
			txtCodigo.setText(modelo.getValueAt(indice, 0).toString());
			txtNome.setText(modelo.getValueAt(indice, 1).toString());		
			txtTeste1.setText(modelo.getValueAt(indice, 2).toString()); 
			txtTeste2.setText(modelo.getValueAt(indice, 3).toString());
		}
	}
		
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
