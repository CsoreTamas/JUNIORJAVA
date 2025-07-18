import java.util.ArrayList;
import java.util.List;

public class Customer {
    private String name;

    private double walletBalance;
    private List<Game> ownedGames;

    public Customer() {

    }

    public Customer(String name, double walletBalance) {
        this.name = name;
        this.walletBalance = walletBalance;
        this.ownedGames = new ArrayList<>();
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setOwnedGames(List<Game> ownedGames) {
        this.ownedGames = ownedGames;
    }

    public void setWalletBalance(double walletBalance) {
        this.walletBalance = walletBalance;
    }

    public String getName() {
        return this.name;
    }

    public double getWalletBalance() {
        return this.walletBalance;
    }

    public List<Game> getOwnedGames() {
        return this.ownedGames;
    }

    public void addFounds(double amount) {
        this.walletBalance += amount;
    }

    public boolean purchaseGame(Game game) {
        if (game == null) {
            System.out.println("The game doesn't exist.");
            return false;
        } else if (!game.isInStock()) {
            System.out.printf("Game %s is not in stock. \n", game.getTitle());
            return false;
        } else if (this.walletBalance < game.getPrice()) {
            System.out.printf("%s , You don't have enough amount to buy %s. \n", this.getName(), game.getTitle());
            return false;
        } else {
            this.walletBalance -= game.getPrice();
            this.ownedGames.add(game);
            System.out.printf("%s , Successful purchase : %s \n", this.getName(), game.getTitle());
            return true;
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Name: ").append(this.getName()).append("\n");
        sb.append("Wallet balance: ").append(this.walletBalance).append(" Forint").append("\n");
        sb.append("Games: ");
        if (this.ownedGames.isEmpty()) {
            sb.append("You don't have any games.");
        }

        for (Game game : this.ownedGames) {
            sb.append(game.getTitle()).append(", ").append("\n");
        }

        return sb.toString();
    }
}

