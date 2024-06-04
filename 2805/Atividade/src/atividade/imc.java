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
		setBounds(100, 100, 463, 648);
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
		lblAltura.setBounds(116, 0, 156, 74);
		panel.add(lblAltura);
		
		tfAltura = new JTextField();
		tfAltura.setBounds(21, 58, 338, 64);
		panel.add(tfAltura);
		tfAltura.setColumns(10);
		
		JLabel lblPeso = new JLabel("PESO:");
		lblPeso.setHorizontalAlignment(SwingConstants.CENTER);
		lblPeso.setForeground(Color.WHITE);
		lblPeso.setFont(new Font("Arial", Font.PLAIN, 28));
		lblPeso.setBounds(116, 130, 156, 74);
		panel.add(lblPeso);
		
		tfPeso = new JTextField();
		tfPeso.setColumns(10);
		tfPeso.setBounds(21, 191, 338, 64);
		panel.add(tfPeso);
		
		JLabel lblResultado = new JLabel("RESULTADO:");
		lblResultado.setHorizontalAlignment(SwingConstants.CENTER);
		lblResultado.setForeground(new Color(255, 255, 255));
		lblResultado.setFont(new Font("Arial", Font.PLAIN, 28));
		lblResultado.setBounds(90, 266, 215, 46);
		panel.add(lblResultado);
		
		tfResultado = new JTextField();
		tfResultado.setEditable(false);
		tfResultado.setColumns(10);
		tfResultado.setBounds(21, 308, 338, 64);
		panel.add(tfResultado);
		
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
	}

public void coleta() {
	altura = Double.parseDouble(tfAltura.getText());
	peso = Double.parseDouble(tfPeso.getText());

}

public void limpar() {
	tfAltura.setText("");
	tfPeso.setText("");
	tfResultado.setText("");
}

public void cauculo() {
	imc = peso/(altura * altura);
	
	if (imc < 18.9) {
		 tfResultado.setText("MUITO MAGRO" + "Seu IMC é" + imc);
    } else if (imc < 24.9) {
    	 tfResultado.setText("NORMAL" + "Seu IMC é"+ imc);
    } else if (imc < 29.9) {
    	 tfResultado.setText("ACIMA DO PESO" + "Seu IMC é"+ imc);
    } else if (imc < 39.9) {
    	 tfResultado.setText("OBESO" + "Seu IMC é"+ imc );
    } else {
        tfResultado.setText("OBESIDADE GRAVE" + "Seu IMC é"+ imc);
    }
   
  }
}


