package src;


public class enunciado3 {


    static int contador = 0;

    public static void KMPSearch(String pat, String txt) {
        int M = pat.length();
        int N = txt.length();

        // cria lps[] que vai guardar o maior
        // valor prefixo sufixo para o padrão
        int[] lps = new int[M];
        int j = 0; // index for pat[]

        // Calcula lps[]
        contador++;
        computeLPSArray(pat, M, lps);

        int i = 0; // index for txt[]
        while (i < N) {
            if (pat.charAt(j) == txt.charAt(i)) {
                contador++;
                j++;
                i++;
            }
            if (j == M) {
                contador++;
                System.out.println("Found pattern "
                        + "at index " + (i - j));
                contador++;
                j = lps[j - 1];
            }

            // mismatch após j matches
            else if (i < N && pat.charAt(j) != txt.charAt(i)) {
                contador++;
                // Não faz match dos caracteres lps[0..lps[j-1]],
                // não é necessário, eles combinarão
                contador++;
                if (j != 0) {
                    j = lps[j - 1];
                }
                else {
                    i = i + 1;
                }
            }
        }
    }

    public static void computeLPSArray(String pat, int M, int[] lps)
    {
        // tamanho do maior prefixo sufixo anterior
        int len = 0;
        int i = 1;
        lps[0] = 0; // lps[0] is always 0

        // loop calcula lps[i] for i = 1 to M-1
        while (i < M) {
            if (pat.charAt(i) == pat.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            }
            else // (pat[i] != pat[len])
            {
                if (len != 0) {
                    len = lps[len - 1];
                }
                else // if (len == 0)
                {
                    lps[i] = len;
                    i++;
                }
            }
        }
    }

    public static void main(String[] args) {
        contador = 0;
        String s1 = """
                O jogo de apostas é antigo no Brasil: ele foi criado na época do Império. Em 1892, um barão do Rio de Janeiro organizou uma rifa para atrair pessoas ao seu zoológico e cada bilhete de entrada tinha a imagem de um animal. A cada dia, quem tivesse um bilhete com o animal sorteado na urna ganhava um prêmio equivalente a vinte vezes o valor da entrada. Logo o jogo informal virou ‘febre’ em diversos lugares.
                As principais regras do jogo do bicho
                Jogo de azar é ilegal
                Como ditam os bons mandamentos das finanças, jogos de azar são perigosos para o orçamento familiar. Caso as apostas sejam feitas sem controle, podem se tornar um vício e gerar grande prejuízo aos jogadores.
                O jogo do bicho tem um adicional mais perigoso: é considerado uma contravenção penal. Isso significa que os envolvidos podem ser multados e até presos.
                
                Conteúdos e análises exclusivas para ajudar você a investir. Faça seu cadastro na Ágora Investimentos
                Para piorar, o jogo costuma estar associado ao crime organizado e é comum ver bicheiros serem presos por chefiarem organizações criminosas e cometer crimes. Por isso, cuidado!
                O que é o jogo do bicho?
                O jogo do bicho é um jogo de apostas com números representados por 25 animais. Cada bicho corresponde a quatro dezenas. Do avestruz (01,02,03,04), à vaca (97,98,99,00), eles somam 100 dezenas.
                No jogo do bicho há a figura de um bicheiro, que financia o jogo; do gerente, que organiza as apostas; e o anotador, que passa o jogo. O ponto é onde o jogo pode ser adquirido e o prêmio é recolhido após a apresentação do comprovante do jogo.
                Como o jogo do bicho funciona?
                Como nas loterias, o prêmio varia conforme a probabilidade de acerto: quanto maior, menor a possibilidade de ganhar. O prêmio é multiplicado pelo valor da aposta, independentemente do valor.
                Para jogar, é necessário escolher um animal e aguardar o sorteio da Loteria Federal. As duas últimas dezenas sorteadas formarão um milhar que será a base para os sorteios do jogo do bicho.
                Existem mais de dez tipos de apostas, mas a mais comum é a mais simples: basta escolher um bicho e esperar que seja sorteada a dezena relacionada a ele.
                
                Por exemplo, se as duas últimas dezenas sorteadas na loteria forem 10 e 23 elas formam o milhar 1023. Neste caso, a última dezena é 23, e o bicho sorteado é a cabra (21,22, 23, 24).
                Também é possível apostar no milhar: para isso, o jogador deve escolher uma dupla de animais e espera que ambos os números saiam no sorteio""";
        String s2 = "jogo do bicho";

        String s3 = """
                Em abril deste ano, a Vivaleik, empresa de Val Marchiori, foi cobrada na Justiça pela instituição financeira por conta de uma dívida. Para piorar, a loira também entrou nessa, afinal, ela foi avalista, ou seja, garantidora do empréstimo de capital de giro que deu início a essa história. Foram cobrados cerca de R$ 275 mil da pessoa jurídica e da pessoa física.
                
                Ao questionar a cobrança, a empresa de Val afirmou estar passando por dificuldades financeiras consideráveis. A situação, na verdade, seria tão ruim, que a Vivaleik pediu gratuidade de Justiça, afirmando que não tem condições de arcar com os R$ 4 mil de custas do processo. O pedido, no entanto, também foi feito pela própria empresária, que disse que não tem como pagar o valor sem prejudicar a si e a sua família.
  
                Em uma petição, Val Marchiori e a empresa indicam que as cobranças de dinheiro não são de exclusividade do banco, vindo, ainda, de outras fontes. Surpreendente, não é?! Mas acalmem-se, pois, as descobertas não acabam aqui.
                Neste mês de junho, a socialite foi chamada para pagar R$ 109 mil a um homem que alugou seu famoso barco em Angra dos Reis e acabou prejudicado pela loira.
                
                
                Se, além de tudo isso, Val também tiver outras dívidas, não é exagero dizer que o título de “mulher rica” ficou no passado…
                
                Posicionamento de Val Marchiori
                Após a publicação da matéria, Val Marchiori emitiu um comunicado oficial sobre a notícia. De acordo com a empresária, ela foi mal assessorada pelos seus antigos advogados e que faziam parte a equipe do seu ex-marido. Veja a nota completa abaixo:
                
                
                “Em resposta à matéria publicada recentemente sobre minha suposta incapacidade de arcar com as custas processuais, venho a público esclarecer que as informações veiculadas são completamente inverídicas. Infelizmente, fui muito mal assessorada por advogados que ainda faziam parte da equipe do meu ex-marido.
                
                Gostaria de informar que já troquei toda a equipe jurídica e em momento algum solicitei que fosse pedido gratuidade de Justiça em meu nome ou das minhas empresas. Reitero que não tenho enfrentado os problemas financeiros descritos e que a situação exposta não reflete a realidade.
                
                Agradeço a compreensão de todos e reforço meu compromisso com a verdade e, principalmente, com a Justiça!”""";
        String s4 = "mulher rica";

        KMPSearch(s4, s3);
        System.out.println("Iterações: " + contador);

        contador = 0;

        KMPSearch(s2, s1);
        System.out.println("Iterações: " + contador);
    }
}