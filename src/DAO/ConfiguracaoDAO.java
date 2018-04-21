package DAO;

import Entidades.Parametrodb;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class ConfiguracaoDAO {

    private File file;

    public void readFile() {
        file = new File("src/res/parametros.txt");         
    }
    public Parametrodb loadConf() throws IOException {
        readFile();
        Parametrodb bd = new Parametrodb();
        FileReader reader = new FileReader(file);
        BufferedReader bReader = new BufferedReader(reader);

        bd.setUrl(bReader.readLine());
        bd.setUser(bReader.readLine());
        bd.setSenha(bReader.readLine());
        bd.setDb(bReader.readLine());

        bReader.close();
        return bd;
    }
    
    public void writeConf(Parametrodb bd) throws FileNotFoundException {
        readFile();
        PrintWriter printFile = new PrintWriter(file);
            printFile.println(bd.getUrl());
            printFile.println(bd.getUser());
            printFile.println(bd.getSenha());
            printFile.println(bd.getDb());
            
            printFile.close();
    }        
}
