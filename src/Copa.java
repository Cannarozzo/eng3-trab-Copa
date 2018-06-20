import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Copa {
	
	Scanner sc;
	private SelecaoFactory factory;
	
	public Copa(SelecaoFactory factory) throws ClassNotFoundException, IOException {

		this.factory = SelecaoFactory.getInstance();
		sc = new Scanner(System.in);
	}
	
	public char selecionarGrupo()
	{
		char c;
		do
		{
			System.out.println("Selecione um Grupo de A a H:");
			c = sc.next().charAt(0);
			if(c !='A' && c !='B' && c !='C' && c !='D' && c !='E'&& c !='F' && c !='G' && c !='H')
			{
				System.out.println("Você Digitou algo diferente de um caractere A a H, digite novamente!");
			}
		}
		while(c !='A' && c !='B' && c !='C' && c !='D' && c !='E'&& c !='F' && c !='G' && c !='H');
		
		return c;
	
	}
	
	public void cadastrarSelecoes() throws FileNotFoundException, IOException
	{
		int flag =-1;
		char grupo = selecionarGrupo();
		for(int i=1;i<5;i++)
		{
			flag = -1;
			
			do
			{
				DAO<Selecao> selecaoDao = new DAO<>("selecao.dat");
				
				System.out.println("Cadastro da " + i + "ª Seleção ");
				
				System.out.println("Digite o id da seleção: ");
				long id = Long.parseLong(sc.next());
				if(factory.getSelecao(id) == null)
				{
					System.out.println("Digite o nome da Seleção: ");
					String nome = sc.next();
					
					factory.addSelecao(new Selecao(id,nome,grupo));
					selecaoDao.save(new Selecao(id,nome,grupo));
					flag=0;
					
					
				}
				else
				{
					System.out.println("id já existente, digite um novo id");
				}
			}
			while(flag !=0);
			
			
			
			
		}
		
		
	}
	
	public void listarSelecoes() throws FileNotFoundException, ClassNotFoundException, IOException
	{
		try {
			DAO<Selecao> selecaoDao = new DAO<>("selecao.dat");
			selecaoDao.findAll().forEach(selecao -> System.out.println(selecao));
		}
		catch(Exception e)
		{
			e.getMessage();
		}
		
		
	}
	
	public void listarSelecoesGrupo(char grupo) throws FileNotFoundException, ClassNotFoundException, IOException
	{
		try {
			DAO<Selecao> selecaoDao = new DAO<>("selecao.dat");
			for (int i = 0; i < selecaoDao.findAll().size(); i++) {
				Selecao selecao = selecaoDao.findAll().get(i);
				if(selecao.getGrupo() == grupo)
				{
					System.out.println(selecao);
				}
				
			}
		}
		catch(Exception e)
		{
			e.getMessage();
		}
		
		
	}
	
	public static void main(String[] args) throws ClassNotFoundException, IOException {
		
	/*	
		Selecao brasil = new Selecao(1,"Brasil",'A');
		Selecao peru = new Selecao(2,"peru",'A');
		Selecao china = new Selecao(3,"china",'B');
		Selecao russia = new Selecao(4,"russia",'B');
		Selecao ITALIA = new Selecao(5,"italia",'C');
		Selecao JAPAO = new Selecao(6,"japao",'C');
		
		SelecaoFactory factory = SelecaoFactory.getInstance();
		factory.addSelecao(brasil);
		factory.addSelecao(peru);
		factory.addSelecao(ITALIA);
		factory.addSelecao(JAPAO);
		factory.addSelecao(china);
		factory.addSelecao(russia);
		
		
		*/
		Copa copa2018 = new Copa(SelecaoFactory.getInstance());
		copa2018.cadastrarSelecoes();
		copa2018.listarSelecoes();
		
		
	}

}
