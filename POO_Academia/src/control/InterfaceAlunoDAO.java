package control;

import java.util.ArrayList;
import java.util.List;

import model.Aluno;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


/*
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;*/

public class InterfaceAlunoDAO implements AlunoDAO {

	@Override
	public void salvar(Aluno aluno) {
		
		String sql = "INSERT INTO aluno (nomeAluno, rgAluno, nascimentoAluno, entradaAluno, emailAluno, foneAluno) values (?, ?, ?, ?, ?, ?)";
		

		//1.2 Iniciamos uma conexão
		
		Connection conn = null;
		
		
		//1.3 Essa interface atibui os valores aos parãmetros antes de executar a consulta MySQL
		
		PreparedStatement pstm = null;
		
		//1.4 TENTATIVA DE CONEXÃO AO BANCO DE DADOS
		
		
				try {
					
					
					//1.4.1 Chamada da classe responsável pela conexão ao banco de dados
					conn = ConnectionFactory.createConnectionToMySQL();
					
					
					//1.4.2 Preparar uma PreparedStatement para executar uma consulta
					
					pstm = (PreparedStatement) conn.prepareStatement(sql);
					
					//1.4.3 Atribuição dos valores aos espaços reservados
					
					pstm.setString(1, aluno.getNomeAluno());
					pstm.setString(2, aluno.getRgAluno());
					pstm.setString(3, aluno.getdtNascAluno());
					pstm.setString(4, aluno.getDtEntrada());
					pstm.setString(5, aluno.getEmailAluno());
					pstm.setString(6, aluno.getFoneAluno());
					
					
					//1.4.5 Execução da query (Como se fosse uma confirmação)
					
					pstm.executeUpdate();
					
					System.out.println("Registro salvo com sucesso.");
					
					
				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					
					//1.4.6 Fechar as conexões
					
					try {
						
						if(pstm != null) {
							pstm.close();
						}
					
						if(conn != null) {
							conn.close();
				
						}  
						
					} catch (Exception e) {
						e.printStackTrace();
					}
					
				}
				
		
		
	}

	
	
	
	@Override
	public List<Aluno> lerTodos() throws Exception {
		return pesquisarAluno("");
	}

	
	@Override
	public List<Aluno> pesquisarAluno(String nomeAluno) throws Exception {
	
		    List<Aluno> listaAlunos = new ArrayList<>();
		    String sql = "SELECT * from aluno WHERE nomeAluno LIKE ?";
		    
		    Connection conn = null;
		    PreparedStatement pstm = null;
		    ResultSet rs = null;
		    
		    try {
		        conn = ConnectionFactory.createConnectionToMySQL();
		        pstm = conn.prepareStatement(sql);
		        pstm.setString(1, "%" + nomeAluno + "%");
		        rs = pstm.executeQuery();
		        
		        while (rs.next()) {
		            Aluno aluno = new Aluno();
		            aluno.setNomeAluno(rs.getString("nomeAluno"));
		            aluno.setRgAluno(rs.getString("rgAluno"));
		            aluno.setDtNascimento(rs.getString("nascimentoAluno"));
		            aluno.setDtEntrada(rs.getString("entradaAluno"));
		            aluno.setEmailAluno(rs.getString("emailAluno"));
		            aluno.setFoneAluno(rs.getString("foneAluno"));
		            listaAlunos.add(aluno);
		        }
		    } catch (SQLException e) {
		        e.printStackTrace();
		        throw new Exception("Erro ao pesquisar alunos: " + e.getMessage());
		    } finally {
		      
		        if (rs != null) {
		            rs.close();
		        }
		        if (pstm != null) {
		            pstm.close();
		        }
		        if (conn != null) {
		            conn.close();
		        }
		    }
		    
		    return listaAlunos;
		}

}




