package br.com.alurafood.pedidos.amqp;

import br.com.alurafood.pedidos.dto.PagamentoDto;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class PagamentoListener {

/*
    @RabbitListener(queues = "pagamento.concluido")
    public void recebeMensagem(Message message) {
        System.out.println("Mensagem recebida: " + message.toString());
    }
*/
    @RabbitListener(queues = "pagamento.concluido")
    public void recebeMensagem(PagamentoDto pagamento) {
        String msg = "Dados do pagamento recebido: " +
                "Nome: %s, Numero do pedido: %s, Valor: R$ %s".formatted(pagamento.getNome(), pagamento.getNumero(), pagamento.getValor());
        System.out.println(msg);
    }
}
