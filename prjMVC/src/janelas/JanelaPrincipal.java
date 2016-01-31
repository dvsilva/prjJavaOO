package janelas;

import java.awt.BorderLayout;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

import controle.CtrlPrograma;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * Classe que implementa a janela principal do sistema
 * @author Alessandro Cerqueira
 */
public class JanelaPrincipal extends JFrame {

	//
	// ATRIBUTOS
	//
	
	/**
	 * Referência para o painel de conteúdo da janela
	 */
	private JPanel contentPane;
	/**
	 * Referência para o controlador do programa a quem a janela
	 * principal irá sempre mandar a notificação.
	 */
	private CtrlPrograma ctrlPrg;
	
	//
	// MÉTODOS
	//
	/**
	 * Create the frame.
	 */
	public JanelaPrincipal(CtrlPrograma p) {
		this.ctrlPrg = p;
		setTitle("Principal");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 420, 150);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnDepartamentos = new JButton("Departamentos");
		btnDepartamentos.addActionListener(new ActionListener() {
			// Método acionado quando o botão "Departamentos" 
			// for pressionado (Método de Callback).
			public void actionPerformed(ActionEvent arg0) {
				ctrlPrg.iniciarCasoDeUsoManterDepartamentos();
			}
		});
		btnDepartamentos.setBounds(10, 25, 124, 55);
		contentPane.add(btnDepartamentos);
		
		JButton btnEmpregados = new JButton("Empregados");
		btnEmpregados.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// Método acionado quando o botão "Empregados" 
				// for pressionado (Método de Callback).
				ctrlPrg.iniciarCasoDeUsoManterEmpregados();
			}
		});
		btnEmpregados.setBounds(144, 25, 124, 55);
		contentPane.add(btnEmpregados);
		
		JButton btnSair = new JButton("Sair");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// Método acionado quando o botão "Sair" 
				// for pressionado (Método de Callback).
				ctrlPrg.terminar();
			}
		});
		btnSair.setBounds(278, 25, 124, 55);
		contentPane.add(btnSair);
		
		this.setVisible(true);
	}
}
