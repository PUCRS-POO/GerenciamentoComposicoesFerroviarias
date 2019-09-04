import java.util.Scanner;

public class App {

    private static Scanner in = new Scanner(System.in);

    private static void imprimeComposicao(Composicao trem) {
        System.out.println("Composicao: "+trem.getIdentificador());
        for(int i=0;i<trem.getQtdadeLocomotivas();i++) {
            System.out.println(trem.getLocomotiva(i));
        }
        for(int i=0;i<trem.getQtdadeVagoes();i++) {
            System.out.println(trem.getVagao(i));
        }
    }

    public static void main(String args[]) {
        CadastroVagoes cv = new CadastroVagoes();
        cv.carrega();
        CadastroLocomotivas cl = new CadastroLocomotivas();
        cl.carrega();

        // System.out.println("Cadastro de vagoes:");
        // for(int i=0;i<cv.qtdade(); i++) {
        //     System.out.println(cv.getPorPosicao(i));
        // }
        // System.out.println("Cadastro de locomotivas:");
        // for(int i=0;i<cl.qtdade(); i++) {
        //     System.out.println(cl.getPorPosicao(i));
        // }

        CadastroComposicoes cc = new CadastroComposicoes();
        Composicao t1 = new Composicao(6656);
        t1.engataLocomotiva(cl.getPorId(20));
        t1.engataVagao(cv.getPorId(30));
        t1.engataVagao(cv.getPorId(40));
        t1.engataVagao(cv.getPorId(50));
        cc.cadastra(t1);

        Composicao t2 = new Composicao(9712);
        t2.engataLocomotiva(cl.getPorId(40));
        t2.engataVagao(cv.getPorId(100));
        t2.engataVagao(cv.getPorId(110));
        t2.engataVagao(cv.getPorId(120));
        t2.engataVagao(cv.getPorId(130));
        t2.engataVagao(cv.getPorId(140));
        t2.engataVagao(cv.getPorId(150));
        t2.engataVagao(cv.getPorId(160));
        t2.engataVagao(cv.getPorId(170));
        t2.engataVagao(cv.getPorId(180));
        t2.engataVagao(cv.getPorId(190));
        t2.engataVagao(cv.getPorId(200));
        cc.cadastra(t2);

        System.out.println("Cadastro de composicoes:");
        for(int i=0;i<cc.getQtdade();i++) {
            imprimeComposicao(cc.getPorPosicao(i));
        }

        cv.persiste();
        cl.persiste();
        cc.persiste();

        System.out.println("Fim");

        int opcaoMenuPrincipal = 1;
        int opcaoSecundaria = 0;
        clearScreen();
        while(opcaoMenuPrincipal > 0) {
            opcaoMenuPrincipal = MenuPrincipal();
            switch(opcaoMenuPrincipal) {
                case 1:
                    System.out.println("1");
                    opcaoSecundaria = MenuLocomotivas();
                    switch(opcaoSecundaria) {
                        case 1:
                            ListarTodasLocomotivas();
                            break;
                        case 2:
                            ListarLocomotivasDisponiveis();
                            break;
                    }
                    break;
                case 2:
                    System.out.println("2");
                    opcaoSecundaria = MenuVagoes();
                    break;
                case 3:
                    System.out.println("3");
                    opcaoSecundaria = MenuComposicoes();
                    break;
            }
        }

    }

    private static int MenuPrincipal() {
        clearScreen();
        System.out.println("---------- MENU ----------");
        System.out.println("\t1 - Locomotivas");
        System.out.println("\t2 - Vagoes");
        System.out.println("\t3 - Composicoes");

        System.out.print("Informe a opcoes deseja: ");
        return in.nextInt();
    }

    private static int MenuLocomotivas() {
        clearScreen();
        System.out.println("---------- MENU LOCOMOTIVAS ----------");
        System.out.println("\t1 - Listar Todas");
        System.out.println("\t2 - Listar Disponiveis");

        System.out.print("Informe a opcoes deseja: ");
        return in.nextInt();
    }

    private static void ListarTodasLocomotivas() {
    }

    private static void ListarLocomotivasDisponiveis() {

    }

    private static int MenuVagoes() {
        return -1;
    }

    private static void ListarTodosVagoes() {
        
    }

    private static void ListarVagoesDisponiveis() {
        
    }

    private static int MenuComposicoes() {
        return -1;
    }

    private void CriarComposicao() {
        
    }

    private void AdicionarLocomotivaNaComposicao(Composicao c) {

    }

    private void AdicionarVagaoNaComposicao(Composicao c) {
        
    }

    private void RemoverLocomotivaNaComposicao(Composicao c) {

    }

    private void RemoverVagaoNaComposicao(Composicao c) {
        
    }

    private void ListarComposicoes() {

    }

    public static void clearScreen() {  
        System.out.print("\033[H\033[2J");  
        System.out.flush();  
    }  
}