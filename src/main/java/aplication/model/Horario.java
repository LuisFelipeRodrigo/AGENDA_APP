package aplication.model;

public class Horario {
	private Boolean disponibilidade;
	private HoraTrabalho horariotrabalho;
	
	
	public Horario() {
	}
	public Horario(Boolean disponibilidade, HoraTrabalho horariotrabalho) {
		this.disponibilidade = disponibilidade;
		this.horariotrabalho = horariotrabalho;
	}
	public Boolean getDisponibilidade() {
		return disponibilidade;
	}
	public void setDisponibilidade(Boolean disponibilidade) {
		this.disponibilidade = disponibilidade;
	}
	public HoraTrabalho getHorariotrabalho() {
		return horariotrabalho;
	}
	public void setHorariotrabalho(HoraTrabalho horariotrabalho) {
		this.horariotrabalho = horariotrabalho;
	}
	
}
