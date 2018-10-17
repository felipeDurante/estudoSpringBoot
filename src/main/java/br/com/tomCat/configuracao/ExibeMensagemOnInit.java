package br.com.tomCat.configuracao;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class ExibeMensagemOnInit implements ApplicationListener<ContextRefreshedEvent> {

	@Value(value = "geral.Mensagem")
	private String nome;

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		System.out.println("UUUUUHUUUUUUUUUUUL \n\n" + nome);

	}

}
