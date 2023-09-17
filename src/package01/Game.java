package package01;
import java.awt.Color;
import java.awt.Container; // Para poder acceder a los elementos de la ventana
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame; // Para la UI
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class Game {
	
	// Creo la UI
	JFrame window;
	Container con; // Para poder acceder a los elementos de la ventana
	JPanel titleNamePanel, startButtoPanel, mainTextPanel, choiceButtonPanel, playerPanel; // Panel del nombre del juego, Panel para el boton "start"
	JLabel titleNameLabel, hpLabel, hpLabelNumber, weaponLabel, weaponLabelName; // Titulo del juego
	Font titleFont = new Font("Times New Roman", Font.PLAIN, 90); // Fuente del titulo
	Font normalFont = new Font("Times New Roman", Font.PLAIN, 28); // Funte generica
	JButton startButton, choice1, choice2, choice3, choice4;
	JTextArea mainTextArea;
	//TitleScreenHandler tsHandler = new TitleScreenHandler();
	ChoiceHandler choiceHandler = new ChoiceHandler();
	int playerHP, monsterHP;
	boolean silverRing;
	String weapon, position;



	// JFrame -> Container -> JPanel -> JLabel/JButton
	
	
	public static void main(String[] args) {
		
		new Game();

	}
	
	public Game(){
		
		// Ventana del Juego:
		window = new JFrame();
		window.setSize(800, 600);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Para poder cerrar la ventana con la "X"
		window.getContentPane().setBackground(Color.black); // Para cambiar el color de fondo de la ventana
		window.setLayout(null); // Para poder posicionar los elementos donde quiera
		window.setVisible(true); // Para que la ventana sea visible
		con = window.getContentPane(); // Para poder acceder a los elementos de la ventana
		
		// Titulo del juego:
		titleNamePanel = new JPanel(); // Panel para el titulo
		titleNamePanel.setBounds(100, 100, 600, 150); // Ubicacion del panel en la ventana
		titleNamePanel.setBackground(Color.black);
		
		titleNameLabel = new JLabel("ADVENTURE"); // Titulo del juego
		titleNameLabel.setForeground(Color.white); // Color del texto
		titleNameLabel.setFont(titleFont);
		
		titleNamePanel.add(titleNameLabel); // Pongo el Label en el Panel
		con.add(titleNamePanel); // Pongo el JPanel "titleNamePanel" dentro del Container "con"
		
		//Boton de "Start":
		startButtoPanel = new JPanel(); // Panel en donde va el boton
		startButtoPanel.setBounds(300, 400, 200, 100);
		startButtoPanel.setBackground(Color.black);
		
		startButton = new JButton("START");
		startButton.setBackground(Color.black); // Color del boton
		startButton.setForeground(Color.white); // Color del texto del boton
		startButton.setFont(normalFont);
		//Para emprolijar los contornos de los botones cuando los clickeamos:
		startButton.setFocusPainted(false);
		
		//startButton.addActionListener(tsHandler); // Agrego accion al boton cuando apreto el boton, llamando a "tsHandele"
		//Otra forma de implementar el ActionListener():
		startButton.addActionListener((tittleScreenHandler)-> createGameScreen());

		
		startButtoPanel.add(startButton);
		con.add(startButtoPanel);

		window.setVisible(true); // Necesario para que aparezcan el titulo y el boton (No se porque)

	}

	// Metodo para la pantalla del juego que contiene:
	// HP, Weapon, Texto y Opciones a elegir
	public void createGameScreen(){

		// Para cambiar de pantalla tengo que deshabiliar los paneles actuales:
		titleNamePanel.setVisible(false); 
		startButtoPanel.setVisible(false);

		// Ahora creo los paneles nuevos:
		// Panel de texto:
		mainTextPanel = new JPanel();
		mainTextPanel.setBounds(100, 100, 600, 250);
		mainTextPanel.setBackground(Color.black);

		mainTextArea = new JTextArea("This is the main text area");
		mainTextArea.setBounds(100, 100, 600, 250);
		mainTextArea.setBackground(Color.black);
		mainTextArea.setForeground(Color.white);
		mainTextArea.setFont(normalFont);
		mainTextArea.setLineWrap(true); // Para que se acomode el texto con salto de linea
		
		mainTextPanel.add(mainTextArea);
		con.add(mainTextPanel);

		// Panel de opciones:
		choiceButtonPanel = new JPanel();
		choiceButtonPanel.setBounds(250, 350, 300, 150);
		choiceButtonPanel.setBackground(Color.black);
		choiceButtonPanel.setLayout(new GridLayout(4,1)); // Para alinear los botones(1,2,3,4) 4 filas y 1 columna

		//Botones:
		choice1 = new JButton("Choice 1");
		choice1.setBackground(Color.black);
		choice1.setForeground(Color.white);
		choice1.setFont(normalFont);
		choice1.setFocusPainted(false);
		choice1.addActionListener(choiceHandler); // Para manejar las acciones al clicker el boton
		choice1.setActionCommand("c1"); // Para diferencias las acciones del los botones 1,2,3,4

		choice2 = new JButton("Choice 2");
		choice2.setBackground(Color.black);
		choice2.setForeground(Color.white);
		choice2.setFont(normalFont);
		choice2.setFocusPainted(false);
		choice2.addActionListener(choiceHandler);
		choice2.setActionCommand("c2");


		choice3 = new JButton("Choice 3");
		choice3.setBackground(Color.black);
		choice3.setForeground(Color.white);
		choice3.setFont(normalFont);
		choice3.setFocusPainted(false);
		choice3.addActionListener(choiceHandler);
		choice3.setActionCommand("c3");


		choice4 = new JButton("Choice 4");
		choice4.setBackground(Color.black);
		choice4.setForeground(Color.white);
		choice4.setFont(normalFont);
		choice4.setFocusPainted(false);
		choice4.addActionListener(choiceHandler);
		choice4.setActionCommand("c4");
		
		choiceButtonPanel.add(choice1);
		choiceButtonPanel.add(choice2);
		choiceButtonPanel.add(choice3);
		choiceButtonPanel.add(choice4);;
		con.add(choiceButtonPanel);

		// Panel del jugador (Vida, Arma, etc)
		playerPanel = new JPanel();
		playerPanel.setBounds(100, 15, 600, 50);
		playerPanel.setBackground(Color.black);
		playerPanel.setForeground(Color.white);
		playerPanel.setLayout(new GridLayout(1,4));

		con.add(playerPanel);


		hpLabel = new JLabel("HP:");
		hpLabel.setFont(normalFont);
		hpLabel.setForeground(Color.white);
		playerPanel.add(hpLabel);
		
		hpLabelNumber = new JLabel("vida");
		hpLabelNumber.setFont(normalFont);
		hpLabelNumber.setForeground(Color.white);
		playerPanel.add(hpLabelNumber);

		weaponLabel = new JLabel("Weapon:");
		weaponLabel.setFont(normalFont);
		weaponLabel.setForeground(Color.white);
		playerPanel.add(weaponLabel);

		weaponLabelName = new JLabel("arma");
		weaponLabelName.setFont(normalFont);
		weaponLabelName.setForeground(Color.white);
		playerPanel.add(weaponLabelName);

		playerSetup();

		


	}

	public void playerSetup(){

		//Condicion inicial
		playerHP = 15;
		weapon = "Knife";
		monsterHP = 20;
		silverRing = false;

		weaponLabelName.setText(weapon);
		hpLabelNumber.setText(Integer.toString(playerHP));
		//hpLabelNumber.setText("" + playerHP); // Otra forma

		townGate();
	}

	public void townGate(){
		position = "townGate"; // Para saber en que funcion estamos dentro del programa

		mainTextArea.setText("You are at the gate of the town. A guard is standing in front of you. What do you do?");
		mainTextArea.setWrapStyleWord(true); // Para que no se corten las palabras en los saltos de linea
	
		choice1.setText("Talk to the guard");
		choice2.setText("Attack the guard");
		choice3.setText("Leave");
		choice4.setText("");
	
	}

	public void talkGuard(){
		position = "talkGuard";

		mainTextArea.setText("Guard: Hello stranger. I have never seen your face. I'm sorry but i cannot let a stranger enter out town.");
		mainTextArea.setWrapStyleWord(true);
		choice1.setText(">");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
	}

	public void attackGuard(){
		position = "attackGuard";
		
		mainTextArea.setText("Guard: Hey, don't be stupid.\n\nThe guard fought back and hit you hard.\n(You recived 3 damage)");
		playerHP = playerHP - 3;
		hpLabelNumber.setText(Integer.toString(playerHP));
		mainTextArea.setWrapStyleWord(true);
		choice1.setText(">");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");

	}

	public void crossRoad(){
		position = "crossRoad";

		mainTextArea.setText("You are at a crossroad.\nIf you go south, you will go back to town.");
		choice1.setText("Go north");
		choice2.setText("Go east");
		choice3.setText("Go south");
		choice4.setText("Go west");

	}

	public void north() {
		position = "north";
		System.out.print(position);

		// You can only restore healt if you have 13 HP or less
		if(playerHP <= 13) {
			playerHP = playerHP + 2;
			mainTextArea.setText("There is a river.\n You drink water and rest at the riverside.\n\n(Your HP is recovered by 2)");
		}
		else { // Si el usuario tiene mas de 13 de vida no se recupera
			mainTextArea.setText("There is a river.\n You drink water and rest at the riverside.");
		}
		hpLabelNumber.setText(Integer.toString(playerHP));

		choice1.setText("Go south");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
	}

	public void east(){
		position = "east";
		mainTextArea.setText("You walked into a forest and found a Long Sword!\n\n(You obtained a Long Sword)");
		weapon = "Long Sword";
		weaponLabelName.setText(weapon);
		choice1.setText("Go west");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
	}

	public void west(){
		position = "west";

		mainTextArea.setText("You encounter a goblin!");
		

		choice1.setText("Fight");
		choice2.setText("Run");
		choice3.setText("");
		choice4.setText("");
	}

	public void fight(){
		position = "fight";

		mainTextArea.setText("Monster HP: " + monsterHP + "\n\nWhat do you do?");
		choice1.setText("Attack");
		choice2.setText("Run");
		choice3.setText("");
		choice4.setText("");

	}

	public void playerAttack(){
		position = "playerAttack";

		int damage = weapon == "Knife" ? 3 : 12; // Si el arma es un cuchillo, el daño es [0,2], sino es [0,4]
		int playerDamage = new java.util.Random().nextInt(damage); // Genera un numero random de ataque entre {0,1,2}

		mainTextArea.setText("You attacked the monster and gave " + playerDamage + " damage!");
		monsterHP -= playerDamage;

		choice1.setText(">");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");

	}

	public void monsterAttack(){
		position = "monsterAttack";

		int monsterDamage = new java.util.Random().nextInt(6);

		mainTextArea.setText("The monster attacked you and have " + monsterDamage + " damage!");

		playerHP = playerHP - monsterDamage < 0 ? 0 : playerHP - monsterDamage; 
		hpLabelNumber.setText(Integer.toString(playerHP));

		choice1.setText(">");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");

	}

	public void win(){
		position = "win";

		mainTextArea.setText("You defeated the monster!\nThe monster dropped a ring!\n\n(You obteined a Silver Ring)");

		silverRing = true;

		choice1.setText("Go east");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
	}

	public void lose(){
		position = "lose";

		mainTextArea.setText("You are dead!\n\n<GAME OVER>");

		choice1.setText("");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
		// Oculto los botones:	
		choice1.setVisible(false);
		choice2.setVisible(false);
		choice3.setVisible(false);
		choice4.setVisible(false);

		 // Deshabilito el componente mainTextArea para no poder interactuar y que aparezca el cursor cuando le hago click:
		 mainTextArea.setEnabled(false);
	}

	public void ending(){
		position = "ending"; // Creo que no es necesario

		mainTextArea.setText("Gaurd: Oh you killed that gobling?\nThank you so much. You are a true hero!\nWelcome to out town\n\n<THE END>");
		mainTextArea.setFont(normalFont);
		choice1.setText("");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
		// Oculto los botones:	
		choice1.setVisible(false);
		choice2.setVisible(false);
		choice3.setVisible(false);
		choice4.setVisible(false);

		 // Deshabilito el componente mainTextArea para no poder interactuar y que aparezca el cursor cuando le hago click:
		 mainTextArea.setEnabled(false);
	}

	// Implementacion generica para agregar accion a un boton (Lo evito usando: startButton.addActionListener((e)-> createGameScreen());)
	// public class TitleScreenHandler implements ActionListener{

	// 	public void actionPerformed(ActionEvent event){
			
	// 		createGameScreen(); // Cuando apreto el "start", llamo a "tsHandeler" que invoca la funcion "createGameScreen"

	// 	}

	public class ChoiceHandler implements ActionListener{

		public void actionPerformed(ActionEvent event){
			
			String yourChoice = event.getActionCommand(); // Asigna a "yourChoice" el valor del boton que clickeamos: "c1", "c2", "c3" o "c4"

			switch(position){ // Primero veo en que pantalla estoy
				case "townGate":
					switch(yourChoice){ // Aca veo que boton clickie
						case "c1":
							if(silverRing == true){
								ending();
							}
							else{
								talkGuard();
							}
							break;
						case "c2": attackGuard(); break;
						case "c3": crossRoad(); break;
						case "c4": break;		
					}
					break;

				case "talkGuard":
					switch(yourChoice){
						case "c1": townGate(); break;
						case "c2": break;
						case "c3": break;
						case "c4": break;
					}
					break;

				case "attackGuard":
					switch(yourChoice){
						case "c1": townGate(); break;
					}
					break;
				case "crossRoad":
					switch(yourChoice){
						case "c1": north(); break;
						case "c2": east(); break;
						case "c3": townGate(); break;
						case "c4": west(); break;
					}
					break;
				case "north":
					switch(yourChoice){
						case "c1": crossRoad(); break;
					}
					break;
				case "east":
					switch(yourChoice){
						case "c1": crossRoad(); break;
					}
					break;
				case "west":
					switch(yourChoice){
						case "c1": fight(); break;
						case "c2": crossRoad(); break;
					}
					break;
				case "fight":
					switch(yourChoice){
						case "c1": playerAttack(); break;
						case "c2": crossRoad(); break;
					}
					break;
				case "playerAttack":
					switch(yourChoice){
						case "c1":
							if(monsterHP <= 0){
								win();
							}
							else{
								monsterAttack();
							}
							break;
					}
					break;
				case "monsterAttack":
					switch(yourChoice){
						case "c1": 
							if(playerHP <= 0){
								lose();
							}
							else{
								fight();
							}
							break;
					}
					break;
				case "win":
					switch(yourChoice){
						case "c1": crossRoad(); break;
					}
					break;
			}
		}
	}
}

