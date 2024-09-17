package model;

public class EncryptionDecorator extends DataSourceDecorator {

    int encodeNextPosition = 2;

    public EncryptionDecorator(DataSource wrappee) {
        super(wrappee);

    }

    @Override
    public void writeData(String data) {
        System.out.println("=====================Encryption====================");
        
        System.out.println("Encriptografando o arquivo Antes de Escrever...");
        String encodeedData = encode(data);
        this.wrappee.writeData(encodeedData);
        System.out.println("=====================Encryption====================");

    }

    @Override
    public String readData() {
        System.out.println("=====================Encryption====================");
        System.out.println("Descriptografando o Arquivo Antes de Ler...");    
        System.out.println("=====================Encryption====================");

        return this.decode(this.wrappee.readData());
    }

    private String encode(String data) {
        //Quis fazer a minha própria criptografia
        char[] characters = data.toCharArray();
        char[] encodeData = new char[data.length()];

        for (int i = 0; i < characters.length; i++) {
            int index = (i + encodeNextPosition) % encodeData.length;
            encodeData[i] = characters[index];
        }
        return new String(encodeData);

    }

    public String decode(String data) {
        char[] encript_characters = data.toCharArray();
        char[] decodeData = new char[data.length()];

        for (int i = 0; i < encript_characters.length; i++) {
            int index = 
            ((i - encodeNextPosition) + encript_characters.length) 
            % encript_characters.length; 

            decodeData[i] = encript_characters[index];
        }
        return new String(decodeData);

    }
}
