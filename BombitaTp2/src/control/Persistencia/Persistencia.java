package control.Persistencia;

import java.io.FileWriter;

import modelo.mapa.Mapa;

import org.dom4j.*;

public class Persistencia {

	public void guardar(String archivo,Mapa mapa){
		Document doc = DocumentHelper.createDocument();
		doc.add(mapa.guardar());
        FileWriter writer = new FileWriter(archivo);
        doc.write( writer);
        writer.close();
	}
	
	
	
	
	
}
