import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;
public class interfaz {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		marco mi_marco=new marco();
		mi_marco.setVisible(true);

	}

}

class marco extends JFrame{
	JTextField texto1;
	public marco(){
		setTitle("ESCUELA INGLES");
		setBounds(300,100,500,500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		lamina mi_lamina=new lamina();
		add(mi_lamina);
	}
}

class lamina extends JPanel{
	public lamina(){
		setLayout(new BorderLayout());
//----------------------------------- COMPONENTES DE LA PRIMERA CAJA------------------------------------------------//
		JLabel dni=new JLabel("DNI");
		texto1=new JTextField(10);
		texto1.setMaximumSize(texto1.getPreferredSize());
		
		
		
//-----------------------------BOTON GUARDAR Y PONERLO A LA ESCUCHA---------------------------------------------//
		JButton agregar=new JButton("AÑADIR");
		agregar.addActionListener(new ActionListener(){
			
			public void actionPerformed(ActionEvent e) {
				

		        try {
		            //Cojo los datos
		            String DNI = texto1.getText();
		            String nombre = texto2.getText();
		            double salario = Double.parseDouble(texto3.getText());
		            boolean fijo = mi_radio.isSelected();

		            //si no hay nada seleccionado, lanzo una excepcion
		            if (!(fijo )) {
		                throw new Exception("Debes marcar si es fijo o no");
		            }

		            //Valido el dni, sino esta bien se lanza una excepcion
		           // metodos.validarDNI(DNI);

		            boolean encontrado = false;

		            //recorro la lista de profesores
		            for (profesor p : profesores) {
		                if (p.getDNI().equals(DNI)) {
		                    encontrado = true;
		                }
		            }

		            //si lo encuentro, muestro un error
		            if (encontrado) {
		                JOptionPane.showMessageDialog(null, "Ya existe un profesor con ese DNI",
		                        "Error", JOptionPane.ERROR_MESSAGE);
		            } else {
		                //Sino esta en la lista, lo añado
		                profesor p = new profesor(salario, fijo, DNI, nombre);

		                profesores.add(p);

		                JOptionPane.showMessageDialog(null, "Se ha añadido el profesor",
		                        "Añadido", JOptionPane.INFORMATION_MESSAGE);

		            }

		        } catch (DNIException | NumberFormatException ex) {
		            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		        } catch (Exception ex) {
		            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		        }
			
			}});
		
//---------------------------CREASION DE LA PRIMERA CAJA----------------------------------------------------------//
		
		Box caja1=Box.createHorizontalBox();
		caja1.add(dni);
		caja1.add(Box.createHorizontalStrut(10));
		caja1.add(texto1);
		caja1.add(Box.createHorizontalStrut(10));
		caja1.add(agregar);
		
//-------------------------------------SEGUNDA CAJA Y COMPONENTES----------------------------------------------//
		
		JLabel nombre=new JLabel("NOMBRE");
		texto2=new JTextField(10);
		texto2.setMaximumSize(texto2.getPreferredSize());
		
//-----------------------------------BOTON LIMPIAR Y PONERLO A LA ECUCHA-----------------------------------------//
		JButton limpiar=new JButton("LIMPIAR");
		limpiar.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				texto1.setText(" ");
				texto2.setText(" ");
				texto3.setText(" ");
				mi_grupo.clearSelection();
			}
			
			
			
		});
//-------------------------------------CREASION DE SEGUNDA CAJA---------------------------------------------------//
		
		Box caja2=Box.createHorizontalBox();
		caja2.add(nombre);
		caja2.add(Box.createHorizontalStrut(10));
		caja2.add(texto2);
		caja2.add(Box.createHorizontalStrut(10));
		caja2.add(limpiar);
		
		
//----------------------------------------TERCERA CAJA Y COMPONENETS------------------------------------------------//
		
		JLabel salario=new JLabel("SALARIO");
		texto3=new JTextField(10);
		texto3.setMaximumSize(texto3.getPreferredSize());
		JButton buscar=new JButton("BUSCAR");
		
		Box caja3=Box.createHorizontalBox();
		caja3.add(salario);
		caja3.add(Box.createHorizontalStrut(10));
		caja3.add(texto3);
		caja3.add(Box.createHorizontalStrut(10));
		caja3.add(buscar);
		
		
//--------------------------------------COMPONENTES DE LA CUARTA CAJA------------------------------------------------//
		JLabel contrato=new JLabel("TIPO DE CONTRATO");
		mi_grupo=new ButtonGroup();
		 mi_radio=new JRadioButton("Fijo");
		 mi_radio2=new JRadioButton("Temporal");
		mi_grupo.add(mi_radio);
		mi_grupo.add(mi_radio2);
		
		
//----------------------------------------BOTON DE SALIR Y PONERLO A LA ESCUCHA---------------------------------------//
		
		JButton salir=new JButton("SALIR");
		salir.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				System.exit(0);
				
			}
			
		});
		
		
//-----------------------------------------CREASION DE LA CUARTA CAJA----------------------------------------------------//		
		Box caja4=Box.createHorizontalBox();
		caja4.add(contrato);
		caja4.add(Box.createHorizontalStrut(10));
		caja4.add(mi_radio);
		caja4.add(mi_radio2);
		caja4.add(Box.createHorizontalStrut(10));
		caja4.add(salir);
		
		
		
//----------------------------------------CAJA VETICAL-------------------------------------------------------------//
		
		Box caja_vertical=Box.createVerticalBox();
		caja_vertical.add(caja1);
		caja_vertical.add(caja2);
		caja_vertical.add(caja3);
		caja_vertical.add(caja4);
		add(caja_vertical,BorderLayout.CENTER);
		
//-------------------------------------ARRAYLIST-----------------------------------------------------------------//
		profesores = new ArrayList<>();
	}
	
//-------------------------------------VARIABLES----------------------------------------------------------//
	 ArrayList<profesor> profesores;
	JTextField texto1;
	JTextField texto2;
	JTextField texto3;
	
	JRadioButton mi_radio;
	JRadioButton mi_radio2;
	
	ButtonGroup mi_grupo;
	
}