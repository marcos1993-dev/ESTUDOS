package escola.modulo10.sistema;

import javax.swing.JOptionPane;

public class ArrayVetor {

	public static void main(String[] args) {
		
		int qtd = Integer.parseInt(JOptionPane.showInputDialog("Informe a quantidade de linhas "));
		
		double notas[] = new double [qtd];
		
		for(int x=0; x<notas.length; x++) {
			double nt = Double.parseDouble(JOptionPane.showInputDialog("Informe a nota "+(x+1)+": "));
			notas[x]=nt;
		}
		
		
		 
		 System.out.println("Comprimento Array: "+notas.length);
		 
		 System.out.println("------------------------------");
		 
		for (int i=0; i<notas.length; i++) {
			
			System.out.println("NOTA "+(i+1)+ ": " + notas[i]);
		}
		System.out.println("------------------------------");
		
		int pos = 0;
		 while(pos <notas.length) {
			 
			 System.out.println("NOTA "+(pos+1)+ ": " + notas[pos]);
			 pos++;
		 }
		 
		 double media=0.0;
		 
		 for(int cont=0; cont< notas.length; cont++ ) {
			 
			 media += notas[cont];
			
		 } System.out.println("Média : "+media/notas.length);
		 
		
	}

}
