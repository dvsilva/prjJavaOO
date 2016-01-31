package janelas;

import controle.ICtrlManterEmpregados;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.SwingConstants;

public class JanelaEmpregado extends JFrame implements IEmpregado {
	//
	// ATRIBUTOS
	//
	/**
	 * Referência para o controlador do caso de uso
	 */
	private ICtrlManterEmpregados ctrl;
	/**
	 * Indica se estou fazendo uma operação de inclusão ou 
	 * alteração
	 */
	private boolean ehAlteração;
	
	private JPanel contentPane;
	private JTextField tfCpf;
	private JTextField tfNome;
	private JComboBox  cbDeptos;
	
	/**
	 * Create the frame.
	 */
	public JanelaEmpregado(ICtrlManterEmpregados ct, Object[] deptos) {
		this.ctrl = ct;
		setTitle("Empregado");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 211);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCpf = new JLabel("Cpf:");
		lblCpf.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCpf.setBounds(42, 14, 46, 14);
		contentPane.add(lblCpf);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNome.setBounds(42, 51, 46, 14);
		contentPane.add(lblNome);
		
		tfCpf = new JTextField();
		tfCpf.setBounds(98, 11, 86, 20);
		contentPane.add(tfCpf);
		tfCpf.setColumns(10);
		
		tfNome = new JTextField();
		tfNome.setBounds(98, 48, 334, 20);
		contentPane.add(tfNome);
		tfNome.setColumns(10);
		
		JButton btnOk = new JButton("Ok");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// Recupero os valores digitados nos textfields
				String cpf = tfCpf.getText();
				String nome = tfNome.getText();
				Object depto = cbDeptos.getSelectedItem();
				// Verifico qual é a operação que estou fazendo
				// e notifico ao controlador
				if(!ehAlteração)
					ctrl.incluir(cpf, nome, depto);
				else
					ctrl.alterar(cpf, nome, depto);
			}
		});
		btnOk.setBounds(73, 130, 143, 23);
		contentPane.add(btnOk);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(!ehAlteração)
					ctrl.cancelarIncluir();
				else
					ctrl.cancelarAlterar();
			}
		});
		btnCancelar.setBounds(256, 130, 154, 23);
		contentPane.add(btnCancelar);
		
		JLabel lblDepartamento = new JLabel("Departamento:");
		lblDepartamento.setBounds(20, 91, 80, 14);
		contentPane.add(lblDepartamento);
		
		cbDeptos = new JComboBox();
		cbDeptos.setBounds(99, 88, 292, 20);
		contentPane.add(cbDeptos);
		//
		// Adicionando os deptos na combobox
		//
		for(Object o : deptos)
			if(o != null)
				cbDeptos.addItem(o);
		this.setVisible(true);
	}

	/* (non-Javadoc)
	 * @see janelas.IEmpregado#atualizarCampos(java.lang.String, java.lang.String, java.lang.Object)
	 */
	@Override
	public void atualizarCampos(String cpf, String nome, Object depto) {
		this.tfCpf.setText(cpf);
		this.tfNome.setText(nome);
		this.cbDeptos.setSelectedItem(depto);
		this.ehAlteração = true;
	}
}
