package atividade;

import java.awt.EventQueue;

import javax.swing.JFrame;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import java.text.DecimalFormat;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class imc extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField tfAltura;
	private JTextField tfPeso;

	
	DecimalFormat df = new DecimalFormat();
	
	double altura= 0;
	double peso= 0;
	double imc = 0;
	double resultado= 0;
	private JTextField tfResultado;
	private JTextField tfNome;
	private JTextField tfImc;

	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					imc frame = new imc();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public imc() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 932, 644);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(42, 42, 42));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(24, 23, 391, 487);
		panel.setBackground(new Color(69, 69, 69));
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblAltura = new JLabel("ALTURA:");
		lblAltura.setForeground(new Color(255, 255, 255));
		lblAltura.setFont(new Font("Arial", Font.PLAIN, 28));
		lblAltura.setHorizontalAlignment(SwingConstants.CENTER);
		lblAltura.setBounds(118, 104, 156, 74);
		panel.add(lblAltura);
		
		tfAltura = new JTextField();
		tfAltura.setBounds(23, 162, 338, 64);
		panel.add(tfAltura);
		tfAltura.setColumns(10);
		
		JLabel lblPeso = new JLabel("PESO:");
		lblPeso.setHorizontalAlignment(SwingConstants.CENTER);
		lblPeso.setForeground(Color.WHITE);
		lblPeso.setFont(new Font("Arial", Font.PLAIN, 28));
		lblPeso.setBounds(118, 234, 156, 74);
		panel.add(lblPeso);
		
		tfPeso = new JTextField();
		tfPeso.setColumns(10);
		tfPeso.setBounds(23, 295, 338, 64);
		panel.add(tfPeso);
		
		JLabel lblResultado = new JLabel("RESULTADO:");
		lblResultado.setHorizontalAlignment(SwingConstants.CENTER);
		lblResultado.setForeground(new Color(255, 255, 255));
		lblResultado.setFont(new Font("Arial", Font.PLAIN, 28));
		lblResultado.setBounds(92, 370, 215, 46);
		panel.add(lblResultado);
		
		tfResultado = new JTextField();
		tfResultado.setEditable(false);
		tfResultado.setColumns(10);
		tfResultado.setBounds(23, 412, 338, 64);
		panel.add(tfResultado);
		
		JLabel lblNome = new JLabel("NOME");
		lblNome.setBounds(118, -12, 156, 74);
		panel.add(lblNome);
		lblNome.setHorizontalAlignment(SwingConstants.CENTER);
		lblNome.setForeground(Color.WHITE);
		lblNome.setFont(new Font("Arial", Font.PLAIN, 28));
		
		tfNome = new JTextField();
		tfNome.setBounds(23, 46, 338, 64);
		panel.add(tfNome);
		tfNome.setColumns(10);
		
		JButton btnNewButton = 	new JButton("CAUCULAR");
		btnNewButton.setBounds(34, 538, 111, 36);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					coleta();
					cauculo();
				} catch (NumberFormatException erro354) {
					JOptionPane.showMessageDialog(null, "Parece que voce não está inserindo a informação correta! Por Favor tente Novamente");
					limpar();
				}
				}
		});
		contentPane.add(btnNewButton);
		
		JButton btnLimpar = new JButton("LIMPAR");
		btnLimpar.setBounds(173, 538, 111, 36);
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpar();
			}
		});
		contentPane.add(btnLimpar);
		
		JButton btnSair = new JButton("SAIR");
		btnSair.setBounds(304, 538, 111, 36);
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int confirm = JOptionPane.showConfirmDialog(null, "Deseja Sair do Programa?", "Confirmação", JOptionPane.YES_NO_OPTION);
				if (confirm ==JOptionPane.YES_OPTION) {
					System.exit(1);	
				}
				
			}
		});
		contentPane.add(btnSair);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBackground(new Color(69, 69, 69));
		panel_1.setBounds(494, 23, 391, 487);
		contentPane.add(panel_1);
		
		JLabel lblImc = new JLabel("IMC");
		lblImc.setHorizontalAlignment(SwingConstants.CENTER);
		lblImc.setForeground(Color.WHITE);
		lblImc.setFont(new Font("Arial", Font.PLAIN, 28));
		lblImc.setBounds(125, 11, 156, 74);
		panel_1.add(lblImc);
		
		tfImc = new JTextField();
		tfImc.setEditable(false);
		tfImc.setColumns(10);
		tfImc.setBounds(30, 72, 338, 64);
		panel_1.add(tfImc);
	}

public void coleta() {
	altura = Double.parseDouble(tfAltura.getText());
	peso = Double.parseDouble(tfPeso.getText());

}

public void limpar() {
	tfAltura.setText("");
	tfPeso.setText("");
	tfResultado.setText("");
	tfNome.setText("");
	tfImc.setText("");
	tfNome.requestFocus();
}

public void cauculo() {
	imc = peso/(altura * altura);
	df.applyLocalizedPattern("KG 00,00");
	tfResultado.setText(df.format(imc));
	
	if (imc < 18.9) {
		tfImc.setText("MUITO MAGRO");
    } else if (imc < 24.9) {
    	tfImc.setText("NORMAL");
    } else if (imc < 29.9) {
    	tfImc.setText("ACIMA DO PESO");
    } else if (imc < 39.9) {
    	tfImc.setText("OBESO");
    } else {
        tfImc.setText("OBESIDADE GRAVE");
    }
   
  }
}


