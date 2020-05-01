/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package puzzlesolver.Util;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Slider;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import puzzlesolver.PuzzleInterface;

/**
 *
 * @author Sam
 */
public class Settings extends VBox {
    
    private Label                   intro;
    private RadioButton             showStep;
    
    private ChoiceBox<String>       algOp;
    private ObservableList<String>  algList;
    
    private Button                  genBtn;
    private Button                  runBtn;
    
    private Slider                  scaleSlid;
    
    private final PuzzleInterface   puzzle;
    
    public Settings(String title, PuzzleInterface puz) {
        super(15);
        puzzle = puz;
        super.setPrefSize(170, puz.getPuzHeight());
        init(title);
        super.setAlignment(Pos.TOP_CENTER);
        super.setPadding(new Insets(10,10,10,10));
        super.getChildren().addAll(intro,showStep,scaleSlid,algOp,genBtn,runBtn);
    }
    
    private void init(String title) {
        intro = new Label(title);
        intro.setMaxWidth(150);
        intro.setFont(new Font("Monospace",18));
        intro.setTextAlignment(TextAlignment.CENTER);
        intro.setWrapText(true);
        
        showStep = new RadioButton("Show Steps");
        showStep.setSelected(true);
        
        algList = FXCollections.observableArrayList("Breadth First","Depth First","Turn Left","Dijstra","AStar");
        algOp = new ChoiceBox<>(algList);
        algOp.setMaxWidth(Double.MAX_VALUE);
        algOp.setValue("Breadth First");
        
        scaleSlid = new Slider(0,100, 75);
        scaleSlid.setShowTickMarks(true);
        scaleSlid.setShowTickLabels(true);
        scaleSlid.setTooltip(new Tooltip("% of Walls"));
        
        genBtn = new Button("Generate Puzzle");
        genBtn.setMaxWidth(Double.MAX_VALUE);
        runBtn = new Button("Solve Puzzle");
        runBtn.setMaxWidth(Double.MAX_VALUE);
        
        addBtnActions();
        
    }
    
    public boolean showStep(){
        return showStep.isPressed();
    }

    private void addBtnActions() {
        genBtn.setOnAction(e -> {
            puzzle.Generate((int) scaleSlid.getValue());
        });
        runBtn.setOnAction(e -> {
            puzzle.Solve(getChoice(algOp.getValue()));
        });
    }

    private AlgType getChoice(String value) {
        switch(value) {
            case "Breadth First":
                return AlgType.BREADTH_FIRST;
            case "Depth First":
                return AlgType.DEPTH_FIRST;
            case "Dijstra":
                return AlgType.DIJKSTRA;
            case "AStar":
                return AlgType.ASTAR;
            case "Turn Left":
                return AlgType.TURN_LEFT;
            default:
                System.out.println("Error: Algorithm Not Found - Settings");
        }
        return null; //should not be able to get here
    }
}