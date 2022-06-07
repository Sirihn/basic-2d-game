public class Coin extends GameObject {

    // filename of the image used to represent the gameobject
    private static String filename = "images/coin2.png";

    public Coin(int x, int y) {
        // load the assets
        super(filename, x, y);
    }

}
