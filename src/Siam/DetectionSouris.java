package Siam;

import javax.swing.event.MouseInputAdapter;
import java.awt.event.MouseEvent;

public class DetectionSouris extends MouseInputAdapter implements Constantes {

    private Game game;

    public DetectionSouris(Game game) {
        this.game = game;
    }

    public void mouseClicked(MouseEvent event) {
        if (event.getX() < BORDURE_FENETRE/2 || event.getX() > (1+NOMBRE_CASE_INI)*TAILLE_SPRITE) return;
        if (event.getY() < BORDURE_FENETRE/2 || event.getY() > (1+NOMBRE_CASE_INI)*TAILLE_SPRITE) return;
        int colonne = (event.getX() - BORDURE_FENETRE/2) / TAILLE_SPRITE;
        int ligne = (event.getY() - BORDURE_FENETRE/2) / TAILLE_SPRITE;
        clickPerformed(colonne,ligne);
    }

    private void clickPerformed(int colonne, int ligne) {
        System.out.println("clic");
        game.setInsertionPiece(true);
        if (game.isInsertionPiece()) {
            game.getJoueurActif().posePiece(game.getPlateau().getCase(colonne, ligne));
        }
    }
}