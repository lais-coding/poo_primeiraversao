package model;

public class Aluno {


	
	private int idAluno;
	private String nomeAluno;
	private String rgAluno;
	private String dtNascAluno;
	private String dtEntrada;
	private String emailAluno;
	private String foneAluno;
	private Plano planoContratado;
	

	public int getIdAluno() {
		return idAluno;
	}
	public void setIdAluno(int idAluno) {
		this.idAluno = idAluno;
	}
	public String getNomeAluno() {
		return nomeAluno;
	}
	public void setNomeAluno(String nomeAluno) {
		this.nomeAluno = nomeAluno;
	}
	public String getRgAluno() {
		return rgAluno;
	}
	public void setRgAluno(String rgAluno) {
		this.rgAluno = rgAluno;
	}
	public String getdtNascAluno() {
		return dtNascAluno;
	}
	public void setDtNascimento(String localDate) {
		this.dtNascAluno = localDate;
	}
	public String getDtEntrada() {
		return dtEntrada;
	}
	public void setDtEntrada(String dtEntrada) {
		this.dtEntrada = dtEntrada;
	}
	public String getEmailAluno() {
		return emailAluno;
	}
	public void setEmailAluno(String emailAluno) {
		this.emailAluno = emailAluno;
	}
	public String getFoneAluno() {
		return foneAluno;
	}
	public void setFoneAluno(String foneAluno) {
		this.foneAluno = foneAluno;
	}
	public Plano getPlanoContratado() {
		return planoContratado;
	}
	public void setPlanoContratado(Plano planoContratado) {
		this.planoContratado = planoContratado;
	}
	
	
	
	
	
}
