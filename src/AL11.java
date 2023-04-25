import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.BoxLayout;
import net.miginfocom.swing.MigLayout;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.regex.*;
import java.io.PrintWriter;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import java.awt.Color;
import java.awt.Rectangle;
import java.awt.Window.Type;
import javax.swing.border.LineBorder;


public class AL11 extends JFrame {

	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JTable tablaSimbolos;
	private JTable tablaErrores;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AL11 frame = new AL11();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public String[] Separar (String Ins) {
		
		int p;
		StringTokenizer st = new StringTokenizer(Ins);
		p = st.countTokens();
		
		
		if (p==1) {
			String[] Palabra= {Ins};
			return (Palabra);
		}
		else {
		//Arreglo para almacenar las palabras
		String [] Palabras=Ins.split("(\n{0,1}[\r\t\n ]+)");
		return(Palabras);
		}
		
		
	}
	
	public String[] Generar(String Lex[]) {
		
		int zise = Lex.length;
		
		//Arreglo para almacenar los tokens
		String [] Tokens = new String[zise];
		int SEP=0;
		int OA=0;
		int OR=0;
		int OAS=0;
		int OL=0;
		int VAR=0;
		int NE=0;
		int NPD=0;
		int TD=0;
		int DW=0;
		int ERL=0;
		int rep=0;
		int indice;
		
		for (int z=0; z<zise; z++){
			if (Lex[z].matches("[(){},;]")){		// EL LEXEMA ES UN SEPARADOR Y SE GENERA SU TOKEN (SEP)
				if (z==0){
					SEP++;
					Tokens[z]="SEP"+SEP;
					System.out.println("Si es valida emp " + Lex[z]);
					System.out.println(Tokens[z]);
				} 
				else{
					for(int s=0; s<z; s++) {
						if(s==z-1 && !Lex[z].equals(Lex[s]))
						{
							SEP++;
							Tokens[z]="SEP"+SEP;
							System.out.println("Si es valida false " + Lex[z]);
							System.out.println(Tokens[z]);
							
							break;
						}
						if(Lex[z].equals(Lex[s])){
							Tokens[z]=Tokens[s];
							System.out.println("Si es valida true " + Lex[z]);
							System.out.println(Tokens[z]);
							
							break;
							
						}
						
					}
				}
			}  // TERMINA LA GENERACION DEL TOKEN SEP
			
			else if(Lex[z].matches("[-+*/%]")) {	//EL LEXEMA ES UN OPERADOR ARITMETICO Y SE GENERA SU TOKEN (OA)
				if (z==0){
					OA++;
					Tokens[z]="OA"+OA;
					System.out.println("Si es valida emp " + Lex[z]);
					System.out.println(Tokens[z]);
				} 
				else{
					for(int s=0; s<z; s++) {
						if(s==z-1 && !Lex[z].equals(Lex[s]))
						{
							OA++;
							Tokens[z]="OA"+OA;
							System.out.println("Si es valida false " + Lex[z]);
							System.out.println(Tokens[z]);
							
							break;
						}
						if(Lex[z].equals(Lex[s])){
							Tokens[z]=Tokens[s];
							System.out.println("Si es valida true " + Lex[z]);
							System.out.println(Tokens[z]);
							
							break;
							
						}
						
					}
				}
				
			}	//TERMINA LA GENERACION DEL TOKEN
			
			else if(Lex[z].matches("==|<=|<|>=|>|!=")) {	//EL LEXEMA ES UN OPERADOR RELACIONAL Y SE GENERA SU TOKEN (OR)
				if (z==0){
					OR++;
					Tokens[z]="OR"+OR;
					System.out.println("Si es valida emp " + Lex[z]);
					System.out.println(Tokens[z]);
				} 
				else{
					for(int s=0; s<z; s++) {
						if(s==z-1 && !Lex[z].equals(Lex[s]))
						{
							OR++;
							Tokens[z]="OR"+OR;
							System.out.println("Si es valida false " + Lex[z]);
							System.out.println(Tokens[z]);
							
							break;
						}
						if(Lex[z].equals(Lex[s])){
							Tokens[z]=Tokens[s];
							System.out.println("Si es valida true " + Lex[z]);
							System.out.println(Tokens[z]);
							
							break;
							
						}
						
					}
				}
				
			}	//TERMINA LA GENERACION DEL TOKEN
			
			else if(Lex[z].matches("=")) {	//EL LEXEMA ES UN OPERADOR DE ASIGNACION Y SE GENERA SU TOKEN(OAS)
				if (z==0){
					OAS++;
					Tokens[z]="OAS"+OAS;
					System.out.println("Si es valida emp " + Lex[z]);
					System.out.println(Tokens[z]);
				} 
				else{
					for(int s=0; s<z; s++) {
						if(s==z-1 && !Lex[z].equals(Lex[s]))
						{
							OAS++;
							Tokens[z]="OAS"+OAS;
							System.out.println("Si es valida false " + Lex[z]);
							System.out.println(Tokens[z]);
							
							break;
						}
						if(Lex[z].equals(Lex[s])){
							Tokens[z]=Tokens[s];
							System.out.println("Si es valida true " + Lex[z]);
							System.out.println(Tokens[z]);
							
							break;
							
						}
						
					}
				}
				
			}	//TERMINA LA GENERACION DEL TOKEN
			
			else if(Lex[z].matches("[&]{2}|[|]{2}")) {	//EL LEXEMA ES UN OPERADOR LOGICO O BOOLEANO Y SE GENERA SU TOKEN (OL)
				if (z==0){
					OL++;
					Tokens[z]="OL"+OL;
					System.out.println("Si es valida emp " + Lex[z]);
					System.out.println(Tokens[z]);
				} 
				else{
					for(int s=0; s<z; s++) {
						if(s==z-1 && !Lex[z].equals(Lex[s]))
						{
							OL++;
							Tokens[z]="OL"+OL;
							System.out.println("Si es valida false " + Lex[z]);
							System.out.println(Tokens[z]);
							
							break;
						}
						if(Lex[z].equals(Lex[s])){
							Tokens[z]=Tokens[s];
							System.out.println("Si es valida true " + Lex[z]);
							System.out.println(Tokens[z]);
							
							break;
							
						}
						
					}
				}
				
			}	//TERMINA LA GENERACION DEL TOKEN
			
			else if(Lex[z].matches("SE_[0-9a-zA-Z]+")) {	//EL LEXEMA ES UN IDENTIFICADOR Y SE GENERA SU TOKEN (VAR)
				if (z==0){
					VAR++;
					Tokens[z]="VAR"+VAR;
					System.out.println("Si es valida emp " + Lex[z]);
					System.out.println(Tokens[z]);
				} 
				else{
					for(int s=0; s<z; s++) {
						if(s==z-1 && !Lex[z].equals(Lex[s]))
						{
							VAR++;
							Tokens[z]="VAR"+VAR;
							System.out.println("Si es valida false " + Lex[z]);
							System.out.println(Tokens[z]);
							
							break;
						}
						if(Lex[z].equals(Lex[s])){
							Tokens[z]=Tokens[s];
							System.out.println("Si es valida true " + Lex[z]);
							System.out.println(Tokens[z]);
							
							break;
							
						}
						
					}
				}
				
			}	//TERMINA LA GENERACION DEL TOKEN
			
			else if(Lex[z].matches("(-?[0-9]*11)")) {	//EL LEXEMA ES UN NUMERO ENTERO Y SE GENERA SU TOKEN (NE)
				if (z==0){
					NE++;
					Tokens[z]="NE"+NE;
					System.out.println("Si es valida emp " + Lex[z]);
					System.out.println(Tokens[z]);
				} 
				else{
					for(int s=0; s<z; s++) {
						if(s==z-1 && !Lex[z].equals(Lex[s]))
						{
							NE++;
							Tokens[z]="NE"+NE;
							System.out.println("Si es valida false " + Lex[z]);
							System.out.println(Tokens[z]);
							
							break;
						}
						if(Lex[z].equals(Lex[s])){
							Tokens[z]=Tokens[s];
							System.out.println("Si es valida true " + Lex[z]);
							System.out.println(Tokens[z]);
							
							break;
							
						}
						
					}
				}
				
			}	//TERMINA LA GENERACION DEL TOKEN
			
			else if(Lex[z].matches("-?[0-9]*11[.][0-9]+")) {	//EL LEXEMA ES UN NUMERO CON PUNTO DECIMAL  Y SE GENERA SU TOKEN(NPD)
				if (z==0){
					NPD++;
					Tokens[z]="NPD"+NPD;
					System.out.println("Si es valida emp " + Lex[z]);
					System.out.println(Tokens[z]);
				} 
				else{
					for(int s=0; s<z; s++) {
						if(s==z-1 && !Lex[z].equals(Lex[s]))
						{
							NPD++;
							Tokens[z]="NPD"+NPD;
							System.out.println("Si es valida false " + Lex[z]);
							System.out.println(Tokens[z]);
							
							break;
						}
						if(Lex[z].equals(Lex[s])){
							Tokens[z]=Tokens[s];
							System.out.println("Si es valida true " + Lex[z]);
							System.out.println(Tokens[z]);
							
							break;
							
						}
						
					}
				}
				
			}	//TERMINA LA GENERACION DEL TOKEN
			
			else if(Lex[z].matches("@Entero|@Cadena|@Char")) {	//EL LEXEMA ES UN TIPO DE DATO Y SE GENERA SU TOKEN(TD)
				if (z==0){
					TD++;
					Tokens[z]="TD"+TD;
					System.out.println("Si es valida emp " + Lex[z]);
					System.out.println(Tokens[z]);
				} 
				else{
					for(int s=0; s<z; s++) {
						if(s==z-1 && !Lex[z].equals(Lex[s]))
						{
							TD++;
							Tokens[z]="TD"+TD;
							System.out.println("Si es valida false " + Lex[z]);
							System.out.println(Tokens[z]);
							
							break;
						}
						if(Lex[z].equals(Lex[s])){
							Tokens[z]=Tokens[s];
							System.out.println("Si es valida true " + Lex[z]);
							System.out.println(Tokens[z]);
							
							break;
							
						}
						
					}
				}
				
			}	//TERMINA LA GENERACION DEL TOKEN
			
			else if(Lex[z].matches("do|while")) {	//EL LEXEMA ES UN DO-WHILE Y SE GENERA SU TOKEN(DW)
				if (z==0){
					DW++;
					Tokens[z]="DW"+DW;
					System.out.println("Si es valida emp " + Lex[z]);
					System.out.println(Tokens[z]);
				} 
				else{
					for(int s=0; s<z; s++) {
						if(s==z-1 && !Lex[z].equals(Lex[s]))
						{
							DW++;
							Tokens[z]="DW"+DW;
							System.out.println("Si es valida false " + Lex[z]);
							System.out.println(Tokens[z]);
							
							break;
						}
						if(Lex[z].equals(Lex[s])){
							Tokens[z]=Tokens[s];
							System.out.println("Si es valida true " + Lex[z]);
							System.out.println(Tokens[z]);
							
							break;
							
						}
						
					}
				}
				
			}	//TERMINA LA GENERACION DEL TOKEN
			
			
				// EL LEXEMA ES INCORRECTO Y SE GENERA SU TOKEN DE ERROR (ERL)
			else{
				//------------------
				if (z==0) {
					ERL++;
					Tokens[z]="ERL"+ERL;
					System.out.println("No es valida emp " + Lex[z]);
					System.out.println(Tokens[z]);
				}
				else{
					for(int s=0; s<z; s++) {
						if(s==z-1 && !Lex[z].equals(Lex[s]))
						{
							ERL++;
							Tokens[z]="ERL"+ERL;
							System.out.println("No es valido false " + Lex[z]);
							System.out.println(Tokens[z]);
							break;
						}
						if(Lex[z].equals(Lex[s])){
							Tokens[z]=Tokens[s];
							System.out.println("No es valido true " + Lex[z]);
							System.out.println(Tokens[z]);
							
							break;
							
						}
						
					}
				}
				
				//---------------------
				
			}
				
		} // TERMINA LA GENERACION DE TOKENS
		
		for (int a=0; a<zise; a++)
		{
			//System.out.println(Tokens[a]+" ");
			System.out.print(Tokens[a]+" ");
		}
		
		return(Tokens);
	}
	
	
	public void ArchivoT (String TK[]) {
		int zis = TK.length;
		try {
			PrintWriter writer = new PrintWriter("ArchivoTokens.txt","UTF-8");
			for (int i=0; i<zis; i++) {
			writer.print(TK[i]+" ");
			}
			writer.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public String[][] MostrarTablaS(String L[], String T[]) {
		int z = L.length;
		int fila=0;
		int f1=0;
		int f2=0;
		
		String[] Le = new String[z];
		String[] To = new String[z];
		
		for(int n=0; n<z; n++) {
			
			if (n==0) {
				Le[0]=L[0];
				f1++;
			}
			else {
				for (int m=0; m<n; m++){
					if(m==n-1 && !L[n].equals(Le[m])) {
						Le[f1]=L[n];
						f1++;
					}
					if(L[n].equals(Le[m])) {
						break;
					}
				}
			}
		}
		
		for(int n=0; n<z; n++) {
			
			if (n==0) {
				To[0]=T[0];
				f2++;
			}
			else {
				for (int m=0; m<n; m++){
					if(m==n-1 && !T[n].equals(To[m])) {
						To[f2]=T[n];
						f2++;
					}
					if(T[n].equals(To[m])) {
						break;
					}
				}
			}
		}
		
		int df=Le.length;
		//Impresion 
		/*
		for(int d=0; d<df; d++) {
			System.out.println(Le[d]+" "+To[d]);
		}*/
		
		
		String[][] TablaSimbolos=new String[df][2];
		//Eliminar tokens de error
		for (int f=0; f<df; f++){
			if(To[f]==null || To[f].contains("ERL")) {
							
			}
			else{
				TablaSimbolos[fila][1]=To[f];
				TablaSimbolos[fila][0]=Le[f];
				fila++;
			}
		}
				
		
		int LTS=TablaSimbolos.length;
		//Impresion ---------------------------------------------------------
		for(int d=0; d<LTS; d++) {
	
			for (int h=0; h<2; h++) {
				System.out.print(TablaSimbolos[d][h]+" ");
			}
				System.out.println();
		}
		
		
		//Mostrar los datos en la tabla
		int nm= TablaSimbolos.length;
		String[] TablaSim = new String[2];
		
		
		
		DefaultTableModel m= (DefaultTableModel)tablaSimbolos.getModel();
		for(int h=0; h<nm; h++) {
			
					TablaSim[0]=TablaSimbolos[h][0];
					TablaSim[1]=TablaSimbolos[h][1];
					if(TablaSim[0]==null) {
						
					}
					else {
						
						m.addRow(TablaSim);
					}
		}
		
		
		//Estructura de Datos ----------------------------------------------------------------
		int longTabla=m.getRowCount();
		String[][] EstructuraSimb = new String [longTabla][3];
		
		for(int h=0; h<longTabla; h++){
			for(int s=0; s<2; s++){
				EstructuraSimb[h][s]=TablaSimbolos[h][s];
			}
		}
		
		int longMatriz=EstructuraSimb.length;
		
		for(int h=0; h<longMatriz; h++){
			System.out.println("LINEEEEEEEEE");
			for(int s=0; s<3; s++){
				System.out.println(EstructuraSimb[h][s]);
			}
		}
		
		return(EstructuraSimb);
	}
	
	public void MostrarTablaE(String L[], String T[], String codigo){
		
		int z = L.length;
		int fila=0;
		int f1=0;
		int f2=0;
		
		String[] Le = new String[z];
		String[] To = new String[z];
		//ELIMINAR DATOS REPETIDOS
		for(int n=0; n<z; n++) {
			
			if (n==0) {
				Le[0]=L[0];
				f1++;
			}
			else {
				for (int m=0; m<n; m++){
					if(m==n-1 && !L[n].equals(Le[m])) {
						Le[f1]=L[n];
						f1++;
					}
					if(L[n].equals(Le[m])) {
						break;
					}
				}
			}
		}
		
		for(int n=0; n<z; n++) {
			
			if (n==0) {
				To[0]=T[0];
				f2++;
			}
			else {
				for (int m=0; m<n; m++){
					if(m==n-1 && !T[n].equals(To[m])) {
						To[f2]=T[n];
						f2++;
					}
					if(T[n].equals(To[m])) {
						break;
					}
				}
			}
		}
		
		int df=Le.length;
		//Impresion 
		
		for(int d=0; d<df; d++) {
			System.out.println(Le[d]+" "+To[d]);
		}
		
		
		String[][] TablaErrores=new String[df][2];
		//Eliminar tokens
		for (int f=0; f<df; f++){
			if(To[f]==null || !To[f].contains("ERL")) {
							
			}
			else{
				TablaErrores[fila][1]=To[f];
				TablaErrores[fila][0]=Le[f];
				fila++;
			}
		}
				
		
		int LTS=TablaErrores.length;
		//Impresion 
		for(int d=0; d<LTS; d++) {
			for (int h=0; h<2; h++) {
				System.out.print("Error:"+d+" "+TablaErrores[d][h]+" ");
			}
				System.out.println();
		}
		
		//Imprimir los da
		
		
		
		//Generar numero de filas
		String [] Filas=codigo.split("\n[\t ]*");
		int E= Filas.length;
		
		String[][] Palabras;
		Palabras=new String[E][]; 
		for(int h=0; h<E; h++) {
			Palabras[h]=Filas[h].split("([\r\t\n ])+");
		}
		
		for (int d=0; d<E; d++) {
			for(int e=0; e<Palabras[d].length; e++) {
				System.out.println("Fila: "+d+" palabra: "+e+" "+Palabras[d][e]);
			}
		}
		
		
		// System.out.println("NUMERO DE CARACTERES: "+sj);
		
		//Ver lo que arroja---------------
		for(int d=0; d<E; d++) {
			System.out.println("Fila:"+d+" "+Filas[d]+" ");
		}
		
		int J=TablaErrores.length;
		String NFila[]=new String[J];
		
		for(int i=0; i<J; i++) {
			for(int s=0; s<E; s++) {
				String aux=TablaErrores[i][0];
				String aux2=Filas[s];
				if(aux==null) {
					
				}
				else {
				for(int pa=0; pa<Palabras[s].length; pa++)
				{
					if(aux.equals(Palabras[s][pa])) {
						if(NFila[i]==null) {
							NFila[i]=""+(s+1);
							//System.out.println(i);
						}
						else {
							NFila[i]=NFila[i]+","+(s+1);
							//System.out.println(i);
						}
					
					}
				}
				}
				//fe++;
			}
		}
		
		int fg=NFila.length;
		//Imprimir el numero de filas
		for(int d=0; d<fg; d++) {
			System.out.println("El error: "+d+" Esta en la fila "+NFila[d]+" ");
		}
		
		
		
		
		//Mostrar los datos en la tabla
		int nm= TablaErrores.length;
		String[] TablaSim = new String[4];
		DefaultTableModel m= (DefaultTableModel)tablaErrores.getModel();
		for(int h=0; h<nm; h++) {
			
					TablaSim[0]=TablaErrores[h][1];
					TablaSim[1]=TablaErrores[h][0];
					TablaSim[2]=NFila[h];
					TablaSim[3]="Error Léxico";
					if(TablaSim[0]==null) {
						
					}
					else {
						m.addRow(TablaSim);
					}
		}
		
	}
	
	public String ImprimirTokens(String tkn[]) {
		String Text="";
		int l=tkn.length;
		for(int i=0; i<l; i++) {
			Text=Text+tkn[i]+" ";
		}
		
		return(Text);
	}
	
	
	// ----------------------- ANALISIS SEMANTICO ------------------------------------------------------------
	
	
	
	public void AsignarTipo(String AreaTexto, String TableSimbolos[][]) {
		
		//Generar numero de filas
		String [] Filas2=AreaTexto.split("\n[\t ]*");
		int E= Filas2.length;
				
		String[][] Palabras2;
		Palabras2=new String[E][]; 
		for(int h=0; h<E; h++) {
				Palabras2[h]=Filas2[h].split("([\r\t\n ])+");
		}
		
		System.out.println("------ESTRUCTURA DE DATOS-------");
		for (int d=0; d<E; d++) {
			for(int e=0; e<Palabras2[d].length; e++) {
				System.out.println("Fila: "+d+" palabra: "+e+" "+Palabras2[d][e]);
			}
		}
		
		String TDato;
		String Lexema;
		DefaultTableModel m= (DefaultTableModel)tablaSimbolos.getModel();
		int LongitudTabla = m.getRowCount();
		
		for(int i=0; i<E; i++)
		{
			for(int f=0; f<Palabras2[i].length; f++) {
				
				if(Palabras2[i][f].matches("@Entero|@Cadena|@Char")) {
					TDato = Palabras2[i][f];
				
					for(int h=f; h<Palabras2[i].length; h++) {
						
						if(Palabras2[i][h].matches("SE_[0-9a-zA-Z]+")){
							
							Lexema=Palabras2[i][h];
							
							for(int a=0; a<LongitudTabla; a++) {
								if(TableSimbolos[a][0].equals(Lexema))
								{
									TableSimbolos[a][2]=TDato;
									m.setValueAt(TDato, a, 2);
								}
							}
							
							if((h+1)<Palabras2[i].length) {
								if(Palabras2[i][h+1].matches(",")) {
									h=h+1;
									
								}
								else {
									break;
								}
							}
							
							
						
						}
						else {
							
						}
						
						
					}
					
				}
				
			}
		}
		
		//ACTUALIZAR TABLA
		//m.setValueAt(, E, LongitudTabla);
		
	}
	
	//("(\n{0,1}[\r\t\n ]+)")
	
	
	public void ErrorSemantico(String CodigoT, String TblSimbolos[][]) {
		
		//Generar numero de filas
		String [] Filas3=CodigoT.split("\n[\t ]*");
		int E= Filas3.length;
				
		String[][] Palabras3;
		Palabras3=new String[E][]; 
		for(int h=0; h<E; h++) {
				Palabras3[h]=Filas3[h].split("([\r\t\n ])+");
		}
		
		System.out.println("------ESTRUCTURA DE DATOS-------");
		for (int d=0; d<E; d++) {
			for(int e=0; e<Palabras3[d].length; e++) {
				System.out.println("Fila: "+d+" palabra: "+e+" "+Palabras3[d][e]);
			}
		}
		
		
		String Ident;
		String Ident2;
		String Ident3;
		String TDato="No";
		String TDato2="No";
		String TDato3="No";
		String Lexema;
		DefaultTableModel m= (DefaultTableModel)tablaSimbolos.getModel();
		DefaultTableModel mE= (DefaultTableModel)tablaErrores.getModel();
		String ErrorSem[]=new String[4];
		int nE=0;
		int LongitudTErrores=mE.getRowCount();
		int LongitudTabla = m.getRowCount();
		
		for(int i=0; i<E; i++)
		{
			for(int f=0; f<Palabras3[i].length; f++) {
				
				if(Palabras3[i].length>=6) {
				if(Palabras3[i][f].matches("SE_[0-9a-zA-Z]+") && Palabras3[i][f+1].matches("=")) {
					
					System.out.println("SE IDENTIFICA UNA OPERACION");
					
					Ident = Palabras3[i][f];
					for(int o=0; o<m.getRowCount(); o++) {
						if(TblSimbolos[o][0].equals(Ident)) {
							TDato=""+m.getValueAt(o, 2);
							System.out.println("SE IDENTIFICO EL TIPO DE DATO 1 " + TDato);
							////////// PRIMER IDENTIFICADOR
							if(TDato.equals("@Entero")) {
								
								if(Palabras3[i][f+2].matches("SE_[0-9a-zA-Z]+")) {
									
									System.out.println("LA OPERACION CONTINUA");
									
									Ident2 = Palabras3[i][f+2];
									for(int p=0; p<m.getRowCount(); p++) {
										if(TblSimbolos[p][0].equals(Ident2)) {
											TDato2=""+m.getValueAt(p, 2);
											System.out.println("SE IDENTIFICO EL TIPO DE DATO 2 " + TDato2);
											
											// CHECAR EL CASO CUANDO SE TIENE UN NUMERO
											
											//SEGUNDO IDENTIFICADOR
											
											if(TDato2.equals("@Entero")) {
												
												if(Palabras3[i][f+3].matches(";")){
													// OKKKK
													System.out.println("OKKKK");;
													break;
												}
												
												else if(Palabras3[i][f+3].matches("[-+*]")) {
													
													System.out.println("SE IDENTIFICO EL OPERADOR + - / *");
													
													if(Palabras3[i][f+4].matches("SE_[0-9a-zA-Z]+")) {
														
														
														System.out.println("LA OPERACION CONTINUA");
														Ident3 = Palabras3[i][f+4];
														for(int q=0; q<m.getRowCount(); q++) {
															if(TblSimbolos[q][0].equals(Ident3)) {
																TDato3=""+m.getValueAt(q, 2);
																System.out.println("SE IDENTIFICO EL TIPO DE DATO 3 " + TDato3);
																
																// TERCER IDENTIFICADOR
																if(TDato3.equals("@Entero")) {
																	//OKKKKK
																	System.out.println("LA OPERACION ES CORRECTA ENTERO");
																}
																else if (TDato3.equals("@Cadena")){
																	//INCOPATIBILIDAD DE TIPOS
																	System.out.println("INCOPATIBILIDAD CON CADENA");
																	nE=nE+1;
																	ErrorSem[0]="ERSem"+nE;
																	ErrorSem[1]=Palabras3[i][f+4];
																	ErrorSem[2]=""+(i+1);
																	ErrorSem[3]="Incopatibilidad de tipos @Entero";
																	mE.addRow(ErrorSem);
																	
																}
																else if (TDato3.equals("@Char")) {
																	System.out.println("INCOPATIBILIDAD CON CHAR");
																	nE=nE+1;
																	ErrorSem[0]="ERSem"+nE;
																	ErrorSem[1]=Palabras3[i][f+4];
																	ErrorSem[2]=""+(i+1);
																	ErrorSem[3]="Incopatibilidad de tipos @Entero";
																	mE.addRow(ErrorSem);
																	
																}
																else {
																	System.out.println("VARIABLE INDEFINIDA");
																	nE=nE+1;
																	ErrorSem[0]="ERSem"+nE;
																	ErrorSem[1]=Palabras3[i][f+4];
																	ErrorSem[2]=""+(i+1);
																	ErrorSem[3]="Variable Indefinida";
																	mE.addRow(ErrorSem);
																}
															}
															else {
																TDato3="ErrorLexico";
															}
														}	
													}
												}
												
												else {
													// CUANDO NO SE TIENE UN OPERADOR + - / * 
												}
											}
											
											else if (TDato2.equals("@Cadena")){
												//INCOPATIBILIDAD DE TIPOS
												System.out.println("INCOPATIBILIDAD CON CADENA");
												nE=nE+1;
												ErrorSem[0]="ERSem"+nE;
												ErrorSem[1]=Palabras3[i][f+2];
												ErrorSem[2]=""+(i+1);
												ErrorSem[3]="Incopatibilidad de tipos @Entero";
												mE.addRow(ErrorSem);
												
											}
											else if (TDato2.equals("@Char")) {
												System.out.println("INCOPATIBILIDAD CON CHAR");
												nE=nE+1;
												ErrorSem[0]="ERSem"+nE;
												ErrorSem[1]=Palabras3[i][f+2];
												ErrorSem[2]=""+(i+1);
												ErrorSem[3]="Incopatibilidad de tipos @Entero";
												mE.addRow(ErrorSem);
											}
											else {
												System.out.println("VARIABLE INDEFINIDA");
												nE=nE+1;
												ErrorSem[0]="ERSem"+nE;
												ErrorSem[1]=Palabras3[i][f+2];
												ErrorSem[2]=""+(i+1);
												ErrorSem[3]="Variable Indefinida";
												mE.addRow(ErrorSem);
											}
											
										}
										
									}
									
									//----------------
									
								}
							}
							
							else if(TDato.equals("@Cadena")) {
								
									if(Palabras3[i][f+2].matches("SE_[0-9a-zA-Z]+")) {
									
									System.out.println("LA OPERACION CONTINUA");
									
									Ident2 = Palabras3[i][f+2];
									for(int p=0; p<m.getRowCount(); p++) {
										if(TblSimbolos[p][0].equals(Ident2)) {
											TDato2=""+m.getValueAt(p, 2);
											System.out.println("SE IDENTIFICO EL TIPO DE DATO 2 " + TDato2);
											
											
											
											//SEGUNDO IDENTIFICADOR
											
											if(TDato2.equals("@Cadena")) {
												
												if(Palabras3[i][f+3].matches(";")){
													// OKKKK
													System.out.println("OKKKK");;
													break;
												}
												
												else if(Palabras3[i][f+3].matches("[-+]")) {
													
													System.out.println("SE IDENTIFICO EL OPERADOR + -");
													
													if(Palabras3[i][f+4].matches("SE_[0-9a-zA-Z]+")) {
														
														
														System.out.println("LA OPERACION CONTINUA");
														Ident3 = Palabras3[i][f+4];
														for(int q=0; q<m.getRowCount(); q++) {
															if(TblSimbolos[q][0].equals(Ident3)) {
																TDato3=""+m.getValueAt(q, 2);
																System.out.println("SE IDENTIFICO EL TIPO DE DATO 3 " + TDato3);
																
																// TERCER IDENTIFICADOR
																if(TDato3.equals("@Cadena")) {
																	//OKKKKK
																	System.out.println("LA OPERACION ES CORRECTA ENTERO");
																}
																else if (TDato3.equals("@Entero")){
																	//INCOPATIBILIDAD DE TIPOS
																	System.out.println("INCOPATIBILIDAD CON ENTERO");
																	nE=nE+1;
																	ErrorSem[0]="ERSem"+nE;
																	ErrorSem[1]=Palabras3[i][f+4];
																	ErrorSem[2]=""+(i+1);
																	ErrorSem[3]="Incopatibilidad de tipos @Cadena";
																	mE.addRow(ErrorSem);
																	
																}
																else if (TDato3.equals("@Char")) {
																	System.out.println("INCOPATIBILIDAD CON CHAR");
																	nE=nE+1;
																	ErrorSem[0]="ERSem"+nE;
																	ErrorSem[1]=Palabras3[i][f+4];
																	ErrorSem[2]=""+(i+1);
																	ErrorSem[3]="Incopatibilidad de tipos @Cadena";
																	mE.addRow(ErrorSem);
																	
																}
																else {
																	System.out.println("VARIABLE INDEFINIDA");
																	nE=nE+1;
																	ErrorSem[0]="ERSem"+nE;
																	ErrorSem[1]=Palabras3[i][f+4];
																	ErrorSem[2]=""+(i+1);
																	ErrorSem[3]="Variable Indefinida";
																	mE.addRow(ErrorSem);
																}
															}
															else {
																TDato3="ErrorLexico";
															}
														}	
													}
												}
												
												else {
													// CUANDO NO SE TIENE UN OPERADOR + - / * 
												}
											}
											
											else if (TDato2.equals("@Entero")){
												//INCOPATIBILIDAD DE TIPOS
												System.out.println("INCOPATIBILIDAD CON ENTERO");
												nE=nE+1;
												ErrorSem[0]="ERSem"+nE;
												ErrorSem[1]=Palabras3[i][f+2];
												ErrorSem[2]=""+(i+1);
												ErrorSem[3]="Incopatibilidad de tipos @Cadena";
												mE.addRow(ErrorSem);
												
											}
											else if (TDato2.equals("@Char")) {
												System.out.println("INCOPATIBILIDAD CON CHAR");
												nE=nE+1;
												ErrorSem[0]="ERSem"+nE;
												ErrorSem[1]=Palabras3[i][f+2];
												ErrorSem[2]=""+(i+1);
												ErrorSem[3]="Incopatibilidad de tipos @Cadena";
												mE.addRow(ErrorSem);
											}
											else {
												System.out.println("VARIABLE INDEFINIDA");
												nE=nE+1;
												ErrorSem[0]="ERSem"+nE;
												ErrorSem[1]=Palabras3[i][f+2];
												ErrorSem[2]=""+(i+1);
												ErrorSem[3]="Variable Indefinida";
												mE.addRow(ErrorSem);
											}
											
										}
										
									}
									
									//----------------
									
								}
							}
							
							else if(TDato.equals("@Char")) {
								
									if(Palabras3[i][f+2].matches("SE_[0-9a-zA-Z]+")) {
									
									System.out.println("LA OPERACION CONTINUA");
									
									Ident2 = Palabras3[i][f+2];
									for(int p=0; p<m.getRowCount(); p++) {
										if(TblSimbolos[p][0].equals(Ident2)) {
											TDato2=""+m.getValueAt(p, 2);
											System.out.println("SE IDENTIFICO EL TIPO DE DATO 2 " + TDato2);
											
											// CHECAR EL CASO CUANDO SE TIENE UN NUMERO
											
											//SEGUNDO IDENTIFICADOR
											
											if(TDato2.equals("@Char") || TDato2.equals("@Entero")) {
												
												if(Palabras3[i][f+3].matches(";")){
													// OKKKK
													System.out.println("OKKKK");;
													break;
												}
												
												else if(Palabras3[i][f+3].matches("[-+*/]")) {
													
													System.out.println("SE IDENTIFICO EL OPERADOR + - / *");
													
													if(Palabras3[i][f+4].matches("SE_[0-9a-zA-Z]+")) {
														
														
														System.out.println("LA OPERACION CONTINUA");
														Ident3 = Palabras3[i][f+4];
														for(int q=0; q<m.getRowCount(); q++) {
															if(TblSimbolos[q][0].equals(Ident3)) {
																TDato3=""+m.getValueAt(q, 2);
																System.out.println("SE IDENTIFICO EL TIPO DE DATO 3 " + TDato3);
																
																// TERCER IDENTIFICADOR
																if(TDato3.equals("@Char") || TDato3.equals("@Entero")) {
																	//OKKKKK
																	System.out.println("LA OPERACION ES CORRECTA ENTERO");
																}
																else if (TDato3.equals("@Cadena")){
																	//INCOPATIBILIDAD DE TIPOS
																	System.out.println("INCOPATIBILIDAD CON CADENA");
																	nE=nE+1;
																	ErrorSem[0]="ERSem"+nE;
																	ErrorSem[1]=Palabras3[i][f+4];
																	ErrorSem[2]=""+(i+1);
																	ErrorSem[3]="Incopatibilidad de tipos @Char";
																	mE.addRow(ErrorSem);
																	
																}								
																else {
																	System.out.println("VARIABLE INDEFINIDA");
																	nE=nE+1;
																	ErrorSem[0]="ERSem"+nE;
																	ErrorSem[1]=Palabras3[i][f+4];
																	ErrorSem[2]=""+(i+1);
																	ErrorSem[3]="Variable Indefinida";
																	mE.addRow(ErrorSem);
																}
															}
															else {
																TDato3="ErrorLexico";
															}
														}	
													}
												}
												
												else {
													// CUANDO NO SE TIENE UN OPERADOR + - / * 
												}
											}
											
											else if (TDato2.equals("@Cadena")){
												//INCOPATIBILIDAD DE TIPOS
												System.out.println("INCOPATIBILIDAD CON CADENA");
												nE=nE+1;
												ErrorSem[0]="ERSem"+nE;
												ErrorSem[1]=Palabras3[i][f+2];
												ErrorSem[2]=""+(i+1);
												ErrorSem[3]="Incopatibilidad de tipos @Char";
												mE.addRow(ErrorSem);
												
											}
											else {
												System.out.println("VARIABLE INDEFINIDA");
												nE=nE+1;
												ErrorSem[0]="ERSem"+nE;
												ErrorSem[1]=Palabras3[i][f+2];
												ErrorSem[2]=""+(i+1);
												ErrorSem[3]="Variable Indefinida";
												mE.addRow(ErrorSem);
											}
											
										}
										
									}
									
									//----------------
									
								}
								
							}
							
							else {
								System.out.println("VARIABLE INDEFINIDA");
								nE=nE+1;
								ErrorSem[0]="ERSem"+nE;
								ErrorSem[1]=Palabras3[i][f];
								ErrorSem[2]=""+(i+1);
								ErrorSem[3]="Variable Indefinida";
								mE.addRow(ErrorSem);
							}
							
						}
					}
				}  //AQUI
				
				
				
				}
				
				else {
					break;
				}
				
			}
	
		}
		
	}
	
	
	public String[][] CodigoIntermedio(String CodigoT, String TblSimbolos[][]) {
		
		//Generar numero de filas
		String [] Filas=CodigoT.split("\n[\t ]*");
		int NumeroFilas= Filas.length;
				
		String[][] Palabras;
		Palabras=new String[NumeroFilas][]; 
		for(int h=0; h<NumeroFilas; h++) {
				Palabras[h]=Filas[h].split("([\r\t\n ])+");
		}
		
		System.out.println("------ESTRUCTURA DE DATOS-------");
		for (int d=0; d<NumeroFilas; d++) {
			for(int e=0; e<Palabras[d].length; e++) {
				System.out.println("Fila: "+d+" palabra: "+e+" "+Palabras[d][e]);
			}
		}
		
		String[][] TablaTriplos = new String[50][4];
		
		int FilaTriplo=0;
		int InicioDoWhile=0;
		int FinDoWhile;
		//int NTR=1;
		
		//int FilaA=-1;
		
		TablaTriplos[0][0]="Linea";
		TablaTriplos[0][1]="Objeto";
		TablaTriplos[0][2]="Fuente";
		TablaTriplos[0][3]="Operador";
		
		for(int i=0; i<NumeroFilas; i++)
		{
			for(int f=0; f<Palabras[i].length; f++) {
				
				//DO
				if(Palabras[i][f].matches("Do|do")) {
					InicioDoWhile=FilaTriplo+1;
				}
				
				//ASIGNACION
				if(Palabras[i].length>=4) {
				if(Palabras[i][f].matches("[0-9a-zA-Z]+[0-9a-zA-Z_]*") && Palabras[i][f+1].matches("=") && Palabras[i][f+2].matches("[0-9a-zA-Z]+[0-9a-zA-Z_]*") && Palabras[i][f+3].matches(";")) {
					
					System.out.println("SE IDENTIFICA UNA ASIGNACION");
					FilaTriplo=FilaTriplo+1;
					//FilaA=FilaA+1;
					TablaTriplos[FilaTriplo][0]=""+FilaTriplo;
					TablaTriplos[FilaTriplo][1]="T1";
					TablaTriplos[FilaTriplo][2]=Palabras[i][f+2];
					TablaTriplos[FilaTriplo][3]=Palabras[i][f+1];
					FilaTriplo=FilaTriplo+1;
					//FilaA=FilaA+1;
					TablaTriplos[FilaTriplo][0]=""+FilaTriplo;
					TablaTriplos[FilaTriplo][1]=Palabras[i][f];
					TablaTriplos[FilaTriplo][2]="T1";
					TablaTriplos[FilaTriplo][3]="=";
					
					f=f+3;
				}
			}
				
				//ARITMETICAS
				if(Palabras[i].length>=6) {
				if(Palabras[i][f].matches("[0-9a-zA-Z]+[0-9a-zA-Z_]*") && Palabras[i][f+1].matches("=") && Palabras[i][f+2].matches("[0-9a-zA-Z]+[0-9a-zA-Z_]*") && Palabras[i][f+3].matches("[-+*/%]") && Palabras[i][f+4].matches("[0-9a-zA-Z]+[0-9a-zA-Z_]*") && Palabras[i][f+5].matches(";")) {
					
					System.out.println("SE IDENTIFICA UNA ARITMETICA");
					FilaTriplo=FilaTriplo+1;
					TablaTriplos[FilaTriplo][0]=""+FilaTriplo;
					TablaTriplos[FilaTriplo][1]="T1";
					TablaTriplos[FilaTriplo][2]=Palabras[i][f+2];
					TablaTriplos[FilaTriplo][3]="=";
					
					FilaTriplo=FilaTriplo+1;
					TablaTriplos[FilaTriplo][0]=""+FilaTriplo;
					TablaTriplos[FilaTriplo][1]="T1";
					TablaTriplos[FilaTriplo][2]=Palabras[i][f+4];
					TablaTriplos[FilaTriplo][3]=Palabras[i][f+3];
					
					FilaTriplo=FilaTriplo+1;
					TablaTriplos[FilaTriplo][0]=""+FilaTriplo;
					TablaTriplos[FilaTriplo][1]=Palabras[i][f];
					TablaTriplos[FilaTriplo][2]="T1";
					TablaTriplos[FilaTriplo][3]="=";
					
					f=f+5;
				}
				}
				
				//OPERADORES RELACIONALES
				if(Palabras[i].length>=5) {
					//if(Palabras[i][f].matches("[0-9a-zA-z]+[0-9a-zA-z_]*") && Palabras[i][f+1].matches("==|<=|<|>=|>|!=") && Palabras[i][f+2].matches("[0-9a-zA-z]+[0-9a-zA-z_]*")) {
					if(Palabras[i][f].matches("[(]") && Palabras[i][f+1].matches("[0-9a-zA-Z]+[0-9a-zA-Z_]*") && Palabras[i][f+2].matches("==|<=|<|>=|>|!=") && Palabras[i][f+3].matches("[0-9a-zA-Z]+[0-9a-zA-Z_]*") && Palabras[i][f+4].matches("[)]")) {
						System.out.println("SE IDENTIFICA UN OPERADOR RELACIONAL");
						FilaTriplo=FilaTriplo+1;
						TablaTriplos[FilaTriplo][0]=""+FilaTriplo;
						TablaTriplos[FilaTriplo][1]="T1";
						TablaTriplos[FilaTriplo][2]=Palabras[i][f+1];
						TablaTriplos[FilaTriplo][3]="=";
						
						FilaTriplo=FilaTriplo+1;
						TablaTriplos[FilaTriplo][0]=""+FilaTriplo;
						TablaTriplos[FilaTriplo][1]="T1";
						TablaTriplos[FilaTriplo][2]=Palabras[i][f+3];
						TablaTriplos[FilaTriplo][3]=Palabras[i][f+2];
						
						FilaTriplo=FilaTriplo+1;
						TablaTriplos[FilaTriplo][0]=""+FilaTriplo;
						TablaTriplos[FilaTriplo][1]="TR1";  //"TR"+NTR
						TablaTriplos[FilaTriplo][2]="TRUE";
						TablaTriplos[FilaTriplo][3]=""+InicioDoWhile;
						
						FilaTriplo=FilaTriplo+1;
						TablaTriplos[FilaTriplo][0]=""+FilaTriplo;
						TablaTriplos[FilaTriplo][1]="TR1"; //"TR"+NTR
						TablaTriplos[FilaTriplo][2]="FALSE";
						TablaTriplos[FilaTriplo][3]=""+(FilaTriplo+1);
						
						//NTR=NTR+1;
						f=f+4;
					}
					}
				
				
				
				//OPERADORES LOGICOS
				if(Palabras[i].length>=9) {
					if(Palabras[i][f].matches("[(]") && Palabras[i][f+1].matches("[0-9a-zA-Z]+[0-9a-zA-Z_]*") && Palabras[i][f+2].matches("==|<=|<|>=|>|!=") && Palabras[i][f+3].matches("[0-9a-zA-Z]+[0-9a-zA-Z_]*") && Palabras[i][f+4].matches("[&]{2}") && Palabras[i][f+5].matches("[0-9a-zA-Z]+[0-9a-zA-Z_]*") && Palabras[i][f+6].matches("==|<=|<|>=|>|!=") && Palabras[i][f+7].matches("[0-9a-zA-Z]+[0-9a-zA-Z_]*") && Palabras[i][f+8].matches("[)]")) {
						System.out.println("SE IDENTIFICA UN OPERADOR LOGICO &&");
						//PRIMERA CONDICION
						FilaTriplo=FilaTriplo+1;
						TablaTriplos[FilaTriplo][0]=""+FilaTriplo;
						TablaTriplos[FilaTriplo][1]="T1";
						TablaTriplos[FilaTriplo][2]=Palabras[i][f+1];
						TablaTriplos[FilaTriplo][3]="=";
						
						FilaTriplo=FilaTriplo+1;
						TablaTriplos[FilaTriplo][0]=""+FilaTriplo;
						TablaTriplos[FilaTriplo][1]="T1";
						TablaTriplos[FilaTriplo][2]=Palabras[i][f+3];
						TablaTriplos[FilaTriplo][3]=Palabras[i][f+2];
						
						FilaTriplo=FilaTriplo+1;
						TablaTriplos[FilaTriplo][0]=""+FilaTriplo;
						TablaTriplos[FilaTriplo][1]="TR1";
						TablaTriplos[FilaTriplo][2]="TRUE";
						TablaTriplos[FilaTriplo][3]=""+(FilaTriplo+2);
						
						FilaTriplo=FilaTriplo+1;
						TablaTriplos[FilaTriplo][0]=""+FilaTriplo;
						TablaTriplos[FilaTriplo][1]="TR1";
						TablaTriplos[FilaTriplo][2]="FALSE";
						TablaTriplos[FilaTriplo][3]=""+(FilaTriplo+5);
						
						//SEGUNDA CONDICION
						FilaTriplo=FilaTriplo+1;
						TablaTriplos[FilaTriplo][0]=""+FilaTriplo;
						TablaTriplos[FilaTriplo][1]="T1";
						TablaTriplos[FilaTriplo][2]=Palabras[i][f+5];
						TablaTriplos[FilaTriplo][3]="=";
						
						FilaTriplo=FilaTriplo+1;
						TablaTriplos[FilaTriplo][0]=""+FilaTriplo;
						TablaTriplos[FilaTriplo][1]="T1";
						TablaTriplos[FilaTriplo][2]=Palabras[i][f+7];
						TablaTriplos[FilaTriplo][3]=Palabras[i][f+6];
						
						FilaTriplo=FilaTriplo+1;
						TablaTriplos[FilaTriplo][0]=""+FilaTriplo;
						TablaTriplos[FilaTriplo][1]="TR1";
						TablaTriplos[FilaTriplo][2]="TRUE";
						TablaTriplos[FilaTriplo][3]=""+InicioDoWhile;
						
						FilaTriplo=FilaTriplo+1;
						TablaTriplos[FilaTriplo][0]=""+FilaTriplo;
						TablaTriplos[FilaTriplo][1]="TR1";
						TablaTriplos[FilaTriplo][2]="FALSE";
						TablaTriplos[FilaTriplo][3]=""+(FilaTriplo+1);
						
						
						
						//NTR=NTR+1;
						f=f+8;
					}
					}
				
				
				if(Palabras[i].length>=9) {
					if(Palabras[i][f].matches("[(]") && Palabras[i][f+1].matches("[0-9a-zA-Z]+[0-9a-zA-Z_]*") && Palabras[i][f+2].matches("==|<=|<|>=|>|!=") && Palabras[i][f+3].matches("[0-9a-zA-Z]+[0-9a-zA-Z_]*") && Palabras[i][f+4].matches("[|]{2}") && Palabras[i][f+5].matches("[0-9a-zA-Z]+[0-9a-zA-Z_]*") && Palabras[i][f+6].matches("==|<=|<|>=|>|!=") && Palabras[i][f+7].matches("[0-9a-zA-Z]+[0-9a-zA-Z_]*") && Palabras[i][f+8].matches("[)]")) {
						System.out.println("SE IDENTIFICA UN OPERADOR LOGICO ||");
						//PRIMERA CONDICION
						FilaTriplo=FilaTriplo+1;
						TablaTriplos[FilaTriplo][0]=""+FilaTriplo;
						TablaTriplos[FilaTriplo][1]="T1";
						TablaTriplos[FilaTriplo][2]=Palabras[i][f+1];
						TablaTriplos[FilaTriplo][3]="=";
						
						FilaTriplo=FilaTriplo+1;
						TablaTriplos[FilaTriplo][0]=""+FilaTriplo;
						TablaTriplos[FilaTriplo][1]="T1";
						TablaTriplos[FilaTriplo][2]=Palabras[i][f+3];
						TablaTriplos[FilaTriplo][3]=Palabras[i][f+2];
						
						FilaTriplo=FilaTriplo+1;
						TablaTriplos[FilaTriplo][0]=""+FilaTriplo;
						TablaTriplos[FilaTriplo][1]="TR1";
						TablaTriplos[FilaTriplo][2]="TRUE";
						TablaTriplos[FilaTriplo][3]=""+InicioDoWhile;
						
						FilaTriplo=FilaTriplo+1;
						TablaTriplos[FilaTriplo][0]=""+FilaTriplo;
						TablaTriplos[FilaTriplo][1]="TR1";
						TablaTriplos[FilaTriplo][2]="FALSE";
						TablaTriplos[FilaTriplo][3]=""+(FilaTriplo+1);
						
						//SEGUNDA CONDICION
						FilaTriplo=FilaTriplo+1;
						TablaTriplos[FilaTriplo][0]=""+FilaTriplo;
						TablaTriplos[FilaTriplo][1]="T1";
						TablaTriplos[FilaTriplo][2]=Palabras[i][f+5];
						TablaTriplos[FilaTriplo][3]="=";
						
						FilaTriplo=FilaTriplo+1;
						TablaTriplos[FilaTriplo][0]=""+FilaTriplo;
						TablaTriplos[FilaTriplo][1]="T1";
						TablaTriplos[FilaTriplo][2]=Palabras[i][f+7];
						TablaTriplos[FilaTriplo][3]=Palabras[i][f+6];
						
						FilaTriplo=FilaTriplo+1;
						TablaTriplos[FilaTriplo][0]=""+FilaTriplo;
						TablaTriplos[FilaTriplo][1]="TR1";
						TablaTriplos[FilaTriplo][2]="TRUE";
						TablaTriplos[FilaTriplo][3]=""+InicioDoWhile;
						
						FilaTriplo=FilaTriplo+1;
						TablaTriplos[FilaTriplo][0]=""+FilaTriplo;
						TablaTriplos[FilaTriplo][1]="TR1";
						TablaTriplos[FilaTriplo][2]="FALSE";
						TablaTriplos[FilaTriplo][3]=""+(FilaTriplo+1);
						
						
						
						//NTR=NTR+1;
						f=f+8;
					}
					}
				
				
			}
		}
		
		FilaTriplo=FilaTriplo+1;
		TablaTriplos[FilaTriplo][0]=""+FilaTriplo;
		TablaTriplos[FilaTriplo][1]=" ";
		TablaTriplos[FilaTriplo][2]=" ";
		TablaTriplos[FilaTriplo][3]=" ";
							////////// PRIMER IDENTIFICADOR
		
		int FilasTriplo=TablaTriplos.length;
		
		System.out.println("------TABLA TRIPLOS-------");
		for (int d=0; d<FilasTriplo; d++) {
			if(TablaTriplos[d][0]!=null)
			{
				for(int e=0; e<TablaTriplos[d].length; e++) {
					if(e==0)
					{
						System.out.print("	|	"+TablaTriplos[d][e] + "	|");
					}
					else if(e==3 && d==0) {
						System.out.print("	"+TablaTriplos[d][e] + "|");
					}
					else {
						System.out.print("	"+TablaTriplos[d][e] + "	|");
					}
				}
				System.out.println("\n\t-----------------------------------------------------------------");
			}
			
		}
		
		
		return(TablaTriplos);
	}
	
	public void ArchivoTriplos (String EstructuraTriplo[][]) {
		int FilasTriplo = EstructuraTriplo.length;
		try {
			PrintWriter writer = new PrintWriter("TablaTriplo.txt","UTF-8");
			for (int d=0; d<FilasTriplo; d++) {
				if(EstructuraTriplo[d][0]!=null)
				{
					for(int e=0; e<EstructuraTriplo[d].length; e++) {
						if(e==0)
						{
							writer.print("	|	"+EstructuraTriplo[d][e] + "	|");
						}
						else if(e==3 && d==0) {
							writer.print("	"+EstructuraTriplo[d][e] + "|");
						}
						else {
							writer.print("	"+EstructuraTriplo[d][e] + "	|");
						}
					}
					writer.println("\n\t-----------------------------------------------------------------");
				}
				
			}
			writer.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public String Optimizar(String CodigoOptimizar) {
		
		//Generar numero de filas
		String [] Filas=CodigoOptimizar.split("\n[\t ]*");
		int NumeroFilas= Filas.length;
						
		String[][] Palabras;
		Palabras=new String[NumeroFilas][]; 
		for(int h=0; h<NumeroFilas; h++) {
				Palabras[h]=Filas[h].split("([\r\t\n ])+");
		}
				
		System.out.println("------ESTRUCTURA DE DATOS-------");
		for (int d=0; d<NumeroFilas; d++) {
			for(int e=0; e<Palabras[d].length; e++) {
				System.out.println("Fila: "+d+" palabra: "+e+" "+Palabras[d][e]);
			}
		}
		
		int ciclo=0;
	
		String Validar;
		int repeticiones=0;
		int reoptimizar=0;
		
		do {
			reoptimizar=0;
			
			for(int i=0; i<NumeroFilas; i++)
			{
				for(int f=0; f<Palabras[i].length; f++) {
							
					
					//DO
					if(Palabras[i][f].matches("Do|do")) {
						ciclo=1;
						System.out.println("esta dentro de un do");
					}
					
					else if(Palabras[i][f].matches("While|while")) {
						ciclo=0;
						System.out.println("esta fuera de un do");
					}
					else {
						
					}
					
					//ASIGNACION
					if(Palabras[i].length>=6) {	
						if(Palabras[i][f].matches("[0-9a-zA-Z]+[0-9a-zA-Z_]*") && Palabras[i][f+1].matches("=") && Palabras[i][f+2].matches("[0-9a-zA-Z]+[0-9a-zA-Z_]*") && Palabras[i][f+3].matches("[-+*/%]") && Palabras[i][f+4].matches("[0-9a-zA-Z]+[0-9a-zA-Z_]*") && Palabras[i][f+5].matches(";")) {
							
							System.out.println("SE IDENTIFICA UNA ARITMETICA");
							Validar=Palabras[i][f];
							
							if(ciclo==1) {
								System.out.println("se buscara en todo el codigo " +Validar);
								for(int i2=0; i2<NumeroFilas; i2++)
								{
									for(int f2=0; f2<Palabras[i2].length; f2++) {
										
										if(Palabras[i2][f2].equals(Validar)) {
											repeticiones=repeticiones+1;
											
										}
										
									}
								}
								System.out.println("se repite "+Validar+" "+repeticiones+" veces");
							}
							else if(ciclo==0) {
								System.out.println("se buscara en lo que falta del codigo "+Validar);
								for(int i3=i; i3<NumeroFilas; i3++)
								{
									for(int f3=f; f3<Palabras[i3].length; f3++) {
									
										if(Palabras[i3][f3].equals(Validar)) {
											repeticiones=repeticiones+1;
											
										}
										
									}
								}
								System.out.println("se repite "+Validar+" "+repeticiones+" veces");
							}
							
							if(repeticiones<=1) {
								System.out.println("no se utiliza en todo el programa");
								Palabras[i][f]="null/";
								Palabras[i][f+1]="null/";
								Palabras[i][f+2]="null/";
								Palabras[i][f+3]="null/";
								Palabras[i][f+4]="null/";
								Palabras[i][f+5]="null/";
								
								//analizar varias veces
								reoptimizar=1;
							}
							repeticiones=0;
							
							f=f+5;
						}
						else {
							//f=f+5;
						}
						
						
					}
				}
			}
				
		}while(reoptimizar==1);
		
		
		
		String Text="";	
		int salto=1;
		for(int fi=0; fi<NumeroFilas; fi++)
		{
			for(int pa=0; pa<Palabras[fi].length; pa++) {
				if(Palabras[fi][pa].equals("null/")) {
					salto=0;
				}
				else {
					Text=Text+Palabras[fi][pa]+" ";
					salto=1;
				}
			}
			if(salto==1) {
				Text=Text+"\n";
			}
			
		}
		
			
		
		
		return(Text);
		
		
	}
	
	
	
	
	public String[][] CodigoEnsamblador(String CodigoT) {
		
		//Generar numero de filas
		String [] Filas=CodigoT.split("\n[\t ]*");
		int NumeroFilas= Filas.length;
				
		String[][] Palabras;
		Palabras=new String[NumeroFilas][]; 
		for(int h=0; h<NumeroFilas; h++) {
				Palabras[h]=Filas[h].split("([\r\t\n ])+");
		}
		
		System.out.println("------ESTRUCTURA DE DATOS-------");
		for (int d=0; d<NumeroFilas; d++) {
			for(int e=0; e<Palabras[d].length; e++) {
				System.out.println("Fila: "+d+" palabra: "+e+" "+Palabras[d][e]);
			}
		}
		
		String[][] TablaEnsamblador = new String[50][4];
		
		int FilaTriplo=0;
		int InicioDoWhile=0;
		int FinDoWhile;
		//int NTR=1;
		
		//int FilaA=-1;
		
		TablaEnsamblador[0][0]="";
		TablaEnsamblador[0][1]="";
		TablaEnsamblador[0][2]="";
		TablaEnsamblador[0][3]="";
		
		String OperadorRelacional="0";
		String OperadorRelacional2="0";
		
		for(int i=0; i<NumeroFilas; i++)
		{
			for(int f=0; f<Palabras[i].length; f++) {
				
				//DO
				if(Palabras[i][f].matches("Do|do")) {
					InicioDoWhile=FilaTriplo+1;
				}
				
				//ASIGNACION
				if(Palabras[i].length>=4) {
				if(Palabras[i][f].matches("[0-9a-zA-Z]+[0-9a-zA-Z_]*") && Palabras[i][f+1].matches("=") && Palabras[i][f+2].matches("[0-9a-zA-Z]+[0-9a-zA-Z_]*") && Palabras[i][f+3].matches(";")) {
					
					System.out.println("SE IDENTIFICA UNA ASIGNACION");
					FilaTriplo=FilaTriplo+1;
					//FilaA=FilaA+1;
					TablaEnsamblador[FilaTriplo][0]="LINE-"+FilaTriplo+":";
					TablaEnsamblador[FilaTriplo][1]="MOV";
					TablaEnsamblador[FilaTriplo][2]="AX,";
					TablaEnsamblador[FilaTriplo][3]=Palabras[i][f+2]+";";
					FilaTriplo=FilaTriplo+1;
					//FilaA=FilaA+1;
					TablaEnsamblador[FilaTriplo][0]="LINE-"+FilaTriplo+":";
					TablaEnsamblador[FilaTriplo][1]="MOV";
					TablaEnsamblador[FilaTriplo][2]=Palabras[i][f]+",";
					TablaEnsamblador[FilaTriplo][3]="AX;";
					
					f=f+3;
				}
			}
				
				//ARITMETICAS
				if(Palabras[i].length>=6) {
				if(Palabras[i][f].matches("[0-9a-zA-Z]+[0-9a-zA-Z_]*") && Palabras[i][f+1].matches("=") && Palabras[i][f+2].matches("[0-9a-zA-Z]+[0-9a-zA-Z_]*") && Palabras[i][f+3].matches("[+]") && Palabras[i][f+4].matches("[0-9a-zA-Z]+[0-9a-zA-Z_]*") && Palabras[i][f+5].matches(";")) {
					
					System.out.println("SE IDENTIFICA UNA SUMA");
					FilaTriplo=FilaTriplo+1;
					TablaEnsamblador[FilaTriplo][0]="LINE-"+FilaTriplo+":";
					TablaEnsamblador[FilaTriplo][1]="MOV";
					TablaEnsamblador[FilaTriplo][2]="AX,";
					TablaEnsamblador[FilaTriplo][3]=Palabras[i][f+2]+";";
					
					FilaTriplo=FilaTriplo+1;
					TablaEnsamblador[FilaTriplo][0]="LINE-"+FilaTriplo+":";
					TablaEnsamblador[FilaTriplo][1]="ADD";
					TablaEnsamblador[FilaTriplo][2]="AX,";
					TablaEnsamblador[FilaTriplo][3]=Palabras[i][f+4]+";";
					
					FilaTriplo=FilaTriplo+1;
					TablaEnsamblador[FilaTriplo][0]="LINE-"+FilaTriplo+":";
					TablaEnsamblador[FilaTriplo][1]="MOV";
					TablaEnsamblador[FilaTriplo][2]=Palabras[i][f]+",";
					TablaEnsamblador[FilaTriplo][3]="AX;";
					
					f=f+5;
				}
			}
				
				if(Palabras[i].length>=6) {
					if(Palabras[i][f].matches("[0-9a-zA-Z]+[0-9a-zA-Z_]*") && Palabras[i][f+1].matches("=") && Palabras[i][f+2].matches("[0-9a-zA-Z]+[0-9a-zA-Z_]*") && Palabras[i][f+3].matches("-") && Palabras[i][f+4].matches("[0-9a-zA-Z]+[0-9a-zA-Z_]*") && Palabras[i][f+5].matches(";")) {
						
						System.out.println("SE IDENTIFICA UNA RESTA");
						FilaTriplo=FilaTriplo+1;
						TablaEnsamblador[FilaTriplo][0]="LINE-"+FilaTriplo+":";
						TablaEnsamblador[FilaTriplo][1]="MOV";
						TablaEnsamblador[FilaTriplo][2]="AX,";
						TablaEnsamblador[FilaTriplo][3]=Palabras[i][f+2]+";";
						
						FilaTriplo=FilaTriplo+1;
						TablaEnsamblador[FilaTriplo][0]="LINE-"+FilaTriplo+":";
						TablaEnsamblador[FilaTriplo][1]="SUB";
						TablaEnsamblador[FilaTriplo][2]="AX,";
						TablaEnsamblador[FilaTriplo][3]=Palabras[i][f+4]+";";
						
						FilaTriplo=FilaTriplo+1;
						TablaEnsamblador[FilaTriplo][0]="LINE-"+FilaTriplo+":";
						TablaEnsamblador[FilaTriplo][1]="MOV";
						TablaEnsamblador[FilaTriplo][2]=Palabras[i][f]+",";
						TablaEnsamblador[FilaTriplo][3]="AX;";
						
						f=f+5;
					}
				}
				
				if(Palabras[i].length>=6) {
					if(Palabras[i][f].matches("[0-9a-zA-Z]+[0-9a-zA-Z_]*") && Palabras[i][f+1].matches("=") && Palabras[i][f+2].matches("[0-9a-zA-Z]+[0-9a-zA-Z_]*") && Palabras[i][f+3].matches("[*]") && Palabras[i][f+4].matches("[0-9a-zA-Z]+[0-9a-zA-Z_]*") && Palabras[i][f+5].matches(";")) {
						
						System.out.println("SE IDENTIFICA UNA MULTIPLICACION");
						FilaTriplo=FilaTriplo+1;
						TablaEnsamblador[FilaTriplo][0]="LINE-"+FilaTriplo+":";
						TablaEnsamblador[FilaTriplo][1]="MOV";
						TablaEnsamblador[FilaTriplo][2]="AL,";
						TablaEnsamblador[FilaTriplo][3]=Palabras[i][f+2]+";";
						
						FilaTriplo=FilaTriplo+1;
						TablaEnsamblador[FilaTriplo][0]="LINE-"+FilaTriplo+":";
						TablaEnsamblador[FilaTriplo][1]="MOV";
						TablaEnsamblador[FilaTriplo][2]="BL,";
						TablaEnsamblador[FilaTriplo][3]=Palabras[i][f+4]+";";
						
						FilaTriplo=FilaTriplo+1;
						TablaEnsamblador[FilaTriplo][0]="LINE-"+FilaTriplo+":";
						TablaEnsamblador[FilaTriplo][1]="MUL";
						TablaEnsamblador[FilaTriplo][2]="BL;";
						TablaEnsamblador[FilaTriplo][3]="";
						
						FilaTriplo=FilaTriplo+1;
						TablaEnsamblador[FilaTriplo][0]="LINE-"+FilaTriplo+":";
						TablaEnsamblador[FilaTriplo][1]="MOV";
						TablaEnsamblador[FilaTriplo][2]=Palabras[i][f]+",";
						TablaEnsamblador[FilaTriplo][3]="AX;";
						
						
						f=f+5;
					}
				}
				
				
				if(Palabras[i].length>=6) {
					if(Palabras[i][f].matches("[0-9a-zA-Z]+[0-9a-zA-Z_]*") && Palabras[i][f+1].matches("=") && Palabras[i][f+2].matches("[0-9a-zA-Z]+[0-9a-zA-Z_]*") && Palabras[i][f+3].matches("/") && Palabras[i][f+4].matches("[0-9a-zA-Z]+[0-9a-zA-Z_]*") && Palabras[i][f+5].matches(";")) {
						
						System.out.println("SE IDENTIFICA UNA DIVISION");
						FilaTriplo=FilaTriplo+1;
						TablaEnsamblador[FilaTriplo][0]="LINE-"+FilaTriplo+":";
						TablaEnsamblador[FilaTriplo][1]="MOV";
						TablaEnsamblador[FilaTriplo][2]="AX,";
						TablaEnsamblador[FilaTriplo][3]=Palabras[i][f+2]+";";
						
						FilaTriplo=FilaTriplo+1;
						TablaEnsamblador[FilaTriplo][0]="LINE-"+FilaTriplo+":";
						TablaEnsamblador[FilaTriplo][1]="MOV";
						TablaEnsamblador[FilaTriplo][2]="BL,";
						TablaEnsamblador[FilaTriplo][3]=Palabras[i][f+4]+";";
						
						FilaTriplo=FilaTriplo+1;
						TablaEnsamblador[FilaTriplo][0]="LINE-"+FilaTriplo+":";
						TablaEnsamblador[FilaTriplo][1]="DIV";
						TablaEnsamblador[FilaTriplo][2]="BL;";
						TablaEnsamblador[FilaTriplo][3]="";
						
						FilaTriplo=FilaTriplo+1;
						TablaEnsamblador[FilaTriplo][0]="LINE-"+FilaTriplo+":";
						TablaEnsamblador[FilaTriplo][1]="MOV";
						TablaEnsamblador[FilaTriplo][2]=Palabras[i][f]+",";
						TablaEnsamblador[FilaTriplo][3]="AL;";
						
						
						f=f+5;
					}
				}
				
				
				if(Palabras[i].length>=6) {
					if(Palabras[i][f].matches("[0-9a-zA-Z]+[0-9a-zA-Z_]*") && Palabras[i][f+1].matches("=") && Palabras[i][f+2].matches("[0-9a-zA-Z]+[0-9a-zA-Z_]*") && Palabras[i][f+3].matches("%") && Palabras[i][f+4].matches("[0-9a-zA-Z]+[0-9a-zA-Z_]*") && Palabras[i][f+5].matches(";")) {
						
						System.out.println("SE IDENTIFICA UN MODULO");
						FilaTriplo=FilaTriplo+1;
						TablaEnsamblador[FilaTriplo][0]="LINE-"+FilaTriplo+":";
						TablaEnsamblador[FilaTriplo][1]="MOV";
						TablaEnsamblador[FilaTriplo][2]="AX,";
						TablaEnsamblador[FilaTriplo][3]=Palabras[i][f+2]+";";
						
						FilaTriplo=FilaTriplo+1;
						TablaEnsamblador[FilaTriplo][0]="LINE-"+FilaTriplo+":";
						TablaEnsamblador[FilaTriplo][1]="MOV";
						TablaEnsamblador[FilaTriplo][2]="BL,";
						TablaEnsamblador[FilaTriplo][3]=Palabras[i][f+4]+";";
						
						FilaTriplo=FilaTriplo+1;
						TablaEnsamblador[FilaTriplo][0]="LINE-"+FilaTriplo+":";
						TablaEnsamblador[FilaTriplo][1]="DIV";
						TablaEnsamblador[FilaTriplo][2]="BL;";
						TablaEnsamblador[FilaTriplo][3]="";
						
						FilaTriplo=FilaTriplo+1;
						TablaEnsamblador[FilaTriplo][0]="LINE-"+FilaTriplo+":";
						TablaEnsamblador[FilaTriplo][1]="MOV";
						TablaEnsamblador[FilaTriplo][2]=Palabras[i][f]+",";
						TablaEnsamblador[FilaTriplo][3]="AH;";
						
						
						f=f+5;
					}
				}
				
				
				//OPERADORES RELACIONALES
				if(Palabras[i].length>=5) {
					//if(Palabras[i][f].matches("[0-9a-zA-z]+[0-9a-zA-z_]*") && Palabras[i][f+1].matches("==|<=|<|>=|>|!=") && Palabras[i][f+2].matches("[0-9a-zA-z]+[0-9a-zA-z_]*")) {
					if(Palabras[i][f].matches("[(]") && Palabras[i][f+1].matches("[0-9a-zA-Z]+[0-9a-zA-Z_]*") && Palabras[i][f+2].matches("==|<=|<|>=|>|!=") && Palabras[i][f+3].matches("[0-9a-zA-Z]+[0-9a-zA-Z_]*") && Palabras[i][f+4].matches("[)]")) {
						System.out.println("SE IDENTIFICA UN OPERADOR RELACIONAL");
						
						switch(Palabras[i][f+2]){
							case "==":
								OperadorRelacional="EQ";
								break;
							case "<=":
								OperadorRelacional="LE";
								break;
							case "<":
								OperadorRelacional="LT";
								break;
							case ">=":
								OperadorRelacional="GE";
								break;
							case ">":
								OperadorRelacional="GT";
								break;
							case "!=":
								OperadorRelacional="NE";
								break;
								
						}
						
						FilaTriplo=FilaTriplo+1;
						TablaEnsamblador[FilaTriplo][0]="LINE-"+FilaTriplo+":";
						TablaEnsamblador[FilaTriplo][1]="MOV";
						TablaEnsamblador[FilaTriplo][2]="AX,";
						TablaEnsamblador[FilaTriplo][3]=Palabras[i][f+1]+";";
						
						FilaTriplo=FilaTriplo+1;
						TablaEnsamblador[FilaTriplo][0]="LINE-"+FilaTriplo+":";
						TablaEnsamblador[FilaTriplo][1]="CMP";
						TablaEnsamblador[FilaTriplo][2]="AX,";
						TablaEnsamblador[FilaTriplo][3]=Palabras[i][f+3]+";";
						
						FilaTriplo=FilaTriplo+1;
						TablaEnsamblador[FilaTriplo][0]="LINE-"+FilaTriplo+":";
						TablaEnsamblador[FilaTriplo][1]=OperadorRelacional;  //"TR"+NTR-----------------------------------------------
						TablaEnsamblador[FilaTriplo][2]="LINE-"+InicioDoWhile;
						TablaEnsamblador[FilaTriplo][3]=";";
						
						FilaTriplo=FilaTriplo+1;
						TablaEnsamblador[FilaTriplo][0]="LINE-"+FilaTriplo+":";
						TablaEnsamblador[FilaTriplo][1]="JMP"; //"TR"+NTR
						TablaEnsamblador[FilaTriplo][2]="LINE-"+(FilaTriplo+1);
						TablaEnsamblador[FilaTriplo][3]=";";
						
						//NTR=NTR+1;
						f=f+4;
					}
					}
				
				
				
				//OPERADORES LOGICOS
				if(Palabras[i].length>=9) {
					if(Palabras[i][f].matches("[(]") && Palabras[i][f+1].matches("[0-9a-zA-Z]+[0-9a-zA-Z_]*") && Palabras[i][f+2].matches("==|<=|<|>=|>|!=") && Palabras[i][f+3].matches("[0-9a-zA-Z]+[0-9a-zA-Z_]*") && Palabras[i][f+4].matches("[&]{2}") && Palabras[i][f+5].matches("[0-9a-zA-Z]+[0-9a-zA-Z_]*") && Palabras[i][f+6].matches("==|<=|<|>=|>|!=") && Palabras[i][f+7].matches("[0-9a-zA-Z]+[0-9a-zA-Z_]*") && Palabras[i][f+8].matches("[)]")) {
						System.out.println("SE IDENTIFICA UN OPERADOR LOGICO &&");
						
						switch(Palabras[i][f+2]){
						case "==":
							OperadorRelacional="EQ";
							break;
						case "<=":
							OperadorRelacional="LE";
							break;
						case "<":
							OperadorRelacional="LT";
							break;
						case ">=":
							OperadorRelacional="GE";
							break;
						case ">":
							OperadorRelacional="GT";
							break;
						case "!=":
							OperadorRelacional="NE";
							break;
							
					}
						
						switch(Palabras[i][f+6]){
						case "==":
							OperadorRelacional2="EQ";
							break;
						case "<=":
							OperadorRelacional2="LE";
							break;
						case "<":
							OperadorRelacional2="LT";
							break;
						case ">=":
							OperadorRelacional2="GE";
							break;
						case ">":
							OperadorRelacional2="GT";
							break;
						case "!=":
							OperadorRelacional2="NE";
							break;
							
					}
						
						
						//PRIMERA CONDICION
						FilaTriplo=FilaTriplo+1;
						TablaEnsamblador[FilaTriplo][0]="LINE-"+FilaTriplo+":";
						TablaEnsamblador[FilaTriplo][1]="MOV";
						TablaEnsamblador[FilaTriplo][2]="AX,";
						TablaEnsamblador[FilaTriplo][3]=Palabras[i][f+1]+";";
						
						FilaTriplo=FilaTriplo+1;
						TablaEnsamblador[FilaTriplo][0]="LINE-"+FilaTriplo+":";
						TablaEnsamblador[FilaTriplo][1]="CMP";
						TablaEnsamblador[FilaTriplo][2]="AX,";
						TablaEnsamblador[FilaTriplo][3]=Palabras[i][f+3]+";";
						
						FilaTriplo=FilaTriplo+1;
						TablaEnsamblador[FilaTriplo][0]="LINE-"+FilaTriplo+":";
						TablaEnsamblador[FilaTriplo][1]=OperadorRelacional;
						TablaEnsamblador[FilaTriplo][2]="LINE-"+(FilaTriplo+2);
						TablaEnsamblador[FilaTriplo][3]=";";
						
						FilaTriplo=FilaTriplo+1;
						TablaEnsamblador[FilaTriplo][0]="LINE-"+FilaTriplo+":";
						TablaEnsamblador[FilaTriplo][1]="JMP";
						TablaEnsamblador[FilaTriplo][2]="LINE-"+(FilaTriplo+5);
						TablaEnsamblador[FilaTriplo][3]=";";
						
						//SEGUNDA CONDICION
						FilaTriplo=FilaTriplo+1;
						TablaEnsamblador[FilaTriplo][0]="LINE-"+FilaTriplo+":";
						TablaEnsamblador[FilaTriplo][1]="MOV";
						TablaEnsamblador[FilaTriplo][2]="AX,";
						TablaEnsamblador[FilaTriplo][3]=Palabras[i][f+5]+";";
						
						FilaTriplo=FilaTriplo+1;
						TablaEnsamblador[FilaTriplo][0]="LINE-"+FilaTriplo+":";
						TablaEnsamblador[FilaTriplo][1]="CMP";
						TablaEnsamblador[FilaTriplo][2]="AX,";
						TablaEnsamblador[FilaTriplo][3]=Palabras[i][f+7]+";";
						
						FilaTriplo=FilaTriplo+1;
						TablaEnsamblador[FilaTriplo][0]="LINE-"+FilaTriplo+":";
						TablaEnsamblador[FilaTriplo][1]=OperadorRelacional2;
						TablaEnsamblador[FilaTriplo][2]="LINE-"+InicioDoWhile;
						TablaEnsamblador[FilaTriplo][3]=";";
						
						FilaTriplo=FilaTriplo+1;
						TablaEnsamblador[FilaTriplo][0]="LINE-"+FilaTriplo+":";
						TablaEnsamblador[FilaTriplo][1]="JMP";
						TablaEnsamblador[FilaTriplo][2]="LINE-"+(FilaTriplo+1);
						TablaEnsamblador[FilaTriplo][3]=";";
						
						
						
						//NTR=NTR+1;
						f=f+8;
					}
					}
				
				
				if(Palabras[i].length>=9) {
					if(Palabras[i][f].matches("[(]") && Palabras[i][f+1].matches("[0-9a-zA-Z]+[0-9a-zA-Z_]*") && Palabras[i][f+2].matches("==|<=|<|>=|>|!=") && Palabras[i][f+3].matches("[0-9a-zA-Z]+[0-9a-zA-Z_]*") && Palabras[i][f+4].matches("[|]{2}") && Palabras[i][f+5].matches("[0-9a-zA-Z]+[0-9a-zA-Z_]*") && Palabras[i][f+6].matches("==|<=|<|>=|>|!=") && Palabras[i][f+7].matches("[0-9a-zA-Z]+[0-9a-zA-Z_]*") && Palabras[i][f+8].matches("[)]")) {
						System.out.println("SE IDENTIFICA UN OPERADOR LOGICO ||");
						
						
						switch(Palabras[i][f+2]){
						case "==":
							OperadorRelacional="EQ";
							break;
						case "<=":
							OperadorRelacional="LE";
							break;
						case "<":
							OperadorRelacional="LT";
							break;
						case ">=":
							OperadorRelacional="GE";
							break;
						case ">":
							OperadorRelacional="GT";
							break;
						case "!=":
							OperadorRelacional="NE";
							break;
							
					}
						
						switch(Palabras[i][f+6]){
						case "==":
							OperadorRelacional2="EQ";
							break;
						case "<=":
							OperadorRelacional2="LE";
							break;
						case "<":
							OperadorRelacional2="LT";
							break;
						case ">=":
							OperadorRelacional2="GE";
							break;
						case ">":
							OperadorRelacional2="GT";
							break;
						case "!=":
							OperadorRelacional2="NE";
							break;
							
					}
						
						
						//PRIMERA CONDICION
						FilaTriplo=FilaTriplo+1;
						TablaEnsamblador[FilaTriplo][0]="LINE-"+FilaTriplo+":";
						TablaEnsamblador[FilaTriplo][1]="MOV";
						TablaEnsamblador[FilaTriplo][2]="AX,";
						TablaEnsamblador[FilaTriplo][3]=Palabras[i][f+1]+";";
						
						FilaTriplo=FilaTriplo+1;
						TablaEnsamblador[FilaTriplo][0]="LINE-"+FilaTriplo+":";
						TablaEnsamblador[FilaTriplo][1]="CMP";
						TablaEnsamblador[FilaTriplo][2]="AX,";
						TablaEnsamblador[FilaTriplo][3]=Palabras[i][f+3]+";";
						
						FilaTriplo=FilaTriplo+1;
						TablaEnsamblador[FilaTriplo][0]="LINE-"+FilaTriplo+":";
						TablaEnsamblador[FilaTriplo][1]=OperadorRelacional;
						TablaEnsamblador[FilaTriplo][2]="LINE-"+InicioDoWhile;
						TablaEnsamblador[FilaTriplo][3]=";";
						
						FilaTriplo=FilaTriplo+1;
						TablaEnsamblador[FilaTriplo][0]="LINE-"+FilaTriplo+":";
						TablaEnsamblador[FilaTriplo][1]="JMP";
						TablaEnsamblador[FilaTriplo][2]="LINE-"+(FilaTriplo+1);
						TablaEnsamblador[FilaTriplo][3]=";";
						
						//SEGUNDA CONDICION
						FilaTriplo=FilaTriplo+1;
						TablaEnsamblador[FilaTriplo][0]="LINE-"+FilaTriplo+":";
						TablaEnsamblador[FilaTriplo][1]="MOV";
						TablaEnsamblador[FilaTriplo][2]="AX,";
						TablaEnsamblador[FilaTriplo][3]=Palabras[i][f+5]+";";
						
						FilaTriplo=FilaTriplo+1;
						TablaEnsamblador[FilaTriplo][0]="LINE-"+FilaTriplo+":";
						TablaEnsamblador[FilaTriplo][1]="CMP";
						TablaEnsamblador[FilaTriplo][2]="AX,";
						TablaEnsamblador[FilaTriplo][3]=Palabras[i][f+7]+";";
						
						FilaTriplo=FilaTriplo+1;
						TablaEnsamblador[FilaTriplo][0]="LINE-"+FilaTriplo+":";
						TablaEnsamblador[FilaTriplo][1]=OperadorRelacional2;
						TablaEnsamblador[FilaTriplo][2]="LINE-"+InicioDoWhile;
						TablaEnsamblador[FilaTriplo][3]=";";
						
						FilaTriplo=FilaTriplo+1;
						TablaEnsamblador[FilaTriplo][0]="LINE-"+FilaTriplo+":";
						TablaEnsamblador[FilaTriplo][1]="JMP";
						TablaEnsamblador[FilaTriplo][2]="LINE-"+(FilaTriplo+1);
						TablaEnsamblador[FilaTriplo][3]=";";
						
						
						
						//NTR=NTR+1;
						f=f+8;
					}
					}
				
				
			}
		}
		
		FilaTriplo=FilaTriplo+1;
		TablaEnsamblador[FilaTriplo][0]="LINE-"+FilaTriplo+":";
		TablaEnsamblador[FilaTriplo][1]=" ";
		TablaEnsamblador[FilaTriplo][2]=" ";
		TablaEnsamblador[FilaTriplo][3]=" ";
							////////// PRIMER IDENTIFICADOR
		
		int FilasTriplo=TablaEnsamblador.length;
		int repe=0;
		/*
		for(int w=1; w<FilasTriplo; w++) {
			
				for(int x=1; x<FilasTriplo; x++) {
					if(TablaEnsamblador[w][0]!=null && TablaEnsamblador[x][2]!=null) {
						if(TablaEnsamblador[w][0].contains(TablaEnsamblador[x][2])){
							repe++;
						}
					}
					
				}
				if(repe<=0) {
					if(TablaEnsamblador[w][0]!=null) {
						TablaEnsamblador[w][0]="";
					}
					
				}
				repe=0;
				
		} */
		
		for(int w=1; w<FilasTriplo; w++) {
			
			for(int x=1; x<FilasTriplo; x++) {
				if(TablaEnsamblador[w][0]!=null && TablaEnsamblador[x][2]!=null) {
					if(TablaEnsamblador[w][0].equals(TablaEnsamblador[x][2]+":")){
						repe++;
					}
				}
				
			}
			if(repe<=0) {
				if(TablaEnsamblador[w][0]!=null) {
					TablaEnsamblador[w][0]="";
				}
				
			}
			repe=0;
			
	}
		
		
		
		
		
		
		System.out.println("------TABLA ENSAM-------");
		for (int d=0; d<FilasTriplo; d++) {
			if(TablaEnsamblador[d][0]!=null)
			{
				for(int e=0; e<TablaEnsamblador[d].length; e++) {
					if(e==0)
					{
						System.out.print("	|	"+TablaEnsamblador[d][e] + "	|");
					}
					else if(e==3 && d==0) {
						System.out.print("	"+TablaEnsamblador[d][e] + "|");
					}
					else {
						System.out.print("	"+TablaEnsamblador[d][e] + "	|");
					}
				}
				System.out.println("\n\t-----------------------------------------------------------------");
			}
			
		}
		
		
		System.out.println("------TABLA ENSAM-------");
		for (int d=0; d<FilasTriplo; d++) {
			if(TablaEnsamblador[d][0]!=null)
			{
				for(int e=0; e<TablaEnsamblador[d].length; e++) {
					if(TablaEnsamblador[d][0].equals("")) {
						TablaEnsamblador[d][0]="\t";
					}

					System.out.print(TablaEnsamblador[d][e]+" ");
				}
				System.out.println("\n");
			}
			
		}
		
		
		return(TablaEnsamblador);
	}
	
	
	public void ArchivoEnsamblador (String TablaEnsamblador[][]) {
		int FilasTriplo = TablaEnsamblador.length;
		try {
			PrintWriter writer = new PrintWriter("CodigoEnsamblador.txt","UTF-8");
			for (int d=0; d<FilasTriplo; d++) {
				if(TablaEnsamblador[d][0]!=null)
				{
					for(int e=0; e<TablaEnsamblador[d].length; e++) {
						if(TablaEnsamblador[d][0].equals("")) {
							TablaEnsamblador[d][0]="\t";
						}

						writer.print(TablaEnsamblador[d][e]+" ");
					}
					writer.print("\n\n\t");
				}
				
			}
			writer.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	/**
	 * Create the frame.
	 */
	public AL11() {
		setTitle("Equipo 11");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1350, 475);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextArea textInstrucciones = new JTextArea();
		textInstrucciones.setFont(new Font("SansSerif", Font.PLAIN, 14));
		textInstrucciones.setWrapStyleWord(true);
		textInstrucciones.setText("");
		textInstrucciones.setBounds(25, 60, 300, 200);
		contentPane.add(textInstrucciones);
		JScrollPane sp = new JScrollPane(textInstrucciones, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		sp.setSize(300, 200);
		sp.setLocation(25, 60);
		contentPane.add(sp);
		
		JTextArea textAreaTokens = new JTextArea();
		textAreaTokens.setFont(new Font("SansSerif", Font.PLAIN, 12));
		textAreaTokens.setWrapStyleWord(true);
		textAreaTokens.setLineWrap(true);
		textAreaTokens.setEditable(false);
		textAreaTokens.setBounds(350, 318, 625, 100);
		contentPane.add(textAreaTokens);
		JScrollPane tp = new JScrollPane(textAreaTokens, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		tp.setSize(625, 100);
		tp.setLocation(350, 318);
		contentPane.add(tp);
		
		
		JTextArea codigoOpt = new JTextArea();
		codigoOpt.setFont(new Font("SansSerif", Font.PLAIN, 14));
		codigoOpt.setWrapStyleWord(true);
		codigoOpt.setEditable(false);
		codigoOpt.setText("");
		codigoOpt.setBounds(1000,60,300,200);
		contentPane.add(codigoOpt);
		JScrollPane cod = new JScrollPane(codigoOpt, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		cod.setSize(300,200);
		cod.setLocation(1000,60);
		contentPane.add(cod);
		
		lblNewLabel = new JLabel("Instrucciones");
		lblNewLabel.setFont(new Font("SansSerif", Font.BOLD, 16));
		lblNewLabel.setBounds(125, 25, 126, 14);
		contentPane.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("Tabla De Simbolos");
		lblNewLabel_1.setFont(new Font("SansSerif", Font.BOLD, 16));
		lblNewLabel_1.setBounds(378, 25, 154, 14);
		contentPane.add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("Tabla De Errores");
		lblNewLabel_2.setFont(new Font("SansSerif", Font.BOLD, 16));
		lblNewLabel_2.setBounds(703, 25, 144, 14);
		contentPane.add(lblNewLabel_2);
		
		JButton btnBorrar = new JButton("Borrar");
		btnBorrar.setForeground(new Color(0, 0, 0));
		btnBorrar.setBackground(new Color(5, 219, 242));
		btnBorrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textInstrucciones.setText("");
				textAreaTokens.setText("");
				codigoOpt.setText("");
				DefaultTableModel m= (DefaultTableModel)tablaSimbolos.getModel();
				int fS=m.getRowCount();
				for (int i=0; fS>i; i++) {
					m.removeRow(0);
				}
				
				DefaultTableModel m2= (DefaultTableModel)tablaErrores.getModel();
				int fE=m2.getRowCount();
				for (int f=0; fE>f; f++) {
					m2.removeRow(0);
				}
			}
		});
		btnBorrar.setFont(new Font("SansSerif", Font.BOLD, 14));
		btnBorrar.setBounds(50, 284, 89, 40);
		contentPane.add(btnBorrar);
		
		JButton btnCompilar = new JButton("Compilar");
		btnCompilar.setForeground(new Color(0, 0, 0));
		btnCompilar.setBackground(new Color(5, 219, 242));
		btnCompilar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				// Borrar tabla antes de compilar
				DefaultTableModel m= (DefaultTableModel)tablaSimbolos.getModel();
				int fS=m.getRowCount();
				
				for (int i=0; fS>i; i++) {
					m.removeRow(0);
				}
				
				DefaultTableModel m2= (DefaultTableModel)tablaErrores.getModel();
				int fE=m2.getRowCount();
				for (int f=0; fE>f; f++) {
					m2.removeRow(0);
				}
				
				//Compilar
				String Itokens;
				String cOptimizado;
				String TextA=textInstrucciones.getText();
				if (TextA.length()==0) {
					
				}
				else {
					String Lexemas[]=Separar(textInstrucciones.getText());
					String Tokns[]=Generar(Lexemas);
					ArchivoT(Tokns);
					String EstructuraDatos[][]=MostrarTablaS(Lexemas,Tokns);
					MostrarTablaE(Lexemas, Tokns, textInstrucciones.getText());
					Itokens=ImprimirTokens(Tokns);
					textAreaTokens.setText(Itokens);
					
					//Analisis Semantico
					AsignarTipo(textInstrucciones.getText(), EstructuraDatos);
					ErrorSemantico(textInstrucciones.getText(), EstructuraDatos);
					
					
					
					//CODIGO OPTIMIZADO
					cOptimizado=Optimizar(textInstrucciones.getText());
					codigoOpt.setText(cOptimizado);
					
					//Generacion de codigo intermedio
					String Triplos[][]=CodigoIntermedio(codigoOpt.getText(), EstructuraDatos);
					ArchivoTriplos(Triplos);
					
					//Generacion de codigo objeto
					String Ensamblador[][]=CodigoEnsamblador(codigoOpt.getText());
					ArchivoEnsamblador(Ensamblador);
					
				}
				
			}
		});
		btnCompilar.setFont(new Font("SansSerif", Font.BOLD, 14));
		btnCompilar.setBounds(202, 284, 98, 40);
		contentPane.add(btnCompilar);
		
		DefaultTableModel model = new DefaultTableModel();
		tablaSimbolos = new JTable(model);
		tablaSimbolos.setFillsViewportHeight(true);
		tablaSimbolos.setBackground(new Color(255, 255, 255));
		tablaSimbolos.setFont(new Font("SansSerif", Font.PLAIN, 12));
		model.addColumn("Lexema");
		model.addColumn("Token");
		model.addColumn("Tipo");
		tablaSimbolos.setBounds(350, 60, 200, 200);
		contentPane.add(tablaSimbolos);
		JScrollPane ts = new JScrollPane(tablaSimbolos, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		ts.setBackground(new Color(255, 255, 255));
		ts.setFont(new Font("SansSerif", Font.PLAIN, 13));
		ts.setSize(200, 200);
		ts.setLocation(350, 60);
		contentPane.add(ts);
		
		
		DefaultTableModel model2 = new DefaultTableModel();
		tablaErrores = new JTable(model2);
		tablaErrores.setFillsViewportHeight(true);
		tablaErrores.setFont(new Font("SansSerif", Font.PLAIN, 12));
		model2.addColumn("Token");
		model2.addColumn("Lexema");
		model2.addColumn("Linea");
		model2.addColumn("Descripcion");
		tablaErrores.setBounds(575, 60, 400, 200);
		contentPane.add(tablaErrores);
		JScrollPane te = new JScrollPane(tablaErrores, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		te.setBackground(new Color(255, 255, 255));
		te.setFont(new Font("SansSerif", Font.PLAIN, 13));
		te.setSize(400, 200);
		te.setLocation(575, 60);
		contentPane.add(te);
		
		JLabel lblNewLabel_3 = new JLabel("Tokens");
		lblNewLabel_3.setFont(new Font("SansSerif", Font.BOLD, 16));
		lblNewLabel_3.setBounds(635, 284, 70, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_2_1 = new JLabel("Codigo Optimizado");
		lblNewLabel_2_1.setFont(new Font("SansSerif", Font.BOLD, 16));
		lblNewLabel_2_1.setBounds(1077, 20, 154, 24);
		contentPane.add(lblNewLabel_2_1);
		
		
		
		
		
	}
}
