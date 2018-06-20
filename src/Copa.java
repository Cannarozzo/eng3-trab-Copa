import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Copa {

	Scanner sc;
	private SelecaoFactory factory;

	public Copa() throws ClassNotFoundException, IOException {

		this.factory = SelecaoFactory.getInstance();
		sc = new Scanner(System.in);
	}

	public char selecionarGrupo() {
		char c;
		do {
			System.out.println("Selecione um Grupo de A a H:");
			c = sc.next().charAt(0);
			if (c != 'A' && c != 'B' && c != 'C' && c != 'D' && c != 'E' && c != 'F' && c != 'G' && c != 'H') {
				System.out.println("Você Digitou algo diferente de um caractere A a H, digite novamente!");
			}
		} while (c != 'A' && c != 'B' && c != 'C' && c != 'D' && c != 'E' && c != 'F' && c != 'G' && c != 'H');

		return c;

	}

	public void cadastrarSelecoes() throws FileNotFoundException, IOException {
		int flag = -1;
		char grupo = selecionarGrupo();
		for (int i = 1; i < 5; i++) {
			flag = -1;

			do {
				DAO<Selecao> selecaoDao = new DAO<>("selecao.dat");

				System.out.println("Cadastro da " + i + "ª Seleção ");

				System.out.println("Digite o id da seleção: ");
				long id = Long.parseLong(sc.next());
				if (factory.getSelecao(id) == null) {
					System.out.println("Digite o nome da Seleção: ");
					String nome = sc.next();

					factory.addSelecao(new Selecao(id, nome, grupo));
					selecaoDao.save(new Selecao(id, nome, grupo));
					flag = 0;

				} else {
					System.out.println("id já existente, digite um novo id");
				}
			} while (flag != 0);

		}

	}

	public void listarSelecoes() throws FileNotFoundException, ClassNotFoundException, IOException {
		try {
			DAO<Selecao> selecaoDao = new DAO<>("selecao.dat");
			selecaoDao.findAll().forEach(selecao -> System.out.println(selecao));
		} catch (Exception e) {
			e.getMessage();
		}

	}

	public void listarSelecoesGrupo(char grupo) throws FileNotFoundException, ClassNotFoundException, IOException {
		try {
			DAO<Selecao> selecaoDao = new DAO<>("selecao.dat");
			for (int i = 0; i < selecaoDao.findAll().size(); i++) {
				Selecao selecao = selecaoDao.findAll().get(i);
				if (selecao.getGrupo() == grupo) {
					System.out.println(selecao);
				}

			}
		} catch (Exception e) {
			e.getMessage();
		}

	}
	public void listarSelecoesGrupo() throws FileNotFoundException, ClassNotFoundException, IOException {
		Scanner sc = new Scanner(System.in);
		System.out.println("Digite o grupo: ");
		char g = sc.next().charAt(0);
		listarSelecoesGrupo(g);
		

	}

	public static void main(String[] args) throws ClassNotFoundException, IOException {

		Copa copa2018 = new Copa();
		Scanner sc = new Scanner(System.in);
		int opc = 0;

		while (opc != 4) {
			System.out.println("1 Cadastrar Seleções" + "\n2 Mostrar seleções" + "\n3 Mostrar as seleções pelo grupo"
					+ "\n4 Sair do programa");
			opc = sc.nextInt();
			
			switch(opc) {
			case 1:
				copa2018.cadastrarSelecoes();
				break;
			case 2:
				copa2018.listarSelecoes();
				break;
			case 3:
				copa2018.listarSelecoesGrupo();
				break;
			case 4:
				break;
			default:
				System.out.println("Erro: digite uma opção válida");
				break;
			}

		}

	}

}
