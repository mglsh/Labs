package Lab;

public class ProxiCash extends AbstractImedg {
    int nanberOfArrayColor = 0;
    int namberOfArrayImages = 0;
    int countColor=0, countImages= 0;
    CashArray [] cashArrays = new CashArray[10];
    CashImagesArray [] cashImagesArrays = new CashImagesArray[10];
    Images images = new Images();

    @Override
    public void getImg(String name, int x, int y) {

        if (checkSavedColor(name, x, y)){
            System.out.println("Колір є в пам'яті проксі "+ "Ім'я "+ cashArrays[nanberOfArrayColor].getName() + " X " +cashArrays[nanberOfArrayColor].getX()+ " Y "+ cashArrays[nanberOfArrayColor].getY()+ "Колір картинки " + cashImagesArrays[namberOfArrayImages].getPikche()[x][y]);
        }else {
            System.out.println("На проксі збереженого кольру немає");
            if (checkSavedImages(name)){
                System.out.println("На проксі є картинка колір дам з неї. Ім'я картинки "+cashImagesArrays[namberOfArrayImages].getName()+ " Колір картинки " + cashImagesArrays[namberOfArrayImages].getPikche()[x][y]);
            }else {
                saveImages(name);
                System.out.println("На проксі не має картинки ми її загружаєм з Images");
                checkSavedImages(name);
                System.out.println("Даємо колір з картинки яку загрузили на проксі Назва картинки "+cashImagesArrays[namberOfArrayImages].getName()+ " Колір картинки " + cashImagesArrays[namberOfArrayImages].getPikche()[x][y]);
                saveColor(name,x,y);
            }


               
        }


    }


    private boolean checkSavedColor(String name, int x, int y){
       boolean flag = false;
       if (countColor==0){
           flag=false;
       }else {
           for (int i = 0; i < countColor; i++) {
               if (cashArrays[i].getName().equals(name) && cashArrays[i].getX()==x && cashArrays[i].getY()==y){
                   flag = true;
                   nanberOfArrayColor = i;

               }else {
                   flag = false;
               }
           }
       }

        return flag;
    }


    private boolean checkSavedImages(String name){
        boolean flag = false;
        if (countImages ==0){
            flag=false;
        }else {
            for (int i = 0; i < countImages; i++) {
                if (cashImagesArrays[i].getName().equals(name)){
                    flag = true;
                    namberOfArrayImages = i;

                }else {
                    flag = false;
                }
            }
        }
        return flag;
    }



    private void saveColor(String name, int x, int y){
        cashArrays[countColor] = new CashArray();
        cashArrays[countColor].setName(name);
        cashArrays[countColor].setX(x);
        cashArrays[countColor].setY(y);
        cashArrays[countColor].setColor(cashImagesArrays[namberOfArrayImages].getPikche()[x][y]);
        countColor++;

    }

    private void saveImages(String name){
        cashImagesArrays[countImages] = new CashImagesArray();
        cashImagesArrays[countImages].setName(images.winningThePicture(name).getName());
        cashImagesArrays[countImages].setPikche(images.winningThePicture(name).getPikche());
        countImages++;
    }



}
