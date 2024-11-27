import java.util.Random;
import java.util.Scanner;
public class Main {
    public static String luckyShot(int n) {
        int [] lucky = new int[3];

        Random random = new Random();

        for (int i = 0; i < lucky.length; i++) {
            lucky[i] = random.nextInt(3)+1;
        }
        for (int i = 0; i < 10; i++) {
            int [] roule = new int[3];
            for (int j = 0; j < roule.length; j++) {
                roule[j] = random.nextInt(3)+1;
            }
            String rouli = "["+roule[0]+","+roule[1]+","+roule[2]+"]";
            try {
                Thread.sleep(500);
                System.out.println(rouli);

            }catch (InterruptedException e) {
                System.out.println(e);
            }
        }

        int count = 1;
        String result = "["+lucky[0]+",";

        for (int i = 1; i < lucky.length; i++) {

            if (i<2){
                result += lucky[i] + ",";
            }

            if (i == 2){
                result += lucky[i]+"]";
            }

            if (lucky[i] == lucky[0]) {
                count++;
            }
        }
        System.out.println(result);
        if (count == 3){
            return "Bravo vous avez gagnez "+Integer.toString(n*15)+" $. Avec ces nombres "+result;
        }
        return "Womp vous avez perdu "+Integer.toString(n)+" $. Avec ces nombres "+result;
    }


    public static void main(String[] args) {
        String var = "";
        int solde = 1000;
        System.out.println("Bienvenue a la machine a sous de Cyprien");
        do {
            Scanner sc = new Scanner(System.in);
            System.out.println("Entrer votre pari, votre solde est "+Integer.toString(solde)+" $");
            try{
                int bet = sc.nextInt();

                if (bet > solde) {
                    System.out.println("Solde insuffisant");
                } else {
                    String luckyShoot = luckyShot(bet);
                    System.out.println(luckyShoot);
                    String[] wait = luckyShoot.split(" ");

                    switch (wait[0]) {
                        case "Womp":
                            solde -= bet;
                            break;
                        case "Bravo":
                            solde += Integer.valueOf(wait[4]);
                            break;
                    }
                }
            }catch (Exception e){
                System.out.println(sc.next()+" n'est pas valide");
            }
            do {
                Scanner sc2 = new Scanner(System.in);
                System.out.print("Encore ? Votre solde est " + Integer.toString(solde) + " (Y/N) : ");  // ask the input from user
                try {
                    var = sc2.nextLine();
                } catch (Exception e) {
                    System.out.println("Veuillez mettre y ou n");
                }
            }while (!var.equalsIgnoreCase("Y") && !var.equalsIgnoreCase("N")    );
        } while (var.equalsIgnoreCase("y"));
    }
}
