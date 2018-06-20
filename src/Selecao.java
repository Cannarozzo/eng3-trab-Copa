import java.io.Serializable;

public class Selecao implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private long id;
	public Selecao(long id, String nome, char grupo) {
		this.id = id;
		this.nome = nome;
		this.grupo = grupo;
	}

	private String nome;
	private char grupo;
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public char getGrupo() {
		return grupo;
	}

	public void setGrupo(char grupo) {
		this.grupo = grupo;
	}

	@Override
	public String toString() {
		return "Selecao [id=" + id + ", nome=" + nome + ", grupo=" + grupo + "]";
	}
	

	@Override
	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Selecao other = (Selecao) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
	
}
