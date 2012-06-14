package modelo.ondaexpantest;
import org.junit.Before;

import modelo.mapa.Mapa;
import modelo.ondaexpansiva.OndaExpansiva;


public class ondaEspansivaTest {
	
	private OndaExpansiva onda;
	private Mapa mapa;
	
	
	@Before
	public void setUp(){
		onda = new OndaExpansiva(3,5);
		mapa = new Mapa(10);
	}
	

}
