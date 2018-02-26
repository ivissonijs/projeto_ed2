package comum;

/**
 * Interface gen�rica que define as opera��es de organizadores
 * de arquivos de alunos em disco.
 * @author Tarcisio Rocha
 */
public interface IFileOrganizer {

	 /**
	  * Dada uma inst�ncia da classe Aluno, este m�todo
	  * adiciona os dados da inst�ncia em um arquivo seguindo o
	  * m�todo de organiza��o de arquivos especificado.
	  * @param p Inst�ncia da classe Aluno
	  */
	 public void addAluno(Aluno p);

	 
	 /**
	  * Dado um n�mero de matr�cula, este m�todo consulta o arquivo de
	  * alunos e devolve uma inst�ncia que encapsula
	  * aos dados do aluno que cont�m a matr�cula fornecida.
	  * @param matric N�mero de matr�cula para a consulta.
	  */
	 public Aluno getAluno(long matric);

	 
	 /**
	  * Dado um n�mero de matr�cula, localiza e exclui o registro do
	  * arquivo de alunos que corresponde � matr�cula
	  * fornecida.
	  * @param matric Matr�cula do aluno a ser exclu�do.
	  * @return Aluno que foi exclu�do.
	 */
	 public Aluno delAluno(long matric);
}
