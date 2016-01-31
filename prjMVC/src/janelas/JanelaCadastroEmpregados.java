package janelas;

import java.awt.BorderLayout;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controle.ICtrlManterEmpregados;
import controle.Tabelavel;

import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.UIManager;
import javax.swing.ListSelectionModel;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JanelaCadastroEmpregados extends JFrame implements ICadastroEmpregados {
	/**
	 * Refer�ncia para o controlador do caso de uso
	 * Manter Empregados
	 */
	private ICtrlManterEmpregados ctrl;
	/** 
	 * Refer�ncia para o painel de conte�do da janela
	 */
	private JPanel contentPane;
	/**
	 * Refer�ncia para a JTable de Empregados
	 */
	private JTable table;

	/**
	 * Create the frame.
	 */
	public JanelaCadastroEmpregados(ICtrlManterEmpregados c) {
		this.ctrl = c;
		setTitle("Empregados");
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 569, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnIncluir = new JButton("Incluir");
		btnIncluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ctrl.iniciarIncluir();
			}
		});
		btnIncluir.setBounds(81, 234, 89, 23);
		contentPane.add(btnIncluir);
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// Recupero a posi��o selecionada
				int pos = table.getSelectedRow();
				// Se a posi��o for -1, n�o h� ningu�m selecionado. Ent�o cancelo
				// a opera��o
				if(pos < 0)
					return;
				// Informo ao controlador para iniciar o processo de exclus�o
				ctrl.iniciarExcluir(pos);	
			}
		});
		btnExcluir.setBounds(180, 234, 89, 23);
		contentPane.add(btnExcluir);
		
		JButton btnAlterar = new JButton("Alterar");
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// Recupero a posi��o selecionada
				int pos = table.getSelectedRow();
				// Se a posi��o for -1, n�o h� ningu�m selecionado. Ent�o cancelo
				// a opera��o
				if(pos < 0)
					return;
				// Informo ao controlador para iniciar o processo de altera��o
				ctrl.iniciarAlterar(pos);	
			}
		});
		btnAlterar.setBounds(279, 234, 89, 23);
		contentPane.add(btnAlterar);
		
		JButton btnSair = new JButton("Sair");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ctrl.terminar();
			}
		});
		btnSair.setBounds(378, 234, 89, 23);
		contentPane.add(btnSair);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 533, 212);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Cpf", "Nome", "Departamento"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(108);
		table.getColumnModel().getColumn(1).setPreferredWidth(269);
		table.getColumnModel().getColumn(2).setPreferredWidth(247);
		scrollPane.setViewportView(table);
		this.setVisible(true);
	}
	
	/* (non-Javadoc)
	 * @see janelas.ICadastroEmpregados#limpar()
	 */
	@Override
	public void limpar() {
		DefaultTableModel dtm = (DefaultTableModel)this.table.getModel();
		while(dtm.getRowCount() > 0)
			dtm.removeRow(0);
	}

	/* (non-Javadoc)
	 * @see janelas.ICadastroEmpregados#incluirLinha(controle.Tabelavel)
	 */
	@Override
	public void incluirLinha(Tabelavel objeto) {
		DefaultTableModel dtm = (DefaultTableModel)this.table.getModel();
		dtm.addRow(objeto.getData());
	}
}