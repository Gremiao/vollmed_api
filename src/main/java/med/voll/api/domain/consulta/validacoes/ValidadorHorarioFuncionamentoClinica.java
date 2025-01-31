package med.voll.api.domain.consulta.validacoes;

import med.voll.api.domain.consulta.DadosAgendamentoConsultaDTO;
import med.voll.api.domain.domain.ValidacaoException;

import java.time.DayOfWeek;

public class ValidadorHorarioFuncionamentoClinica {

    public void validr(DadosAgendamentoConsultaDTO dados){
        var dataConsulta = dados.data();
        var isDomingo = dataConsulta.getDayOfWeek().equals(DayOfWeek.SUNDAY);
        var isAntesAberturaClinica = dataConsulta.getHour() < 7;
        var isDepoisAberturaClinica = dataConsulta.getHour() > 18;
        if(isDomingo || isAntesAberturaClinica || isDepoisAberturaClinica){
            throw new ValidacaoException("Consulta fora do horario de funcionamento da clinica");
        }
    }
}
