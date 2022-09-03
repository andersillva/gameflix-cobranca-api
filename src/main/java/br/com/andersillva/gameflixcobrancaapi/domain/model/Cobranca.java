package br.com.andersillva.gameflixcobrancaapi.domain.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class Cobranca {

	private Long idPedido;
	
	private Long idUsuario;
	
	private LocalDate data;
	
	private List<CobrancaItem> itens = new ArrayList<>();

}
