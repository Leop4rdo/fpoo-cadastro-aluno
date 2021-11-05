package br.senai.sp.jandira.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import br.senai.sp.jandira.model.Periodos;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JList;

public class FrameCadastroAlunos extends JFrame {
	private JPanel contentPane;
	private JTextField txtMatricula;
	private JTextField txtNome;

	/**
	 * Create the frame.
	 */
	public FrameCadastroAlunos() {
		setTitle("Cadastro de Alunos");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblMatricula = new JLabel("Matricula:");
		lblMatricula.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblMatricula.setBounds(10, 11, 51, 14);
		contentPane.add(lblMatricula);
		
		txtMatricula = new JTextField();
		txtMatricula.setBounds(71, 9, 110, 20);
		contentPane.add(txtMatricula);
		txtMatricula.setColumns(10);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNome.setBounds(10, 42, 51, 14);
		contentPane.add(lblNome);
		
		txtNome = new JTextField();
		txtNome.setColumns(10);
		txtNome.setBounds(71, 40, 110, 20);
		contentPane.add(txtNome);
		
		JLabel lblPeriodo = new JLabel("Periodo:");
		lblPeriodo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblPeriodo.setBounds(10, 73, 51, 14);
		contentPane.add(lblPeriodo);
		
		JComboBox comboPeriodo = new JComboBox();
		comboPeriodo.setModel(new DefaultComboBoxModel(Periodos.values()));
		comboPeriodo.setBounds(71, 70, 110, 22);
		contentPane.add(comboPeriodo);
		
		JButton btnSalvar = new JButton("Salvar Aluno");
		btnSalvar.setBounds(10, 210, 171, 40);
		contentPane.add(btnSalvar);
		
		JLabel lblListaDeAlunos = new JLabel("Lista de Alunos:");
		lblListaDeAlunos.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblListaDeAlunos.setBounds(234, 12, 86, 14);
		contentPane.add(lblListaDeAlunos);
		
		JScrollPane scrollPaneOfListAlunos = new JScrollPane();
		scrollPaneOfListAlunos.setBounds(234, 42, 190, 208);
		contentPane.add(scrollPaneOfListAlunos);
		
		JList listAlunos = new JList();
		scrollPaneOfListAlunos.setViewportView(listAlunos);
	}
}
