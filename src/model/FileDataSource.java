package model;

public class FileDataSource implements DataSource {
    private String filename;
    private String data;

    public FileDataSource(String filename) {
        this.filename = filename;
    }

    @Override
    public void writeData(String data) {
        System.out.println("====================Normal File=========================");

        System.out.println(String.format("Escrevendo \n%s\n no arquivo: %s",data, this.filename));    
        this.data = data;
        System.out.println("====================Normal File=========================");

    }

    @Override

    public String readData() {
        System.out.println("====================Normal File=========================");    
        return this.data;   
    
    }
}
