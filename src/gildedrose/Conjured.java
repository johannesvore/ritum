package gildedrose;

public class Conjured extends UpdateInterface {

	@Override
	public void updateQuality(Item item) {
		item.quality -= 2;
		item.sellIn--;
	}

}
