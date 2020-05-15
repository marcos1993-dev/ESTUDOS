package escola.modulo10.objetos;

import java.util.Arrays;

public class Disciplinas {
	
	private String materia;
	
	double notas[] = new double [4];
	
	

	public String getMateria() {
		return materia;
	}

	public void setMateria(String materia) {
		this.materia = materia;
	}

	public double[] getNotas() {
		return notas;
	}

	public void setNotas(double[] notas) {
		this.notas = notas;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((materia == null) ? 0 : materia.hashCode());
		result = prime * result + Arrays.hashCode(notas);
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
		Disciplinas other = (Disciplinas) obj;
		if (materia == null) {
			if (other.materia != null)
				return false;
		} else if (!materia.equals(other.materia))
			return false;
		if (!Arrays.equals(notas, other.notas))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Materia: " + materia ;
	}
	
	
	
	
	
	
	
	

}
