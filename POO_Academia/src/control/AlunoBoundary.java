package control;

import java.util.List;

import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.collections.FXCollections;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import model.Aluno;

public class AlunoBoundary extends Application {
	 
	/**************** CONFIGURAÇÕES DA TELA ***************/
	 
	 
	 //Stage - Janela da aplicação
	 	private Stage stage;
	 
 
	 //TableView = Tabela de exibição dos alunos
	    TableView<Aluno> tabelaAluno = new TableView<>();
	    
	    
	 //TextField - Campos para inserir dados
	    TextField txtNomeAluno = new TextField();
	    TextField txtRgAluno = new TextField();
	    TextField txtDtNascimento = new TextField();
	    TextField txtDtEntrada = new TextField();
	    TextField txtEmailAluno = new TextField();
	    TextField txtFoneAluno = new TextField();
	    TextField txtPlanoVigente = new TextField();
	    
	   
	  //Instância para exercitar a lógica
	    AlunoControl controle = new AlunoControl();
	    
	    
	 
	 /**************** EXECUÇÃO ***************/
		 
	@Override
	public void start(Stage stage) throws Exception {
		
		//Pane - classe base para componentes de layout
		Pane panel = new Pane();
		
		//Scene - Conterá os elementos gráficos
		Scene scene = new Scene(panel, 900, 500);
		
		stage.setTitle("MANUTENÇÃO DE ALUNOS");
		
		
		//BorderPane - auxilia no posicionamento
		BorderPane root = new BorderPane();
		
		/*
		
		//Organizar abas
		TabPane tabPane = new TabPane();
		
		//Tab - Abas
		Tab tabAlunos = new Tab("Alunos");
		
				*/
		
		//GridPane - Layout para organizar em linhas e colunas
		GridPane gridAlunos = new GridPane();
		
		
		//Ajustar espaçamento entre os TextFields
		gridAlunos.setHgap(10); //Espaçamento horizontal
		gridAlunos.setVgap(15); //Espaçamento vertical
		
		
		//Sintaxe: O label que desejo adicionar, índice da coluna, índice da linha
		
		gridAlunos.add(new Label("Manutenção de Alunos"), 0, 0);		 
		gridAlunos.add(new Label("Nome do Aluno: "), 0, 1);
		gridAlunos.add(txtNomeAluno, 1, 1);
		gridAlunos.add(new Label("RG do Aluno: "), 0, 2);
		gridAlunos.add(txtRgAluno, 1, 2);
		gridAlunos.add(new Label("Data de nascimento: "), 0, 3);
		gridAlunos.add(txtDtNascimento, 1, 3);
		gridAlunos.add(new Label("Data de entrada: "), 0, 4);
		gridAlunos.add(txtDtEntrada, 1, 4);
		gridAlunos.add(new Label("E-mail: "), 0, 5);
		gridAlunos.add(txtEmailAluno, 1, 5);
		gridAlunos.add(new Label("Telefone: "), 0, 6);
		gridAlunos.add(txtFoneAluno, 1, 6);
		gridAlunos.add(new Label("Plano vigente: "), 0, 7);
		gridAlunos.add(txtPlanoVigente, 1, 7);
		
		gridAlunos.add(tabelaAluno, 1,10);
		
		//Configurações dos botões
		
		Button btnSalvar = new Button("Salvar");
		Button btnPesquisar = new Button("Pesquisar");
		
		//Width (Largura) e Height (altura)
		 btnPesquisar.setMaxHeight(650);
		 btnSalvar.setMaxHeight(650);
		 btnSalvar.setMaxWidth(200);
		 btnPesquisar.setMaxWidth(500);


		//Posicionamento dos botões
		gridAlunos.add(btnPesquisar, 2, 8);
		gridAlunos.add(btnSalvar, 1, 8);
		
		//Formatação dos botões
		btnPesquisar.setStyle("-fx-base: orange");
		btnSalvar.setStyle("-fx-base: green");
		
			//Evento do botão Salvar
				btnSalvar.setOnAction(e -> {
					try {
						controle.cadastrarAluno();
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				});
				
		
			//Evento do botão Pesquisar
				btnPesquisar.setOnAction(e -> {
					try {
						controle.pesquisarAluno();
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				});
	
		
		//Chamada do método para ligar os componentes da interface com o control
		bindingAlunos();
		createColumnsAlunos();
		
		
		
		/*
		//Definindo o conteúdo da aba
		tabAlunos.setContent(gridAlunos);
	
		*/
		scene.getStylesheets().add(getClass().getResource("estilo.css").toExternalForm());
		
		//Exibir conteúdo
		panel.getChildren().add(gridAlunos);
		stage.setScene(scene);
		stage.show();
	}


	
	
	//Método para adicionar colunas na tabela
	@SuppressWarnings("unchecked")
	public void createColumnsAlunos() {
		
		tabelaAluno.setItems(controle.getListaAlunos());
		
		TableColumn<Aluno, String> colNomeAluno = new TableColumn<>("Nome do aluno");
		colNomeAluno.setCellValueFactory(itemData -> new ReadOnlyStringWrapper(itemData.getValue().getNomeAluno()));
		TableColumn<Aluno, String> colRgAluno = new TableColumn<>("RG");
		colRgAluno.setCellValueFactory(itemData -> new ReadOnlyStringWrapper(itemData.getValue().getRgAluno()));
		TableColumn<Aluno, String> colNascimento = new TableColumn<>("Nascimento");
		colNascimento.setCellValueFactory(itemData -> new ReadOnlyStringWrapper(itemData.getValue().getdtNascAluno()));
		TableColumn<Aluno, String> colEntrada = new TableColumn<>("Entrada");
		colEntrada.setCellValueFactory(itemData -> new ReadOnlyStringWrapper(itemData.getValue().getDtEntrada()));
		TableColumn<Aluno, String> colEmail = new TableColumn<>("E-mail");
		colEmail.setCellValueFactory(itemData -> new ReadOnlyStringWrapper(itemData.getValue().getEmailAluno()));
		TableColumn<Aluno, String> colFone = new TableColumn<>("Telefone");
		colFone.setCellValueFactory(itemData -> new ReadOnlyStringWrapper(itemData.getValue().getFoneAluno()));
		
		colNomeAluno.setPrefWidth(150);
		colRgAluno.setPrefWidth(150);
		colNascimento.setPrefWidth(120);
		colEntrada.setPrefWidth(120);
		colEmail.setPrefWidth(150);
		colFone.setPrefWidth(150);
		
		tabelaAluno.getColumns().addAll(colNomeAluno, colRgAluno, colNascimento, colEntrada, colEmail, colFone);
	
	
	}



		//Método onde faz a ligação entre os componentes da interface gráfica com o Control
		public void bindingAlunos() {
			
			Bindings.bindBidirectional(txtNomeAluno.textProperty(), controle.nomeProperty());
			Bindings.bindBidirectional(txtRgAluno.textProperty(), controle.rgProperty());
			Bindings.bindBidirectional(txtEmailAluno.textProperty(), controle.emailProperty());
			Bindings.bindBidirectional(txtFoneAluno.textProperty(), controle.foneProperty());			
		}
	
		
		
		
		
		
	
	
		public static void main(String[] args) {
		 	launch(args);
	    }
}
