package objetos;

public class Marcas {
	
	String nomeMarca;

	public String getNomeMarca() {
		return nomeMarca;
	}

	public void setNomeMarca(String nomeMarca) {
		this.nomeMarca = nomeMarca;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nomeMarca == null) ? 0 : nomeMarca.hashCode());
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
		Marcas other = (Marcas) obj;
		if (nomeMarca == null) {
			if (other.nomeMarca != null)
				return false;
		} else if (!nomeMarca.equals(other.nomeMarca))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return  nomeMarca ;
	}
}
