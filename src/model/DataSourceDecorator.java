package model;

public abstract class DataSourceDecorator implements DataSource {
    public DataSource wrappee;

    public DataSourceDecorator(DataSource wrappee){
        this.wrappee=wrappee;
    }
    
    @Override
    public void writeData(String data) {
        wrappee.writeData(data);
    }

    @Override
    public String readData() {
        return wrappee.readData();
    }

    
}
