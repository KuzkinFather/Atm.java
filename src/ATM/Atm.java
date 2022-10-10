package ATM;

public class Atm {

    private int nominals100;
    private int nominals50;
    private int nominals20;

    public Atm() {
    }

    public Atm(int nominals100, int nominals50, int nominals20) {
        this.nominals100 = nominals100;
        this.nominals50 = nominals50;
        this.nominals20 = nominals20;
    }

    public int replenish100(int addNominals100) {
        int sumNominals100 = getNominals100();
        sumNominals100 += addNominals100;
        setNominals100(sumNominals100);
        return getNominals100();
    }

    public int replenish50(int addNominals50) {
        int sumNominals50 = getNominals50();
        sumNominals50 += addNominals50;
        setNominals50(sumNominals50);
        return getNominals50();
    }

    public int replenish20(int addNominals20) {
        int sumNominals20 = getNominals20();
        sumNominals20 += addNominals20;
        setNominals20(sumNominals20);
        return getNominals100();
    }

    public int sumAllNominals() {
        return getNominals100() * 100 + getNominals50() * 50 + getNominals20() * 20;
    }


    public boolean withdrawalСash(int requiredAmount) {
        System.out.println("Введите сумму не больше: " + sumAllNominals());
        System.out.println("Вы ввели: " + requiredAmount);
        int currentValue = requiredAmount;

        int totalNeedNominals100 = currentValue / 100;


        if (currentValue <= sumAllNominals() && totalNeedNominals100 <= getNominals100()
                && (currentValue % 100 == 0)) {
            System.out.println("Выдано 100: " + totalNeedNominals100);
            currentValue -= (100 * totalNeedNominals100);
//            System.out.println("Оставшаяся сумма к выдаче: " + currentValue);
        } else if (currentValue <= sumAllNominals() && totalNeedNominals100 <= getNominals100()
                && currentValue % 100 != 0 && (currentValue % 100 % 50 == 0 || currentValue % 100 % 50 % 20 == 0)) {
            System.out.println("Выдано 100: " + totalNeedNominals100);
            currentValue -= (100 * totalNeedNominals100);
//            System.out.println("Оставшаяся сумма к выдаче: " + currentValue);
        } else if (currentValue <= sumAllNominals() && totalNeedNominals100 > getNominals100()
                && (currentValue % 100 != 0 || currentValue % 100 == 0) && (currentValue % 100 % 50 == 0 || currentValue % 100 % 50 % 20 == 0)) {
            System.out.println("Выдано 100: " + getNominals100());
            currentValue -= 100 * getNominals100();
//            System.out.println("Оставшаяся сумма к выдаче: " + currentValue);
        } else if (currentValue <= sumAllNominals() && totalNeedNominals100 > getNominals100() && currentValue % 100 != 0
                && (((currentValue - 100 * getNominals100()) - 50) % 20 == 0)) {
            System.out.println("Выдано 100: " + getNominals100());
            currentValue -= 100 * getNominals100();
//            System.out.println("Оставшаяся сумма к выдаче: " + currentValue);
        }


        int totalNeedNominals50 = currentValue / 50;
        if (currentValue <= sumAllNominals() && totalNeedNominals50 <= getNominals50()
                && currentValue % 50 == 0) {
            System.out.println("Выдано 50: " + totalNeedNominals50);
            currentValue -= 50 * totalNeedNominals50;
//            System.out.println("Оставшаяся сумма к выдаче: " + currentValue);
        } else if (currentValue <= sumAllNominals() && totalNeedNominals50 <= getNominals50()
                && currentValue % 50 != 0 && currentValue % 50 % 20 == 0) {
            System.out.println("Выдано 50: " + totalNeedNominals50);
            currentValue -= 50 * totalNeedNominals50;
//            System.out.println("Оставшаяся сумма к выдаче: " + currentValue);
        } else if (currentValue <= sumAllNominals() && totalNeedNominals50 <= getNominals50()
                && currentValue % 50 != 0 && ((currentValue - 50) % 20 == 0)) {
            totalNeedNominals50 = 1;
            System.out.println("Выдано 50: " + totalNeedNominals50);
            currentValue -= 50;
//            System.out.println("Оставшаяся сумма к выдаче: " + currentValue);
        } else if (currentValue <= sumAllNominals() && totalNeedNominals50 > getNominals50() && ((currentValue - (getNominals50() * 50)) % 20) != 0) {
            totalNeedNominals50 = getNominals50() - 1 ;
            System.out.println("Выдано 50: " + totalNeedNominals50);
            currentValue -= 50 * totalNeedNominals50;
//            System.out.println("Оставшаяся сумма к выдаче: " + currentValue);
        }else if (currentValue <= sumAllNominals() && totalNeedNominals100 > getNominals50()
                && (currentValue % 50 != 0 || currentValue % 50 == 0) && (currentValue % 100 % 50 == 0 || currentValue % 100 % 50 % 20 == 0)) {
            System.out.println("Выдано 50: " + getNominals50());
            currentValue -= 50 * getNominals50();
//            System.out.println("Оставшаяся сумма к выдаче: " + currentValue);
        }

        int totalNeedNominals20 = currentValue / 20;
        if (currentValue <= sumAllNominals() && totalNeedNominals20 <= getNominals20() && currentValue % 20 == 0) {
            System.out.println("Выдано 20: " + totalNeedNominals20);
            currentValue -= 20 * totalNeedNominals20;
        } else if (currentValue <= sumAllNominals() && totalNeedNominals20 == getNominals20())  {
            System.out.println("Выдано 20: " + getNominals20());
            currentValue -= 20 * getNominals20();
        }

        if (currentValue != 0) {
            System.out.println("Имеющейся суммы недостаточно, либо введно значение не кратное минимальному номиналу 20");
            return false;
        } else {
            return true;
        }
    }

    public int getNominals100() {
        return nominals100;
    }

    public void setNominals100(int nominals100) {
        this.nominals100 = nominals100;
    }

    public int getNominals50() {
        return nominals50;
    }

    public void setNominals50(int nominals50) {
        this.nominals50 = nominals50;
    }

    public int getNominals20() {
        return nominals20;
    }

    public void setNominals20(int nominals20) {
        this.nominals20 = nominals20;
    }
}
