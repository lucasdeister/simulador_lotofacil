package exercicioNovo;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.LineBorder;



@SuppressWarnings("serial")

public class Tela extends JFrame implements ActionListener {
	
	final int TOTAL_BOTOES=25;

	private JButton[] botoes;
	private GridLayout gridLayout1;
	JLabel textoSelecao;
	JLabel textoNumeros;
	JLabel textoSpinner;
	JLabel textoSpinnerNumeros;
	JLabel textoTitulo;
	JLabel textoResultado;
	JLabel textoContador;
	JLabel contador;
	JPanel painel = new JPanel();
	JButton botaoVerificar = new JButton("Jogar");
	JButton botaoSobre = new JButton("Sobre");
	JButton botaoLimpar = new JButton("Limpar");
	List<Integer> numJogados = new ArrayList<Integer>();
	List<Integer> numSorteados = new ArrayList<Integer>();
	boolean ganhou=false;
	int sorteiosRealizados=1;
	public int qtdMinimaAcerto = 0;
	Sorteio num = new Sorteio();
	SpinnerNumberModel model1 = new SpinnerNumberModel(11, 11, 15, 1);
	SpinnerNumberModel model2 = new SpinnerNumberModel(15, 15, 20, 1); 
	JSpinner spinner = new JSpinner(model1);
	JSpinner spinnerAleatorio = new JSpinner(model2);
	JTextArea logResultado;
	public String textoLog="";
	public String novoTexto="";
	private int cont=0;
	public int valorSpinnerAleatorio = 0;
	public int numerosRemovidos = 0;

	public Tela(){
		
		
		
		setTitle("Simulador Lotofácil");
		setBounds(700,250,520,540);
		setLayout(null);
		add(painel);
		
		textoTitulo = new JLabel("Simulador Lotofácil ──────────────────────────────────────────");
		textoTitulo.setFocusable(true);
		textoTitulo.setBounds(50,-5,550,50);
		textoTitulo.setFont(new Font("Calibri", Font.BOLD, 14));
		add(textoTitulo);
		
		textoResultado = new JLabel("Resultado:");
		textoResultado.setFocusable(true);
		textoResultado.setBounds(50,240,350,100);
		textoResultado.setFont(new Font("Calibri", Font.PLAIN, 14));
		add(textoResultado);
		
		textoNumeros = new JLabel("números");
		textoNumeros.setFocusable(true);
		textoNumeros.setBounds(260,23,100,100);
		textoNumeros.setFont(new Font("Calibri", Font.PLAIN, 14));
		add(textoNumeros);
		
		textoSpinner = new JLabel("Número mínimo de acertos para ganhar (de 11 a 15 números):");
		textoSpinner.setFocusable(true);
		textoSpinner.setBounds(50,37,350,15);
		textoSpinner.setFont(new Font("Calibri", Font.PLAIN, 14));
		add(textoSpinner);

		spinner.setValue(11);
		spinner.setFocusable(false);
		spinner.setBounds(410,32,40,20);
		add(spinner);
		
		textoSelecao = new JLabel();
		textoSelecao.setBounds(50,60,150,15);
		textoSelecao.setFont(new Font("Calibri",Font.PLAIN,14));
		textoSelecao.setText("<html><a href=''>Selecionar aleatoriamente</a></html>");
		textoSelecao.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		
		spinnerAleatorio.setValue(15);
		spinnerAleatorio.setFocusable(false);
		spinnerAleatorio.setBounds(210,60,40,20);
		add(spinnerAleatorio);
		
		textoSelecao.addMouseListener(new MouseAdapter() {
			
		    @Override
		    public void mouseClicked(MouseEvent e) {
		    	
		    spinnerAleatorio.updateUI();
			spinner.updateUI();
					
		    logResultado.setText(null);
		    	
		    List<Integer> numSorteadosAleatorios = new ArrayList<Integer>();
		    	
		    valorSpinnerAleatorio = (Integer) spinnerAleatorio.getValue();
		    
		    switch(valorSpinnerAleatorio) {
		    
		    case 15:
				  numerosRemovidos = 10;
				  break;
			  case 16:
				  numerosRemovidos = 9;
				  break;
			  case 17:
				  numerosRemovidos = 8;
				  break;
			  case 18:
				  numerosRemovidos = 7;
				  break;
			  case 19:
				  numerosRemovidos = 6;
				  break;
			  case 20:
				  numerosRemovidos = 5;
				  break;
		    }
		    
		    numSorteadosAleatorios = num.sortear(numerosRemovidos);
		    selecionarAleatorio(numSorteadosAleatorios);
		    }
			});

		add(textoSelecao);
		
		textoContador = new JLabel("Números selecionados:");
		textoContador.setBounds(300,240,400,100);
		textoContador.setFont(new Font("Calibri",Font.PLAIN,14));
		add(textoContador);
		
		contador = new JLabel("0");
		contador.setBounds(435,240,400,100);
		contador.setFont(new Font("Calibri",Font.PLAIN,14));
		add(contador);
		
		logResultado = new JTextArea();
		logResultado.setBounds(50,300,410,100);
		logResultado.setEnabled(false);
		logResultado.setFont(new Font("Calibri",Font.PLAIN,14));
		logResultado.setBorder(new LineBorder(Color.BLACK, 1));
		add(logResultado);

		gridLayout1 = new GridLayout(5,5,3,3);
		painel.setLayout(gridLayout1);

		painel.setBounds(50,100,410,170);
		botoes = new JButton[TOTAL_BOTOES];
		
		for(int i = 0; i < TOTAL_BOTOES; i++){
			botoes[i] = new JButton(String.valueOf(i+1));
			botoes[i].addActionListener(this);
			painel.add(botoes[i]);
			botoes[i].setFocusable(false);
		}
		
		botaoVerificar.setSize(79,25);
		botaoVerificar.setLocation(216,430);
		botaoVerificar.setFont(new Font("ScriptS",Font.BOLD,12));
		botaoVerificar.setEnabled(true);
		botaoVerificar.setFocusable(false);
		
		botaoSobre.setSize(79,25);
		botaoSobre.setLocation(51,430);
		botaoSobre.setFont(new Font("ScriptS",Font.BOLD,12));
		botaoSobre.setEnabled(true);
		botaoSobre.setFocusable(false);
		
		botaoLimpar.setSize(79,25);
		botaoLimpar.setLocation(381,430);
		botaoLimpar.setFont(new Font("ScriptS",Font.BOLD,12));
		botaoLimpar.setEnabled(true);
		botaoLimpar.setFocusable(false);
				
		getContentPane().setLayout(null);
		getContentPane().add(botaoVerificar);
		getContentPane().add(botaoSobre);
		getContentPane().add(botaoLimpar);
		botaoVerificar.addActionListener(this);
		botaoSobre.addActionListener(this);
		botaoLimpar.addActionListener(this);
	}
	
