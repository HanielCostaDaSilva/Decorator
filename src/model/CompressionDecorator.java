package model;

public class CompressionDecorator extends DataSourceDecorator {

    public CompressionDecorator(DataSource wrappee) {
        super(wrappee);
    }

    @Override
    public void writeData(String data) {
        System.out.println("===================Compression====================");        
        System.out.println("Comprimindo o arquivo antes de escrever...");
        String compressedData = compress(data); // Aplica a compressão nos dados
        this.wrappee.writeData(compressedData); // Escreve os dados comprimidos
        System.out.println("===================Compression====================");
    }

    @Override
    public String readData() {
        System.out.println("===================Compression====================");
        
        System.out.println("Descomprimindo o arquivo antes de ler...");
        String data = this.wrappee.readData(); 
        System.out.println("===================Compression====================");

        return decompress(data); // Descomprime os dados ao ler
    }

    // Método de compressão usando Run-Length Encoding (RLE)
    private String compress(String data) {
        return data+" %%compressedData%%";
    }

    // Método de descompressão corrigido
    private String decompress(String data) {

        return data.replace("%%compressedData%%", "");
    }
}
