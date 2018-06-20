import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class SelecaoFactory {

	private  Map<Long,Selecao> selecaoPool;
	public Map<Long, Selecao> getSelecaoPool() {
		return selecaoPool;
	}

	public void setSelecaoPool(Map<Long, Selecao> selecaoPool) {
		this.selecaoPool = selecaoPool;
	}

	private static SelecaoFactory instance;
	
	private SelecaoFactory() throws FileNotFoundException, ClassNotFoundException, IOException {
		
		selecaoPool = new HashMap<>();
		DAO<Selecao> daoSelecao = new DAO<>("selecao.dat");
		try {
		    for (Selecao selecao : daoSelecao.findAll()) {
		    	addSelecao(selecao);
			}
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}
	
	public static SelecaoFactory getInstance() throws IOException, ClassNotFoundException
	{
		if(instance == null)
			return instance = new SelecaoFactory();
		else
			return instance;
	}
	
	public void addSelecao(Selecao s) {
		if(!selecaoPool.containsKey(s.getId())) {
			selecaoPool.put(s.getId(), s);
		}
			
			
	}
	
	public Selecao getSelecao(Long id)
	{
		if(selecaoPool.containsKey(id))
			return selecaoPool.get(id);
		return null;
		
	}
	
	




	
	
	
}