	public void selecionarAleatorio(List<Integer> nAleatorios) {
		
		for(int i=0;i< TOTAL_BOTOES;i++) {
			botoes[i].setBackground(null);
		}
		
		for(int i=0;i < nAleatorios.size();i++) {
			int aux = nAleatorios.get(i);
			botoes[aux-1].setBackground(Color.green);
		}

		contador.setText(String.valueOf(spinnerAleatorio.getValue()));
		
}

	public void jogar() {

		List<Integer> nJogados = new ArrayList<Integer>();
		
		String textoNum="";
		
		for(int i=0;i<TOTAL_BOTOES;i++) {
			if(botoes[i].getBackground()== Color.green) {
				textoNum=botoes[i].getText();
				int num = Integer.parseInt(textoNum);
				nJogados.add(num);
			}
		}
		
		numJogados=nJogados;
		numSorteados=num.sortear(10);
		
		textoLog=("Quantidade de numeros jogados: " + numJogados.size());
	
		novoTexto=num.exibirNumeros(numJogados,"jogados",numJogados.size(),textoLog);
	}
	
	public void exibirLog(int qtdAcertos , int valor , int qtdSorteios) {
		
		novoTexto=num.exibirNumeros(num.numSorteados2,"sorteados",numJogados.size(),novoTexto);
		novoTexto = novoTexto + "\nVocê acertou " + qtdAcertos + " números";
		novoTexto = novoTexto + " e ganhou o prêmio de " + valor + " reais!"; 
		textoLog = novoTexto + "\nForam necessários " + qtdSorteios +" sorteios para ganhar.";
		num.numeroAcertos2=0;
		num.valor2=0;
		sorteiosRealizados=1;
		logResultado.setEnabled(true);
		logResultado.setText(textoLog);
		botaoVerificar.setEnabled(true);
		logResultado.setEditable(false);
	}
	
	
	public int obterSelecionados() {
		
		int cont = 0;
		
		for(int i=0;i< TOTAL_BOTOES;i++) {
			if(botoes[i].getBackground() == Color.green) {
				cont++;
			}
		}
		
		return cont;
	}
    
	public void actionPerformed(ActionEvent evento) {
		
		spinnerAleatorio.updateUI();
		spinner.updateUI();	

		for(int i=0;i< TOTAL_BOTOES;i++) {
			if(evento.getSource() == botoes[i]){
				cont = obterSelecionados();
				if(botoes[i].getBackground() != Color.green) {
					botoes[i].setBackground(Color.green);
					cont++;
				}
				else {
					botoes[i].setBackground(null);
					cont--;
				}	
			   	contador.setText(String.valueOf(cont));
			   	break;
			}	
		}
		
		if(evento.getSource() == botaoSobre)
			JOptionPane.showMessageDialog (null, "Simulador Lotofácil versão 1.0\nDesenvolvedor: Lucas de Azevedo Deister");

		if(evento.getSource() == botaoLimpar) {
			cont=0;
			contador.setText(String.valueOf(cont));
			logResultado.setText(null);
			for(int i=0;i< TOTAL_BOTOES;i++) {
				botoes[i].setBackground(null);
			}
		}
			
		int qtd=0;
		
		if(evento.getSource() == botaoVerificar){
			for(int i=0;i< TOTAL_BOTOES;i++) {
				if(botoes[i].getBackground() == Color.green) {
					qtd++;
				}
			}
			if(qtd<15 || qtd>20)
				JOptionPane.showMessageDialog (null, "Quantidade inválida!");
			else {
				qtdMinimaAcerto = (Integer) spinner.getValue();
				botaoVerificar.setEnabled(false);
				jogar();
				ganhou=num.VerificarResultado(numJogados,numSorteados,numJogados.size(),qtdMinimaAcerto);
									
				if(ganhou&&sorteiosRealizados==1)
					exibirLog(num.numeroAcertos2,num.valor2,sorteiosRealizados);

				while(ganhou==false) {
					sorteiosRealizados++;
					num.limparLista(numSorteados);
					numSorteados=num.sortear(10);
					ganhou=num.VerificarResultado(numJogados,numSorteados,numJogados.size(),qtdMinimaAcerto);
				}
				if(sorteiosRealizados>1)
					exibirLog(num.numeroAcertos2,num.valor2,sorteiosRealizados);
			  }	
			}		 
		}
	}

	











