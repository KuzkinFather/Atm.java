package ATM;

public class AtmRunner {

    public static void main(String[] args) {
        Atm atm = new Atm(5,2,2);

        atm.replenish100(5);
        atm.replenish50(5);
        atm.replenish20(5);

       System.out.println(atm.getNominals100() + " " + atm.getNominals50() + " "+ atm.getNominals20());

        System.out.println(atm.withdrawalСash(1470));
    }


}
