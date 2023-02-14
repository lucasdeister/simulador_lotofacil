package exercicioNovo;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Sorteio{
	
	public static final int qtd_sorteados = 15;
	
	Scanner input = new Scanner(System.in);
	
	  public int numeroAcertos2=0;
	  public int valor2=0;
	  List<Integer> numSorteados2 = new ArrayList<Integer>();
	  
	public List<Integer> sortear(int qtdRemovidos) {
		
	List<Integer> numSorteados = new ArrayList<Integer>();
	 
     for (int i=1; i<26; i++) {
     	numSorteados.add(i);
     }
      
     Collections.shuffle(numSorteados);   
     
     for(int i=0;i<qtdRemovidos;i++) {
    	 numSorteados.remove(i);
     }

     return numSorteados;    
}
      
  public String exibirNumeros(List<Integer> array,String tipo, int tam, String textoLog) {

	  Collections.sort(array);
	  
	  if(tipo.equals("jogados")) {
		  textoLog=textoLog + "\nNúmeros jogados  :";
	  }
	  else {
		   textoLog=textoLog + "\nNúmeros sorteados:";
		   tam=qtd_sorteados;
	  }
	  
	  for (int i=0; i<tam; i++) {
		  textoLog=textoLog + array.get(i) + " ";
	  }
	
	    input.close();

	    return textoLog;    
  }
  
  public void limparLista(List<Integer> array) {
	  
	    for(int i=0;i<qtd_sorteados;) {
	    	if (array.isEmpty()) {
	    		break;
	    	}
	    	array.remove(i);
	    }
  }

  public boolean VerificarResultado(List<Integer> Jogados,List<Integer> Sorteados, int tam, int qtd) {
	  
	  boolean acertou = false;
	  int numeroAcertos=0;
	  int valor=0;  
	  
	  for(int i=0;i<tam;i++) {
		  for(int j=0;j<qtd_sorteados;j++) {
			if(Jogados.get(i) == Sorteados.get(j))
				numeroAcertos++;
		  }
	  }
	  
	  switch(numeroAcertos) {
	  
	  case 11:
		  valor = 5;
		  break;
	  case 12:
		  valor = 10;
		  break;
	  case 13:
		  valor = 25;
		  break;
	  case 14:
		  valor = 2000;
		  break;
	  case 15:
		  valor = 1000000;
		  break;
	  }

	  if(numeroAcertos>=qtd) { 
		  numeroAcertos2=numeroAcertos;
		  valor2=valor;
		  numSorteados2=Sorteados;
		  acertou = true;
		  numeroAcertos=0;
		  valor=0;
	  }
	  return acertou;
  }
  
}
     

     
     
     
     
