package control.Persistencia;

import java.io.FileWriter;
import java.io.IOException;

import modelo.mapa.Mapa;

import org.dom4j.*;
import org.dom4j.io.SAXReader;

public class Persistencia {

	public void guardar(String archivo,Mapa mapa){
		Document doc = DocumentHelper.createDocument();
		doc.add(mapa.guardar());
        FileWriter writer;
		try {
			writer = new FileWriter(archivo);
			doc.write( writer);
	        writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public static Mapa recuperar(String archivo) throws IOException{
		Mapa mapa = new Mapa();
        SAXReader reader = new SAXReader();
        try{
	        Document document = reader.read(archivo);
	        Element elemMapa = document.getRootElement();
	        mapa = mapa.recuperar(elemMapa);
        }catch(DocumentException ex){
            throw new IOException();
        }
        return mapa;
    }
}
