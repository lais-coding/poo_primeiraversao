package control;


import java.util.List;

import javafx.beans.property.LongProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Aluno;



public class AlunoControl {

	
	InterfaceAlunoDAO dao = new InterfaceAlunoDAO();
	
	
	//Há conceitos do padrão de projeto Observer
	
	//Alterações são notificadas por qualquer lugar onde as propriedades podem ser observadas
	
	//LongProperty - Interface observável do tipo long (Permite visualizar a alteração nesse tipo de variável)
	private LongProperty idAluno = new SimpleLongProperty(0);
	
	//StringProperty - Interface observável do tipo String (Permite visualizar a alteração nesse tipo de variável)
	private StringProperty nomeAluno = new SimpleStringProperty("");
	private StringProperty rgAluno = new SimpleStringProperty("");
	private StringProperty emailAluno = new SimpleStringProperty("");
	private StringProperty foneAluno = new SimpleStringProperty("");
	private StringProperty dtNascimento = new SimpleStringProperty("");
	private StringProperty dtEntrada = new SimpleStringProperty("");
	
	//ObservableList - Lista
	
	private ObservableList<Aluno> listaAlunos = FXCollections.observableArrayList();

	//Métodos
	
	
	public void cadastrarAluno() throws Exception {
		Aluno aluno = new Aluno();
		aluno.setNomeAluno(nomeAluno.get());
		aluno.setRgAluno(rgAluno.get());
		aluno.setDtNascimento(dtNascimento.get());
	    aluno.setDtEntrada(dtEntrada.get());
	    aluno.setEmailAluno(emailAluno.get());
	    aluno.setFoneAluno(foneAluno.get());
		
		//Salvar no banco através do DAO
		
		dao.salvar(aluno);
		lerTodos();
		
	}
	
	
	void pesquisarAluno() throws Exception {
		List<Aluno> listaAlunos = dao.pesquisarAluno(nomeAluno.get());
		listaAlunos.clear();
		listaAlunos.addAll(listaAlunos);
	} 
	
	


	public void lerTodos() throws Exception {
		List<Aluno> listaAlunos = dao.lerTodos();
		listaAlunos.clear();
		listaAlunos.addAll(listaAlunos);
	}
	
	
	
	public StringProperty nomeProperty() {
		return this.nomeAluno;
	}
	

	public StringProperty rgProperty() {
		return this.rgAluno;
	}
	
	public StringProperty emailProperty() {
		return this.emailAluno;
	}
	
	public StringProperty foneProperty() {
		return this.foneAluno;
	}

	
	public StringProperty dtNascimentoProperty() {
		return this.dtNascimento;
	}
	

	public StringProperty dtEntradaProperty() {
		return this.dtEntrada;
	}


	public ObservableList<Aluno> getListaAlunos() {
		return listaAlunos;
	}


	public void setListaAlunos(ObservableList<Aluno> listaAlunos) {
		this.listaAlunos = listaAlunos;
	}
	
	
	
	
	
	
}
