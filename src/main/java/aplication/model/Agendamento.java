package aplication.model;

import java.sql.Date;

public class Agendamento {
	private Date dia;
	private Horario horario;
	public Date getDia() {
		return dia;
	}
	public void setDia(Date dia) {
		this.dia = dia;
	}
	public Horario getHorario() {
		return horario;
	}
	public void setHorario(Horario horario) {
		this.horario = horario;
	}
}
