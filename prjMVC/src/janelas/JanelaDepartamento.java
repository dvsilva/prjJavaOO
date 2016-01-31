package janelas;

import controle.ICtrlManterDepartamentos;

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

public class JanelaDepartamento extends JFrame implements IDepartamento {
	//
	// ATRIBUTOS
	//
	/**
	 * Referência para o controlador do caso de uso
	 */
	private ICtrlManterDepartamentos ctrl;
	/**
	 * Indica se estou fazendo uma operação de inclusão ou 
	 * alteração
	 */
	private boolean ehAlteração;
	
	private JPanel contentPane;
	private JTextField tfSigla;
	private JTextField tfNome;

	/**
	 * Create the frame.
	 */
	public JanelaDepartamento(ICtrlManterDepartamentos ct) {
		this.ctrl = ct;
		setTitle("Departamento");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 178);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblSigla = new JLabel("Sigla:");
		lblSigla.setBounds(20, 11, 46, 14);
		contentPane.add(lblSigla);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(20, 48, 46, 14);
		contentPane.add(lblNome);
		
		tfSigla = new JTextField();
		tfSigla.setBounds(76, 8, 86, 20);
		contentPane.add(tfSigla);
		tfSigla.setColumns(10);
		
		tfNome = new JTextField();
		tfNome.setBounds(76, 45, 334, 20);
		contentPane.add(tfNome);
		tfNome.setColumns(10);
		
		JButton btnOk = new JButton("Ok");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// Recupero os valores digitados nos textfields
				String sigla = tfSigla.getText();
				String nome = tfNome.getText();
				// Verifico qual é a operação que estou fazendo
				// e notifico ao controlador
				if(!ehAlteração)
					ctrl.incluir(sigla, nome);
				else
					ctrl.alterar(sigla, nome);
			}
		});
		btnOk.setBounds(73, 95, 143, 23);
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
		btnCancelar.setBounds(256, 95, 154, 23);
		contentPane.add(btnCancelar);
		
		this.setVisible(true);
	}

	/* (non-Javadoc)
	 * @see janelas.IDepartamento#atualizarCampos(java.lang.String, java.lang.String)
	 */
	@Override
	public void atualizarCampos(String sigla, String nome) {
		this.tfSigla.setText(sigla);
		this.tfNome.setText(nome);
		this.ehAlteração = true;
	}
}
