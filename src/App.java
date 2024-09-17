import model.*;
public class App{
    public static void main(String[] args){
        
        FileDataSource file = new FileDataSource("meus_segredos.txt");
        DataSourceDecorator ed = new EncryptionDecorator(file);
        DataSourceDecorator cd = new CompressionDecorator(ed); //CompressionDecorator

        cd.writeData("Example Data");
        System.out.println(ed.readData());
        System.out.println(cd.readData());
        
        }
}