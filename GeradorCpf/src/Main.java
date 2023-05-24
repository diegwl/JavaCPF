import java.util.Random;
import java.util.Scanner;

public class Main {
    static Scanner entrada = new Scanner(System.in);
    static Random random = new Random();

    public static void validarCPF(){
        System.out.println("Digite o CPF que deseja validar: ");
    }

    public static void gerarCPF(){
        StringBuilder cpf = new StringBuilder();
        int validadorD1 = 0, validadorD2 = 0, d1, d2, cont = 0;
        for (int i = 1; i <= 9; i++) {
            int numero = random.nextInt(9);
            String strNumero = Integer.toString(numero);
            cpf.append(strNumero);
        }
        for (int i = 10; i >= 2; i--) {
            System.out.println(i);
            char caracter = cpf.charAt(cont);
            int numero = Integer.parseInt(Character.toString(caracter));
            validadorD1 += (numero * i);
            validadorD2 += (numero * (i+1));
            cont++;
        }

        d1 = 11 - (validadorD1 % 11);

        validadorD2 += d1 * 2;
        d2 = 11 - (validadorD2 % 11);

        if(d1 > 9){
            d1 = 0;
        }
        if(d2 > 9){
            d2 = 0;
        }

        String strd1 = Integer.toString(d1);
        String strd2 = Integer.toString(d2);
        cpf.append(strd1);
        cpf.append(strd2);

        cpf.insert(3, ".");
        cpf.insert(7, ".");
        cpf.insert(11, "-");
        System.out.println(cpf);
    }

    public static void main(String[] args) {
        while(true){
            try {
                System.out.println("--------------------------------");
                System.out.println("--- RECEITA FEDERAL ---\n1 - Validar CPF\n2 - Gerar CPF\n3 - Sair");
                System.out.println("--------------------------------");
                int opcao = entrada.nextInt();
                switch (opcao){
                    case 1 -> validarCPF();
                    case 2 -> gerarCPF();
                    case 3 -> System.out.println("Finalizando Programa");
                    default -> System.out.println("Número inválido");
                }
            } catch (Exception e) {
                System.out.printf("Erro: %s\n", e);
            }
        }
    }
}
