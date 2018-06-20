import java.io.Serializable;
import java.util.Date;

public class Jogo implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Date data;
	private String estadio;
	private Selecao mandante;
	private Selecao visitante;
	
	
	public void setData(Date data) {
		this.data = data;
	}


	public void setEstadio(String estadio) {
		this.estadio = estadio;
	}


	public void setMandante(Selecao mandante) {
		this.mandante = mandante;
	}


	public void setVisitante(Selecao visitante) {
		this.visitante = visitante;
	}


	public Jogo(Date data, String estadio, Selecao mandante, Selecao visitante) {

		this.data = data;
		this.estadio = estadio;
		this.mandante = mandante;
		this.visitante = visitante;
	}

	
	@Override
	public String toString() {
		return "Jogo [data=" + data + ", estadio=" + estadio + ", mandante=" + mandante + ", visitante=" + visitante
				+ "]";
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((data == null) ? 0 : data.hashCode());
		result = prime * result + ((estadio == null) ? 0 : estadio.hashCode());
		result = prime * result + ((mandante == null) ? 0 : mandante.hashCode());
		result = prime * result + ((visitante == null) ? 0 : visitante.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Jogo other = (Jogo) obj;
		if (data == null) {
			if (other.data != null)
				return false;
		} else if (!data.equals(other.data))
			return false;
		if (estadio == null) {
			if (other.estadio != null)
				return false;
		} else if (!estadio.equals(other.estadio))
			return false;
		if (mandante == null) {
			if (other.mandante != null)
				return false;
		} else if (!mandante.equals(other.mandante))
			return false;
		if (visitante == null) {
			if (other.visitante != null)
				return false;
		} else if (!visitante.equals(other.visitante))
			return false;
		return true;
	}
	

	
}
