package interfaces;

/**Interface BorneService*/
public interface BorneService {

    /**Lieu borne*/
    boolean ajouterLieu();
    boolean modifierLieu();

    /**Bornes*/
    boolean ajouterBorne();
    boolean modifierBorne();
    boolean supprimerBorne();
}
