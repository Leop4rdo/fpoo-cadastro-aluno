package br.senai.sp.jandira.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;

import br.senai.sp.jandira.model.Aluno;
import br.senai.sp.jandira.model.Periodos;
import br.senai.sp.jandira.repository.AlunoRepository;

import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class FrameCadastroAlunos extends JFrame {
	private JPanel contentPane;
	private JTextField txtMatricula;
	private JTextField txtNome;
	
	private DefaultListModel<String> modelAlunos;
	
	private AlunoRepository turma;

	private int posicao;
	
	/**
	 * Create the frame. {} []
	 */
	public FrameCadastroAlunos() {
		turma = new AlunoRepository();
		modelAlunos = new DefaultListModel<String>();
		
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
		
		JComboBox<String> comboPeriodo = new JComboBox<String>();
		DefaultComboBoxModel<String> modelPeriodo = new DefaultComboBoxModel<String>();
		
		for (Periodos periodo : Periodos.values()) {
			modelPeriodo.addElement(periodo.getDescricao());
		}
		
		comboPeriodo.setModel(modelPeriodo);
		comboPeriodo.setBounds(71, 70, 110, 22);
		contentPane.add(comboPeriodo);
		
		JButton btnSalvar = new JButton("Salvar Aluno");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Aluno aluno = new Aluno();
				aluno.setMatricula(txtMatricula.getText());
				aluno.setNome(txtNome.getText());
				// aluno.setPeriodo(Periodos.getValueWithDescricao(modelPeriodo.getSelectedItem().toString()));
				aluno.setPeriodo(Periodos.values()[comboPeriodo.getSelectedIndex()]);
				
				turma.gravar(aluno, posicao);
				posicao++;
				
				modelAlunos.addElement(aluno.getNome());
				
				if (posicao >= turma.getTamanho()) {
					btnSalvar.setEnabled(false);
					btnSalvar.setBackground(Color.LIGHT_GRAY);
					
					JOptionPane.showMessageDialog(null, "turma preenchida completamente!", 
								"Turma Preenchida", JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		btnSalvar.setBackground(new Color(0, 204, 102));
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
		listAlunos.setModel(modelAlunos);
		listAlunos.addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {
				Aluno aluno = turma.listarAluno(listAlunos.getSelectedIndex());
				
				txtNome.setText(aluno.getNome());
				txtMatricula.setText(aluno.getMatricula());
				comboPeriodo.setSelectedIndex(aluno.getPeriodo().ordinal());
			}
		});
		scrollPaneOfListAlunos.setViewportView(listAlunos);
	}
}