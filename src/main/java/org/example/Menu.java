package org.example;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class Menu {

    @FXML Button Reiniciar;
    @FXML Button Sortir;
    @FXML Label puntsTens;

    public void initialize() {
        puntsTens.setText("Has tret un total de " + App.pc.getPuntuacio() + " punts");
    }

    @FXML public void onReiniciar(ActionEvent event) {
        App.stagemenu.close();
        App.pc.startLevel(1);
        App.pc.tl.play();
    }

    @FXML public void onSortir(ActionEvent event) {
        App.stagemenu.close();
        App.principal.close();
    }

}
