package com.api.helpr.services;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.api.helpr.domain.Chamado;
import com.api.helpr.domain.Cliente;
import com.api.helpr.domain.Tecnico;
import com.api.helpr.domain.enums.Perfil;
import com.api.helpr.domain.enums.Prioridade;
import com.api.helpr.domain.enums.Status;
import com.api.helpr.repositories.ChamadoRepository;
import com.api.helpr.repositories.ClienteRepository;
import com.api.helpr.repositories.TecnicoRepository;

@Service
public class DBService {
	
	@Autowired
	private TecnicoRepository tecnicoRepository;
	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private ChamadoRepository chamadoRepository;
	@Autowired
	private BCryptPasswordEncoder encoder;

	public void instanciaDB() {
		Tecnico t1 = new Tecnico(null, "Victor Icoma", "009.393.200-61","victor.icoma@gmail.com", encoder.encode("gordinho123"));
		t1.addPerfils(Perfil.ADMIN);
		Tecnico t2 = new Tecnico(null, "Jhon Milles Oliveira", "684.344.850-01","jmoliveira@gmail.com", encoder.encode("123456"));
		t2.addPerfils(Perfil.TECNICO);
		Tecnico t3 = new Tecnico(null, "Roger Guedes", "504.368.110-14","guedesroger@gmail.com", encoder.encode("123456"));
		t3.addPerfils(Perfil.TECNICO);
		Tecnico t4 = new Tecnico(null, "Taisa Ferreira", "612.261.820-97","tataferreira@gmail.com", encoder.encode("123456"));
		t4.addPerfils(Perfil.TECNICO);
		Tecnico t5 = new Tecnico(null, "Danrley Souza", "936.848.410-48","dandansouza@gmail.com", encoder.encode("123456"));
		t5.addPerfils(Perfil.ADMIN);
		Tecnico t6 = new Tecnico(null, "Bruna Souza", "820.420.380-24","souzabrubs@gmail.com", encoder.encode("123456"));
		t6.addPerfils(Perfil.TECNICO);
		
		Cliente c1 = new Cliente(null, "Salazar Sonserina", "172.551.910-02","sa.sonserina@gmail.com",encoder.encode("ofideo123"));
		Cliente c2 = new Cliente(null, "Tony Krisley", "072.198.180-17","tonykrisley@gmail.com", encoder.encode("1234"));
		Cliente c3 = new Cliente(null, "Gregorio Grifinória", "075.261.600-51","grifinoriagreg@gmail.com", encoder.encode("1234"));
		Cliente c4 = new Cliente(null, "Lorena Corvinal", "603.780.760-43","corvinallorena@gmail.com", encoder.encode("1234"));
		
		Chamado ch1 = new Chamado(null, Prioridade.MEDIA, 
				Status.ANDAMENTO, "Chamado Inaugural","Este é o 1o chamado para o sistema.", t1, c1);
		Chamado ch2 = new Chamado(null, Prioridade.MEDIA, 
				Status.ABERTO, "Erro sistema pagamento","Erro ao construir novas vendas.", t2, c2);
		Chamado ch3 = new Chamado(null, Prioridade.MEDIA, 
				Status.ABERTO, "Correcao Sistema de venda","Correcao do sistema de vandas sem listagem final.", t3, c3);
		Chamado ch4 = new Chamado(null, Prioridade.MEDIA, 
				Status.ENCERRADO, "Bug Tabelas de pedidos","Saltando linhas demais na tabela de vendas.", t4, c4);		
		Chamado ch5 = new Chamado(null, Prioridade.MEDIA, 
						Status.ENCERRADO, "Bug cadastros novos","Carregamento duplo dos novos cadastros.", t5, c3);
		
		tecnicoRepository.saveAll(Arrays.asList(t1, t2, t3, t4, t5, t6));
		clienteRepository.saveAll(Arrays.asList(c1, c2, c3, c4));
		chamadoRepository.saveAll(Arrays.asList(ch1, ch2, ch3, ch4, ch5));
	}
	
}
