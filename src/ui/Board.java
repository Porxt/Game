package ui;

import util.ComputerIA;
import util.GameMaster;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Board extends JFrame implements ActionListener {

    // Player options
    private JButton buttonRock;
    private JButton buttonPaper;
    private JButton buttonScissors;
    private JButton buttonLizard;
    private JButton buttonSpock;

    // Board options
    private JButton buttonNewGame;
    private JButton buttonShowScoreboard;
    private JButton buttonExit;

    Timer showResult = new Timer(800, this);

    private final GameMaster master = new GameMaster();
    private final ComputerIA ia = new ComputerIA();
    private final GameCanvas canvas = new GameCanvas();

    public Board() {
        super("Let's Play!!");
        initComponents();
        setBounds(10, 10, 500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setResizable(false);
    }

    private void initComponents() {
        JPanel boardOptions = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JPanel playerOptions = new JPanel(new FlowLayout());

        // Player options
        buttonRock = new JButton("Piedra");
        buttonRock.setEnabled(false);
        buttonRock.addActionListener(this);

        buttonPaper = new JButton("Papel");
        buttonPaper.setEnabled(false);
        buttonPaper.addActionListener(this);

        buttonScissors = new JButton("Tijeras");
        buttonScissors.setEnabled(false);
        buttonScissors.addActionListener(this);

        buttonLizard = new JButton("Lagarto");
        buttonLizard.setEnabled(false);
        buttonLizard.addActionListener(this);

        buttonSpock = new JButton("Spok");
        buttonSpock.setEnabled(false);
        buttonSpock.addActionListener(this);

        // Board options
        buttonNewGame = new JButton("Nuevo juego");
        buttonNewGame.addActionListener(this);

        buttonShowScoreboard = new JButton("Puntuación");
        buttonShowScoreboard.addActionListener(this);

        buttonExit = new JButton("Salir");
        buttonExit.addActionListener(this);

        // Putting components in place
        boardOptions.add(buttonNewGame);
        boardOptions.add(buttonShowScoreboard);
        boardOptions.add(buttonExit);
        add(boardOptions, BorderLayout.NORTH);

        playerOptions.add(buttonRock);
        playerOptions.add(buttonPaper);
        playerOptions.add(buttonScissors);
        playerOptions.add(buttonLizard);
        playerOptions.add(buttonSpock);
        add(playerOptions, BorderLayout.SOUTH);

        add(canvas, BorderLayout.CENTER);
    }

    public void actionPerformed(ActionEvent e) {
        int playerChoice;
        if(e.getSource() == buttonExit) {
            System.exit(0);
        } else if(e.getSource() == buttonNewGame) {
            ia.makeChoice(master.getGames());
            buttonRock.setEnabled(true);
            buttonPaper.setEnabled(true);
            buttonScissors.setEnabled(true);
            buttonLizard.setEnabled(true);
            buttonSpock.setEnabled(true);
            buttonNewGame.setEnabled(false);
            canvas.clear();
        } else if(e.getSource() == buttonShowScoreboard) {
            JOptionPane.showMessageDialog(
                    this,
                    master.toString(),
                    "Puntuación",
                    JOptionPane.INFORMATION_MESSAGE
            );
        } else if(e.getSource() == buttonRock) {
            playerChoice = GameMaster.ROCK;
            GameMaster.playerWins(ia.getComputerChoice(), playerChoice, master);
            canvas.showHands(playerChoice, ia.getComputerChoice());
            showResult.start();
            ia.updateRoulette(playerChoice);
        } else if(e.getSource() == buttonPaper) {
            playerChoice = GameMaster.PAPER;
            GameMaster.playerWins(ia.getComputerChoice(), playerChoice, master);
            canvas.showHands(playerChoice, ia.getComputerChoice());
            showResult.start();
            ia.updateRoulette(playerChoice);
        } else if(e.getSource() == buttonScissors) {
            playerChoice = GameMaster.SCISSORS;
            GameMaster.playerWins(ia.getComputerChoice(), playerChoice, master);
            canvas.showHands(playerChoice, ia.getComputerChoice());
            showResult.start();
            ia.updateRoulette(playerChoice);
        } else if(e.getSource() == buttonLizard) {
            playerChoice = GameMaster.LIZARD;
            GameMaster.playerWins(ia.getComputerChoice(), playerChoice, master);
            canvas.showHands(playerChoice, ia.getComputerChoice());
            showResult.start();
            ia.updateRoulette(playerChoice);
        } else if(e.getSource() == buttonSpock) {
            playerChoice = GameMaster.SPOCK;
            GameMaster.playerWins(ia.getComputerChoice(), playerChoice, master);
            canvas.showHands(playerChoice, ia.getComputerChoice());
            showResult.start();
            ia.updateRoulette(playerChoice);
        } else {
            canvas.showResult(master.getGameResult());
            buttonRock.setEnabled(false);
            buttonPaper.setEnabled(false);
            buttonScissors.setEnabled(false);
            buttonLizard.setEnabled(false);
            buttonSpock.setEnabled(false);
            buttonNewGame.setEnabled(true);
            showResult.stop();
        }
    }
}
