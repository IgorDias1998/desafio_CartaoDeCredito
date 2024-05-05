import java.util.Collections;
import java.util.Scanner;

public class Shopping {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("\nDigite o limite do cartão");
        double limiteCartao = sc.nextDouble();

        CartaoDeCredito cartao = new CartaoDeCredito(limiteCartao);
        int continuarCompra = 1;

        while(continuarCompra != 0){
            System.out.println("Digite a descrição do item: ");
            String descricao = sc.next();
            
            System.out.println("Digite o valor do item: ");
            double valor = sc.nextDouble();
            
            Compra novaCompra = new Compra(descricao, valor);
            boolean compraFeita = cartao.realizarCompra(novaCompra);

            if (compraFeita){
                System.out.println("Compra realizada com sucesso!");
                System.out.println("Digite 0 para finalizar ou 1 para continuar comprando...");
                continuarCompra = sc.nextInt();
            } else {
                System.out.println("Saldo insuficiente para compra!");
                continuarCompra = 0;
            }
        }

        Collections.sort(cartao.getCompras());
        System.out.println("---------------------------");
        System.out.println("Compras Realizadas: ");
        for (Compra c : cartao.getCompras()) {
            System.out.println(c.getDescricao() + " " + c.getValor());
        }
        System.out.println("---------------------------");
        System.out.println("Saldo: " + cartao.getSaldo());
    }
}
