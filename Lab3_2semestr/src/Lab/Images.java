package Lab;

public class Images extends AbstractImedg {
    private ImagesArray[] imagesArrays = new ImagesArray[2];
    int count=2;

    public Images() {
        zapov();
    }


    private void zapov(){
        String[][] sky = new String[6][6];
        String[][] san = new String[6][6];
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                sky[i][j]= "blue";
                san[i][j]= "yellow";
            }
        }

        imagesArrays[0] = new ImagesArray();
        imagesArrays[0].setPikche(sky);
        imagesArrays[0].setName("sky");
        imagesArrays[1] = new ImagesArray();
        imagesArrays[1].setPikche(san);
        imagesArrays[1].setName("san");
    }


    public ImagesArray winningThePicture(String name){
        for (int i = 0; i < count; i++) {
            if (imagesArrays[i].getName().equals(name)){
                return imagesArrays[i];
            }
        }
        return null;
    }



    @Override
    public void getImg(String name, int x, int y) {

    }
}
