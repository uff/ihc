package br.com.ihc.cc.uff.quadrodeavisos;

import java.sql.Date;

public class Notificacoes {
	
	public Notificacoes(boolean msg_lida, boolean msg_nao_lida, boolean msg_favorita,
			String assunto, String mensagem, Date data_criacao, Date data_expira) {

		this.msg_lida = msg_lida;
		this.msg_nao_lida = msg_nao_lida;
		this.msg_favorita = msg_favorita;
		this.assunto = assunto;
		this.mensagem = mensagem;
		this.data_criacao = data_criacao;
		this.data_expira = data_expira;
	}

	/**
	 * Variáveis booleanas que indicam o status da notificação.
	 */
	private boolean msg_lida;
	private boolean msg_nao_lida;
	private boolean msg_favorita;
	
	/**
	 * Por enquanto não vou mexer com arquivo nem nada. Todas as infos da mensagem serão strings na memória.
	 */
	private String assunto;
	private String mensagem;
	
	/**
	 * Data de criação e data para expirar a notificação.
	 */
	private Date data_criacao;
	private Date data_expira;

	
	
	
	public boolean isMsg_lida() {
		return msg_lida;
	}

	public void setMsg_lida(boolean msg_lida) {
		this.msg_lida = msg_lida;
	}

	public boolean isMsg_nao_lida() {
		return msg_nao_lida;
	}

	public void setMsg_nao_lida(boolean msg_nao_lida) {
		this.msg_nao_lida = msg_nao_lida;
	}

	public boolean isMsg_favorita() {
		return msg_favorita;
	}

	public void setMsg_favorita(boolean msg_favorita) {
		this.msg_favorita = msg_favorita;
	}

	
	public String getAssunto() {
		return assunto;
	}
	

	public void setAssunto(String assunto) {
		this.assunto = assunto;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

	public Date getData_criacao() {
		return data_criacao;
	}

	public void setData_criacao(Date data_criacao) {
		this.data_criacao = data_criacao;
	}

	public Date getData_expira() {
		return data_expira;
	}

	public void setData_expira(Date data_expira) {
		this.data_expira = data_expira;
	}
	
	

}
