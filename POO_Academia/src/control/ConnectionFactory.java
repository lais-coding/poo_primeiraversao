package control;

import java.sql.Connection;
import java.sql.DriverManager;


public class ConnectionFactory {

	//1 - CONFIGURAÇÕES DE CONEXÃO AO BANCO DE DADOS
	
	
			//1.1 NOME DO USUÁRIO DO MYSQL
			private static final String USERNAME = "root";
			
			//1.2 SENHA DO BANCO DE DADOS
			private static final String PASSWORD = "";
		
			//1.3 CAMINHO DO BANCO DE DADOS
			
			//Caminho: Protocolo JDBC - MYSQL ACESSO - SERVIDOR LOCALHOST - Nº DA PORTA - ACESSAR O DATABASE
			private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/academia";


		//2 - CRIAÇÃO DE CONEXÃO COM O MYSQL	
			
			public static Connection createConnectionToMySQL() throws Exception {
				
				
				//2.1 CHAMADA PARA O CARREGAMENTO DA CLASSE DO DRIVER DE COMUNICAÇÃO ENTRE O JAVA E O MYSQL PARA A JVM
				Class.forName("com.mysql.jdbc.Driver");
			
				
				//2.2 CRIA A CONEXÃO, PASSANDO OS PARÂMETROS ANTERIORMENTE ATRIBUÍDOS NO PASSO 1
				Connection connection = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);
			
				return connection;
				
			}
			
			
		//3 - VERIFICAÇÃO DE CONEXÕES ATIVAS
			
			public static void main(String[] args) throws Exception {
				
				
				Connection con = createConnectionToMySQL();
				
				//TESTANDO SE A CONEXÃO É NULA
				
				if(con!=null) {
					System.out.println("Conexão obtida com sucesso");
					con.close(); //FECHAR A CONEXÃO, GARANTINDO QUE NÃO HAJA MAIS DE UMA CONEXÃO ATIVA
				}
				
				
			}
			
			
			
	
	
}
