import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Création des héros
        Hero warrior = new Hero();
        Hero mage = new Hero();
        Hero hunter = new Hero();
        Hero healer = new Hero();

        // Création des ennemis
        Enemy enemy1 = new Enemy(50);
        Enemy enemy2 = new Enemy(60);
        Enemy enemy3 = new Enemy(70);
        Enemy enemy4 = new Enemy(80);

        // Choix des héros par l'utilisateur
        System.out.println("Choisissez vos héros parmi les suivants :");
        System.out.println("1 - Guerrier");
        System.out.println("2 - Mage");
        System.out.println("3 - Chasseur");
        System.out.println("4 - Guérisseur");
        System.out.print("Choisissez vos héros en entrant les numéros correspondant : ");
        int[] heroChoices = new int[4];
        for (int i = 0; i < 4; i++) {
            heroChoices[i] = sc.nextInt();
        }

        // Ajout des héros choisis à une liste
        Hero[] heroes = new Hero[4];
        for (int i = 0; i < 4; i++) {
            switch (heroChoices[i]) {
                case 1:
                    heroes[i] = warrior;
                    break;
                case 2:
                    heroes[i] = mage;
                    break;
                case 3:
                    heroes[i] = hunter;
                    break;
                case 4:
                    heroes[i] = healer;
                    break;
            }
        }

        // Boucle de combat
        while (true) {
            // Attaque des héros
            for (Hero hero : heroes) {
                if (hero instanceof Mage) {
                    ((Mage) hero).castSpell(enemy1);
                    ((Mage) hero).castSpell(enemy2);
                    ((Mage) hero).castSpell(enemy3);
                    ((Mage) hero).castSpell(enemy4);
                } else {
                    hero.attack(enemy1);
                    hero.attack(enemy2);
                    hero.attack(enemy3);
                    hero.attack(enemy4);
                }
            }

            // Vérification de la vie des ennemis
            if (enemy1.isDead() && enemy2.isDead() && enemy3.isDead() && enemy4.isDead()) {
                // Si les ennemis sont morts, les héros gagnent
                for (Hero hero : heroes) {
                    if (hero instanceof Warrior || hero instanceof Hunter) {
                        hero.heal();
                    }
                }
                System.out.println("Les héros ont gagné le combat !");


            }}}}


