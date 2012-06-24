package control.Persistencia;

import java.io.FileWriter;
import java.io.IOException;

import modelo.mapa.Mapa;

import org.dom4j.*;

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
	
	
	
	
	
}
