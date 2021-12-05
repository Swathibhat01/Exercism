import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class Knapsack {

    List<Item> itemsList;

    public int maximumValue(int knapsackWeightLimit, List<Item> items) {
        if(items.isEmpty()){
            return 0;
        }

        this.itemsList= new ArrayList<>(items);
        itemsList.sort(new Comparator<Item>() {
            @Override
            public int compare(Item o1, Item o2) {
                return o2.getValue() - o1.getValue();
            }
        });
        return getSumOfValues(knapsackWeightLimit, 0, 0, 0);
    }

    private int getSumOfValues(int knapsackWeightLimit, int valueOfItemsThiefPutInSac,
        int currentWeightOfTheSac,
        int itemNumber) {
        if (itemNumber > itemsList.size() - 1) {
            return valueOfItemsThiefPutInSac;
        }
        if (itemsList.get(itemNumber).getWeight() < knapsackWeightLimit) {
            valueOfItemsThiefPutInSac =
                valueOfItemsThiefPutInSac + itemsList.get(itemNumber).getValue();
        }
        currentWeightOfTheSac = currentWeightOfTheSac + itemsList.get(itemNumber).getWeight();
        if (currentWeightOfTheSac == knapsackWeightLimit) {
            valueOfItemsThiefPutInSac=valueOfItemsThiefPutInSac+itemsList.get(itemNumber).getValue();
            return valueOfItemsThiefPutInSac;
        }
        if (currentWeightOfTheSac > knapsackWeightLimit) {
            return getSumOfValues(knapsackWeightLimit,
                valueOfItemsThiefPutInSac - itemsList.get(itemNumber).getValue(),
                currentWeightOfTheSac - itemsList.get(itemNumber).getWeight(), itemNumber + 1);
        }
            return getSumOfValues(knapsackWeightLimit,valueOfItemsThiefPutInSac,currentWeightOfTheSac,itemNumber+1);

    }
}