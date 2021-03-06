package sequencial.index;

import java.io.File;
import java.util.Scanner;

import comum.Aluno;

public class Main {

	private static final String DB_FILE_NAME = "alunos.db";
	private static OrganizadorSequencial org;
	private static String dbPath,
						  dbFullPath;
	
	
	public static void main( String[] args ) {
		
		int opcao = -1;
		dbPath = System.getProperty( "user.home" );
		dbFullPath = dbPath + File.separator + DB_FILE_NAME;
		org = new OrganizadorSequencial( dbFullPath );
		Aluno aluno;
		Scanner scan = new Scanner( System.in );
		
		while( opcao != 6 ) {
			
			long matricula;
			aluno = null;
			printMenu();
			opcao = scan.nextInt();
			
			switch( opcao ) {
			case 1:
				System.out.println(
						"\n================== CONSULTAR DADOS DO ALUNO ===================\n" +
						"Informe a matr�cula: "
					);
				matricula = scan.nextLong();
				
				aluno = org.getAluno( matricula );
				
				if( aluno == null )
					System.out.println( "Aluno n�o encontrado!" );
				else {
					System.out.println(
							"Curso: " + aluno.getCurso() + "\n" +
							"Nome: " + aluno.getNome() + "\n" +
							"Endere�o: " + aluno.getEndereco() + "\n" +
							"Telefone: " + aluno.getTelefone() + "\n" +
							"E-mail: " + aluno.getEmail() + "\n"
						);
				}
				
				
				break;
			case 2:
				System.out.println(
						"\n===================== NOVO ALUNO =====================\n" +
						"Matr�cula: " 
					);
				matricula = scan.nextLong();
				System.out.print( "Curso: " );
				short curso = scan.nextShort();
				System.out.print( "Nome (at� 40 caracteres): " );
				String nome = scan.nextLine();
				nome = nome.substring( 0, 39 );
				System.out.print( "Endere�o (at� 50 caracteres): " );
				String endereco = scan.nextLine();
				endereco = endereco.substring( 0, 49 );
				System.out.print( "Telefone (at� 10 caracteres): " );
				String telefone = scan.nextLine();
				telefone = telefone.substring( 0, 9 );
				System.out.print( "E-mail (at� 45 caracteres): " );
				String email = scan.nextLine();
				email = email.substring( 0, 44 );
				
				aluno = new Aluno( matricula, curso, nome, endereco );
				aluno.setEmail( email );
				aluno.setTelefone( telefone );
				
				org.addAluno( aluno );
				break;
			case 3:
				System.out.println(
						"\n===================== EXCLUIR ALUNO =====================\n" +
						"Matr�cula: "
					);
				matricula = scan.nextLong();
				aluno = org.delAluno( matricula );
				
				if( aluno == null)
					System.out.println( "Aluno n�o encontrado!" );
				else
					System.out.println( "Aluno " + aluno.getNome() + "removido com sucesso!" );
				break;
			case 4:
				System.out.print( "\nInforme o novo diret�rio: " );
				scan.nextLine();
				setDBPath( scan.nextLine() );
				break;
			case 5:
				System.out.println( "Registros salvos em " + getDBFullPath() );
			}
		}
		
		scan.close();
	}
	
	private static String getDBPath() { return dbPath;	}
	
	private static String getDBFullPath() { return dbFullPath; }
	
	private static void setDBPath( String newPath ) {
		
		dbPath = newPath;
		dbFullPath = dbPath + File.separator + DB_FILE_NAME;
		org.moveDatabase( dbFullPath );
	}
	
	private static void printMenu() {
		
		System.out.println(
				"======================= MENU ====================\n" +
				"1 - CONSULTAR ALUNO\n" +
				"2 - ADICIONAR ALUNO\n" +
				"3 - EXCLUIR ALUNO\n" +
				"4 - ALTERAR LOCAL DE ARMAZENAMENTO\n" +
				"5 - CONFERIR LOCAL DA DATABASE\n" +
				"6 - SAIR"
			);
	}
}
